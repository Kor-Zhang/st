package com.st.front.officialwebsite.pc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.front.officialwebsite.pc.OwFrontStatic;
import com.st.front.officialwebsite.pc.dao.ImgsAndInfoFrontDaoI;
import com.st.front.officialwebsite.pc.dao.ImgsFrontDaoI;
import com.st.front.officialwebsite.pc.exception.OwImgsAndInfoFrontException;
import com.st.front.officialwebsite.pc.pageModel.PageImgsAndInfoFront;
import com.st.front.officialwebsite.pc.service.ImgsAndInfoFrontServiceI;
import com.st.front.officialwebsite.pc.util.OwFrontReturnJSON;
import com.st.front.officialwebsite.pc.util.OwFrontTools;
import com.st.model.Imgs;
import com.st.model.ImgsAndInfo;
@Service(value="imgsAndInfoFrontService")
public class ImgsAndInfoFrontServiceImpl implements ImgsAndInfoFrontServiceI{
	//注入imgsAndInfoFrontDao
	private ImgsAndInfoFrontDaoI imgsAndInfoFrontDao;
	
	
	
	public ImgsAndInfoFrontDaoI getImgsAndInfoFrontDao() {
		return imgsAndInfoFrontDao;
	}
	@Autowired
	public void setImgsAndInfoFrontDao(ImgsAndInfoFrontDaoI imgsAndInfoFrontDao) {
		this.imgsAndInfoFrontDao = imgsAndInfoFrontDao;
	}

	//注入imgsFrontDao
	private ImgsFrontDaoI imgsFrontDao;

	public ImgsFrontDaoI getImgsFrontDao() {
		return imgsFrontDao;
	}
	@Autowired
	public void setImgsFrontDao(ImgsFrontDaoI imgsFrontDao) {
		this.imgsFrontDao = imgsFrontDao;
	}
	@Override
	public OwFrontReturnJSON<PageImgsAndInfoFront> getImgsByInfoId(PageImgsAndInfoFront pageModel)
			throws OwImgsAndInfoFrontException {
		try {
			OwFrontReturnJSON<PageImgsAndInfoFront> retJSON = new OwFrontReturnJSON<PageImgsAndInfoFront>();
			Map<String,Object> params = OwFrontTools.getHashMap();
			//hql语句
			StringBuffer totalHql = new StringBuffer("select count(*) from "+OwFrontStatic.OW_HQL_TABLE_NAME_IMGS_AND_INFO+" t where t.infoId =:infoId and t.status = 1 and t.isDelete=false ");
			StringBuffer rowsHql = new StringBuffer("from "+OwFrontStatic.OW_HQL_TABLE_NAME_IMGS_AND_INFO+" t where t.infoId =:infoId and t.status = 1 and t.isDelete=false ");
			params.put("infoId", pageModel.getInfoId());
			//设置where条件
			//list储存需要添加where条件的hql语句
			List<StringBuffer> hqls = OwFrontTools.getArrayList();
			//设置需要添加where的语句
			hqls.add(totalHql);
			hqls.add(rowsHql);
			//添加wehre
			OwFrontTools.setSearchWhere(hqls, pageModel, params);
			OwFrontTools.setSortOrder(hqls, pageModel);
			//查询记录
			List<ImgsAndInfo> beanList = imgsAndInfoFrontDao.get(rowsHql.toString(),params,pageModel.getPage(),pageModel.getRows());
			//转化模型
			List<PageImgsAndInfoFront> rows = OwFrontTools.copyPropertiesList(beanList, PageImgsAndInfoFront.class);
			//获取，设置imgname
			for (PageImgsAndInfoFront imgsAndInfo : rows) {
				Imgs img = imgsFrontDao.findById(Imgs.class, imgsAndInfo.getImgId());
				imgsAndInfo.setImgName(img.getImgName());
			}
			//查询total
			Integer total = imgsAndInfoFrontDao.length(totalHql.toString(),params);

			retJSON.setRows(rows);
			retJSON.setTotal(total);
			//3.返回结果
			return retJSON;
		} catch (Exception e) {
			e.printStackTrace();
			throw new OwImgsAndInfoFrontException();
		}
	}
	@Override
	public PageImgsAndInfoFront getMainImgByInfoId(
			PageImgsAndInfoFront pageModel) throws OwImgsAndInfoFrontException {
		try {
			//获取main为1的imgsandinfo对象
			ImgsAndInfo imgsAndInfo = null;
			PageImgsAndInfoFront model = new PageImgsAndInfoFront();
			StringBuffer rowsHql = new StringBuffer("from "+OwFrontStatic.OW_HQL_TABLE_NAME_IMGS_AND_INFO+" t where t.infoId ='"+pageModel.getInfoId()+"' and t.status = 1 and t.isDelete=false and t.main=1");
			imgsAndInfo = imgsAndInfoFrontDao.find(rowsHql.toString());
			//如果没有图片,那么设置一个默认图片
			if(imgsAndInfo==null){
				model.setImgName(OwFrontStatic.OW_PATH_DEFAULT_IMG_NAME);
			}else{
				BeanUtils.copyProperties(imgsAndInfo, model);
				//获取imgs对象的imgname
				Imgs img =imgsFrontDao.findById(Imgs.class,imgsAndInfo.getImgId());
				model.setImgName(img.getImgName());
			}
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			throw new OwImgsAndInfoFrontException(e);
		}
	}

	
}
