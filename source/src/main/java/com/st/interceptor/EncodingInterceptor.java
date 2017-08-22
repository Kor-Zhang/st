package com.st.interceptor;

import org.slf4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.st.PubStatic;
import com.st.util.PubTools;


public class EncodingInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		PubStatic.L.info("---------------------------------------------设置编码--------------------------------------");
		PubTools.getReq().setCharacterEncoding("utf-8");
		PubTools.getRes().setContentType("text/html;charset=UTF-8;");
		PubTools.getRes().setCharacterEncoding("utf-8");
		return ai.invoke();
	}
	

}
