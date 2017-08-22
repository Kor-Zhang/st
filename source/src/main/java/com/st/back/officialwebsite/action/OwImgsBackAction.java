package com.st.back.officialwebsite.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.officialwebsite.OwBackStatic;
import com.st.back.officialwebsite.exception.OwImgsBackException;
import com.st.back.officialwebsite.pageModel.PageOwImgsAndInfoBack;
import com.st.back.officialwebsite.pageModel.PageOwImgsBack;
import com.st.back.officialwebsite.service.OwImgsBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.back.util.BackTools;
import com.st.model.Admins;
@Action(value="owImgsBackAction")
public class OwImgsBackAction extends OfficialwebsiteBackBaseAction  implements ModelDriven<PageOwImgsBack>{
	//注入owImgsBackService
	private OwImgsBackServiceI owImgsBackService;
	
	public OwImgsBackServiceI getOwImgsBackService() {
		return owImgsBackService;
	}
	@Autowired
	public void setOwImgsBackService(OwImgsBackServiceI owImgsBackService) {
		this.owImgsBackService = owImgsBackService;
	}


	//注入pageModel
	private PageOwImgsBack pageModel = new PageOwImgsBack();
	
	@Override
	public PageOwImgsBack getModel() {
		return pageModel;
	}
	
	
}
