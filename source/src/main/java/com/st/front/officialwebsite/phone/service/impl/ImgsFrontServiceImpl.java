package com.st.front.officialwebsite.phone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.front.officialwebsite.phone.dao.ImgsFrontDaoI;
import com.st.front.officialwebsite.phone.service.ImgsFrontServiceI;
@Service(value="imgsFrontPhoneService")
public class ImgsFrontServiceImpl implements ImgsFrontServiceI{
	//注入imgsFrontDao
	private ImgsFrontDaoI imgsFrontPhoneDao;

	public ImgsFrontDaoI getImgsFrontPhoneDao() {
		return imgsFrontPhoneDao;
	}

	public void setImgsFrontPhoneDao(ImgsFrontDaoI imgsFrontPhoneDao) {
		this.imgsFrontPhoneDao = imgsFrontPhoneDao;
	}


	
	
}
