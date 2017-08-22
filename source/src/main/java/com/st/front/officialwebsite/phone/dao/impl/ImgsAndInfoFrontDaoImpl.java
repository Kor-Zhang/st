package com.st.front.officialwebsite.phone.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.back.officialwebsite.dao.OwImgsAndInfoBackDaoI;
import com.st.dao.impl.BaseDaoImpl;
import com.st.front.officialwebsite.phone.dao.ImgsAndInfoFrontDaoI;
import com.st.model.ImgsAndInfo;
@Repository(value="imgsAndInfoFrontPhoneDao")
public class ImgsAndInfoFrontDaoImpl extends BaseDaoImpl<ImgsAndInfo> implements ImgsAndInfoFrontDaoI{
	
}
