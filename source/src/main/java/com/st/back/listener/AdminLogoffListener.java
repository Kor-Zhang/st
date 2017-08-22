package com.st.back.listener;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.st.back.BackStatic;
import com.st.back.action.AdminsAction;
import com.st.back.service.AdminLoginRecordServiceI;
import com.st.back.util.BackTools;
import com.st.model.Adminloginrecord;

/**
 * session销毁时，更新admin登出记录
 *@author Jhon
 * 
 */
public class AdminLogoffListener implements HttpSessionListener{
	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(AdminLogoffListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//获取bean
		AdminLoginRecordServiceI adminLoginRecordService = BackTools.getSpringBean("adminLoginRecordService",se.getSession().getServletContext());
		//获取即将销毁的session中的adminLoginRecord
		HttpSession session = se.getSession();
		Adminloginrecord alr = (Adminloginrecord) session.getAttribute(BackStatic.adminLoginRecordSessionName);
		//移除sessionmap的session，不然登录再次登录时候，取出sessionmap中的session时会怕抛出异常
		AdminsAction.adminsSessionMap.removeAttribute(alr.getAdmins().getId());;
		//判断是否含有adminLoginRecord
		if(alr!=null){
			//含有，更新登出时间
			alr.setLogoffTime(new Timestamp(new Date().getTime()));
			adminLoginRecordService.updateLogoffTime(alr);
			
			logger.info(alr.getLogoffTime()+"，"+alr.getAdmins().getId()+"在"+alr.getLoginAddress()+"登出！");
		}
		
	}
	

}
