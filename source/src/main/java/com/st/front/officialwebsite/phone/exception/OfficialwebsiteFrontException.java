package com.st.front.officialwebsite.phone.exception;

import com.st.front.exception.STFrontException;

public class OfficialwebsiteFrontException extends STFrontException {
	
	public OfficialwebsiteFrontException() {
		super();
	}

	public OfficialwebsiteFrontException(String message) {
		super(message);
	}

	public OfficialwebsiteFrontException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OfficialwebsiteFrontException(String message, Throwable cause) {
		super(message, cause);
	}

	public OfficialwebsiteFrontException(Throwable cause) {
		super(cause);
	}
	
}
