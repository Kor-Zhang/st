package com.st.back.officialwebsite.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.back.officialwebsite.dao.OwNewsBackDaoI;
import com.st.dao.impl.BaseDaoImpl;
import com.st.model.OfficialwebsiteNews;
@Repository(value="owNewsBackDao")
public class OwNewsBackDaoImpl extends BaseDaoImpl<OfficialwebsiteNews> implements OwNewsBackDaoI{
	
}
