package eki.ekilex.runner;

import eki.common.constant.FreeformType;
import eki.common.data.Count;
import eki.ekilex.data.transform.Lexeme;
import eki.ekilex.data.transform.Meaning;
import eki.ekilex.data.transform.Paradigm;
import eki.ekilex.data.transform.Rection;
import eki.ekilex.data.transform.Usage;
import eki.ekilex.data.transform.Word;
import eki.ekilex.service.ReportComposer;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.removePattern;
import static org.apache.commons.lang3.StringUtils.replaceChars;

@Component
public class Ss1LoaderRunner extends AbstractLoaderRunner {

	private final static String dataLang = "est";
	private final static String dataset = "ss1";
	private final static String formStrCleanupChars = ".()¤:_|[]̄̆̇’\"'`´–+=";
	private final String defaultWordMorphCode = "SgN";
	private final String defaultRectionValue = "-";

	private final static String sqlWordLexemesByDataset = "select l.* from " + LEXEME + " l where l.word_id = :wordId and l.dataset_code = :dataset";

	private final static String LEXEME_RELATION_BASIC_WORD = "head";
	private final static String LEXEME_RELATION_ANTONYM = "ant";
	private final static String LEXEME_RELATION_COHYPONYM = "cohyponym";

	private final static String ARTICLES_REPORT_NAME = "keywords";
	private final static String BASIC_WORDS_REPORT_NAME = "basic_words";
	private final static String SYNONYMS_REPORT_NAME = "synonyms";
	private final static String ANTONYMS_REPORT_NAME = "antonyms";
	private final static String ABBREVIATIONS_REPORT_NAME = "abbreviations";
	private final static String COHYPONYMS_REPORT_NAME = "cohyponyms";
	private final static String TOKENS_REPORT_NAME = "tokens";
	private final static String FORMULAS_REPORT_NAME = "formulas";

	private static Logger logger = LoggerFactory.getLogger(PsvLoaderRunner.class);

	private ReportComposer reportComposer;
	private boolean reportingEnabled;

	private Map<String, String> lexemeTypes;
	private Map<String, String> posCodes;
	private Map<String, String> processStateCodes;
	private Map<String, String> displayMorpCodes;
	private String lexemeTypeAbbreviation;
	private String lexemeTypeToken;

	@Override
	void initialise() throws Exception {
		lexemeTypes = loadClassifierMappingsFor(EKI_CLASSIFIER_LIIKTYYP);
		lexemeTypeAbbreviation = lexemeTypes.get("l");
		lexemeTypeToken = lexemeTypes.get("th");
		posCodes = loadClassifierMappingsFor(EKI_CLASSIFIER_SLTYYP);
		processStateCodes = loadClassifierMappingsFor(EKI_CLASSIFIER_ASTYYP);
		displayMorpCodes = loadClassifierMappingsFor(EKI_CLASSIFIER_VKTYYP);
	}

	@Transactional
	public void execute(
			String dataXmlFilePath,
			Map<String, List<Paradigm>> wordParadigmsMap,
			boolean isAddReporting) throws Exception {

		logger.info("Starting import");
		long t1, t2;
		t1 = System.currentTimeMillis();

		reportingEnabled = isAddReporting;
		if (reportingEnabled) {
			reportComposer = new ReportComposer("SS1 import", ARTICLES_REPORT_NAME, BASIC_WORDS_REPORT_NAME, SYNONYMS_REPORT_NAME, ANTONYMS_REPORT_NAME,
					ABBREVIATIONS_REPORT_NAME, COHYPONYMS_REPORT_NAME, TOKENS_REPORT_NAME, FORMULAS_REPORT_NAME);
		}

		Document dataDoc = xmlReader.readDocument(dataXmlFilePath);
		Element rootElement = dataDoc.getRootElement();

		long articleCount = rootElement.content().stream().filter(o -> o instanceof Element).count();
		long progressIndicator = articleCount / Math.min(articleCount, 100);
		long articleCounter = 0;
		logger.debug("{} articles found", articleCount);

		Context context = new Context();

		writeToLogFile("Artiklite töötlus", "", "");
		List<Element> articleNodes = (List<Element>) rootElement.content().stream().filter(o -> o instanceof Element).collect(toList());
		for (Element articleNode : articleNodes) {
			processArticle(articleNode, wordParadigmsMap, context);
			articleCounter++;
			if (articleCounter % progressIndicator == 0) {
				long progressPercent = articleCounter / progressIndicator;
				logger.debug("{}% - {} articles iterated", progressPercent, articleCounter);
			}
		}
		logger.debug("total {} articles iterated", articleCounter);

		processBasicWords(context);
		processSynonymsNotFoundInImportFile(context);
		processAbbreviations(context);
		processTokens(context);
		processFormulas(context);
		processAntonyms(context);
		processCohyponyms(context);

		logger.debug("Found {} word duplicates", context.wordDuplicateCount);

		if (reportComposer != null) {
			reportComposer.end();
		}
		t2 = System.currentTimeMillis();
		logger.debug("Done in {} ms", (t2 - t1));
	}

	@Transactional
	void processArticle(Element articleNode, Map<String, List<Paradigm>> wordParadigmsMap, Context context) throws Exception {

		final String articleHeaderExp = "s:P";
		final String articleBodyExp = "s:S";

		String guid = extractGuid(articleNode);
		String reportingId = extractReporingId(articleNode);
		List<WordData> newWords = new ArrayList<>();

		Element headerNode = (Element) articleNode.selectSingleNode(articleHeaderExp);
		processArticleHeader(reportingId, headerNode, newWords, context, wordParadigmsMap, guid);

		Element contentNode = (Element) articleNode.selectSingleNode(articleBodyExp);
		if (contentNode != null) {
			processArticleContent(reportingId, contentNode, newWords, context);
		}
		context.importedWords.addAll(newWords);
	}

	private void processFormulas(Context context) throws Exception {

		logger.debug("Found {} formulas.", context.formulas.size());
		setActivateReport(FORMULAS_REPORT_NAME);
		writeToLogFile("Valemite töötlus <s:val>", "", "");

		// FIXME: what should be lexeme type ???
		Count newFormulaWordCount = processLexemeToWord(context, context.formulas, lexemeTypeToken, "Ei leitud valemit, loome uue");

		logger.debug("Formula words created {}", newFormulaWordCount.getValue());
		logger.debug("Formulas import done.");
	}

