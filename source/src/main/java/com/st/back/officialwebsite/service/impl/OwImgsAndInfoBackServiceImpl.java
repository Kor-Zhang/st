package com.st.back.officialwebsite.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.lucene.index.SegmentInfos.FindSegmentsFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.back.officialwebsite.OwBackStatic;
import com.st.back.officialwebsite.dao.OwImgsAndInfoBackDaoI;
import com.st.back.officialwebsite.dao.OwImgsBackDaoI;
import com.st.back.officialwebsite.exception.OwImgsAndInfoBackException;
import com.st.back.officialwebsite.pageModel.PageOwImgsAndInfoBack;
import com.st.back.officialwebsite.pageModel.PageOwImgsBack;
import com.st.back.officialwebsite.pageModel.PageOwNewsBack;
import com.st.back.officialwebsite.service.OwImgsAndInfoBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.model.Admins;
import com.st.model.Imgs;
import com.st.model.ImgsAndInfo;
import com.st.model.OfficialwebsiteNews;
@Service(value="owImgsAndInfoAndInfoBackService")
public class OwImgsAndInfoBackServiceImpl implements OwImgsAndInfoBackServiceI{
	//注入owImgsAndInfoBackDao
	private OwImgsAndInfoBackDaoI owImgsAndInfoBackDao;
	
	public OwImgsAndInfoBackDaoI getOwImgsAndInfoBackDao() {
		return owImgsAndInfoBackDao;
	}
	
	@Autowired
	public void setOwImgsAndInfoBackDao(OwImgsAndInfoBackDaoI owImgsAndInfoBackDao) {
		this.owImgsAndInfoBackDao = owImgsAndInfoBackDao;
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
	public OwBackReturnJSON<PageOwImgsAndInfoBack> getImgsByInfoId(
			Admins onlineAdmin, PageOwImgsAndInfoBack pageModel)
			throws OwImgsAndInfoBackException {
		try {
			OwBackReturnJSON<PageOwImgsAndInfoBack> retJSON = new OwBackReturnJSON<PageOwImgsAndInfoBack>();
			Map<String,Object> params = OwBackTools.getHashMap();
			//hql语句
			StringBuffer totalHql = new StringBuffer("select count(*) from "+OwBackStatic.OW_HQL_TABLE_NAME_IMGS_AND_INFO+" t where t.infoId =:infoId and t.status = 1 and t.isDelete=false ");
			StringBuffer rowsHql = new StringBuffer("from "+OwBackStatic.OW_HQL_TABLE_NAME_IMGS_AND_INFO+" t where t.infoId =:infoId and t.status = 1 and t.isDelete=false ");
			params.put("infoId", pageModel.getInfoId());
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
			List<ImgsAndInfo> beanList = owImgsAndInfoBackDao.get(rowsHql.toString(),params,pageModel.getPage(),pageModel.getRows());
			//转化模型
			List<PageOwImgsAndInfoBack> rows = OwBackTools.copyPropertiesList(beanList, PageOwImgsAndInfoBack.class);
			//获取，设置imgname
			for (PageOwImgsAndInfoBack imgsAndInfo : rows) {
				Imgs img = owImgsBackDao.findById(Imgs.class, imgsAndInfo.getImgId());
				imgsAndInfo.setImgName(img.getImgName());
			}
			//查询total
			Integer total = owImgsAndInfoBackDao.length(totalHql.toString(),params);

			retJSON.setRows(rows);
			retJSON.setTotal(total);
			//3.返回结果
			return retJSON;
		} catch (Exception e) {
			e.printStackTrace();
			throw new OwImgsAndInfoBackException();
		}
	}

	@Override
	public void deleteImgsByImgsAndInfoId(
			Admins onlineAdmin, PageOwImgsAndInfoBack pageModel)
			throws OwImgsAndInfoBackException {
		try {
			String[] deleteIds = pageModel.getDeleteIds().split(",");
			//删除imgs表的记录和imgsandinfo表的记录
			for (String deleteId : deleteIds) {
				ImgsAndInfo imgsAndInfo = owImgsAndInfoBackDao.findById(ImgsAndInfo.class, deleteId);
				imgsAndInfo.setIsDelete(true);
				Timestamp now = new Timestamp(new Date().getTime());
				imgsAndInfo.setDeleteTime(now);
				//获取需要删除的imgid
				String imgId = imgsAndInfo.getImgId();
				//撒谎年初imgsandinfo
				owImgsAndInfoBackDao.update(imgsAndInfo);
				//删除img
				Imgs img = new Imgs();
				img.setId(imgId);
				//保存需要删除的img文件名
				String imgName = img.getImgName();
				owImgsBackDao.delete(img);
				//删除文件
				OwBackTools.deleteFile(OwBackStatic.OW_PATH_NEWS_IMG, imgName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new OwImgsAndInfoBackException();
		}
		
	}

	@Override
	public void uploadImgs(PageOwImgsAndInfoBack pageModel,String path)
			throws OwImgsAndInfoBackException {
		String imgName = null;
		try {
			//生成uuid
			String uuid = UUID.randomUUID().toString();
			//写入磁盘
			imgName = OwBackTools.writeUploadFileToDSK(uuid, path, pageModel);
			//生成imgsandinfo
			ImgsAndInfo imgsAndInfo = new ImgsAndInfo();
			Timestamp now = new Timestamp(new Date().getTime());
			imgsAndInfo.setCreateTime(now);
			imgsAndInfo.setUpdateTime(now);
			imgsAndInfo.setId(uuid);
			imgsAndInfo.setImgId(uuid);
			imgsAndInfo.setInfoId(pageModel.getId());
			imgsAndInfo.setIsDelete(false);
			imgsAndInfo.setMain(false);
			imgsAndInfo.setStatus(1);
			owImgsAndInfoBackDao.save(imgsAndInfo);
			
			
			//生成imgs
			Imgs img = new Imgs();
			img.setId(uuid);
			img.setImgName(imgName);
			owImgsBackDao.save(img);

		}catch (Exception e) {
			e.printStackTrace();
			OwBackTools.deleteFile(path, imgName);
			throw new OwImgsAndInfoBackException();
		}
	}

	@Override
	public void UpdateImgMainByImgsAndInfoId(Admins onlineAdmin,
			String imgsAndInfoId)
			throws OwImgsAndInfoBackException {
		ImgsAndInfo imgsAndInfo = owImgsAndInfoBackDao.findById(ImgsAndInfo.class, imgsAndInfoId);
		String infoId = imgsAndInfo.getInfoId();
		//将所有的img的main重置为0
		owImgsAndInfoBackDao.executeHql("update "+OwBackStatic.OW_HQL_TABLE_NAME_IMGS_AND_INFO+" t set t.main = 0 where t.infoId = '"+infoId+"'");
		//将指定的的img的main设置为1
		owImgsAndInfoBackDao.executeHql("update "+OwBackStatic.OW_HQL_TABLE_NAME_IMGS_AND_INFO+" t set t.main = 1  where t.id='"+imgsAndInfoId+"'");
	}





	
}
