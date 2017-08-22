package com.st.back.officialwebsite.util;

import com.st.util.PubReturnJSON;

public class OwBackReturnJSON<T> extends PubReturnJSON<T>{
	private Integer error;
	private String url;
	public Integer getError() {
		return error;
	}
	public void setError(Integer error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