	private void processTokens(Context context) throws Exception {

		logger.debug("Found {} tokens.", context.tokens.size());
		setActivateReport(TOKENS_REPORT_NAME);
		writeToLogFile("Tähiste töötlus <s:ths>", "", "");

		Count newTokenWordCount = processLexemeToWord(context, context.tokens, lexemeTypeToken, "Ei leitud tähist, loome uue");

		logger.debug("Token words created {}", newTokenWordCount.getValue());
		logger.debug("Tokens import done.");
	}

	private Count processLexemeToWord(Context context, List<LexemeToWordData> items, String defaultLexemeType, String logMessage) throws Exception {
		Count newWordCount = new Count();
		for (LexemeToWordData itemData : items) {
			boolean isImported = context.importedWords.stream().anyMatch(w -> itemData.word.equals(w.value));
			if (!isImported) {
				WordData newWord = createDefaultWordFrom(itemData.word, itemData.displayForm);
				context.importedWords.add(newWord);
				newWordCount.increment();
				Lexeme lexeme = new Lexeme();
				lexeme.setWordId(newWord.id);
				lexeme.setMeaningId(itemData.meaningId);
				lexeme.setLevel1(itemData.lexemeLevel1);
				lexeme.setLevel2(1);
				lexeme.setLevel3(1);
				lexeme.setType(itemData.lexemeType == null ? defaultLexemeType : itemData.lexemeType);
				createLexeme(lexeme, dataset);
				logger.debug("new word created : {}", itemData.word);
				writeToLogFile(itemData.reportingId, logMessage, itemData.word);
			}
		}
		return newWordCount;
	}

	private void processAbbreviations(Context context) throws Exception {

		logger.debug("Found {} abbreviations.", context.abbreviations.size());
		setActivateReport(ABBREVIATIONS_REPORT_NAME);
		writeToLogFile("Lühendite töötlus <s:lyh> ja <s:lhx>", "", "");

		Count newAbbreviationWordCount = processLexemeToWord(context, context.abbreviations, lexemeTypeAbbreviation, "Ei leitud lühendit, loome uue");

		logger.debug("Abbreviation words created {}", newAbbreviationWordCount.getValue());
		logger.debug("Abbreviations import done.");
	}

	private void processSynonymsNotFoundInImportFile(Context context) throws Exception {

		logger.debug("Found {} synonyms", context.synonyms.size());
		setActivateReport(SYNONYMS_REPORT_NAME);
		writeToLogFile("Sünonüümide töötlus <s:syn>", "", "");

		Count newSynonymWordCount = processLexemeToWord(context, context.synonyms, null, "sünonüümi ei letud, lisame sõna");

		logger.debug("Synonym words created {}", newSynonymWordCount.getValue());
		logger.debug("Synonyms import done.");
	}

	private void processCohyponyms(Context context) throws Exception {

		logger.debug("Found {} cohyponyms.", context.cohyponyms.size());
		setActivateReport(COHYPONYMS_REPORT_NAME);
		writeToLogFile("Kaashüponüümide töötlus <s:kyh>", "", "");

		for (LexemeToWordData cohyponymData : context.cohyponyms) {
			List<WordData> existingWords = context.importedWords.stream().filter(w -> cohyponymData.word.equals(w.value)).collect(Collectors.toList());
			Long wordId = getWordIdFor(cohyponymData.word, cohyponymData.homonymNr, existingWords, cohyponymData.reportingId);
			if (!existingWords.isEmpty() && wordId != null) {
				Map<String, Object> params = new HashMap<>();
				params.put("wordId", wordId);
				params.put("dataset", dataset);
				try {
					List<Map<String, Object>> lexemeObjects = basicDbService.queryList(sqlWordLexemesByDataset, params);
					Optional<Map<String, Object>> lexemeObject =
							lexemeObjects.stream().filter(l -> (Integer)l.get("level1") == cohyponymData.lexemeLevel1).findFirst();
					if (lexemeObject.isPresent()) {
						createLexemeRelation(cohyponymData.lexemeId, (Long) lexemeObject.get().get("id"), LEXEME_RELATION_COHYPONYM);
					} else {
						logger.debug("Lexeme not found for cohyponym : {}, lexeme level1 : {}.", cohyponymData.word, cohyponymData.lexemeLevel1);
						writeToLogFile(cohyponymData.reportingId, "Ei leitud ilmikut kaashüponüümile", cohyponymData.word + ", level1 " + cohyponymData.lexemeLevel1);
					}
				} catch (Exception e) {
					logger.error("{} | {} | {}", e.getMessage(), cohyponymData.word, wordId);
				}
			}
		}
		logger.debug("Cohyponyms import done.");
	}

	private void processAntonyms(Context context) throws Exception {

		logger.debug("Found {} antonyms.", context.antonyms.size());
		setActivateReport(ANTONYMS_REPORT_NAME);
		writeToLogFile("Antonüümide töötlus <s:ant>", "", "");

		for (LexemeToWordData antonymData : context.antonyms) {
			List<WordData> existingWords = context.importedWords.stream().filter(w -> antonymData.word.equals(w.value)).collect(Collectors.toList());
			Long wordId = getWordIdFor(antonymData.word, antonymData.homonymNr, existingWords, antonymData.reportingId);
			if (!existingWords.isEmpty() && wordId != null) {
				Map<String, Object> params = new HashMap<>();
				params.put("wordId", wordId);
				params.put("dataset", dataset);
				try {
					List<Map<String, Object>> lexemeObjects = basicDbService.queryList(sqlWordLexemesByDataset, params);
					Optional<Map<String, Object>> lexemeObject =
							lexemeObjects.stream().filter(l -> (Integer)l.get("level1") == antonymData.lexemeLevel1).findFirst();
					if (lexemeObject.isPresent()) {
						createLexemeRelation(antonymData.lexemeId, (Long) lexemeObject.get().get("id"), LEXEME_RELATION_ANTONYM);
					} else {
						logger.debug("Lexeme not found for antonym : {}, lexeme level1 : {}.", antonymData.word, antonymData.lexemeLevel1);
						writeToLogFile(antonymData.reportingId, "Ei leitud ilmikut antaonüümile", antonymData.word + ", level1 " + antonymData.lexemeLevel1);
					}
				} catch (Exception e) {
					logger.error("More than one lexeme {}, {}", antonymData.word, wordId);
				}
			}
		}
		logger.debug("Antonyms import done.");
	}

