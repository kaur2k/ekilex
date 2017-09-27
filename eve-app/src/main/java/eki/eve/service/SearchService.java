package eki.eve.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eki.eve.data.Form;
import eki.eve.data.Meaning;
import eki.eve.data.Word;
import eki.eve.data.WordDetails;
import eki.eve.service.db.SearchDbService;

@Service
public class SearchService {

	@Autowired
	SearchDbService searchDbService;

	public List<Word> findWords(String searchFilter) {
		return searchDbService.findWords(searchFilter).into(Word.class);
	}

	public WordDetails findWordDetails(Long formId) {
		List<Form> connectedForms = searchDbService.findConnectedForms(formId).into(Form.class);
		List<Meaning> meanings = searchDbService.findFormMeanings(formId).into(Meaning.class);
		Map<String, String> datasetNameMap = searchDbService.getDatasetNameMap();
		meanings.forEach(meaning -> {
			String[] datasets = meaning.getDatasets();
			datasets = convertToNames(datasets, datasetNameMap);
			meaning.setDatasets(datasets);
		});
		return new WordDetails(d -> {
			d.setForms(connectedForms);
			d.setMeanings(meanings);
		});
	}

	private String[] convertToNames(String[] datasets, Map<String, String> datasetMap) {
		if (datasets == null) {
			return new String[0];
		}
		for (int datasetIndex = 0; datasetIndex < datasets.length; datasetIndex++) {
			datasets[datasetIndex] = datasetMap.get(datasets[datasetIndex]);
		}
		return datasets;
	}
}