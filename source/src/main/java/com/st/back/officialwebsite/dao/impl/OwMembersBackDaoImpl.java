package com.st.back.officialwebsite.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.back.officialwebsite.dao.OwMembersBackDaoI;
import com.st.dao.impl.BaseDaoImpl;
import com.st.model.OfficialwebsiteMembers;
@Repository(value="owMembersBackDao")
public class OwMembersBackDaoImpl extends BaseDaoImpl<OfficialwebsiteMembers> implements OwMembersBackDaoI{
	
}
