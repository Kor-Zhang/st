package com.st.back.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.pageModel.PageAdminPower;
import com.st.back.service.AdminPowerServiceI;

/**
 * 配置action
 * 
 * @author Jhon
 * 
 */
@Action(value = "adminPowerAction")

public class AdminPowerAction extends BackBaseAction implements ModelDriven<PageAdminPower> {

	private PageAdminPower pageModel = new PageAdminPower();

	@Override
	public PageAdminPower getModel() {
		return pageModel;
	}
	
	//注入adminPowerService
	
	private AdminPowerServiceI adminPowerService;
	
	public AdminPowerServiceI getAdminPowerService() {
		return adminPowerService;
	}
	@Autowired
	public void setAdminPowerService(AdminPowerServiceI adminPowerService) {
		this.adminPowerService = adminPowerService;
	}
}
