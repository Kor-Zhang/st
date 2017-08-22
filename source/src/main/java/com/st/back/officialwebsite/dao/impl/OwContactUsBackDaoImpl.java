package com.st.back.officialwebsite.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.back.officialwebsite.dao.OwContactUsBackDaoI;
import com.st.dao.impl.BaseDaoImpl;
import com.st.model.OfficialwebsiteContactUs;
@Repository(value="owContactUsBackDao")
public class OwContactUsBackDaoImpl extends BaseDaoImpl<OfficialwebsiteContactUs> implements OwContactUsBackDaoI{
	
}
