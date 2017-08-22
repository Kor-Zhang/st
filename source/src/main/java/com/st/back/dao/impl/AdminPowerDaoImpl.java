package com.st.back.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.back.dao.AdminPowerDaoI;
import com.st.dao.impl.BaseDaoImpl;
import com.st.model.Adminpower;

@Repository("adminPowerDao")
public class AdminPowerDaoImpl extends BaseDaoImpl<Adminpower> implements AdminPowerDaoI{
	
}
