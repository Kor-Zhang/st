package com.st.exception;

public class STException extends Exception{
	//设置错误码
	private Integer errorCode = -1;
	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public STException() {
		super();
	}

	public STException(String message) {
		super(message);
	}

	public STException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public STException(String message, Throwable cause) {
		super(message, cause);
	}

	public STException(Throwable cause) {
		super(cause);
	}
	
}
