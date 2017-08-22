package com.st.front.officialwebsite.phone.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.dao.impl.BaseDaoImpl;
import com.st.front.officialwebsite.phone.dao.AboutUsFrontDaoI;
import com.st.model.OfficialwebsiteAboutUs;

@Repository(value="aboutUsFrontPhoneDao")
public class AboutUsFrontDaoImpl extends BaseDaoImpl<OfficialwebsiteAboutUs> implements AboutUsFrontDaoI{
	
}
