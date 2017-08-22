package com.st.back.service;

import com.st.back.exception.AdminsException;
import com.st.back.pageModel.PageAdminUpdateRecord;
import com.st.back.util.BackReturnJSON;
import com.st.model.Admins;


public interface AdminUpdateRecordServiceI {

	BackReturnJSON<PageAdminUpdateRecord> getDatagrid(Admins onlineAdmin,
			PageAdminUpdateRecord pageAdminUpdateRecord) throws AdminsException;

	
}
