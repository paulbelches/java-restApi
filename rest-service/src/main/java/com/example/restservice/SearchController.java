package com.example.restservice;
import org.slf4j.Logger;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SearchController {

	private static final Logger log = LoggerFactory.getLogger(SearchController.class);
	//Get controller
	@GetMapping("/search")
	public SearchResult SearchResult(@RequestParam(value = "term", defaultValue = " ") String term) {
		log.info("The term "+term+" was requested");
		return new SearchResult(term);
	}
}