	void processBasicWords(Context context) throws Exception {

		logger.debug("Found {} basic words.", context.basicWords.size());
		setActivateReport(BASIC_WORDS_REPORT_NAME);
		writeToLogFile("Märksõna põhisõna seoste töötlus <s:ps>", "", "");

		for (WordData basicWord : context.basicWords) {
			List<WordData> existingWords = context.importedWords.stream().filter(w -> basicWord.value.equals(w.value)).collect(Collectors.toList());
			Long wordId = getWordIdFor(basicWord.value, basicWord.homonymNr, existingWords, basicWord.reportingId);
			if (!existingWords.isEmpty() && wordId != null) {
				Map<String, Object> params = new HashMap<>();
				params.put("wordId", basicWord.id);
				params.put("dataset", dataset);
				List<Map<String, Object>> secondaryWordLexemes = basicDbService.queryList(sqlWordLexemesByDataset, params);
				for (Map<String, Object> secondaryWordLexeme : secondaryWordLexemes) {
					params.put("wordId", wordId);
					List<Map<String, Object>> lexemes = basicDbService.queryList(sqlWordLexemesByDataset, params);
					for (Map<String, Object> lexeme : lexemes) {
						createLexemeRelation((Long) secondaryWordLexeme.get("id"), (Long) lexeme.get("id"), LEXEME_RELATION_BASIC_WORD);
					}
				}
			}
		}
		logger.debug("Basic words processing done.");
	}

	private void processArticleContent(String reportingId, Element contentNode, List<WordData> newWords, Context context) throws Exception {

		final String meaningNumberGroupExp = "s:tp";
		final String lexemeLevel1Attr = "tnr";
		final String meaningGroupExp = "s:tg";
		final String meaningPosCodeExp = "s:grg/s:sl";
		final String meaningExternalIdExp = "s:tpid";

		List<Element> meaningNumberGroupNodes = contentNode.selectNodes(meaningNumberGroupExp);

		for (Element meaningNumberGroupNode : meaningNumberGroupNodes) {
			String lexemeLevel1Str = meaningNumberGroupNode.attributeValue(lexemeLevel1Attr);
			Integer lexemeLevel1 = Integer.valueOf(lexemeLevel1Str);
			List<Element> meanigGroupNodes = meaningNumberGroupNode.selectNodes(meaningGroupExp);
			List<Long> newLexemes = new ArrayList<>();
			Element meaningExternalIdNode = (Element) meaningNumberGroupNode.selectSingleNode(meaningExternalIdExp);
			String meaningExternalId = meaningExternalIdNode == null ? null : meaningExternalIdNode.getTextTrim();

			int lexemeLevel2 = 0;
			for (Element meaningGroupNode : meanigGroupNodes) {
				lexemeLevel2++;
				List<Usage> usages = extractUsages(meaningGroupNode);
				List<String> definitions = extractDefinitions(meaningGroupNode);
				List<PosData> meaningPosCodes = extractPosCodes(meaningGroupNode, meaningPosCodeExp);
				List<String> importantNotes = extractImportantNotes(meaningGroupNode);

				Long meaningId;
				boolean addDefinitions = true;

				List<LexemeToWordData> meaningSynonyms = extractSynonyms(meaningGroupNode, reportingId);
				List<LexemeToWordData> meaningAbbreviations = extractAbbreviations(meaningGroupNode, reportingId);
				List<LexemeToWordData> meaningTokens = extractTokens(meaningGroupNode, reportingId);
				List<LexemeToWordData> meaningFormulas = extractFormulas(meaningGroupNode, reportingId);
				List<LexemeToWordData> connectedWords =
						Stream.of(meaningSynonyms.stream(), meaningAbbreviations.stream(), meaningTokens.stream(), meaningFormulas.stream())
								.flatMap(i -> i).collect(toList());
				WordToMeaningData meaningData = findExistingMeaning(context, newWords.get(0), lexemeLevel1, connectedWords);
				if (meaningData == null) {
					Meaning meaning = new Meaning();
					meaningId = createMeaning(meaning);
				} else {
					meaningId = meaningData.meaningId;
					validateMeaning(meaningData, definitions, reportingId);
					addDefinitions = meaningData.meaningDefinition == null;
					if (meaningData.meaningDefinition == null && !definitions.isEmpty()) {
						meaningData.meaningDefinition = definitions.get(0);
					}
				}
				if (addDefinitions) {
					for (String definition : definitions) {
						createDefinition(meaningId, definition, dataLang, dataset);
					}
					if (definitions.size() > 1) {
						writeToLogFile(reportingId, "Leitud rohkem kui üks seletus <s:d>", newWords.get(0).value);
					}
				}
				List<LexemeToWordData> meaningAntonyms = extractAntonyms(meaningGroupNode, reportingId);
				List<LexemeToWordData> meaningCohyponyms = extractCohyponyms(meaningGroupNode, reportingId);
				cacheMeaningRelatedData(context, meaningId, definitions, newWords.get(0), lexemeLevel1,
						meaningSynonyms, meaningAbbreviations, meaningTokens, meaningFormulas);

				if (isNotEmpty(meaningExternalId)) {
					createMeaningFreeform(meaningId, FreeformType.MEANING_EXTERNAL_ID, meaningExternalId);
				}
				List<String> registers = extractRegisters(meaningGroupNode);
				processSemanticData(meaningGroupNode, meaningId);
				processDomains(meaningGroupNode, meaningId);
				List<String> publicNotes = extractPublicNotes(meaningGroupNode);
				savePublicNotes(meaningId, publicNotes);

				int lexemeLevel3 = 0;
				for (WordData newWordData : newWords) {
					lexemeLevel3++;
					Lexeme lexeme = new Lexeme();
					lexeme.setWordId(newWordData.id);
					lexeme.setType(newWordData.lexemeType);
					lexeme.setMeaningId(meaningId);
					lexeme.setLevel1(lexemeLevel1);
					lexeme.setLevel2(lexemeLevel2);
					lexeme.setLevel3(lexemeLevel3);
					lexeme.setFrequencyGroup(newWordData.frequencyGroup);
					Long lexemeId = createLexeme(lexeme, dataset);
					if (lexemeId != null) {
						saveRectionsAndUsages(meaningGroupNode, lexemeId, usages);
						savePosAndDeriv(lexemeId, newWordData, meaningPosCodes, reportingId);
						saveGrammars(meaningGroupNode, lexemeId, newWordData);
						saveRegisters(lexemeId, registers);
						saveImportantNotes(lexemeId, importantNotes);
						for (LexemeToWordData meaningAntonym : meaningAntonyms) {
							LexemeToWordData antonymData = meaningAntonym.copy();
							antonymData.lexemeId = lexemeId;
							context.antonyms.add(antonymData);
						}
						for (LexemeToWordData meaningCohyponym : meaningCohyponyms) {
							LexemeToWordData cohyponymData = meaningCohyponym.copy();
							cohyponymData.lexemeId = lexemeId;
							context.cohyponyms.add(cohyponymData);
						}
						newLexemes.add(lexemeId);
					}
				}
			}
		}
	}

