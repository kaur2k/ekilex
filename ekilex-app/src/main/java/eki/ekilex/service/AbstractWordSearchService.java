package eki.ekilex.service;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eki.ekilex.data.SearchDatasetsRestriction;
import eki.ekilex.data.SearchFilter;
import eki.ekilex.data.Word;
import eki.ekilex.data.WordsResult;
import eki.ekilex.service.db.LexSearchDbService;

@Component
public abstract class AbstractWordSearchService extends AbstractSearchService {

	protected final static String classifierLabelLang = "est";
	protected final static String classifierLabelTypeDescrip = "descrip";
	protected final static String classifierLabelTypeFull = "full";

	@Autowired
	private LexSearchDbService lexSearchDbService;

	@Transactional
	public WordsResult getWords(SearchFilter searchFilter, List<String> selectedDatasetCodes, boolean fetchAll, int offset) throws Exception {

		List<Word> words;
		int wordCount;
		if (CollectionUtils.isEmpty(searchFilter.getCriteriaGroups())) {
			words = Collections.emptyList();
			wordCount = 0;
		} else {
			SearchDatasetsRestriction searchDatasetsRestriction = composeDatasetsRestriction(selectedDatasetCodes);
			words = lexSearchDbService.getWords(searchFilter, searchDatasetsRestriction, fetchAll, offset);
			wordCount = words.size();
			if (!fetchAll && wordCount == MAX_RESULTS_LIMIT) {
				wordCount = lexSearchDbService.countWords(searchFilter, searchDatasetsRestriction);
			}
		}
		WordsResult result = new WordsResult();
		result.setWords(words);
		result.setTotalCount(wordCount);

		boolean showPaging = wordCount > MAX_RESULTS_LIMIT;
		result.setShowPaging(showPaging);
		if (showPaging) {
			setPagingData(offset, wordCount, result);
		}
		return result;
	}

	@Transactional
	public WordsResult getWords(String searchFilter, List<String> selectedDatasetCodes, boolean fetchAll, int offset) {

		List<Word> words;
		int wordCount;
		if (StringUtils.isBlank(searchFilter)) {
			words = Collections.emptyList();
			wordCount = 0;
		} else {
			SearchDatasetsRestriction searchDatasetsRestriction = composeDatasetsRestriction(selectedDatasetCodes);
			words = lexSearchDbService.getWords(searchFilter, searchDatasetsRestriction, fetchAll, offset);
			wordCount = words.size();
			if ((!fetchAll && wordCount == MAX_RESULTS_LIMIT) || offset > DEFAULT_OFFSET) {
				wordCount = lexSearchDbService.countWords(searchFilter, searchDatasetsRestriction);
			}
		}
		WordsResult result = new WordsResult();
		result.setWords(words);
		result.setTotalCount(wordCount);

		boolean showPaging = wordCount > MAX_RESULTS_LIMIT;
		result.setShowPaging(showPaging);
		if (showPaging) {
			setPagingData(offset, wordCount, result);
		}
		return result;
	}

	private void setPagingData(int offset, int wordCount, WordsResult result) {
		int currentPage = offset / MAX_RESULTS_LIMIT + 1;
		int totalPages = (wordCount + MAX_RESULTS_LIMIT - 1) / MAX_RESULTS_LIMIT;
		boolean previousPageExists = currentPage > 1;
		boolean nextPageExists = currentPage < totalPages;

		result.setCurrentPage(currentPage);
		result.setTotalPages(totalPages);
		result.setPreviousPageExists(previousPageExists);
		result.setNextPageExists(nextPageExists);
	}

}
