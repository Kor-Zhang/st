package com.st.back.officialwebsite.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.back.exception.AdminsException;
import com.st.back.officialwebsite.OwBackStatic;
import com.st.back.officialwebsite.dao.OwAboutUsBackDaoI;
import com.st.back.officialwebsite.exception.OwAboutUsIsNotExistBackException;
import com.st.back.officialwebsite.exception.OfficialwebsiteBackException;
import com.st.back.officialwebsite.pageModel.PageOwAboutUsBack;
import com.st.back.officialwebsite.service.OwAboutUsBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.model.Admins;
import com.st.model.OfficialwebsiteAboutUs;
@Service(value="owAboutUsBackService")
public class OwAboutUsBackServiceImpl implements OwAboutUsBackServiceI{
	//注入owAboutUsBackDao
	private OwAboutUsBackDaoI owAboutUsBackDao;

	public OwAboutUsBackDaoI getOwAboutUsBackDao() {
		return owAboutUsBackDao;
	}
	@Autowired
	public void setOwAboutUsBackDao(OwAboutUsBackDaoI owAboutUsBackDao) {
		this.owAboutUsBackDao = owAboutUsBackDao;
	}
	@Override
	public OwBackReturnJSON<PageOwAboutUsBack> getDatagrid(Admins onlineAdmin,PageOwAboutUsBack pageModel)
			throws OfficialwebsiteBackException {
		/**
		 * 1.判断当前用户是否拥有查询权限
		 * 2.执行
		 * 3.返回结果
		 */
		//验证603权限（查看权限）
		if(!OwBackTools.power(onlineAdmin.getId(),OwBackStatic.POWER_ID_QUERY_OW_ABOUT_US)){
			throw new OfficialwebsiteBackException("您没有查看轮播的权限！");
		}
		//2.查询
		OwBackReturnJSON<PageOwAboutUsBack> retJSON = new OwBackReturnJSON<PageOwAboutUsBack>();
		Map<String,Object> params = OwBackTools.getHashMap();
		//hql语句，不查询当前用户和超级管理员们
		StringBuffer totalHql = new StringBuffer("select count(*) from "+OwBackStatic.OW_HQL_TABLE_NAME_ABOUT_US+" t where t.isDelete=false ");
		StringBuffer rowsHql = new StringBuffer("from "+OwBackStatic.OW_HQL_TABLE_NAME_ABOUT_US+" t where t.isDelete=false ");
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
		List<OfficialwebsiteAboutUs> beanList = owAboutUsBackDao.get(rowsHql.toString(),params,pageModel.getPage(),pageModel.getRows());
		//转化模型
		List<PageOwAboutUsBack> rows = OwBackTools.copyPropertiesList(beanList, PageOwAboutUsBack.class);
		
		//查询total
		Integer total = owAboutUsBackDao.length(totalHql.toString(),params);

		retJSON.setRows(rows);
		retJSON.setTotal(total);
		//3.返回结果
		return retJSON;
	}
	@Override
	public void uploadAboutUs(Admins onlineAdmin,
			PageOwAboutUsBack pageModel)
			throws OfficialwebsiteBackException {
		//验证601权限（添加权限）
		if(!OwBackTools.power(onlineAdmin.getId(),OwBackStatic.POWER_ID_ADD_OW_ABOUT_US)){
			throw new OfficialwebsiteBackException("您没有添加轮播的权限！");
		}
		String imgName = null;
		try {
			

			String uuid = UUID.randomUUID().toString();
			//写入文件
			imgName = OwBackTools.writeUploadFileToDSK(uuid, OwBackStatic.OW_PATH_ABOUT_US_IMG, pageModel);
			//设置储存实体的信息
			OfficialwebsiteAboutUs owAboutUs = new OfficialwebsiteAboutUs();
			BeanUtils.copyProperties(pageModel, owAboutUs);
			Timestamp currtTime = new Timestamp(new Date().getTime());
			owAboutUs.setCreateTime(currtTime);
			owAboutUs.setUpdateTime(currtTime);

			owAboutUs.setId(uuid);
			owAboutUs.setImgName(imgName);
			owAboutUs.setIsDelete(false);
			//写入数据库
			owAboutUsBackDao.save(owAboutUs);
		} catch (Exception e) {
			e.printStackTrace();
			OwBackTools.deleteFile(OwBackStatic.OW_PATH_ABOUT_US_IMG, imgName);
			throw new OfficialwebsiteBackException("上传错误！");
		}
		
	}
	@Override
	public void deleteAboutUs(Admins onlineAdmin,
			PageOwAboutUsBack pageModel) throws OfficialwebsiteBackException {
		//验证602权限（删除权限）
		if(!OwBackTools.power(onlineAdmin.getId(),OwBackStatic.POWER_ID_DELETE_OW_ABOUT_US)){
			throw new OfficialwebsiteBackException("您没有删除轮播的权限！");
		}
		// 2.删除
		String[] deleteIds = pageModel.getDeleteIds().split(",");
		for (String deleteId : deleteIds) {

			OfficialwebsiteAboutUs owAboutUs = owAboutUsBackDao.findById(OfficialwebsiteAboutUs.class, deleteId);
			owAboutUs.setIsDelete(true);
			// 记录下imgname
			String imgName = owAboutUs.getImgName();

			// 删除数据库
			owAboutUsBackDao.update(owAboutUs);

			// 删除文件图片
			/* Tools.deleteFile(Static.USERS_HEAD_PATH, imgName); */

		}

	}
	@Override
	public void updateAboutUs(Admins onlineAdmin,
			PageOwAboutUsBack pageModel) throws Exception {
		//验证604权限（更新权限）
		if(!OwBackTools.power(onlineAdmin.getId(),OwBackStatic.POWER_ID_UPDATE_OW_ABOUT_US)){
			throw new OfficialwebsiteBackException("您没有更新轮播的权限！");
		}
		String imgName = null;
		try {
			//获取数据库的实体的信息
			OfficialwebsiteAboutUs dbOwAboutUs = owAboutUsBackDao.findById(OfficialwebsiteAboutUs.class, pageModel.getId());
			//验证
			if(dbOwAboutUs==null||dbOwAboutUs.getIsDelete()==true){
				throw new OwAboutUsIsNotExistBackException("该轮播条目不存在！");
			}
			//写入文件
			//判断是否上传文件，如果没有上传文件，那么imgName==null
			if(null != pageModel.getUploadFile()){
				//获取旧图片
				String oldImgName = dbOwAboutUs.getImgName();
				//删除旧文件
				OwBackTools.deleteFile(OwBackStatic.OW_PATH_ABOUT_US_IMG, oldImgName);
				
				//获取文件的id
				String uuid = dbOwAboutUs.getId();
				//写入新文件
				imgName = OwBackTools.writeUploadFileToDSK(uuid,OwBackStatic.OW_PATH_ABOUT_US_IMG,pageModel);
			}
			
			//写入数据库
			//设置文件名
			if(null != imgName){
				
				dbOwAboutUs.setImgName(imgName);
			}
			//设置说明
			dbOwAboutUs.setIntroduction(pageModel.getIntroduction());
			//设置状态
			dbOwAboutUs.setStatus(pageModel.getStatus());
			//设置最后更新时间
			dbOwAboutUs.setUpdateTime(new Timestamp(new Date().getTime()));
			//写入数据库
			owAboutUsBackDao.update(dbOwAboutUs);
		} catch (Exception e) {
			//出现异常，那么刚才上传的删除文件
			OwBackTools.deleteFile(OwBackStatic.OW_PATH_ABOUT_US_IMG, imgName);
			e.printStackTrace();
			throw e;
		}
	}
	
}