	private void savePublicNotes(Long meaningId, List<String> notes) throws Exception {
		for (String note : notes) {
			createMeaningFreeform(meaningId, FreeformType.PUBLIC_NOTE, note);
		}
	}

	private void saveImportantNotes(Long lexemeId, List<String> notes) throws Exception {
		for (String note : notes) {
			createLexemeFreeform(lexemeId, FreeformType.IMPORTANT_NOTE, note, dataLang);
		}
	}

	private void cacheMeaningRelatedData(
			Context context, Long meaningId, List<String> definitions, WordData word, int level1,
			List<LexemeToWordData> synonyms,
			List<LexemeToWordData> abbreviations,
			List<LexemeToWordData> tokens,
			List<LexemeToWordData> formulas
			) {
		synonyms.forEach(data -> {
			data.meaningId = meaningId;
			if (!definitions.isEmpty()) {
				data.definition = definitions.get(0);
			}
		});
		context.synonyms.addAll(synonyms);

		abbreviations.forEach(data -> {
			data.meaningId = meaningId;
		});
		context.abbreviations.addAll(abbreviations);

		tokens.forEach(data -> {
			data.meaningId = meaningId;
		});
		context.tokens.addAll(tokens);

		formulas.forEach(data -> {
			data.meaningId = meaningId;
		});
		context.formulas.addAll(formulas);

		context.meanings.addAll(extractMeaningsData(synonyms, word, level1, definitions));
		context.meanings.addAll(extractMeaningsData(abbreviations, word, level1, definitions));
		context.meanings.addAll(extractMeaningsData(tokens, word, level1, definitions));
		context.meanings.addAll(extractMeaningsData(formulas, word, level1, definitions));
	}

	private void processDomains(Element node, Long meaningId) throws Exception {

		final String domainOrigin = "bolan";
		final String domainExp = "s:dg/s:regr/s:v";

		List<String> domainCodes = extractValuesAsStrings(node, domainExp);
		for (String domainCode : domainCodes) {
			Map<String, Object> params = new HashMap<>();
			params.put("meaning_id", meaningId);
			params.put("domain_code", domainCode);
			params.put("domain_origin", domainOrigin);
			basicDbService.createIfNotExists(MEANING_DOMAIN, params);
		}
	}

	private void processSemanticData(Element node, Long meaningId) throws Exception {

		final String semanticTypeExp = "s:semg/s:st";
		final String semanticTypeGroupAttr = "sta";
		final String systematicPolysemyPatternExp = "s:semg/s:spm";

		List<Element> semanticTypeNodes = node.selectNodes(semanticTypeExp);
		for (Element semanticTypeNode : semanticTypeNodes) {
			String semanticType = semanticTypeNode.getTextTrim();
			Long meaningFreeformId = createMeaningFreeform(meaningId, FreeformType.SEMANTIC_TYPE, semanticType);
			String semanticTypeGroup = semanticTypeNode.attributeValue(semanticTypeGroupAttr);
			if (isNotEmpty(semanticTypeGroup)) {
				createFreeformTextOrDate(FreeformType.SEMANTIC_TYPE_GROUP, meaningFreeformId, semanticTypeGroup, null);
			}
		}

		List<Element> systematicPolysemyPatternNodes = node.selectNodes(systematicPolysemyPatternExp);
		for (Element systematicPolysemyPatternNode : systematicPolysemyPatternNodes) {
			String systematicPolysemyPattern = systematicPolysemyPatternNode.getTextTrim();
			createMeaningFreeform(meaningId, FreeformType.SYSTEMATIC_POLYSEMY_PATTERN, systematicPolysemyPattern);
		}
	}

	private List<LexemeToWordData> extractFormulas(Element node, String reportingId) throws Exception {

		final String tokenExp = "s:lig/s:val";
		return extractLexemeMetadata(node, tokenExp, null, reportingId);
	}

	private List<LexemeToWordData> extractTokens(Element node, String reportingId) throws Exception {

		final String tokenExp = "s:lig/s:ths";
		return extractLexemeMetadata(node, tokenExp, null, reportingId);
	}

	private List<LexemeToWordData> extractAbbreviations(Element node, String reportingId) throws Exception {

		final String abbreviationExp = "s:lig/s:lyh";
		final String abbreviationFullFormExp = "s:dg/s:lhx";

		List<LexemeToWordData> abbreviations = extractLexemeMetadata(node, abbreviationExp, null, reportingId);
		abbreviations.addAll(extractLexemeMetadata(node, abbreviationFullFormExp, null, reportingId));
		abbreviations.forEach(a -> {
			if (a.lexemeType == null) {
				a.lexemeType = lexemeTypeAbbreviation;
			}
		});
		return abbreviations;
	}

