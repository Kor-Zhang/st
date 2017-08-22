package com.st.back.service;

import java.io.Serializable;

import com.st.back.exception.AdminsException;
import com.st.back.pageModel.PageAdmins;
import com.st.back.util.BackReturnJSON;
import com.st.model.Admins;





public interface AdminsServiceI {
	/**
	 * 用户登录
	 * @param pageUser
	 * @return
	 * @throws AdminsException
	 */
	Serializable adminRegist(PageAdmins pageUser) throws AdminsException;
	/**
	 * 用户登录
	 * @param pageUser
	 * @return object[0] 为登陆的admin，object[1]为登陆记录
	 * @throws AdminsException
	 */
	Object[] adminLogin(PageAdmins pageUser) throws AdminsException;
	/**
	 * 获取admin的datagrid
	 * @param onlineAdmin
	 * @param pageAdmin
	 * @return
	 * @throws AdminsException
	 */
	BackReturnJSON<PageAdmins> getDatagrid(Admins onlineAdmin, PageAdmins pageAdmin) throws AdminsException ;
	/**
	 * 添加admin
	 * @param onlineAdmin
	 * @param pageAdmin
	 * @return
	 * @throws AdminsException
	 */
	Admins addAdmin(Admins onlineAdmin, PageAdmins pageAdmin) throws AdminsException;
	/**
	 * 删除admin
	 * @param onlineAdmin
	 * @param deleteIds
	 * @throws AdminsException
	 */
	void deleteAdmins(Admins onlineAdmin, String deleteIds) throws AdminsException;
	/**
	 * 获取admin
	 * @param pageAdmin
	 * @return
	 * @throws AdminsException
	 * Admins getAdmin(PageAdmins pageAdmin) throws AdminsException;
	 */
	/**
	 * 编辑admin除id，password以外的信息
	 * @param onlineAdmin
	 * @param pageAdmin
	 * @return
	 * @throws AdminsException
	 */
	PageAdmins editAdmin(Admins onlineAdmin, PageAdmins pageAdmin) throws AdminsException;
	/**
	 * 编辑admin的password
	 * @param onlineAdmin
	 * @param pageAdmin
	 * @throws AdminsException
	 */
	void updateAdminPwd(Admins onlineAdmin, PageAdmins pageAdmin) throws AdminsException;
	BackReturnJSON<PageAdmins> getSingleAdminDatagridById(Admins onlineAdmin,
			PageAdmins pageAdmin) throws AdminsException;
	void updateTheme(Admins onlineAdmin, PageAdmins pageAdmin) throws AdminsException;
	void updateAdminStatus(Admins onlineAdmin) throws AdminsException;
}
