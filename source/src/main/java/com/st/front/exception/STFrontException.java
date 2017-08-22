package com.st.front.exception;

import com.st.exception.STException;

public class STFrontException extends STException{
	
	public STFrontException() {
		super();
	}

	public STFrontException(String message) {
		super(message);
	}

	public STFrontException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public STFrontException(String message, Throwable cause) {
		super(message, cause);
	}

	public STFrontException(Throwable cause) {
		super(cause);
	}
	
}