	private void saveRegisters(Long lexemeId, List<String> registerCodes) throws Exception {
		for (String registerCode : registerCodes) {
			createLexemeRegister(lexemeId, registerCode);
		}
	}

	private void saveGrammars(Element node, Long lexemeId, WordData wordData) throws Exception {

		List<String> grammars = extractGrammar(node);
		grammars.addAll(wordData.grammars);
		for (String grammar : grammars) {
			createLexemeFreeform(lexemeId, FreeformType.GRAMMAR, grammar, dataLang);
		}
	}

	private List<String> extractGrammar(Element node) {

		final String grammarValueExp = "s:grg/s:gki";

		List<String> grammars = (List<String>) node.selectNodes(grammarValueExp).stream()
				.map(e -> ((Element) e).getTextTrim())
				.collect(toList());
		return grammars;
	}

	//POS - part of speech
	private void savePosAndDeriv(Long lexemeId, WordData newWordData, List<PosData> meaningPosCodes, String reportingId) {

		Set<PosData> lexemePosCodes = new HashSet<>();
		try {
			if (meaningPosCodes.isEmpty()) {
				lexemePosCodes.addAll(newWordData.posCodes);
				if (lexemePosCodes.size() > 1) {
					String posCodesStr = lexemePosCodes.stream().map(p -> p.code).collect(Collectors.joining(","));
//					logger.debug("Found more than one POS code <s:mg/s:sl> : {} : {}", reportingId, posCodesStr);
					writeToLogFile(reportingId, "Märksõna juures leiti rohkem kui üks sõnaliik <s:mg/s:sl>", posCodesStr);
				}
			} else {
				lexemePosCodes.addAll(meaningPosCodes);
			}
			for (PosData posCode : lexemePosCodes) {
				if (posCodes.containsKey(posCode.code)) {
					Map<String, Object> params = new HashMap<>();
					params.put("lexeme_id", lexemeId);
					params.put("pos_code", posCodes.get(posCode.code));
					params.put("process_state_code", processStateCodes.get(posCode.processStateCode));
					basicDbService.create(LEXEME_POS, params);
				}
			}
		} catch (Exception e) {
			logger.debug("lexemeId {} : newWord : {}, {}, {}",
					lexemeId, newWordData.value, newWordData.id, lexemePosCodes.stream().map(p -> p.code).collect(Collectors.joining(",")));
			logger.error("ERROR", e);
		}
	}

	private void saveRectionsAndUsages(Element node, Long lexemeId, List<Usage> usages) throws Exception {

		final String rectionExp = "s:rep/s:reg/s:rek/s:kn";

		List<Element> rectionNodes = node.selectNodes(rectionExp);
		if (rectionNodes.isEmpty()) {
			if (!usages.isEmpty()) {
				Long rectionId = createOrSelectLexemeFreeform(lexemeId, FreeformType.RECTION, defaultRectionValue);
				for (Usage usage : usages) {
					createUsage(rectionId, usage);
				}
			}
		} else {
			for (Element rectionNode : rectionNodes) {
				String rectionValue = rectionNode.getTextTrim();
				Long rectionId = createOrSelectLexemeFreeform(lexemeId, FreeformType.RECTION, rectionValue);
				for (Usage usage : usages) {
					createUsage(rectionId, usage);
				}
			}
		}
	}

	private void createUsage(Long rectionId, Usage usage) throws Exception {
		Long usageMeaningId = createFreeformTextOrDate(FreeformType.USAGE_MEANING, rectionId, "", null);
		createFreeformTextOrDate(FreeformType.USAGE, usageMeaningId, usage.getValue(), dataLang);
		if (isNotEmpty(usage.getDefinition())) {
			createFreeformTextOrDate(FreeformType.USAGE_DEFINITION, usageMeaningId, usage.getDefinition(), dataLang);
		}
	}

	private void processArticleHeader(String reportingId, Element headerNode, List<WordData> newWords, Context context,
			Map<String, List<Paradigm>> wordParadigmsMap, String guid) throws Exception {

		final String wordGroupExp = "s:mg";
		final String wordPosCodeExp = "s:sl";
		final String wordGrammarPosCodesExp = "s:grg/s:sl";

		List<Element> wordGroupNodes = headerNode.selectNodes(wordGroupExp);
		for (Element wordGroupNode : wordGroupNodes) {
			WordData wordData = new WordData();
			wordData.reportingId = reportingId;

			Word word = extractWordData(wordGroupNode, wordData, guid);
			if (word != null) {
				List<Paradigm> paradigms = extractParadigms(wordGroupNode, wordData, wordParadigmsMap);
				wordData.id = saveWord(word, paradigms, dataset, context.wordDuplicateCount);
			}

			List<WordData> basicWordsOfTheWord = extractBasicWords(wordGroupNode, wordData.id, reportingId);
			context.basicWords.addAll(basicWordsOfTheWord);

			List<PosData> posCodes = extractPosCodes(wordGroupNode, wordPosCodeExp);
			wordData.posCodes.addAll(posCodes);
			posCodes = extractPosCodes(wordGroupNode, wordGrammarPosCodesExp);
			wordData.posCodes.addAll(posCodes);

			newWords.add(wordData);
		}
	}

	private List<PosData> extractPosCodes(Element node, String wordPosCodeExp) {

		final String asTyypAttr = "as";

		List<PosData> posCodes = new ArrayList<>();
		List<Element> posCodeNodes = node.selectNodes(wordPosCodeExp);
		for (Element posCodeNode : posCodeNodes) {
			PosData posData = new PosData();
			posData.code = posCodeNode.getTextTrim();
			posData.processStateCode = posCodeNode.attributeValue(asTyypAttr);
			posCodes.add(posData);
		}
		return posCodes;
	}

	private List<LexemeToWordData> extractCohyponyms(Element node, String reportingId) throws Exception {

		final String cohyponymExp = "s:ssh/s:khy";
		return extractLexemeMetadata(node, cohyponymExp, null, reportingId);
	}

	private List<LexemeToWordData> extractAntonyms(Element node, String reportingId) throws Exception {

		final String antonymExp = "s:ssh/s:ant";
		return extractLexemeMetadata(node, antonymExp, null, reportingId);
	}

