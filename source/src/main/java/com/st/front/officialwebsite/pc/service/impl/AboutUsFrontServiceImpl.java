package com.st.front.officialwebsite.pc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.front.officialwebsite.pc.OwFrontStatic;
import com.st.front.officialwebsite.pc.dao.AboutUsFrontDaoI;
import com.st.front.officialwebsite.pc.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.pc.pageModel.PageAboutUsFront;
import com.st.front.officialwebsite.pc.service.AboutUsFrontServiceI;
import com.st.front.officialwebsite.pc.util.OwFrontReturnJSON;
import com.st.front.officialwebsite.pc.util.OwFrontTools;
import com.st.model.OfficialwebsiteAboutUs;
@Service(value="aboutUsFrontService")
public class AboutUsFrontServiceImpl implements AboutUsFrontServiceI{
	//注入aboutUsFrontDao
	private AboutUsFrontDaoI aboutUsFrontDao;
	
	public AboutUsFrontDaoI getAboutUsFrontDao() {
		return aboutUsFrontDao;
	}
	@Autowired
	public void setAboutUsFrontDao(AboutUsFrontDaoI aboutUsFrontDao) {
		this.aboutUsFrontDao = aboutUsFrontDao;
	}
	@Override
	public OwFrontReturnJSON<PageAboutUsFront> getCarousels(PageAboutUsFront pageModel)
			throws OfficialwebsiteFrontException {
		OwFrontReturnJSON<PageAboutUsFront> retJSON = new OwFrontReturnJSON<PageAboutUsFront>();
		//定义查询记录及其记录条数的语句
		String rowsHql = "from "+OwFrontStatic.OW_HQL_TABLE_NAME_ABOUT_US+" t where t.isDelete=false and t.status=1";
		String lengthHql = "select count(*) from "+OwFrontStatic.OW_HQL_TABLE_NAME_ABOUT_US;
		//获取记录
		List<OfficialwebsiteAboutUs> tempRows = aboutUsFrontDao.get(rowsHql, pageModel.getPage(), pageModel.getRows());
		List<PageAboutUsFront> rows = OwFrontTools.copyPropertiesList(tempRows, PageAboutUsFront.class);
		//获取记录条数
		Integer total = aboutUsFrontDao.length(lengthHql);
		retJSON.setRows(rows);
		retJSON.setTotal(total);
		return retJSON;
	}
	

}
