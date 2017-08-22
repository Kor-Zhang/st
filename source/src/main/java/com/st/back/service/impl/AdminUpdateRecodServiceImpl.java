package com.st.back.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.back.BackStatic;
import com.st.back.dao.AdminUpdateRecordDaoI;
import com.st.back.exception.AdminsException;
import com.st.back.pageModel.PageAdminUpdateRecord;
import com.st.back.service.AdminUpdateRecordServiceI;
import com.st.back.util.BackReturnJSON;
import com.st.back.util.BackTools;
import com.st.model.Admins;
import com.st.model.Adminupdaterecord;

@Service(value = "adminUpdateRecordService")
public class AdminUpdateRecodServiceImpl implements AdminUpdateRecordServiceI {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(AdminUpdateRecodServiceImpl.class);
	
	private AdminUpdateRecordDaoI adminUpdateRecordDao;
	
	
	
	public AdminUpdateRecordDaoI getAdminUpdateRecordDao() {
		return adminUpdateRecordDao;
	}
	@Autowired
	public void setAdminUpdateRecordDao(AdminUpdateRecordDaoI adminUpdateRecordDao) {
		this.adminUpdateRecordDao = adminUpdateRecordDao;
	}
	
	@Override
	public BackReturnJSON<PageAdminUpdateRecord> getDatagrid(Admins onlineAdmin,
			PageAdminUpdateRecord pageAdminUpdateRecord)
			throws AdminsException {
		/**
		 * 1.判断当前用户是否拥有查询权限
		 * 2.执行
		 * 3.返回结果
		 */
		//验证802权限（查看管理员更新记录权限）
		if(!BackTools.power(onlineAdmin.getId(),BackStatic.POWER_ID_QUERY_ADMIN_UPDATE)){
			throw new AdminsException("您没有查看管理员更新记录的权限！");
		}
		//2.查询
		BackReturnJSON<PageAdminUpdateRecord> returnJSON = new BackReturnJSON<PageAdminUpdateRecord>();
		Map<String,Object> params = BackTools.getHashMap();
		//hql语句
		StringBuffer totalHql = new StringBuffer("select count(*) from Adminupdaterecord a where a.isDelete=false ");
		StringBuffer rowsHql = new StringBuffer("from Adminupdaterecord a where a.isDelete=false ");
		//设置where条件
		//list储存需要添加where条件的hql语句
		List<StringBuffer> hqls = BackTools.getArrayList();
		//设置需要添加where的语句
		hqls.add(totalHql);
		hqls.add(rowsHql);
		//添加wehre
		setWhere(hqls, pageAdminUpdateRecord, params);
		//如果排序,拼筹hql
		if(pageAdminUpdateRecord.getSort()!=null&&!pageAdminUpdateRecord.getSort().trim().equals("")&&pageAdminUpdateRecord.getOrder()!=null&&!pageAdminUpdateRecord.getOrder().trim().equals("")){
			rowsHql.append( " order by "+pageAdminUpdateRecord.getSort()+" "+pageAdminUpdateRecord.getOrder());
		}

		logger.info(totalHql);
		logger.info(rowsHql);
		//查询记录
		List<Adminupdaterecord> adminsList = adminUpdateRecordDao.get(rowsHql.toString(),params,pageAdminUpdateRecord.getPage(),pageAdminUpdateRecord.getRows());
		
		//转化模型
		List<PageAdminUpdateRecord> tempRows = BackTools.copyPropertiesList(adminsList, PageAdminUpdateRecord.class);
		List<PageAdminUpdateRecord> rows = BackTools.getArrayList();
		//设置PageAdminLoginRecord的id属性
		int index = 0;
		for (Adminupdaterecord a : adminsList) {
			PageAdminUpdateRecord p = tempRows.get(index);
			p.setDoAdminId(a.getAdminsByDoAdminId().getId());
			p.setDoneAdminId(a.getAdminsByDoneAdminId().getId());
			rows.add(p);
			index++;
		}
		//查询total
		Integer total = adminUpdateRecordDao.length(totalHql.toString(),params);

		returnJSON.setRows(rows);
		returnJSON.setTotal(total);
		//3.返回结果
		return returnJSON;
	}
	
	/**
	 * 设置where条件
	 * @param hqls
	 * @param pageAdmin
	 * @param params
	 */
	private void setWhere(List<StringBuffer> hqls,PageAdminUpdateRecord pageAdmin,Map<String,Object> params) {
		//判断是否筛选id
		if(pageAdmin.getSearchId()!=null&&!pageAdmin.getSearchId().trim().equals("")){
			//对list中的所有需要添加where的hql语句循环遍历
			for (StringBuffer hql : hqls) {
				hql.append(" and a.adminsByDoAdminId.id like :searchId");
			}
			//填写参数
			params.put("searchId","%%"+pageAdmin.getSearchId()+"%%");
		}
	}
	
	
}
