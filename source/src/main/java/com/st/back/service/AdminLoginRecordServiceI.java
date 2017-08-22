package com.st.back.service;

import com.st.back.exception.AdminsException;
import com.st.back.pageModel.PageAdminLoginRecord;
import com.st.back.util.BackReturnJSON;
import com.st.model.Adminloginrecord;
import com.st.model.Admins;



public interface AdminLoginRecordServiceI {

	/**
	 * 更新登出时间
	 * @param alr
	 */
	void updateLogoffTime(Adminloginrecord alr);
	/**
	 * 获取datagrid
	 * @param onlineAdmin
	 * @param pageAdminLoginRecord
	 * @return
	 */
	BackReturnJSON<PageAdminLoginRecord> getDatagrid(Admins onlineAdmin,PageAdminLoginRecord pageAdminLoginRecord) throws AdminsException;
	
}
