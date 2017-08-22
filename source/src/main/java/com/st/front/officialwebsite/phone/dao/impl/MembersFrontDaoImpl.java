package com.st.front.officialwebsite.phone.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.dao.impl.BaseDaoImpl;
import com.st.front.officialwebsite.phone.dao.MembersFrontDaoI;
import com.st.model.OfficialwebsiteMembers;

@Repository(value="membersFrontPhoneDao")
public class MembersFrontDaoImpl extends BaseDaoImpl<OfficialwebsiteMembers> implements MembersFrontDaoI{
	
}
