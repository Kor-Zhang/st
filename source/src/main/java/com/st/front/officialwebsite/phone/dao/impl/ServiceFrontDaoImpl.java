package com.st.front.officialwebsite.phone.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.dao.impl.BaseDaoImpl;
import com.st.front.officialwebsite.phone.dao.ServiceFrontDaoI;
import com.st.model.OfficialwebsiteService;

@Repository(value="serviceFrontPhoneDao")
public class ServiceFrontDaoImpl extends BaseDaoImpl<OfficialwebsiteService> implements ServiceFrontDaoI{
	
}
