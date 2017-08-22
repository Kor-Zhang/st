package com.st.back.officialwebsite.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.exception.AdminsException;
import com.st.back.officialwebsite.pageModel.PageOwServiceBack;
import com.st.back.officialwebsite.service.OwImgsAndInfoBackServiceI;
import com.st.back.officialwebsite.service.OwServiceBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.back.util.BackTools;
import com.st.model.Admins;
@Action(value="owServiceBackAction")
public class OwServiceBackAction extends OfficialwebsiteBackBaseAction  implements ModelDriven<PageOwServiceBack>{
	//注入owServiceBackService
	private OwServiceBackServiceI owServiceBackService;
	
	public OwServiceBackServiceI getOwServiceBackService() {
		return owServiceBackService;
	}
	@Autowired
	public void setOwServiceBackService(OwServiceBackServiceI owServiceBackService) {
		this.owServiceBackService = owServiceBackService;
	}

	//注入owImgsAndInfoBackService
	private OwImgsAndInfoBackServiceI owImgsAndInfoBackService;
	
	public OwImgsAndInfoBackServiceI getOwImgsAndInfoBackService() {
		return owImgsAndInfoBackService;
	}
	@Autowired
	public void setOwImgsAndInfoBackService(OwImgsAndInfoBackServiceI owImgsAndInfoBackService) {
		this.owImgsAndInfoBackService = owImgsAndInfoBackService;
	}


	//注入pageModel
	private PageOwServiceBack pageModel = new PageOwServiceBack();
	
	@Override
	public PageOwServiceBack getModel() {
		return pageModel;
	}
	/**
	 * 获取业务信息列表
	 */
	public void getDatagrid(){
		OwBackReturnJSON<PageOwServiceBack> retJSON = new OwBackReturnJSON<PageOwServiceBack>();
		try {
			Admins onlineAdmin = OwBackTools.getOnlineAdmin();
			retJSON = owServiceBackService.getDatagrid(onlineAdmin,pageModel);
			retJSON.setSuccess(true);
			retJSON.setMsg("读取信息成功！");
		}catch (Exception e) {
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
			e.printStackTrace();
		}finally{
			super.writeJSON(retJSON);
		}
	}
	
	/**
	 * 上传业务的文本信息
	 */
	public void uploadTextService(){
		OwBackReturnJSON retJSON = new OwBackReturnJSON();
		
        try {
        	Admins onlineAdmin = BackTools.getOnlineAdmin();
			//执行业务
        	owServiceBackService.uploadTextService(onlineAdmin,pageModel);
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
	/**
	 * 更新业务的文本信息
	 */
	public void updateTextService(){
		OwBackReturnJSON retJSON = new OwBackReturnJSON();
		
        try {
        	Admins onlineAdmin = BackTools.getOnlineAdmin();
			//执行业务
        	owServiceBackService.updateTextService(onlineAdmin,pageModel);
			retJSON.setMsg("更新成功！");
			retJSON.setSuccess(true);
		} catch (Exception e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}finally{
			OwBackTools.writeJSON(retJSON);
			
		}
		
		
	}
	public void deleteService(){
		/**
		 * 获取当前在线admin
		 * 执行事务
		 * 返回结果
		 */
		OwBackReturnJSON retJSON = new OwBackReturnJSON();
		try {
			//1.获取当前在线admin
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			//2.执行事务
			owServiceBackService.deleteService(onlineAdmin,pageModel);
			retJSON.setMsg("删除信息成功！");
			retJSON.setSuccess(true);
		} catch (AdminsException e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}catch (Exception e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}finally{
			//返回结果
			super.writeJSON(retJSON);
		}
	}
	
	

	
	
}
