package com.example.restservice;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.JSONObject;
import org.springframework.web.client.RestTemplate;

public class ApiResult {

	private final JSONArray content;

	public ApiResult(String url,String source,String type, boolean expectObj, String atribute) {	
		// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		// make an HTTP GET request
		String json = restTemplate.getForObject(url, String.class);
		Object obj = JSONValue.parse(json);

		JSONArray array;
		
		if (expectObj){
			JSONObject resultObj = (JSONObject)obj;
			array = (JSONArray)resultObj.get(atribute);
		} else {
			array = (JSONArray)obj;
		}

		JSONArray resultArray = new JSONArray();
		for(int i = 0; i < array.size()-1; i++){
			JSONObject tempObj = new JSONObject();
			tempObj.put("type", type);
			tempObj.put("source", source);
			tempObj.put("data", (JSONObject)array.get(0));
			resultArray.add((JSONObject)tempObj);
		}
		this.content = resultArray;
	}

	
	public JSONArray getContent() {
		return content;
	}
}