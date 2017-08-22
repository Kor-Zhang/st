package com.st.back.officialwebsite.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.back.officialwebsite.dao.OwServiceBackDaoI;
import com.st.dao.impl.BaseDaoImpl;
import com.st.model.OfficialwebsiteService;
@Repository(value="OwServiceBackDao")
public class OwServiceDaoImpl extends BaseDaoImpl<OfficialwebsiteService> implements OwServiceBackDaoI{
	
}
