package com.st.back.officialwebsite.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.back.officialwebsite.dao.OwImgsAndInfoBackDaoI;
import com.st.dao.impl.BaseDaoImpl;
import com.st.model.ImgsAndInfo;
@Repository(value="OwImgsAndInfoBackDao")
public class OwImgsAndInfoDaoImpl extends BaseDaoImpl<ImgsAndInfo> implements OwImgsAndInfoBackDaoI{
	
}
