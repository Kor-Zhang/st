package com.st.back.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.st.back.BackStatic;
import com.st.back.dao.AdminLoginRecordDaoI;
import com.st.back.dao.AdminUpdateRecordDaoI;
import com.st.back.dao.AdminsDaoI;
import com.st.back.exception.AdminsException;
import com.st.back.pageModel.PageAdmins;
import com.st.back.service.AdminsServiceI;
import com.st.back.util.BackReturnJSON;
import com.st.back.util.BackTools;
import com.st.model.Adminloginrecord;
import com.st.model.Admins;
import com.st.model.Adminupdaterecord;
import com.st.util.Encrypt;

@Service(value = "adminsService")
public class AdminsServiceImpl implements AdminsServiceI {

	private AdminsDaoI adminsDao;
	

	public AdminsDaoI getAdminsDao() {
		return adminsDao;
	}
	@Autowired
	public void setAdminsDao(AdminsDaoI adminsDao) {
		this.adminsDao = adminsDao;
	}
	
	private AdminLoginRecordDaoI adminLoginRecordDao;
	
	public AdminLoginRecordDaoI getAdminLoginRecordDao() {
		return adminLoginRecordDao;
	}
	@Autowired
	public void setAdminLoginRecordDao(AdminLoginRecordDaoI adminLoginRecordDao) {
		this.adminLoginRecordDao = adminLoginRecordDao;
	}
	private AdminUpdateRecordDaoI adminUpdateRecordDao;
	
	
	
	public AdminUpdateRecordDaoI getAdminUpdateRecordDao() {
		return adminUpdateRecordDao;
	}
	@Autowired
	public void setAdminUpdateRecordDao(AdminUpdateRecordDaoI adminUpdateRecordDao) {
		this.adminUpdateRecordDao = adminUpdateRecordDao;
	}
	

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(AdminsServiceImpl.class);
	
