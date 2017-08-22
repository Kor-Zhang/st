package com.st.front.officialwebsite.pc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.front.officialwebsite.pc.dao.ImgsFrontDaoI;
import com.st.front.officialwebsite.pc.service.ImgsFrontServiceI;
@Service(value="imgsFrontService")
public class ImgsFrontServiceImpl implements ImgsFrontServiceI{
	//注入imgsFrontDao
	private ImgsFrontDaoI imgsFrontDao;

	public ImgsFrontDaoI getImgsFrontDao() {
		return imgsFrontDao;
	}
	@Autowired
	public void setImgsFrontDao(ImgsFrontDaoI imgsFrontDao) {
		this.imgsFrontDao = imgsFrontDao;
	}
	
	

	
	
}
