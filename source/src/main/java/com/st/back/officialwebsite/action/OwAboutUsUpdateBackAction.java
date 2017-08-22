package com.st.back.officialwebsite.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.officialwebsite.exception.OwAboutUsIsNotExistBackException;
import com.st.back.officialwebsite.pageModel.PageOwAboutUsBack;
import com.st.back.officialwebsite.service.OwAboutUsBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.back.util.BackTools;
import com.st.model.Admins;
public class OwAboutUsUpdateBackAction implements ModelDriven<PageOwAboutUsBack>{
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
	 * 更新轮播
	 */
	public void updateAboutUs(){
		OwBackReturnJSON retJSON = new OwBackReturnJSON();
		
        try {
        	Admins onlineAdmin = BackTools.getOnlineAdmin();
			//执行业务
        	owAboutUsBackService.updateAboutUs(onlineAdmin,pageModel);
			retJSON.setMsg("更新成功！");
			retJSON.setSuccess(true);
		}catch (OwAboutUsIsNotExistBackException e) {
			//没有该记录
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(true);
			e.printStackTrace();
		}catch (Exception e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}finally{
			OwBackTools.writeJSON(retJSON);
			
		}
		
		
	}
	
}
