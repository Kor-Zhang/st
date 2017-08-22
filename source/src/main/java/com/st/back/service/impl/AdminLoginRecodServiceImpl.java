package com.st.back.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.back.BackStatic;
import com.st.back.dao.AdminLoginRecordDaoI;
import com.st.back.exception.AdminsException;
import com.st.back.pageModel.PageAdminLoginRecord;
import com.st.back.service.AdminLoginRecordServiceI;
import com.st.back.util.BackReturnJSON;
import com.st.back.util.BackTools;
import com.st.model.Adminloginrecord;
import com.st.model.Admins;

@Service(value = "adminLoginRecordService")
public class AdminLoginRecodServiceImpl implements AdminLoginRecordServiceI {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(AdminLoginRecodServiceImpl.class);
	
	private AdminLoginRecordDaoI adminLoginRecordDao;
	
	public AdminLoginRecordDaoI getAdminLoginRecordDao() {
		return adminLoginRecordDao;
	}
	@Autowired
	public void setAdminLoginRecordDao(AdminLoginRecordDaoI adminLoginRecordDao) {
		this.adminLoginRecordDao = adminLoginRecordDao;
	}
	
	
	@Override
	public void updateLogoffTime(Adminloginrecord alr) {
		adminLoginRecordDao.update(alr);
	}
	@Override
	public BackReturnJSON<PageAdminLoginRecord> getDatagrid(Admins onlineAdmin,
			PageAdminLoginRecord pageAdminLoginRecord)
			throws AdminsException {
		
		/**
		 * 1.判断当前用户是否拥有查询权限
		 * 2.执行
		 * 3.返回结果
		 */
		//1.验证801权限（查询管理员登陆记录权限）
		if(!BackTools.power(onlineAdmin.getId(),BackStatic.POWER_ID_QUERY_ADMIN_LOGIN)){
			throw new AdminsException("您没有查询管理员登陆记录的权限！");
		}
		//2.查询
		BackReturnJSON<PageAdminLoginRecord> returnJSON = new BackReturnJSON<PageAdminLoginRecord>();
		Map<String,Object> params = BackTools.getHashMap();
		//hql语句
		StringBuffer totalHql = new StringBuffer("select count(*) from Adminloginrecord a where a.isDelete=false ");
		StringBuffer rowsHql = new StringBuffer("from Adminloginrecord a where a.isDelete=false");
		//设置where条件
		//list储存需要添加where条件的hql语句
		List<StringBuffer> hqls = BackTools.getArrayList();
		//设置需要添加where的语句
		hqls.add(totalHql);
		hqls.add(rowsHql);
		//添加wehre
		setWhere(hqls, pageAdminLoginRecord, params);
		//如果排序,拼筹hql
		if(pageAdminLoginRecord.getSort()!=null&&!pageAdminLoginRecord.getSort().trim().equals("")&&pageAdminLoginRecord.getOrder()!=null&&!pageAdminLoginRecord.getOrder().trim().equals("")){
			rowsHql.append( " order by "+pageAdminLoginRecord.getSort()+" "+pageAdminLoginRecord.getOrder());
		}
		//查询记录
		List<Adminloginrecord> adminsList = adminLoginRecordDao.get(rowsHql.toString(),params,pageAdminLoginRecord.getPage(),pageAdminLoginRecord.getRows());
		
		//转化模型
		List<PageAdminLoginRecord> tempRows = BackTools.copyPropertiesList(adminsList, PageAdminLoginRecord.class);
		List<PageAdminLoginRecord> rows = BackTools.getArrayList();
		//设置PageAdminLoginRecord的id属性
		int index = 0;
		for (Adminloginrecord a : adminsList) {
			PageAdminLoginRecord p = tempRows.get(index);
			p.setId(a.getAdmins().getId());
			rows.add(p);
			index++;
		}
		//查询total
		Integer total = adminLoginRecordDao.length(totalHql.toString(),params);

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
	private void setWhere(List<StringBuffer> hqls,PageAdminLoginRecord pageAdmin,Map<String,Object> params) {
		//判断是否筛选id
		if(pageAdmin.getSearchId()!=null&&!pageAdmin.getSearchId().trim().equals("")){
			//对list中的所有需要添加where的hql语句循环遍历
			for (StringBuffer hql : hqls) {
				hql.append(" and admins.id like :searchId");
			}
			//填写参数
			params.put("searchId","%%"+pageAdmin.getSearchId()+"%%");
		}
	}
	
}