	private List<LexemeToWordData> extractLexemeMetadata(Element node, String lexemeMetadataExp, String relationTypeAttr, String reportingId) throws Exception {

		final String lexemeLevel1Attr = "t";
		final String homonymNrAttr = "i";
		final String lexemeTypeAttr = "liik";
		final int defaultLexemeLevel1 = 1;

		List<LexemeToWordData> metadataList = new ArrayList<>();
		List<Element> metadataNodes = node.selectNodes(lexemeMetadataExp);
		for (Element metadataNode : metadataNodes) {
			LexemeToWordData lexemeMetadata = new LexemeToWordData();
			lexemeMetadata.displayForm = metadataNode.getTextTrim();
			lexemeMetadata.word = cleanUp(lexemeMetadata.displayForm);
			lexemeMetadata.reportingId = reportingId;
			String lexemeLevel1AttrValue = metadataNode.attributeValue(lexemeLevel1Attr);
			if (StringUtils.isBlank(lexemeLevel1AttrValue)) {
				lexemeMetadata.lexemeLevel1 = defaultLexemeLevel1;
			} else {
				lexemeMetadata.lexemeLevel1 = Integer.parseInt(lexemeLevel1AttrValue);
			}
			String homonymNrAttrValue = metadataNode.attributeValue(homonymNrAttr);
			if (StringUtils.isNotBlank(homonymNrAttrValue)) {
				lexemeMetadata.homonymNr = Integer.parseInt(homonymNrAttrValue);
			}
			if (relationTypeAttr != null) {
				lexemeMetadata.relationType = metadataNode.attributeValue(relationTypeAttr);
			}
			String lexemeTypeAttrValue = metadataNode.attributeValue(lexemeTypeAttr);
			if (StringUtils.isNotBlank(lexemeTypeAttrValue)) {
				lexemeMetadata.lexemeType = lexemeTypes.get(lexemeTypeAttrValue);
				if (lexemeMetadata.lexemeType == null) {
					logger.debug("unknown lexeme type {}", lexemeTypeAttrValue);
					writeToLogFile(reportingId, "Tundmatu märksõnaliik", lexemeTypeAttrValue);
				}
			}
			metadataList.add(lexemeMetadata);
		}
		return metadataList;
	}

	private List<LexemeToWordData> extractSynonyms(Element node, String reportingId) throws Exception {

		final String synonymExp = "s:ssh/s:syn";
		return extractLexemeMetadata(node, synonymExp, null, reportingId);
	}

	private List<String> extractImportantNotes(Element node) {

		final String registerValueExp = "s:lig/s:nb";
		return extractValuesAsStrings(node, registerValueExp);
	}

	private List<String> extractPublicNotes(Element node) {

		final String registerValueExp = "s:lig/s:tx";
		return extractValuesAsStrings(node, registerValueExp);
	}

	private List<String> extractRegisters(Element node) {

		final String registerValueExp = "s:dg/s:regr/s:s";
		return extractValuesAsStrings(node, registerValueExp);
	}

	private List<String> extractDefinitions(Element node) {

		final String definitionValueExp = "s:dg/s:d";
		return extractValuesAsStrings(node, definitionValueExp);
	}

	private List<String> extractValuesAsStrings(Element node, String registerValueExp) {
		List<String> registers = new ArrayList<>();
		List<Element> registerValueNodes = node.selectNodes(registerValueExp);
		for (Element registerValueNode : registerValueNodes) {
			String register = registerValueNode.getTextTrim();
			registers.add(register);
		}
		return registers;
	}

	private List<Usage> extractUsages(Element node) {

		final String usageExp = "s:np/s:ng/s:n";
		final String deinitionExp = "s:nd";
		final String deinitionExp2 = "s:nk";

		List<Usage> usages = new ArrayList<>();
		List<Element> usageNodes = node.selectNodes(usageExp);
		for (Element usageNode : usageNodes) {
			Usage newUsage = new Usage();
			newUsage.setValue(usageNode.getTextTrim());
			if (usageNode.hasMixedContent()) {
				Element definitionNode = (Element) usageNode.selectSingleNode(deinitionExp);
				if (definitionNode == null) {
					definitionNode = (Element) usageNode.selectSingleNode(deinitionExp2);
				}
				if (definitionNode != null) {
					newUsage.setDefinition(definitionNode.getText());
				}
			}
			usages.add(newUsage);
		}
		return usages;
	}

	private Word extractWordData(Element wordGroupNode, WordData wordData, String guid) throws Exception {

		final String wordExp = "s:m";
		final String wordDisplayMorphExp = "s:vk";
		final String wordVocalFormExp = "s:hld";
		final String homonymNrAttr = "i";
		final String lexemeTypeAttr = "liik";
		final String wordFrequencyGroupExp = "s:msag";

		Element wordNode = (Element) wordGroupNode.selectSingleNode(wordExp);
		if (wordNode.attributeValue(homonymNrAttr) != null) {
			wordData.homonymNr = Integer.parseInt(wordNode.attributeValue(homonymNrAttr));
		}
		if (wordNode.attributeValue(lexemeTypeAttr) != null) {
			wordData.lexemeType = lexemeTypes.get(wordNode.attributeValue(lexemeTypeAttr));
		}
		String wordDisplayForm = wordNode.getTextTrim();
		String wordValue = cleanUp(wordDisplayForm);
		wordData.value = wordValue;
		int homonymNr = getWordMaxHomonymNr(wordValue, dataLang) + 1;

		String wordVocalForm = null;
		Element vocalFormNode = (Element) wordGroupNode.selectSingleNode(wordVocalFormExp);
		if (vocalFormNode != null) {
			wordVocalForm = vocalFormNode.getTextTrim();
		}

		Word word = new Word(wordValue, dataLang, null, null, wordDisplayForm, wordVocalForm, homonymNr, defaultWordMorphCode, guid);

		Element wordDisplayMorphNode = (Element) wordGroupNode.selectSingleNode(wordDisplayMorphExp);
		if (wordDisplayMorphNode != null) {
			word.setDisplayMorph(displayMorpCodes.get(wordDisplayMorphNode.getTextTrim()));
			if (displayMorpCodes.get(wordDisplayMorphNode.getTextTrim()) == null) {
				logger.warn("Unknown display morph code : {} : {}", wordDisplayMorphNode.getTextTrim(), wordValue);
			}
		}
		// FIXME: 2018.01.02 take first non 'P' value, change after we get correct logic from EKI
		Optional<String> frequencyGroup = wordGroupNode.selectNodes(wordFrequencyGroupExp).stream()
				.map(e -> ((Element)e).getTextTrim())
				.filter(v -> !v.equals("P"))
				.findFirst();
		if (frequencyGroup.isPresent()) {
			wordData.frequencyGroup = frequencyGroup.get();
		}
		wordData.grammars = extractGrammar(wordGroupNode);
		return word;
	}

