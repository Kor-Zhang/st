package com.st.back;

import java.io.File;

import com.st.PubStatic;


public class BackStatic extends PubStatic{
	
	/*************************************后台模块资源路径**********************************/
	//后台管理模块资源路径
	public static final String BACK_PATH_SRC = PATH_SRC + File.separator+"back";
	//后台管理图片资源路径
	public static final String BACK_PATH_IMG = BACK_PATH_SRC + File.separator+"img";
	//后台管理背景图片路径
	public static final String BACK_PATH_BG = BACK_PATH_IMG + File.separator+"bgImg";
	//后台管理图标图片路径
	public static final String BACK_PATH_ICONS = BACK_PATH_IMG + File.separator+"iconImg";
	
	/*********************其他***************************/
	//session中保存的管理员们的name
	public static final String ONLINE_ADMIN = "admin";
	//app中map的name
	public static final String adminLoginRecordSessionMapName = "adminLoginRecordMap";
	//session中保存的管理员的登陆记录name
	public static final String adminLoginRecordSessionName = "adminLoginRecord";
	
	//管理员的sessionmap名字
	public static final String SESSION_MAP_ADMIN = "adminsSessionMap";
	
	/****************************************表名******************************************/
	//HQL查询语句中systemddl表名
	public static final String HQL_TABLE_NAME_SYSTEMDDL = " Systemddl ";
	//HQL查询语句中notices表名
	public static final String HQL_TABLE_NAME_NOTICES = " Notices ";
	//HQL查询语句中admins表名
	public static final String HQL_TABLE_NAME_ADMINS = " Admins ";
	//HQL查询语句中cars表名
	public static final String HQL_TABLE_NAME_CARS = " Cars ";
	//HQL查询语句中orders表名
	public static final String HQL_TABLE_NAME_ORDERS = " Orders ";
	//HQL查询语句中Indexcarousels表名
	public static final String HQL_TABLE_NAME_INDEXCAROUSELS = " Indexcarousels ";
	//HQL查询语句中Recommendcars表名
	public static final String HQL_TABLE_NAME_RECOMMENDCARS = " Recommendcars ";
	//HQL查询语句中Rentcarcost表名
	public static final String HQL_TABLE_NAME_RENTCARCOST = " Rentcarcost ";
	//HQL查询语句中Cost表名
	public static final String HQL_TABLE_NAME_COST = " Cost ";
	//HQL查询语句中Powers表名
	public static final String HQL_TABLE_NAME_POWERS = " Powers ";
	//HQL查询语句中Adminpower表名
	public static final String HQL_TABLE_NAME_ADMINPOWER = " Adminpower ";
	
	
	

	
	//权限目录与权限
	//1代表是管理员权限
	public static final Integer IS_POWER_ITEM = 1;
	//0代表不是管理员权限
	public static final Integer IS_NOT_POWER_ITEM = 0;
	
	
	
	
	//权限代码
	
	
	//权限管理的代码
	//204代表修改管理员的权限
	public static final String POWER_ID_UPDATE_ADMIN = "204";
	//203代表查看管理员的权限
	public static final String POWER_ID_QUERY_ADMIN = "203";
	//201代表删除管理员的权限
	public static final String POWER_ID_DELETE_ADMIN = "201";
	//202代表增加管理员的权限
	public static final String POWER_ID_ADD_ADMIN = "202";
	
	//官网业务管理的代码
	//301代表查看的权限
	public static final String POWER_ID_QUERY_OW_SERVICE = "301";
	//302代表删除的权限
	public static final String POWER_ID_DELETE_OW_SERVICE = "302";
	//303代表增加的权限
	public static final String POWER_ID_ADD_OW_SERVICE = "303";
	//304代表修改的权限
	public static final String POWER_ID_UPDATE_OW_SERVICE = "304";
	
	//公告管理的代码
	//401代表增加的权限
	public static final String POWER_ID_ADD_NOTICE = "401";
	//402代表删除的权限
	public static final String POWER_ID_DELETE_NOTICE = "402";
	//403代表修改的权限
	public static final String POWER_ID_UPDATE_NOTICE = "403";
	//404代表查看的权限
	public static final String POWER_ID_QUERY_NOTICE = "404";
	
	
	//官网成员管理的代码
	//501代表增加的权限
	public static final String POWER_ID_ADD_OW_MEMBERS = "501";
	//502代表删除的权限
	public static final String POWER_ID_DELETE_OW_MEMBERS = "502";
	//503代表查看的权限
	public static final String POWER_ID_QUERY_OW_MEMBERS = "503";
	//504代表修改的权限
	public static final String POWER_ID_UPDATE_OW_MEMBERS = "504";
	
	//官网轮播管理的代码
	//601代表增加的权限
	public static final String POWER_ID_ADD_OW_ABOUT_US = "601";
	//602代表删除的权限
	public static final String POWER_ID_DELETE_OW_ABOUT_US = "602";
	//603代表查看的权限
	public static final String POWER_ID_QUERY_OW_ABOUT_US = "603";
	//604代表修改的权限
	public static final String POWER_ID_UPDATE_OW_ABOUT_US = "604";
	
	//官网用户意见管理的代码
	//701代表查看的权限
	public static final String POWER_ID_QUERY_CONTACT_US= "701";
	//702代表删除的权限
	public static final String POWER_ID_DELETE_CONTACT_US = "702";
	//703代表修改的权限
	public static final String POWER_ID_UPDATE_CONTACT_US = "703";
	//704代表增加的权限
	public static final String POWER_ID_ADD_CONTACT_US = "704";
		
	//日志管理权限的代码
	//801代表查看管理员登录的权限
	public static final String POWER_ID_QUERY_ADMIN_LOGIN= "801";
	//802代表删除管理员更新的权限
	public static final String POWER_ID_QUERY_ADMIN_UPDATE = "802";
	/*//803代表修改用户登录的权限
	public static final String POWER_ID_QUERY_USER_LOGIN = "803";
	//804代表增加用户更新的权限
	public static final String POWER_ID_QUERY_USER_UPDATE = "804";*/
			
	//官网新闻管理的代码
	//901代表增加的权限
	public static final String POWER_ID_ADD_OW_NEWS = "901";
	//902代表删除的权限
	public static final String POWER_ID_DELETE_OW_NEWS = "902";
	//903代表查看的权限
	public static final String POWER_ID_QUERY_OW_NEWS = "903";
	//904代表修改的权限
	public static final String POWER_ID_UPDATE_OW_NEWS = "904";
	
	/*//订单管理的代码
	//101代表查询订单的权限
	public static final String POWER_ID_QUERY_ORDER= "101";
	//102代表修改订单的权限
	public static final String POWER_ID_UPDATE_ORDER = "102";*/
	
	
	//字典管理的代码
	//1001代表增加的权限
	public static final String POWER_ID_ADD_SYSTEMDDL= "1001";
	//1002代表删除的权限
	public static final String POWER_ID_DELETE_SYSTEMDDL = "1002";
	//1003代表查看的权限
	public static final String POWER_ID_QUERY_SYSTEMDDL = "1003";
	//1004代表修改的权限
	public static final String POWER_ID_UPDATE_SYSTEMDDL = "1004";
	
	
}
