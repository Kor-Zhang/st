package com.st.front.officialwebsite.phone.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.dao.impl.BaseDaoImpl;
import com.st.front.officialwebsite.phone.dao.NewsFrontDaoI;
import com.st.model.OfficialwebsiteNews;

@Repository(value="newsFrontPhoneDao")
public class NewsFrontDaoImpl extends BaseDaoImpl<OfficialwebsiteNews> implements NewsFrontDaoI{
	
}