	private List<Paradigm> extractParadigms(Element wordGroupNode, WordData word, Map<String, List<Paradigm>> wordParadigmsMap) {

		final String morphGroupExp = "s:mfp/s:mtg";
		final String inflectionTypeNrExp = "s:mt";

		List<Paradigm> paradigms = new ArrayList<>();
		boolean isAddForms = !wordParadigmsMap.isEmpty();
		List<Element> morphGroupNodes = wordGroupNode.selectNodes(morphGroupExp);
		for (Element morphGroupNode : morphGroupNodes) {
			Element inflectionTypeNrNode = (Element) morphGroupNode.selectSingleNode(inflectionTypeNrExp);
			if (inflectionTypeNrNode != null) {
				Paradigm paradigm = new Paradigm();
				paradigm.setInflectionTypeNr(inflectionTypeNrNode.getTextTrim());
				if (isAddForms) {
					Paradigm paradigmFromMab = fetchParadigmFromMab(word.value, paradigm.getInflectionTypeNr(), morphGroupNode, wordParadigmsMap);
					if (paradigmFromMab != null) {
						paradigm.setForms(paradigmFromMab.getForms());
					}
				}
				paradigms.add(paradigm);
			} else {
				if (isAddForms) {
					Paradigm paradigmFromMab = fetchParadigmFromMab(word.value, null, morphGroupNode, wordParadigmsMap);
					if (paradigmFromMab != null) {
						paradigms.add(paradigmFromMab);
					}
				}
			}
		}
		return paradigms;
	}

	private List<WordData> extractBasicWords(Element node, Long wordId, String reportingId) {

		final String basicWordExp = "s:ps";
		final String homonymNrAttr = "i";

		List<WordData> basicWords = new ArrayList<>();
		List<Element> basicWordNodes = node.selectNodes(basicWordExp);
		for (Element basicWordNode : basicWordNodes) {
			WordData basicWord = new WordData();
			basicWord.id = wordId;
			basicWord.value = cleanUp(basicWordNode.getTextTrim());
			basicWord.reportingId = reportingId;
			if (basicWordNode.attributeValue(homonymNrAttr) != null) {
				basicWord.homonymNr = Integer.parseInt(basicWordNode.attributeValue(homonymNrAttr));
			}
			basicWords.add(basicWord);
		}
		return basicWords;
	}

	private String extractGuid(Element node) {

		final String articleGuidExp = "s:G";

		Element guidNode = (Element) node.selectSingleNode(articleGuidExp);
		return guidNode != null ? StringUtils.lowerCase(guidNode.getTextTrim()) : null;
	}

	private String extractReporingId(Element node) {

		final String reportingIdExp = "s:P/s:mg/s:m"; // use first word as id for reporting

		Element reportingIdNode = (Element) node.selectSingleNode(reportingIdExp);
		String reportingId = reportingIdNode != null ? cleanUp(reportingIdNode.getTextTrim()) : "";
		return reportingId;
	}

	private WordData createDefaultWordFrom(String wordValue, String displayForm) throws Exception {

		WordData createdWord = new WordData();
		createdWord.value = wordValue;
		int homonymNr = getWordMaxHomonymNr(wordValue, dataLang) + 1;
		Word word = new Word(wordValue, dataLang, null, null, displayForm, null, homonymNr, defaultWordMorphCode, null);
		createdWord.id = saveWord(word, null, null, null);
		return createdWord;
	}

	private WordToMeaningData findExistingMeaning(Context context, WordData newWord, int level1, List<LexemeToWordData> connectedWords) {

		List<String> connectedWordValues = connectedWords.stream().map(w -> w.word).collect(toList());
		Optional<WordToMeaningData> existingMeaning = context.meanings.stream()
				.filter(cachedMeaning -> newWord.value.equals(cachedMeaning.word) &&
						newWord.homonymNr == cachedMeaning.homonymNr &&
						level1 == cachedMeaning.lexemeLevel1 &&
						connectedWordValues.contains(cachedMeaning.meaningWord))
				.findFirst();
		if (!existingMeaning.isPresent() && !connectedWords.isEmpty()) {
			LexemeToWordData connectedWord = connectedWords.get(0);
			existingMeaning = context.meanings.stream()
					.filter(cachedMeaning -> connectedWord.word.equals(cachedMeaning.meaningWord) &&
							connectedWord.homonymNr == cachedMeaning.meaningHomonymNr &&
							connectedWord.lexemeLevel1 == cachedMeaning.meaningLevel1)
					.findFirst();
		}
		return existingMeaning.orElse(null);
	}

	private boolean validateMeaning(WordToMeaningData meaningData, List<String> definitions, String reportingId) throws Exception {

		String definition = definitions.isEmpty() ? null : definitions.get(0);
		if (meaningData.meaningDefinition == null || definition == null || Objects.equals(definition, meaningData.meaningDefinition)) {
			return true;
		}
		logger.debug("meanings do not match for word {} | {} | {}", reportingId, definition, meaningData.meaningDefinition);
		writeToLogFile(reportingId, "Tähenduse seletused on erinevad", definition + " : " + meaningData.meaningDefinition);
		return false;
	}

