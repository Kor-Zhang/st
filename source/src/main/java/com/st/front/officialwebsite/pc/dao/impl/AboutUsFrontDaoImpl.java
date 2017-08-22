package com.st.front.officialwebsite.pc.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.dao.impl.BaseDaoImpl;
import com.st.front.officialwebsite.pc.dao.AboutUsFrontDaoI;
import com.st.model.OfficialwebsiteAboutUs;

@Repository(value="aboutUsFrontDao")
public class AboutUsFrontDaoImpl extends BaseDaoImpl<OfficialwebsiteAboutUs> implements AboutUsFrontDaoI{
	
}
