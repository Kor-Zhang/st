package com.st.back.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.exception.AdminsException;
import com.st.back.pageModel.PageAdminUpdateRecord;
import com.st.back.service.AdminUpdateRecordServiceI;
import com.st.back.util.BackReturnJSON;
import com.st.back.util.BackTools;
import com.st.model.Admins;

/**
 * 配置action
 * 
 * @author Jhon
 * 
 */
@Action(value = "adminUpdateRecordAction")
public class AdminUpdateRecordAction extends BackBaseAction implements
		ModelDriven<PageAdminUpdateRecord> {

	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(AdminUpdateRecordAction.class);
	public PageAdminUpdateRecord pageAdminUpdateRecord = new PageAdminUpdateRecord();
	@Override
	public PageAdminUpdateRecord getModel() {
		return pageAdminUpdateRecord;
	}
	

	private AdminUpdateRecordServiceI adminUpdateRecordService;

	public AdminUpdateRecordServiceI getAdminUpdateRecordService() {
		return adminUpdateRecordService;
	}
	@Autowired
	public void setAdminUpdateRecordService(
			AdminUpdateRecordServiceI adminUpdateRecordService) {
		this.adminUpdateRecordService = adminUpdateRecordService;
	}

	public void getDatagrid() {
		/**
		 * 获取当前在线admin 执行事务 返回结果
		 */
		BackReturnJSON<PageAdminUpdateRecord> returnJSON = new BackReturnJSON<PageAdminUpdateRecord>();
		try {
			// 1.获取当前在线admin
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			// 2.执行事务
			returnJSON = adminUpdateRecordService.getDatagrid(onlineAdmin,pageAdminUpdateRecord);
			returnJSON.setMsg("读取信息成功！");
			returnJSON.setSuccess(true);
		} catch (AdminsException e) {
			returnJSON.setMsg(e.getMessage());
			returnJSON.setSuccess(false);
			e.printStackTrace();
		} finally {
			logger.info(returnJSON);
			// 返回结果
			super.writeJSON(returnJSON);
		}
	}


}
