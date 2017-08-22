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
import com.st.back.officialwebsite.dao.OwNewsBackDaoI;
import com.st.back.officialwebsite.exception.OfficialwebsiteBackException;
import com.st.back.officialwebsite.pageModel.PageOwImgsBack;
import com.st.back.officialwebsite.pageModel.PageOwNewsBack;
import com.st.back.officialwebsite.service.OwNewsBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.model.Admins;
import com.st.model.Imgs;
import com.st.model.OfficialwebsiteNews;
@Service(value="owNewsBackService")
public class OwNewsBackServiceImpl implements OwNewsBackServiceI{
	//注入owNewsBackDao
	private OwNewsBackDaoI owNewsBackDao;
	
	public OwNewsBackDaoI getOwNewsBackDao() {
		return owNewsBackDao;
	}
	@Autowired
	public void setOwNewsBackDao(OwNewsBackDaoI owNewsBackDao) {
		this.owNewsBackDao = owNewsBackDao;
	}
	//注入owImgsBackDao
	private OwImgsBackDaoI owImgsBackDao;
	
	
	public OwImgsBackDaoI getOwImgsBackDao() {
		return owImgsBackDao;
	}
	@Autowired
	public void setOwImgsBackDao(OwImgsBackDaoI owImgsBackDao) {
		this.owImgsBackDao = owImgsBackDao;
	}
	@Override
	public void uploadTextNews(Admins onlineAdmin, PageOwNewsBack pageModel)
			throws Exception {
		//验证901权限（添加权限）
		if(!OwBackTools.power(onlineAdmin.getId(),OwBackStatic.POWER_ID_ADD_OW_NEWS)){
			throw new OfficialwebsiteBackException("您没有添加新闻的权限！");
		}
		//初始化存储实体
		OfficialwebsiteNews owNews = new OfficialwebsiteNews();
		//copy信息
		BeanUtils.copyProperties(pageModel, owNews);
		//设置参数
		Timestamp currtTime = new Timestamp(new Date().getTime());
		owNews.setCreateTime(currtTime);
		owNews.setUpdateTime(currtTime);
		owNews.setReleaseTime(currtTime);
		owNews.setId(UUID.randomUUID().toString());
		owNews.setIsDelete(false);
		owNewsBackDao.save(owNews);
	}
	@Override
	public void updateTextNews(Admins onlineAdmin, PageOwNewsBack pageModel)
			throws Exception {
		//验证904权限（更新权限）
		if(!OwBackTools.power(onlineAdmin.getId(),OwBackStatic.POWER_ID_UPDATE_OW_NEWS)){
			throw new OfficialwebsiteBackException("您没有更新新闻的权限！");
		}
		//初始化存储实体
		OfficialwebsiteNews dbOwNews = owNewsBackDao.findById(OfficialwebsiteNews.class, pageModel.getId());
		//储存新信息
		dbOwNews.setStatus(pageModel.getStatus());
		dbOwNews.setText(pageModel.getText());
		dbOwNews.setTitle(pageModel.getTitle());
		dbOwNews.setAuthour(pageModel.getAuthour());
		dbOwNews.setClazz(pageModel.getClazz());
		//设置参数
		owNewsBackDao.save(dbOwNews);
	}
	@Override
	public OwBackReturnJSON<PageOwNewsBack> getDatagrid(
			Admins onlineAdmin, PageOwNewsBack pageModel) throws Exception {
		/**
		 * 1.判断当前用户是否拥有查询权限
		 * 2.执行
		 * 3.返回结果
		 */
		//验证903权限（查看权限）
		if(!OwBackTools.power(onlineAdmin.getId(),OwBackStatic.POWER_ID_QUERY_OW_NEWS)){
			throw new OfficialwebsiteBackException("您没有查看新闻的权限！");
		}
		//2.查询
		OwBackReturnJSON<PageOwNewsBack> retJSON = new OwBackReturnJSON<PageOwNewsBack>();
		Map<String,Object> params = OwBackTools.getHashMap();
		//hql语句，不查询当前用户和超级管理员们
		StringBuffer totalHql = new StringBuffer("select count(*) from "+OwBackStatic.OW_HQL_TABLE_NAME_NEWS+" t where t.isDelete=false ");
		StringBuffer rowsHql = new StringBuffer("from "+OwBackStatic.OW_HQL_TABLE_NAME_NEWS+" t where t.isDelete=false ");
		//设置where条件
		//list储存需要添加where条件的hql语句
		List<StringBuffer> hqls = OwBackTools.getArrayList();
		//设置需要添加where的语句
		hqls.add(totalHql);
		hqls.add(rowsHql);
		//添加wehre
		OwBackTools.setSearchWhere(hqls, pageModel, params);
		OwBackTools.setSortOrder(hqls, pageModel);
		//查询记录
		List<OfficialwebsiteNews> beanList = owNewsBackDao.get(rowsHql.toString(),params,pageModel.getPage(),pageModel.getRows());
		//转化模型
		List<PageOwNewsBack> rows = OwBackTools.copyPropertiesList(beanList, PageOwNewsBack.class);
		
		//查询total
		Integer total = owNewsBackDao.length(totalHql.toString(),params);

		retJSON.setRows(rows);
		retJSON.setTotal(total);
		//3.返回结果
		return retJSON;
	}
	@Override
	public void deleteNews(Admins onlineAdmin, PageOwNewsBack pageModel)
			throws Exception {
		//验证902权限（删除权限）
		if(!OwBackTools.power(onlineAdmin.getId(),OwBackStatic.POWER_ID_DELETE_OW_NEWS)){
			throw new OfficialwebsiteBackException("您没有删除新闻的权限！");
		}
		// 2.删除
		String[] deleteIds = pageModel.getDeleteIds().split(",");
		for (String deleteId : deleteIds) {

			OfficialwebsiteNews owNews = owNewsBackDao.findById(OfficialwebsiteNews.class, deleteId);
			owNews.setIsDelete(true);
			// 记录下imgname
			/*String imgName = owNews.getImgName();*/

			// 删除数据库
			owNewsBackDao.update(owNews);

			// 删除文件图片
			/* Tools.deleteFile(Static.USERS_HEAD_PATH, imgName); */

		}
	}
	
	
}
