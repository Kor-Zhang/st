package com.st.front.officialwebsite.pc.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.dao.impl.BaseDaoImpl;
import com.st.front.officialwebsite.pc.dao.NewsFrontDaoI;
import com.st.model.OfficialwebsiteNews;

@Repository(value="newsFrontDao")
public class NewsFrontDaoImpl extends BaseDaoImpl<OfficialwebsiteNews> implements NewsFrontDaoI{
	
}
