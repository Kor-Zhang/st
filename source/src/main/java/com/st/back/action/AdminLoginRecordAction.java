package com.st.back.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.BackStatic;
import com.st.back.exception.AdminsException;
import com.st.back.pageModel.PageAdminLoginRecord;
import com.st.back.service.AdminLoginRecordServiceI;
import com.st.back.util.BackReturnJSON;
import com.st.back.util.BackTools;
import com.st.model.Admins;

/**
 * 配置action
 * 
 * @author Jhon
 * 
 */

@Action(value = "adminLoginRecordAction")
public class AdminLoginRecordAction extends BackBaseAction implements ModelDriven<PageAdminLoginRecord> {
	
	public PageAdminLoginRecord pageAdminLoginRecord = new PageAdminLoginRecord();

	@Override
	public PageAdminLoginRecord getModel() {
		return pageAdminLoginRecord;
	}
	

	private AdminLoginRecordServiceI adminLoginRecordService;
	
	public AdminLoginRecordServiceI getAdminLoginRecordService() {
		return adminLoginRecordService;
	}
	@Autowired
	public void setAdminLoginRecordService(
			AdminLoginRecordServiceI adminLoginRecordService) {
		this.adminLoginRecordService = adminLoginRecordService;
	}
	
	
	public void getDatagrid(){
		/**
		 * 获取当前在线admin
		 * 执行事务
		 * 返回结果
		 */
		BackReturnJSON<PageAdminLoginRecord> returnJSON = new BackReturnJSON<PageAdminLoginRecord>();
		try {
			//1.获取当前在线admin
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			//2.执行事务
			returnJSON = adminLoginRecordService.getDatagrid(onlineAdmin,pageAdminLoginRecord);
			returnJSON.setMsg("读取信息成功！");
			returnJSON.setSuccess(true);
		} catch (AdminsException e) {
			returnJSON.setMsg(e.getMessage());
			returnJSON.setSuccess(false);
			e.printStackTrace();
		}finally{
			BackStatic.L.info(returnJSON);
			//返回结果
			super.writeJSON(returnJSON);
		}
	}
	
}
