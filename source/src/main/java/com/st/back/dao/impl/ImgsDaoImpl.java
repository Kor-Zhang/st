package com.st.back.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.back.dao.ImgsDaoI;
import com.st.dao.impl.BaseDaoImpl;
import com.st.model.Imgs;

@Repository("imgsDao")
public class ImgsDaoImpl extends BaseDaoImpl<Imgs> implements ImgsDaoI{
	
}
