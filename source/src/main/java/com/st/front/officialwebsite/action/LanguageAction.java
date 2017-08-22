package com.st.front.officialwebsite.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.st.back.BackStatic;
import com.st.back.officialwebsite.pageModel.PageLanguage;
import com.st.front.officialwebsite.phone.OwFrontStatic;
import com.st.front.officialwebsite.phone.util.OwFrontTools;
@Action(value="languageAction", 
results = { @Result(name = "SUCCESS",location = "/front/officialwebsite/jsps/index.jsp") })
public class LanguageAction implements ModelDriven<PageLanguage>{
	PageLanguage pageModel = new PageLanguage();
	@Override
	public PageLanguage getModel() {
		return pageModel;
	}
	public String setLanguage(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession(true);
			//如果用户没有设置语言，那么根据浏览器的默认语言设置网站显示语言
			if(session.getAttribute("userLang") == null){
				/**
				 * 获取客户端语言
				 */
				Locale cilentlLcale = request.getLocale();
				OwFrontStatic.L.info("客户端语言："+cilentlLcale.getDisplayName());
				OwFrontStatic.L.info("服务器语言："+Locale.US.getDisplayName());
				//将客户端默认的语言设置为网站显示的语言
				if(cilentlLcale.getDisplayName().equals(Locale.US.getDisplayName())){
					pageModel.setLang("en_US");
				}else{
					pageModel.setLang("zh_CN");
					
				}
			}
			/**
			 * 根据pagemodel的lang字段设置当前语言
			 */
			
			if(!OwFrontTools.isEmptyTrimString(pageModel.getLang())){
				setUserLang(session);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "SUCCESS";
	
    }
	/**
	 * 更具pageModel中lang字段，设置struts2国际化语言；
	 * 将lang值放入session，前台读取显示当前的语言
	 * @param session
	 */
	public void setUserLang(HttpSession session){
		Locale locale = null;
        if (pageModel.getLang().equals("zh_CN")) {
            // 显示中文
            locale = Locale.CHINA;
        } else if (pageModel.getLang().equals("en_US")) {
            // 显示英文
            locale = Locale.US;
        }else{
        	// 默认显示中文
        	pageModel.setLang("zh_CN");
            locale = Locale.CHINA;
        }
        //设置前台显示的当前语言
        session.setAttribute("userLang",pageModel.getLang());
        //设置struts的国际化语言
        ActionContext.getContext().setLocale(locale);                                    
        session.setAttribute("WW_TRANS_I18N_LOCALE", locale);
	}
}

