package com.st.front.officialwebsite.pc.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.dao.impl.BaseDaoImpl;
import com.st.front.officialwebsite.pc.dao.MembersFrontDaoI;
import com.st.model.OfficialwebsiteMembers;

@Repository(value="membersFrontDao")
public class MembersFrontDaoImpl extends BaseDaoImpl<OfficialwebsiteMembers> implements MembersFrontDaoI{
	
}
