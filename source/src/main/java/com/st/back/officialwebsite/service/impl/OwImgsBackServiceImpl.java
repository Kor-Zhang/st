package com.st.back.officialwebsite.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.back.officialwebsite.OwBackStatic;
import com.st.back.officialwebsite.dao.OwImgsBackDaoI;
import com.st.back.officialwebsite.dao.OwImgsBackDaoI;
import com.st.back.officialwebsite.exception.OwImgsBackException;
import com.st.back.officialwebsite.pageModel.PageOwImgsAndInfoBack;
import com.st.back.officialwebsite.pageModel.PageOwImgsBack;
import com.st.back.officialwebsite.pageModel.PageOwImgsBack;
import com.st.back.officialwebsite.service.OwImgsBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.model.Admins;
import com.st.model.Imgs;
@Service(value="owImgsBackService")
public class OwImgsBackServiceImpl implements OwImgsBackServiceI{
	//注入owImgsBackDao
	private OwImgsBackDaoI owImgsBackDao;
	
	public OwImgsBackDaoI getOwImgsBackDao() {
		return owImgsBackDao;
	}
	
	@Autowired
	public void setOwImgsBackDao(OwImgsBackDaoI owImgsBackDao) {
		this.owImgsBackDao = owImgsBackDao;
	}

	
	
}