	@Override
	public Serializable adminRegist(PageAdmins pageUser)
			throws AdminsException {
		Admins targetUser = new Admins();
		BeanUtils.copyProperties(pageUser, targetUser);
		targetUser.setPassword(Encrypt.e(targetUser.getPassword()));
		return adminsDao.save(targetUser);
	}
	@Override
	public Object[] adminLogin(PageAdmins pageAdmin) throws AdminsException {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", pageAdmin.getId());
		map.put("password", Encrypt.e(pageAdmin.getPassword()));
		String hql = "from Admins a where a.id=:id and a.password=:password and a.isDelete=false";
		
		Admins dbAdmin = adminsDao.find(hql,map);
		//判断账户密码对错
		if(dbAdmin==null){
			throw new AdminsException("账户或密码错误！");
		}
		//判断账户状态
		if(dbAdmin.getStatus()==0){
			throw new AdminsException("账户被冻结，请联系相关管理员！");
		}
		//写入登陆记录
		Adminloginrecord alr = this.addLoginRecord(dbAdmin);
		
		logger.info(alr.getLoginTime()+"，"+alr.getAdmins().getId()+"在"+alr.getLoginAddress()+"登陆！");
		
		
		return new Object[]{dbAdmin,alr};
	}
	@Override
	public BackReturnJSON<PageAdmins> getDatagrid(Admins onlineAdmin,PageAdmins pageAdmin) throws AdminsException {
		/**
		 * 1.判断当前用户是否拥有查询权限
		 * 2.执行
		 * 3.返回结果
		 */
		//1.验证203权限（查询管理员权限）
		if(!BackTools.power(onlineAdmin.getId(),BackStatic.POWER_ID_QUERY_ADMIN)){
			throw new AdminsException("您没有查询管理员的权限！");
		}
		//2.查询
		BackReturnJSON<PageAdmins> retJSON = new BackReturnJSON<PageAdmins>();
		Map<String,Object> params = BackTools.getHashMap();
		params.put("id", onlineAdmin.getId());
		//hql语句，不查询当前用户和超级管理员们
		StringBuffer totalHql = new StringBuffer("select count(*) from "+BackStatic.HQL_TABLE_NAME_ADMINS+" t where t.isDelete=false and t.isSuperAdmin=0 and t.id<>:id ");
		StringBuffer rowsHql = new StringBuffer("from "+BackStatic.HQL_TABLE_NAME_ADMINS+" t where t.isDelete=false and t.isSuperAdmin=0 and t.id<>:id ");
		//设置where条件
		//list储存需要添加where条件的hql语句
		List<StringBuffer> hqls = BackTools.getArrayList(new StringBuffer[]{totalHql,rowsHql});
		//添加wehre
		BackTools.setSearchWhere(hqls, pageAdmin, params);
		//排序
		BackTools.setSortOrder(hqls, pageAdmin);
		//查询记录
		List<Admins> adminsList = adminsDao.get(rowsHql.toString(),params,pageAdmin.getPage(),pageAdmin.getRows());
		//转化模型
		List<PageAdmins> rows = BackTools.copyPropertiesList(adminsList, PageAdmins.class);

		//查询total
		Integer total = adminsDao.length(totalHql.toString(),params);
		retJSON.setRows(rows);
		retJSON.setTotal(total);
		//3.返回结果
		return retJSON;
	}
	@Override
	public Admins addAdmin(Admins onlineAdmin,PageAdmins pageAdmin) throws AdminsException {
		//1.验证202权限（添加管理员权限）
		if(!BackTools.power(onlineAdmin.getId(),BackStatic.POWER_ID_ADD_ADMIN)){
			throw new AdminsException("您没有添加管理员的权限！");
		}
		//检测密码长度
		Integer passwordLength = pageAdmin.getPassword().length();
		if(!(passwordLength<=16&&passwordLength>=6)){
			throw new AdminsException("密码长度为6-16！");
		}
		//检测账户长度
		Integer idLength = pageAdmin.getId().length(); 
		if(!(idLength<=16&&idLength>=6)){
			throw new AdminsException("账户长度为6-16！");
		} 
		//检测用户是否存在
		Admins dbAdmin = adminsDao.find("from Admins a where a.id=:id",BackTools.getHashMap(new String[]{"id"}, new Object[]{pageAdmin.getId()}));
		if(dbAdmin!=null){
			if(dbAdmin.getIsDelete()==false){

				throw new AdminsException("账户已存在!");
			}else if(dbAdmin.getIsDelete()==true){
				//如果记录被删除（isDelete=1），那么先删除记录
				adminsDao.delete(dbAdmin);
				
			}
		}
		
		Admins admin = new Admins();
		BeanUtils.copyProperties(pageAdmin, admin);
		admin.setIsSuperAdmin(0);
		admin.setCreateTime(new Timestamp(new Date().getTime()));
		admin.setIsDelete(false);
		
		adminsDao.save(admin);
		this.addUpdateRecord(onlineAdmin, admin, "添加");
		
		return admin;
	}
	
	@Override
	public void deleteAdmins(Admins onlineAdmin,String deleteIds) throws AdminsException{
		/**
		 * 遍历删除 以,分割的字符串的id的admin
		 * 	-假性删除，isDelete是删除标志
		 */
		//1.验证201权限（删除管理员权限）
		if(!BackTools.power(onlineAdmin.getId(),BackStatic.POWER_ID_DELETE_ADMIN)){
			throw new AdminsException("您没有删除管理员的权限！");
		}
		//如果删除自己
		if(deleteIds.indexOf(onlineAdmin.getId())>0){
			throw new AdminsException("错误，无法删除自己！");
		}
		//是否删除管理员
		Admins superAdmin = adminsDao.find("from Admins a where a.isSuperAdmin=1");
		if(deleteIds.indexOf(superAdmin.getId())>0){
			throw new AdminsException("错误，无法删除管理员！");
		}
		try{
			//遍历取出每个id
			for (String deleteId : deleteIds.split(",")) {
				//修改isDelete操作
				Admins admin = adminsDao.findById(Admins.class,deleteId);
				admin.setIsDelete(true);
				//添加删除记录
				this.addUpdateRecord(onlineAdmin,admin, "删除");
				
				
			}
		}catch(Exception e){
			throw new AdminsException("删除失败！");
		}
		
	}
	
