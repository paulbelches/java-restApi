package com.example.restservice;
import org.json.simple.JSONArray;

public class SearchResult {

	private final JSONArray content;
	private final APIConfig[] configs = {
			new APIConfig("http://itunes.apple.com/search?term=", "&entity=song", "itunes", "song", true, "results"),
			new APIConfig("http://itunes.apple.com/search?term=", "&entity=movie", "itunes", "movie", true, "results"),
			new APIConfig("http://api.tvmaze.com/search/shows?q=", "", "serie", "tvmaze", false, ""),
	};
	
	public SearchResult(String term) {
		JSONArray resultArray = new JSONArray();
		for (int i = 0; i < configs.length - 1; i++){
			APIConfig tempConfig = configs[i];
			ApiResult tempResult = new ApiResult(
				tempConfig.getPreUrl()+term+tempConfig.getPostUrl(),
				tempConfig.getSource(), 
				tempConfig.getType(), 
				tempConfig.getExpectObj(), 
				tempConfig.getAtribute()
			);
			resultArray.addAll(tempResult.getContent());	
		}
		this.content = resultArray;
	}

	public JSONArray getContent() {
		return content;
	}
}