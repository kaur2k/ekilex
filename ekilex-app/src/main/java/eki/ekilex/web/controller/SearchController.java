package eki.ekilex.web.controller;

import eki.ekilex.data.Word;
import eki.ekilex.data.WordDetails;
import eki.ekilex.service.SearchService;
import eki.ekilex.service.SpeechSynthesisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@ConditionalOnWebApplication
@Controller
public class SearchController {

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@Autowired
	private SearchService search;

	@Autowired
	private SpeechSynthesisService speechSynthesisService;

	@GetMapping("/search")
	public String search(@RequestParam(required = false) String searchFilter, Model model) {
		logger.debug("doing search");
		if (isNotBlank(searchFilter)) {
			List<Word> words = search.findWords(searchFilter);
			model.addAttribute("wordsFoundBySearch", words);
			model.addAttribute("searchFilter", searchFilter);
		}
		return "search";
	}

	@GetMapping("/details/{id}")
	public String details(@PathVariable("id") Long id, Model model) {
		logger.debug("doing details");
		Word word = search.getWord(id);
		WordDetails details = search.findWordDetails(id);
		String urlToSoundSource = speechSynthesisService.urlToSoundSource(word);
		model.addAttribute("detailsName", id + "_details");
		model.addAttribute("details", details);
		model.addAttribute("soundSource", urlToSoundSource);
		return "search :: details";
	}

}