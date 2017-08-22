package com.st.front.officialwebsite.pc.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.dao.impl.BaseDaoImpl;
import com.st.front.officialwebsite.pc.dao.ServiceFrontDaoI;
import com.st.model.OfficialwebsiteService;

@Repository(value="serviceFrontDao")
public class ServiceFrontDaoImpl extends BaseDaoImpl<OfficialwebsiteService> implements ServiceFrontDaoI{
	
}
