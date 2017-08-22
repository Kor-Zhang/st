package com.st.back.officialwebsite.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.st.back.officialwebsite.pageModel.PageOwAboutUsBack;
import com.st.back.officialwebsite.service.OwAboutUsBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.back.util.BackTools;
import com.st.model.Admins;
public class OwAboutUsUploadBackAction implements ModelDriven<PageOwAboutUsBack>{
	private OwAboutUsBackServiceI owAboutUsBackService;
	//注入owAboutUsBackService
	public OwAboutUsBackServiceI getOwAboutUsBackService() {
		return owAboutUsBackService;
	}
	@Autowired
	public void setOwAboutUsBackService(
			OwAboutUsBackServiceI owAboutUsBackService) {
		this.owAboutUsBackService = owAboutUsBackService;
	}
	//注入pageModel
	private PageOwAboutUsBack pageModel = new PageOwAboutUsBack();
	@Override
	public PageOwAboutUsBack getModel() {
		return pageModel;
	}

	/**
	 * 上传轮播
	 */
	public void uploadAboutUs(){
		OwBackReturnJSON retJSON = new OwBackReturnJSON();
		
        try {
        	Admins onlineAdmin = BackTools.getOnlineAdmin();
			//执行业务
        	owAboutUsBackService.uploadAboutUs(onlineAdmin,pageModel);
			retJSON.setMsg("添加成功！");
			retJSON.setSuccess(true);
		} catch (Exception e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}finally{
			OwBackTools.writeJSON(retJSON);
			
		}
		
		
	}
	
}
