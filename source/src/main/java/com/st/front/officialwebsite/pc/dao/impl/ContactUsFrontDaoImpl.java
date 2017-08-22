package com.st.front.officialwebsite.pc.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.dao.impl.BaseDaoImpl;
import com.st.front.officialwebsite.pc.dao.ContactUsFrontDaoI;
import com.st.model.OfficialwebsiteContactUs;

@Repository(value="contactUsFrontDao")
public class ContactUsFrontDaoImpl extends BaseDaoImpl<OfficialwebsiteContactUs> implements ContactUsFrontDaoI{
	
}
