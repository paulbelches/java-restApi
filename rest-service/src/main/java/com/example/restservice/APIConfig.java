package com.example.restservice;

public class APIConfig {

	private final String preUrl;
	private final String postUrl;
	private final String source;
	private final String type;
	private final boolean expectObj;
	private final String atribute;

	public APIConfig(String preUrl, String postUrl,String source,String type, boolean expectObj, String atribute) {
		this.preUrl = preUrl;
		this.postUrl = postUrl;
		this.source = source;
		this.type = type;
		this.expectObj = expectObj;
		this.atribute = atribute;
	}

	public String getPreUrl() {
		return preUrl;
	}

	public String getPostUrl() {
		return postUrl;
	}

	public String getSource() {
		return source;
	}

	public String getType() {
		return type;
	}

	public boolean getExpectObj() {
		return expectObj;
	}

	public String getAtribute() {
		return atribute;
	}
}