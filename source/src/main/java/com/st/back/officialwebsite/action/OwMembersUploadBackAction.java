package com.st.back.officialwebsite.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.officialwebsite.pageModel.PageOwMembersBack;
import com.st.back.officialwebsite.service.OwMembersBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.back.util.BackTools;
import com.st.model.Admins;

public class OwMembersUploadBackAction extends OfficialwebsiteBackBaseAction  implements ModelDriven<PageOwMembersBack>{
	private OwMembersBackServiceI owMembersBackService;
	//注入owMembersBackService
	public OwMembersBackServiceI getOwMembersBackService() {
		return owMembersBackService;
	}
	@Autowired
	public void setOwMembersBackService(
			OwMembersBackServiceI owMembersBackService) {
		this.owMembersBackService = owMembersBackService;
	}
	//注入pageModel
	private PageOwMembersBack pageModel = new PageOwMembersBack();
	@Override
	public PageOwMembersBack getModel() {
		return pageModel;
	}

	
	/**
	 * 上传成员的信息
	 */
	public void uploadMembers(){
		OwBackReturnJSON retJSON = new OwBackReturnJSON();
		
        try {
        	Admins onlineAdmin = BackTools.getOnlineAdmin();
			//执行业务
        	owMembersBackService.uploadMembers(onlineAdmin,pageModel);
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
