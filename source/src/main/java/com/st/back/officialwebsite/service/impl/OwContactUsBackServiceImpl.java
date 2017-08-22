package com.st.back.officialwebsite.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.back.officialwebsite.OwBackStatic;
import com.st.back.officialwebsite.dao.OwContactUsBackDaoI;
import com.st.back.officialwebsite.exception.OfficialwebsiteBackException;
import com.st.back.officialwebsite.pageModel.PageOwContactUsBack;
import com.st.back.officialwebsite.service.OwContactUsBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.model.Admins;
import com.st.model.OfficialwebsiteContactUs;
@Service(value="owContactUsBackService")
public class OwContactUsBackServiceImpl implements OwContactUsBackServiceI{
	//注入owIndexDisplayBackDao
	private OwContactUsBackDaoI owContactUsBackDao;
	
	public OwContactUsBackDaoI getOwContactUsBackDao() {
		return owContactUsBackDao;
	}
	@Autowired
	public void setOwContactUsBackDao(OwContactUsBackDaoI owContactUsBackDao) {
		this.owContactUsBackDao = owContactUsBackDao;
	}
	@Override
	public OwBackReturnJSON<PageOwContactUsBack> getDatagrid(Admins onlineAdmin,PageOwContactUsBack pageModel)
			throws OfficialwebsiteBackException {
		/**
		 * 1.判断当前用户是否拥有查询权限
		 * 2.执行
		 * 3.返回结果
		 */
		//验证701权限（查看权限）
		if(!OwBackTools.power(onlineAdmin.getId(),OwBackStatic.POWER_ID_QUERY_CONTACT_US)){
			throw new OfficialwebsiteBackException("您没有查看用户意见的权限！");
		}
		//2.查询
		OwBackReturnJSON<PageOwContactUsBack> retJSON = new OwBackReturnJSON<PageOwContactUsBack>();
		Map<String,Object> params = OwBackTools.getHashMap();
		//hql语句，不查询当前用户和超级管理员们
		StringBuffer totalHql = new StringBuffer("select count(*) from "+OwBackStatic.OW_HQL_TABLE_NAME_CONTACT_US+" t where t.isDelete=false ");
		StringBuffer rowsHql = new StringBuffer("from "+OwBackStatic.OW_HQL_TABLE_NAME_CONTACT_US+" t where t.isDelete=false ");
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
		List<OfficialwebsiteContactUs> beanList = owContactUsBackDao.get(rowsHql.toString(),params,pageModel.getPage(),pageModel.getRows());
		OwBackStatic.L.info(beanList);
		//转化模型
		List<PageOwContactUsBack> rows = OwBackTools.copyPropertiesList(beanList, PageOwContactUsBack.class);
		//查询total
		Integer total = owContactUsBackDao.length(totalHql.toString(),params);
		OwBackStatic.L.info(rows);
		retJSON.setRows(rows);
		retJSON.setTotal(total);
		//3.返回结果
		return retJSON;
	}
	@Override
	public void deleteContactUs(Admins onlineAdmin,
			PageOwContactUsBack pageModel) throws Exception {
		//验证702权限（删除权限）
		if(!OwBackTools.power(onlineAdmin.getId(),OwBackStatic.POWER_ID_DELETE_CONTACT_US)){
			throw new OfficialwebsiteBackException("您没有删除用户意见的权限！");
		}
		// 2.删除
		String[] deleteIds = pageModel.getDeleteIds().split(",");
		for (String deleteId : deleteIds) {

			OfficialwebsiteContactUs owContactUs = owContactUsBackDao.findById(OfficialwebsiteContactUs.class, deleteId);
			owContactUs.setIsDelete(true);
			

			// 删除数据库
			owContactUsBackDao.update(owContactUs);

			// 删除文件图片
			/* Tools.deleteFile(Static.USERS_HEAD_PATH, imgName); */

		}

	}
	
	
	@Override
	public void UpdateContactUsStatus(Admins onlineAdmin,
			PageOwContactUsBack pageModel) throws Exception {
		//验证703权限（更新权限）
		if(!OwBackTools.power(onlineAdmin.getId(),OwBackStatic.POWER_ID_UPDATE_CONTACT_US)){
			throw new OfficialwebsiteBackException("您没有更新用户意见的权限！");
		}
		OfficialwebsiteContactUs dbOwContactUs = owContactUsBackDao.findById(OfficialwebsiteContactUs.class,pageModel.getId());
		//数据库的状态
		Integer dbStatus = dbOwContactUs.getStatus();
		//当前新状态
		Integer currtStatus =pageModel.getStatus();
		//数据库状态为提交
		if(dbStatus==OwBackStatic.OFFICIALWEBSITE_CONTACT_US_STATUS_SUBMITED){
			//新状态为接收
			if(currtStatus==OwBackStatic.OFFICIALWEBSITE_CONTACT_US_STATUS_RECEIVE){
				//写入数据库
				dbOwContactUs.setStatus(OwBackStatic.OFFICIALWEBSITE_CONTACT_US_STATUS_RECEIVE);
				//设置受理的admin
				
				dbOwContactUs.setDealAdminId(pageModel.getDealAdminId());
			}else{
				throw new Exception("新状态错误！");
			}
		}else if(dbStatus==OwBackStatic.OFFICIALWEBSITE_CONTACT_US_STATUS_RECEIVE){
			//新状态为处理完毕
			if(currtStatus==OwBackStatic.OFFICIALWEBSITE_CONTACT_US_STATUS_DEALED){
				//写入数据库
				dbOwContactUs.setStatus(OwBackStatic.OFFICIALWEBSITE_CONTACT_US_STATUS_DEALED);
				//设置备注
				dbOwContactUs.setAdminNote(pageModel.getAdminNote());
			}else{
				throw new Exception("新状态错误！");
			}
		}else if(dbStatus==OwBackStatic.OFFICIALWEBSITE_CONTACT_US_STATUS_DEALED){
			
		}
	}
}
