package eki.ekilex.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import eki.ekilex.constant.WebConstant;
import eki.ekilex.data.WordLexeme;
import eki.ekilex.service.CompositionService;
import eki.ekilex.service.LexSearchService;
import eki.ekilex.web.util.SearchHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

@ConditionalOnWebApplication
@Controller
@SessionAttributes(WebConstant.SESSION_BEAN)
public class LexEditController extends AbstractPageController {

	private static final Logger logger = LoggerFactory.getLogger(LexEditController.class);

	@Autowired
	private LexSearchService lexSearchService;

	@Autowired
	private SearchHelper searchHelper;

	@Autowired
	private CompositionService compositionService;

	@RequestMapping(LEX_JOIN_URI + "/{targetLexemeId}")
	public String search(@PathVariable("targetLexemeId") Long targetLexemeId, @RequestParam(name = "searchFilter", required = false) String searchFilter,
			Model model) {

		Long userId = userService.getAuthenticatedUser().getId();
		List<String> userPermDatasetCodes = permissionService.getUserPermDatasetCodes(userId);
		List<String> userPreferredDatasetCodes = getUserPreferredDatasetCodes();

		WordLexeme targetLexeme = commonDataService.getWordLexeme(targetLexemeId);
		Long sourceLexemeMeaningId = targetLexeme.getMeaningId();
		String targetLexemeWord = targetLexeme.getWords()[0];
		if (searchFilter == null) {
			searchFilter = targetLexemeWord;
		}

		Optional<Integer> wordHomonymNumber;
		if (StringUtils.equals(searchFilter, targetLexemeWord)) {
			Integer sourceHomonymNumber = targetLexeme.getWordHomonymNumber();
			wordHomonymNumber = Optional.of(sourceHomonymNumber);
		} else {
			wordHomonymNumber = Optional.empty();
		}

		List<WordLexeme> sourceLexemes = lexSearchService
				.getWordLexemesOfJoinCandidates(searchFilter, userPreferredDatasetCodes, userPermDatasetCodes, wordHomonymNumber, sourceLexemeMeaningId);

		model.addAttribute("targetLexeme", targetLexeme);
		model.addAttribute("searchFilter", searchFilter);
		model.addAttribute("sourceLexemes", sourceLexemes);

		return LEX_JOIN_PAGE;
	}

	@PostMapping(LEX_JOIN_URI)
	public String join(@RequestParam("targetLexemeId") Long targetLexemeId, @RequestParam("sourceLexemeIds") List<Long> sourceLexemeIds) {

		compositionService.joinLexemes(targetLexemeId, sourceLexemeIds);

		WordLexeme lexeme = commonDataService.getWordLexeme(targetLexemeId);
		List<String> datasets = getUserPreferredDatasetCodes();
		String firstWordValue = lexeme.getWords()[0];
		String searchUri = searchHelper.composeSearchUri(datasets, firstWordValue);

		return "redirect:" + LEX_SEARCH_URI + searchUri;
	}

	@GetMapping("/lexseparate/{lexemeId}")
	public String separate(@PathVariable("lexemeId") Long lexemeId) {

		WordLexeme lexeme = commonDataService.getWordLexeme(lexemeId);
		compositionService.separateLexemeMeanings(lexemeId);

		List<String> datasets = getUserPreferredDatasetCodes();
		String firstWordValue = lexeme.getWords()[0];
		String searchUri = searchHelper.composeSearchUri(datasets, firstWordValue);

		return "redirect:" + LEX_SEARCH_URI + searchUri;
	}

	@ResponseBody
	@PostMapping("/duplicatelexeme/{lexemeId}")
	public String duplicateLexemeAndMeaning(@PathVariable("lexemeId") Long lexemeId) throws Exception {

		List<Long> clonedLexemeIds = new ArrayList<>();
		try {
			clonedLexemeIds = compositionService.duplicateLexemeAndMeaningWithSameDatasetLexemes(lexemeId);
		} catch (Exception ignore) {
			logger.error("", ignore);
		}

		Map<String, String> response = new HashMap<>();
		if (CollectionUtils.isNotEmpty(clonedLexemeIds)) {
			response.put("message", "Lekseemi duplikaat lisatud");
			response.put("status", "ok");
		} else {
			response.put("message", "Duplikaadi lisamine ebaõnnestus");
			response.put("status", "error");
		}

		ObjectMapper jsonMapper = new ObjectMapper();
		return jsonMapper.writeValueAsString(response);
	}

	@ResponseBody
	@PostMapping("/duplicateemptylexeme/{lexemeId}")
	public String duplicateEmptyLexemeAndMeaning(@PathVariable("lexemeId") Long lexemeId) throws Exception {

		compositionService.duplicateEmptyLexemeAndMeaning(lexemeId);

		Map<String, String> response = new HashMap<>();
		response.put("message", "Uus tähendus loodud");
		response.put("status", "ok");

		ObjectMapper jsonMapper = new ObjectMapper();
		return jsonMapper.writeValueAsString(response);
	}

	@ModelAttribute("iso2languages")
	public Map<String, String> getIso2Languages() {
		return commonDataService.getLanguagesIso2Map();
	}
}
