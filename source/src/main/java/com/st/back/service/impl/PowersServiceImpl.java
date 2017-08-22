package com.st.back.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.back.BackStatic;
import com.st.back.dao.AdminPowerDaoI;
import com.st.back.dao.AdminsDaoI;
import com.st.back.dao.PowersDaoI;
import com.st.back.exception.AdminsException;
import com.st.back.pageModel.PagePowers;
import com.st.back.service.PowersServiceI;
import com.st.back.util.BackTools;
import com.st.model.Adminpower;
import com.st.model.Admins;
import com.st.model.Powers;

@Service(value = "powersService")
public class PowersServiceImpl implements PowersServiceI {
	//powersDao导入
	private PowersDaoI powersDao;
	
	
	
	public PowersDaoI getPowersDao() {
		return powersDao;
	}
	@Autowired
	public void setPowersDao(PowersDaoI powersDao) {
		this.powersDao = powersDao;
	}
	//注入adminsDao
	private AdminsDaoI adminsDao;
	

	public AdminsDaoI getAdminsDao() {
		return adminsDao;
	}
	@Autowired
	public void setAdminsDao(AdminsDaoI adminsDao) {
		this.adminsDao = adminsDao;
	}
	//注入adminpowerdao
	private AdminPowerDaoI adminPowerDao;
	public AdminPowerDaoI getAdminPowerDao() {
		return adminPowerDao;
	}
	@Autowired
	public void setAdminPowerDao(AdminPowerDaoI adminPowerDao) {
		this.adminPowerDao = adminPowerDao;
	}
	/*@Override
	public List<PagePowers> getTree(PagePowers pageModel) {
		List<Powers> menuTreeList = null;
		String id = pageModel.getId();
		if(id==null||id.equals("")||id.equals("null")){
			//获取根节点
			menuTreeList = powersDao.get("from "+Static.HQL_TABLE_NAME_POWERS+" t where t.powers is null");
		}else{
			获取子节点
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", id);
			menuTreeList = powersDao.get("from  "+Static.HQL_TABLE_NAME_POWERS+" t where t.powers.id = :id",map);
			
		}
		List<PagePowers> pageMenuTreeList = new ArrayList<PagePowers>();
		//判断是否有节点
		if(menuTreeList!=null&&!menuTreeList.isEmpty()){
			//遍历节点,设置其开闭状态和url
			for (Powers menutree : menuTreeList) {
				PagePowers pagePower = new PagePowers();
				//获取子节点
				List<Powers> childrens = powersDao.get("from "+Static.HQL_TABLE_NAME_POWERS+" t where t.powers.id=:parentId",Tools.getHashMap(new String[]{"parentId"}, new Object[]{menutree.getId()}));
				BeanUtils.copyProperties(menutree,pagePower);
				//设置tree节点开闭状态
				if(childrens!=null&&!childrens.isEmpty()){
					pagePower.setState("closed");
				}else{

					pagePower.setState("opend");
				}
				//设置url
				Map<String,Object> attributes = new HashMap<String,Object>();
				attributes.put("url", menutree.getUrl());
				pagePower.setAttrbutes(attributes);
				//设置checked状态（查询指定adminid和powerid的adminpower记录是否存在）
				List<Adminpower> aps = adminPowerDao.get("from "+Static.HQL_TABLE_NAME_ADMINPOWER+"t where t.admins.id = :adminId and t.powers.id=:powerId",Tools.getHashMap(new String[]{"adminId","powerId"},new Object[]{pageModel.getAdminId(),pagePower.getId()}));
				Static.log.info(aps.size());
				if(aps!=null&&!aps.isEmpty()){
					
					pagePower.setChecked(true);
				}else{
					pagePower.setChecked(false);
				}
				
				//添加节点
				pageMenuTreeList.add(pagePower);
			}
		}
		return pageMenuTreeList;
	}*/
	@Override
	public List<PagePowers> getPowerTree(Admins onlineAdmin,PagePowers pageModel) throws AdminsException {
		if(!BackTools.power(onlineAdmin.getId(),BackStatic.POWER_ID_QUERY_ADMIN)){
			throw new AdminsException("您没有查询管理员的权限！");
		}
		//父节点
		Powers root = null;
		Map<String,Object> map = new HashMap<String, Object>();
		//查询根节点
		map.put("id", "999");
		root = powersDao.find("from  "+BackStatic.HQL_TABLE_NAME_POWERS+" t where t.id = :id",map);
	
		PagePowers pageRoot = getChildrenTree(root,pageModel.getAdminId());
		List<PagePowers> pagePowers = pageRoot.getChildren();
		return pagePowers;
	}
	/**
	 * 递归遍历树，设置check的状态
	 * @param parentId
	 * @param root
	 */
	private PagePowers getChildrenTree(Powers root,String adminId){
		//设置当前节点
		PagePowers pagePower = new PagePowers();
		//copy出数据库属性
		BeanUtils.copyProperties(root, pagePower);
		//获取当前节点子节点
		List<Powers> childrens = powersDao.get("from "+BackStatic.HQL_TABLE_NAME_POWERS+" t where t.powers.id=:parentId",BackTools.getHashMap(new String[]{"parentId"},new Object[]{root.getId()}));
		//获取需要返回的子节点
		List<PagePowers> pageChildrens = BackTools.getArrayList();
		
		//设置本节点的check状态
		//查询adminpower是否存在相关记录
		Adminpower ap = adminPowerDao.find("from "+BackStatic.HQL_TABLE_NAME_ADMINPOWER+"t where t.admins.id = :adminId and t.powers.id=:powerId",BackTools.getHashMap(new String[]{"adminId","powerId"},new Object[]{adminId,root.getId()}));
		
		if(root.getStatus()==1&&ap!=null){
			pagePower.setChecked(true);
		}else if(root.getStatus()==1&&ap==null){
			pagePower.setChecked(false);
		}
		//设置为节点展开
		pagePower.setState("open");
		//递归子节点
		for (Powers children : childrens) {
			pageChildrens.add(getChildrenTree(children,adminId));
		}
		pagePower.setChildren(pageChildrens);
		return pagePower;
	}
	@Override
	public void updatePowers(Admins onlineAdmin, PagePowers pageModel)
			throws AdminsException {
		//验证204权限（更新管理员权限）
		if(!BackTools.power(onlineAdmin.getId(),BackStatic.POWER_ID_UPDATE_ADMIN)){
			throw new AdminsException("您没有更新管理员的权限！");
		}
		//验证被操作对象是否为超级管理员
		Admins dBAdmin = adminsDao.findById(Admins.class, pageModel.getAdminId());
		if(dBAdmin.getIsSuperAdmin()==1){
			throw new AdminsException("不能操作超级管理呀！");
		}
		//删除指定adminid的所有权限
		adminPowerDao.executeHql("delete from "+BackStatic.HQL_TABLE_NAME_ADMINPOWER+" t where t.admins.id=:id",BackTools.getHashMap(new String[]{"id"},new Object[]{pageModel.getAdminId()}));
		//添加新权限
		//获取新的权限
		String[] newPowerIds = new String[]{};
		//不为空
		if(!pageModel.getCheckedId().trim().equals("")){
			newPowerIds = pageModel.getCheckedId().split(",");
		}
		for (String newPowerId : newPowerIds) {
			Adminpower newAdminPower = new Adminpower();
			//设置power
			Powers newPower = new Powers();
			newPower.setId(newPowerId);;
			//如果该id的power不是权限，值是目录，那么拒绝添加
			if(newPower.getStatus()==BackStatic.IS_NOT_POWER_ITEM){
				continue;
			}
			newAdminPower.setPowers(newPower);
			//设置admin
			Admins admin = new Admins(); 
			admin.setId(pageModel.getAdminId());	
			newAdminPower.setAdmins(admin);
			newAdminPower.setId(UUID.randomUUID().toString());
			newAdminPower.setIsDelete(false);
			newAdminPower.setStatus(1);
			adminPowerDao.save(newAdminPower);
		}
		
	}
}