package com.st.front.officialwebsite.phone.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.front.officialwebsite.phone.OwFrontStatic;
import com.st.front.officialwebsite.phone.dao.NewsFrontDaoI;
import com.st.front.officialwebsite.phone.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.phone.pageModel.PageNewsFront;
import com.st.front.officialwebsite.phone.service.NewsFrontServiceI;
import com.st.front.officialwebsite.phone.util.OwFrontTools;
import com.st.model.OfficialwebsiteNews;
@Service(value="newsFrontPhoneService")
public class NewsFrontServiceImpl implements NewsFrontServiceI{
	//注入newsFrontPhoneDao
	private NewsFrontDaoI newsFrontPhoneDao;
	
	
	public NewsFrontDaoI getNewsFrontPhoneDao() {
		return newsFrontPhoneDao;
	}
	@Autowired
	public void setNewsFrontPhoneDao(NewsFrontDaoI newsFrontPhoneDao) {
		this.newsFrontPhoneDao = newsFrontPhoneDao;
	}
	@Override
	public List<PageNewsFront> getNews(PageNewsFront pageModel)
			throws OfficialwebsiteFrontException {
		try {
			//定义查询记录及其记录条数的语句
			StringBuffer rowsHqlStringBuffer = new StringBuffer("from "+OwFrontStatic.OW_HQL_TABLE_NAME_NEWS+" t where t.isDelete=false and t.status=1 ");
			//设置条件
			OwFrontTools.setFilterCondition(OwFrontTools.getArrayList(new StringBuffer[]{rowsHqlStringBuffer})
							, pageModel);
			//添加排序语句
			rowsHqlStringBuffer.append(" order by "+pageModel.getSort()+" "+pageModel.getOrder()+" ");
			//获取记录无需分页
			List<OfficialwebsiteNews> tableRows = newsFrontPhoneDao.get(rowsHqlStringBuffer.toString(),pageModel.getPage(),pageModel.getRows());
			//模型转化
			List<PageNewsFront> rows = OwFrontTools.copyPropertiesList(tableRows, PageNewsFront.class);
			//设置记录
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			throw new OfficialwebsiteFrontException();
		}
	}
	@Override
	public PageNewsFront getNewsById(PageNewsFront pageModel)
			throws OfficialwebsiteFrontException {
		PageNewsFront model = new PageNewsFront();
		OfficialwebsiteNews news = newsFrontPhoneDao.findById(OfficialwebsiteNews.class, pageModel.getId());
		BeanUtils.copyProperties(news, model);
		return model;
	}
	

}
