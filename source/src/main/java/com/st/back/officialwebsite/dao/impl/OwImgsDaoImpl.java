package com.st.back.officialwebsite.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.back.officialwebsite.dao.OwImgsBackDaoI;
import com.st.dao.impl.BaseDaoImpl;
import com.st.model.Imgs;
@Repository(value="OwImgsBackDao")
public class OwImgsDaoImpl extends BaseDaoImpl<Imgs> implements OwImgsBackDaoI{
	
}
