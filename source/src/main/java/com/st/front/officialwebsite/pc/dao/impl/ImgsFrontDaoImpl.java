package com.st.front.officialwebsite.pc.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.back.officialwebsite.dao.OwImgsBackDaoI;
import com.st.dao.impl.BaseDaoImpl;
import com.st.front.officialwebsite.pc.dao.ImgsFrontDaoI;
import com.st.model.Imgs;
@Repository(value="owImgsFrontDao")
public class ImgsFrontDaoImpl extends BaseDaoImpl<Imgs> implements ImgsFrontDaoI{
	
}
