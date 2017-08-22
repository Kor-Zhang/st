package com.st.front.officialwebsite.phone.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.dao.impl.BaseDaoImpl;
import com.st.front.officialwebsite.phone.dao.ContactUsFrontDaoI;
import com.st.model.OfficialwebsiteContactUs;

@Repository(value="contactUsFrontPhoneDao")
public class ContactUsFrontDaoImpl extends BaseDaoImpl<OfficialwebsiteContactUs> implements ContactUsFrontDaoI{
	
}
