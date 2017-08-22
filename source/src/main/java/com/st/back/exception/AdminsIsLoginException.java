package com.st.back.exception;
/**
 * 用户重复登陆异常
 * @author Jhon
 *
 */
public class AdminsIsLoginException extends STBackException{
	
	
	public AdminsIsLoginException() {
		super();
	}

	public AdminsIsLoginException(String message) {
		super(message);
	}
	
}
