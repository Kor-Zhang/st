package com.st.back.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.st.back.util.BackReturnJSON;
import com.st.back.util.BackTools;

/**
 * 配置action
 * 
 * @author Jhon
 * 
 */

public class ErorrsAction extends ActionSupport{

	public void uploadError(){
		BackReturnJSON retJSON = new BackReturnJSON();
		Exception e = (Exception) ActionContext.getContext().getValueStack().findValue("Exception");
		retJSON.setMsg("上传错误！");
		retJSON.setSuccess(false);
		BackTools.writeJSON(retJSON);
	}
	
}
