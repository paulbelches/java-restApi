package com.example.restservice;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.*;
public class SearchResult {

	private final JSONArray content;
	private final APIConfig[] configs = {
			new APIConfig("http://itunes.apple.com/search?term=", "&entity=song", "itunes", "song", true, "results"),
			new APIConfig("http://itunes.apple.com/search?term=", "&entity=movie", "itunes", "movie", true, "results"),
			new APIConfig("http://api.tvmaze.com/search/shows?q=", "", "serie", "tvmaze", false, ""),
	};

	//Obtain the result from each of the soruces and merge them into the final result. 
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

			///Sort the result by type
		resultArray.sort( new Comparator<JSONObject>(){
			public int compare(JSONObject ob1, JSONObject ob2){
				String s1, s2;
				s1 = (String)ob1.get("type");
				s2 = (String)ob2.get("type");
				return s1.compareTo(s2);
			}
		});
		

		this.content = resultArray;
	}

	public JSONArray getContent() {
		return content;
	}
}