	@Override
	public PageAdmins editAdmin(Admins onlineAdmin,PageAdmins pageAdmin) throws AdminsException {
		/**
		 * 不更新id和password
		 * 1.判断是否改管理员存在
		 * 2.执行操作
		 */
		//1.验证204权限（跟新管理员权限）
		if(!BackTools.power(onlineAdmin.getId(),BackStatic.POWER_ID_UPDATE_ADMIN)){
			throw new AdminsException("您没有更新管理员的权限！");
		}
		//如果编辑自己
		if(pageAdmin.equals(onlineAdmin.getId())){
			throw new AdminsException("错误，无法编辑自己！");
		}
		
		Admins dbAdmin = adminsDao.findById(Admins.class,pageAdmin.getId());

		//1.判断改管理员是否存在
		//不存在，抛出异常
		if(dbAdmin==null){
			throw new AdminsException("该管理员不存在！");
		}
		//是否编辑超级管理员
		if(dbAdmin.getIsSuperAdmin()==1){
			throw new AdminsException("错误，无法编辑超级管理员！");
		}
		
		//2判断是否更新密码
		//没有更细密码
		/*if(pageAdmin.getPassword().equals("**********")){
			//加密密码
			pageAdmin.setPassword(dbAdmin.getPassword());
		}else{

			pageAdmin.setPassword(Encrypt.e(pageAdmin.getPassword()));
		}*/
		/*
		if(!pageAdmin.getPassword().matches("[A-Za-z0-9._]{10,15}")){
			throw new AdminsException("密码格式只包含字母数字下划线和点[A-Za-z0-9._]！");
		}*/
		
		//2.存在，执行跟新操作
	
		
		//copy对象，实现更新
		
		
		BeanUtils.copyProperties(pageAdmin, dbAdmin,new String[]{"id","password","createTime","isDelete"});
		this.addUpdateRecord(onlineAdmin, dbAdmin, "编辑");
		return pageAdmin;
	}
	
	
	public void updateAdminPwd(Admins onlineAdmin,PageAdmins pageAdmin) throws AdminsException{
		//验证204权限（跟新管理员权限）
		if(!BackTools.power(onlineAdmin.getId(),BackStatic.POWER_ID_UPDATE_ADMIN)){
			throw new AdminsException("您没有更新管理员的权限！");
		}
		//1.判断改管理员是否存在
		Admins dbAdmin = adminsDao.findById(Admins.class,pageAdmin.getId());
		//不存在，抛出异常
		if(dbAdmin==null){
			throw new AdminsException("该管理员不存在！");
		}
		//如果编辑自己
		if(pageAdmin.equals(onlineAdmin.getId())){
			throw new AdminsException("错误，无法编辑自己！");
		}
		//是否编辑管理员
		Admins superAdmin = adminsDao.find("from Admins a where a.isSuperAdmin=1");
		if(pageAdmin.equals(superAdmin.getId())){
			throw new AdminsException("错误，无法编辑管理员！");
		}
		//判断密码格式
		if(!pageAdmin.getPassword().matches("[A-Za-z0-9._]{6,16}")){
			throw new AdminsException("密码格式只包含字母数字下划线和点[A-Za-z0-9._]！");
		}
		
		//跟新密码
		dbAdmin.setPassword(Encrypt.e(pageAdmin.getPassword()));
		adminsDao.update(dbAdmin);
		this.addUpdateRecord(onlineAdmin, dbAdmin, "编辑密码");
		
	}

