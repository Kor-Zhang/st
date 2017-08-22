package com.st.back.officialwebsite.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.back.officialwebsite.dao.OwAboutUsBackDaoI;
import com.st.dao.impl.BaseDaoImpl;
import com.st.model.OfficialwebsiteAboutUs;
@Repository(value="owAboutUsBackDao")
public class OwAboutUsBackDaoImpl extends BaseDaoImpl<OfficialwebsiteAboutUs> implements OwAboutUsBackDaoI{
	
}
