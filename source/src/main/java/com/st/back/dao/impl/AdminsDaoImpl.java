package com.st.back.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.back.dao.AdminsDaoI;
import com.st.dao.impl.BaseDaoImpl;
import com.st.model.Admins;

@Repository("adminsDao")
public class AdminsDaoImpl extends BaseDaoImpl<Admins> implements AdminsDaoI{
	
}
