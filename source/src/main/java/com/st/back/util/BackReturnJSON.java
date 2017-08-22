package com.st.back.util;

import com.st.util.PubReturnJSON;

public class BackReturnJSON<T> extends PubReturnJSON<T>{
	private Integer error;

	public Integer getError() {
		return error;
	}

	public void setError(Integer error) {
		this.error = error;
	}
	
}
