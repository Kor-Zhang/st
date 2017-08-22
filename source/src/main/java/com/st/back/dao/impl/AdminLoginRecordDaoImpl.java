package com.st.back.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.back.dao.AdminLoginRecordDaoI;
import com.st.dao.impl.BaseDaoImpl;
import com.st.model.Adminloginrecord;

@Repository("adminLoginRecordDao")
public class AdminLoginRecordDaoImpl extends BaseDaoImpl<Adminloginrecord> implements AdminLoginRecordDaoI{
	
}
 