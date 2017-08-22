package com.st.back.util;

import com.st.back.BackStatic;
import com.st.back.dao.AdminPowerDaoI;
import com.st.back.exception.AdminsException;
import com.st.dao.BaseDaoI;
import com.st.model.Adminpower;
import com.st.model.Admins;
import com.st.util.PubTools;

public class BackTools extends PubTools{
	/**
	 * 获取当前在线admin对象，并且连接数据库更新
	 * 
	 * @return
	 * @throws AdminsException
	 */
	public static Admins getOnlineAdmin() {
		Admins onlineAdmin = (Admins) PubTools.getSession().getAttribute(
				BackStatic.ONLINE_ADMIN);
		if (onlineAdmin == null) {
			return null;
		}
		BaseDaoI<Admins> baseDao = PubTools.getSpringBean("baseDao", PubTools
				.getSession().getServletContext());
		onlineAdmin = baseDao.findById(Admins.class, onlineAdmin.getId());

		return onlineAdmin;
	}
	
	/**
	 * 验证admin是否具有某项权限
	 * 
	 * @param adminId
	 *            ：需要验证的admin的id
	 * @param powerId
	 *            ：需要验证的权限的id
	 * @return
	 */
	public static Boolean power(String adminId, String powerId) {
		AdminPowerDaoI adminPowerDao = PubTools.getSpringBean("adminPowerDao",
				PubTools.getSession().getServletContext());
		Adminpower ap = adminPowerDao
				.find("from "
						+ BackStatic.HQL_TABLE_NAME_ADMINPOWER
						+ "t where t.admins.id = :adminId and t.powers.id=:powerId",
						PubTools.getHashMap(new String[] { "adminId", "powerId" },
								new Object[] { adminId, powerId }));
		if (ap != null) {
			return true;
		}
		return false;
	}
}
