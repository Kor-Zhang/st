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
import com.st.back.officialwebsite.dao.OwServiceBackDaoI;
import com.st.back.officialwebsite.exception.OfficialwebsiteBackException;
import com.st.back.officialwebsite.pageModel.PageOwServiceBack;
import com.st.back.officialwebsite.service.OwServiceBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.model.Admins;
import com.st.model.OfficialwebsiteService;
@Service(value="owServiceBackService")
public class OwServiceBackServiceImpl implements OwServiceBackServiceI{
	//注入owServiceBackDao
	private OwServiceBackDaoI owServiceBackDao;
	
	
	

	public OwServiceBackDaoI getOwServiceBackDao() {
		return owServiceBackDao;
	}
	@Autowired
	public void setOwServiceBackDao(OwServiceBackDaoI owServiceBackDao) {
		this.owServiceBackDao = owServiceBackDao;
	}
	@Override
	public OwBackReturnJSON<PageOwServiceBack> getDatagrid(Admins onlineAdmin,
			PageOwServiceBack pageModel) throws Exception {
		/**
		 * 1.判断当前用户是否拥有查询权限
		 * 2.执行
		 * 3.返回结果
		 */
		//验证301权限（查询权限）
		if(!OwBackTools.power(onlineAdmin.getId(),OwBackStatic.POWER_ID_QUERY_OW_SERVICE)){
			throw new OfficialwebsiteBackException("您没有查询业务的权限！");
		}
		//2.查询
		OwBackReturnJSON<PageOwServiceBack> retJSON = new OwBackReturnJSON<PageOwServiceBack>();
		Map<String,Object> params = OwBackTools.getHashMap();
		//hql语句，不查询当前用户和超级管理员们
		StringBuffer totalHql = new StringBuffer("select count(*) from "+OwBackStatic.OW_HQL_TABLE_NAME_SERVICE+" t where t.isDelete=false ");
		StringBuffer rowsHql = new StringBuffer("from "+OwBackStatic.OW_HQL_TABLE_NAME_SERVICE+" t where t.isDelete=false ");
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
		List<OfficialwebsiteService> beanList = owServiceBackDao.get(rowsHql.toString(),params,pageModel.getPage(),pageModel.getRows());
		//转化模型
		List<PageOwServiceBack> rows = OwBackTools.copyPropertiesList(beanList, PageOwServiceBack.class);
		/*for (PageOwServiceBack p : rows) {
			String newString = OwBackTools.cleanStringWrap(p.getText());
			p.setText(newString);
		}*/
		//查询total
		Integer total = owServiceBackDao.length(totalHql.toString(),params);

		retJSON.setRows(rows);
		retJSON.setTotal(total);
		//3.返回结果
		return retJSON;
	}
	@Override
	public void uploadTextService(Admins onlineAdmin,
			PageOwServiceBack pageModel) throws Exception {
		//验证303权限（查询权限）
		if(!OwBackTools.power(onlineAdmin.getId(),OwBackStatic.POWER_ID_ADD_OW_SERVICE)){
			throw new OfficialwebsiteBackException("您没有添加业务的权限！");
		}
		//初始化存储实体
		OfficialwebsiteService owService = new OfficialwebsiteService();
		BeanUtils.copyProperties(pageModel, owService);
		//设置参数
		Timestamp currtTime = new Timestamp(new Date().getTime());
		owService.setCreateTime(currtTime);
		owService.setUpdateTime(currtTime);
		owService.setReleaseTime(currtTime);
		owService.setId(UUID.randomUUID().toString());
		owService.setIsDelete(false);
		//清除\r\n
	/*	String newString = OwBackTools.cleanStringWrap(pageModel.getText());
		owService.setText(newString);*/
		owServiceBackDao.save(owService);
	}
	@Override
	public void updateTextService(Admins onlineAdmin,
			PageOwServiceBack pageModel) throws Exception {
		//验证304权限（更新权限）
		if(!OwBackTools.power(onlineAdmin.getId(),OwBackStatic.POWER_ID_UPDATE_OW_SERVICE)){
			throw new OfficialwebsiteBackException("您没有更新业务的权限！");
		}
		Timestamp now = new Timestamp(new Date().getTime());
		//初始化存储实体
		OfficialwebsiteService dbOwService = owServiceBackDao.findById(OfficialwebsiteService.class, pageModel.getId());
		//储存新信息
		dbOwService.setStatus(pageModel.getStatus());
		dbOwService.setRateOfProgress(pageModel.getRateOfProgress());
		dbOwService.setInvestor(pageModel.getInvestor());
		dbOwService.setUpdateTime(now);
		dbOwService.setDevelopers(pageModel.getDevelopers());
		dbOwService.setClazz(pageModel.getClazz());
		//清除\r\n
		/*String newString = OwBackTools.cleanStringWrap(pageModel.getText());
		dbOwService.setText(newString);*/
/*		dbOwService.setText(pageModel.getText());
*/		dbOwService.setTitle(pageModel.getTitle());
		dbOwService.setIntroduction(pageModel.getIntroduction());
		//设置参数
		owServiceBackDao.save(dbOwService);
		
	}
	@Override
	public void deleteService(Admins onlineAdmin, PageOwServiceBack pageModel)
			throws Exception {
		
		//验证302权限（删除权限）
		if(!OwBackTools.power(onlineAdmin.getId(),OwBackStatic.POWER_ID_DELETE_OW_SERVICE)){
			throw new OfficialwebsiteBackException("您没有删除业务的权限！");
		}
		// 2.删除
		String[] deleteIds = pageModel.getDeleteIds().split(",");
		for (String deleteId : deleteIds) {

			OfficialwebsiteService owService = owServiceBackDao.findById(OfficialwebsiteService.class, deleteId);
			owService.setIsDelete(true);
			// 记录下imgname
			/*String imgName = owService.getImgName();*/

			// 删除数据库
			owServiceBackDao.update(owService);

			// 删除文件图片
			/* Tools.deleteFile(Static.USERS_HEAD_PATH, imgName); */

		}
		
	}



}