	private List<WordToMeaningData> extractMeaningsData(List<LexemeToWordData> items, WordData meaningWord, int level1, List<String> definitions) {

		List<WordToMeaningData> meanings = new ArrayList<>();
		for (LexemeToWordData item : items) {
			WordToMeaningData meaning = new WordToMeaningData();
			meaning.meaningId = item.meaningId;
			meaning.meaningWord = meaningWord.value;
			meaning.meaningHomonymNr = meaningWord.homonymNr;
			meaning.meaningLevel1 = level1;
			if (!definitions.isEmpty()) {
				meaning.meaningDefinition = definitions.get(0);
			}
			meaning.word = item.word;
			meaning.homonymNr = item.homonymNr;
			meaning.lexemeLevel1 = item.lexemeLevel1;
			meanings.add(meaning);
		}
		return meanings;
	}

	private Long getWordIdFor(String wordValue, int homonymNr, List<WordData> words, String reportingId) throws Exception {

		Long wordId = null;
		if (words.size() == 1) {
			wordId = words.get(0).id;
		} else if (words.size() > 1) {
			Optional<WordData> matchingWord = words.stream().filter(w -> w.homonymNr == homonymNr).findFirst();
			if (matchingWord.isPresent()) {
				wordId = matchingWord.get().id;
			}
		}
		if (wordId == null) {
			logger.debug("No matching word was found for {} word {}, {}", reportingId, wordValue, homonymNr);
			writeToLogFile(reportingId, "Ei leitud sihtsõna", wordValue + " : " + homonymNr);
		}
		return wordId;
	}

	private Paradigm fetchParadigmFromMab(String wordValue, String inflectionTypeNr, Element node, Map<String, List<Paradigm>> wordParadigmsMap) {

		final String formsNodeExp = "s:mv";

		List<Paradigm> paradigms = wordParadigmsMap.get(wordValue);
		if (CollectionUtils.isEmpty(paradigms)) {
			return null;
		}

		if (isNotEmpty(inflectionTypeNr)) {
			long nrOfParadigmsMatchingInflectionType = paradigms.stream().filter(p -> Objects.equals(p.getInflectionTypeNr(), inflectionTypeNr)).count();
			if (nrOfParadigmsMatchingInflectionType == 1) {
				return paradigms.stream().filter(p -> Objects.equals(p.getInflectionTypeNr(), inflectionTypeNr)).findFirst().get();
			}
		}

		Element formsNode = (Element) node.selectSingleNode(formsNodeExp);
		if (formsNode == null) {
			return null;
		}
		// FIXME: 20.12.2017 its actually lot more complicated logic, change it when we get documentation about it
		List<String> formValues = Arrays.stream(formsNode.getTextTrim().split(",")).map(String::trim).collect(Collectors.toList());
		List<String> mabFormValues;
		Collection<String> formValuesIntersection;
		int bestFormValuesMatchCount = 0;
		Paradigm matchingParadigm = null;
		for (Paradigm paradigm : paradigms) {
			mabFormValues = paradigm.getFormValues();
			formValuesIntersection = CollectionUtils.intersection(formValues, mabFormValues);
			if (formValuesIntersection.size() > bestFormValuesMatchCount) {
				bestFormValuesMatchCount = formValuesIntersection.size();
				matchingParadigm = paradigm;
			}
		}
		return matchingParadigm;
	}

	private String cleanUp(String value) {
		String cleanedWord = replaceChars(value, formStrCleanupChars, "");
		// FIXME: quick fix for removing subscript tags, better solution would be to use some markup for mathematical and chemical formulas
		return removePattern(cleanedWord, "[&]\\w+[;]");
	}

	private void writeToLogFile(String reportingId, String message, String values) throws Exception {
		if (reportingEnabled) {
			String logMessage = String.join(String.valueOf(CSV_SEPARATOR), asList(reportingId, message, values));
			reportComposer.append(logMessage);
		}
	}

	private void setActivateReport(String reportName) {
		if (reportComposer != null) {
			reportComposer.setActiveStream(reportName);
		}
	}

	private class WordData {
		Long id;
		String value;
		int homonymNr = 0;
		String reportingId;
		String lexemeType;
		List<PosData> posCodes = new ArrayList<>();
		String frequencyGroup;
		List<String> grammars = new ArrayList<>();
	}

	private class PosData {
		String code;
		String processStateCode;

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			PosData posData = (PosData) o;
			return Objects.equals(code, posData.code);
		}

		@Override
		public int hashCode() {
			return Objects.hash(code);
		}
	}

	private class WordToMeaningData {
		String word;
		int homonymNr = 0;
		int lexemeLevel1 = 1;
		Long meaningId;
		String meaningDefinition;
		String meaningWord;
		int meaningHomonymNr = 0;
		int meaningLevel1 = 1;
	}

	private class LexemeToWordData {
		Long lexemeId;
		String word;
		String displayForm;
		int lexemeLevel1 = 1;
		int homonymNr = 0;
		String relationType;
		Rection rection;
		String definition;
		List<Usage> usages = new ArrayList<>();
		String reportingId;
		String lexemeType;
		Long meaningId;

		LexemeToWordData copy() {
			LexemeToWordData newData = new LexemeToWordData();
			newData.lexemeId = this.lexemeId;
			newData.word = this.word;
			newData.displayForm = this.displayForm;
			newData.lexemeLevel1 = this.lexemeLevel1;
			newData.homonymNr = this.homonymNr;
			newData.relationType = this.relationType;
			newData.rection = this.rection;
			newData.definition = this.definition;
			newData.reportingId = this.reportingId;
			newData.usages.addAll(this.usages);
			newData.lexemeType = this.lexemeType;
			newData.meaningId = this.meaningId;
			return newData;
		}
	}

	private class Context {
		List<WordData> importedWords = new ArrayList<>();
		List<WordData> basicWords = new ArrayList<>();
		Count wordDuplicateCount = new Count();
		List<LexemeToWordData> synonyms = new ArrayList<>();
		List<LexemeToWordData> antonyms = new ArrayList<>();
		List<LexemeToWordData> abbreviations = new ArrayList<>();
		List<LexemeToWordData> cohyponyms = new ArrayList<>();
		List<LexemeToWordData> tokens = new ArrayList<>();
		List<LexemeToWordData> formulas = new ArrayList<>();
		List<WordToMeaningData> meanings = new ArrayList<>();
	}

}