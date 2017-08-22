package com.st.back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.back.dao.AdminPowerDaoI;
import com.st.back.service.AdminPowerServiceI;

@Service(value = "adminPowerService")
public class AdminPowerServiceImpl implements AdminPowerServiceI{
	//注入adminPowerDao
	private AdminPowerDaoI adminPowerDao;

	public AdminPowerDaoI getAdminPowerDao() {
		return adminPowerDao;
	}
	@Autowired
	public void setAdminPowerDao(AdminPowerDaoI adminPowerDao) {
		this.adminPowerDao = adminPowerDao;
	}
	
	
}