	/**
	 * 添加更新纪录
	 * @param onlineAdmin
	 * @param pageAdmin
	 * @param item
	 */
	private void addUpdateRecord(Admins doAdmin, Admins doneAdmin,
			String item) {
		//生成更新记录
		Adminupdaterecord aur = new Adminupdaterecord();
		//设置操作的管理员
		aur.setAdminsByDoAdminId(doAdmin);
		//设置被操作的管理员
		aur.setAdminsByDoneAdminId(doneAdmin);
		//设置操作项目
		aur.setItem(item);
		//设置时间
		aur.setUpdateTime(new Timestamp(new Date().getTime()));
		//设置id
		aur.setUpdateRecordId(UUID.randomUUID().toString());

		aur.setIsDelete(false);
		//保存
		adminUpdateRecordDao.save(aur);
	}

	/**
	 * 添加登陆记录
	 * @param admin
	 * @return
	 */
	public Adminloginrecord addLoginRecord(Admins admin) {
		Adminloginrecord alr = new Adminloginrecord();
		alr.setLoginRecordId(UUID.randomUUID().toString());
		alr.setAdmins(admin);
		
		alr.setLoginTime(new Timestamp(new Date().getTime()));
		alr.setLogoffTime(new Timestamp(new Date().getTime()));
		
		
		//生成登陆记录
		//获取ip
		String ip= BackTools.getInternetIp(BackTools.getReq());
		String address = "";
		JSONObject addressJson = null;
		//本机
		if(ip.equals("0:0:0:0:0:0:0:1")){
			address = "本机";
		}else{
			/*{"address":"CN|湖南|张家界|None|CHINANET|0|0","content":{"address_detail":{"province":"湖南省","city":"张家界市","district":"","street":"","street_number":"","city_code":312},"address":"湖南省张家界市","point":{"y":"3370564.53","x":"12298891.52"}},"status":0}*/
			//获取地理位置
			try{
				addressJson = BackTools.readJsonFromUrl("http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip="+ip);
				address = (String) JSONObject.parseObject(addressJson.getString("content")).get("address");
			}catch(Exception e1){
				//如果获取位置异常，那么为地理位置
				address = "未知";
			}
			
		}
		
		alr.setLoginAddress(address);
		alr.setLoginIp(ip);
		alr.setIsDelete(false);
		adminLoginRecordDao.save(alr);
		return alr;
	}
	@Override
	public BackReturnJSON<PageAdmins> getSingleAdminDatagridById(
			Admins onlineAdmin, PageAdmins pageAdmin) throws AdminsException {
		/**
		 * 1.判断当前用户是否拥有查询权限
		 * 2.执行
		 * 3.返回结果
		 */
		//1.验证203权限（查询管理员权限）
		if(!BackTools.power(onlineAdmin.getId(),BackStatic.POWER_ID_QUERY_ADMIN)){
			throw new AdminsException("您没有查询管理员的权限！");
		}
		//2.查询
		BackReturnJSON<PageAdmins> retJSON = new BackReturnJSON<PageAdmins>();
		
		//查询记录
		List<Admins> adminsList = adminsDao.get("from Admins a where a.isDelete=false and a.id=:id ",BackTools.getHashMap(new String[]{"id"}, new Object[]{pageAdmin.getId()}));
		//转化模型
		List<PageAdmins> rows = BackTools.copyPropertiesList(adminsList, PageAdmins.class);
		
		retJSON.setRows(rows);
		retJSON.setTotal(rows.size());
		//3.返回结果
		return retJSON;
	}
	@Override
	public void updateTheme(Admins onlineAdmin, PageAdmins pageAdmin)
			throws AdminsException {
		
		Admins dBAdmin = adminsDao.findById(Admins.class, onlineAdmin.getId());
		dBAdmin.setTheme(pageAdmin.getTheme());
		adminsDao.update(dBAdmin);
	}
	@Override
	public void updateAdminStatus(Admins onlineAdmin) throws AdminsException {
		if(onlineAdmin.getIsSuperAdmin()==1){
			throw new AdminsException("不能冻结管理员！");
		}
		onlineAdmin.setStatus(0);
		adminsDao.update(onlineAdmin);
	}
}
