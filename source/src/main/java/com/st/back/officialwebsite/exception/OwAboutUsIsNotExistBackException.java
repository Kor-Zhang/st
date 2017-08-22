package com.st.back.officialwebsite.exception;

import org.aspectj.apache.bcel.ExceptionConstants;

import com.st.back.exception.STBackException;
/**
 * 成员不存在的异常
 * @author Kor_Zhang
 *
 */
public class OwAboutUsIsNotExistBackException extends OfficialwebsiteBackException{

	public OwAboutUsIsNotExistBackException() {
		super();
	}


	public OwAboutUsIsNotExistBackException(String message) {
		super(message);
	}


}
