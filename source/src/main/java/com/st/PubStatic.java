package com.st;

import java.io.File;

import org.apache.log4j.Logger;

import com.st.back.BackStatic;
import com.st.back.util.BackConfig;
import com.st.back.util.BackTools;
import com.st.util.PubConfig;
import com.st.util.PubTools;

public class PubStatic {
	public static final Logger L = Logger.getLogger(PubStatic.class);

	/*****************************项目资源路径**************************/
	/******项目资源根路径，即src的路径******/
	public static final String PATH_SRC = PubConfig.getPro().getProperty("uploadDirectory")+File.separator+"stsrc";
	/**官网模块资源路径**/
	//官网模块资源路径
	public static final String OW_PATH_SRC = PATH_SRC + File.separator+"officialwebsite";
	//官网图片资源路径
	public static final String OW_PATH_IMG = OW_PATH_SRC + File.separator+"img";
	//官网背景图片路径
	public static final String OW_PATH_BG = OW_PATH_IMG + File.separator+"bgImg";
	//官网图标图片路径
	public static final String OW_PATH_ICONS = OW_PATH_IMG + File.separator+"iconImg";
	
	//官网轮播图片资源路径
	public static final String OW_PATH_ABOUT_US_IMG = OW_PATH_IMG + File.separator+"officialwebsiteAboutUsImg";
	//官网成员图片资源路径
	public static final String OW_PATH_MEMBERS_IMG = OW_PATH_IMG + File.separator+"officialwebsiteMembersImg";
	//官网新闻图片资源路径
	public static final String OW_PATH_NEWS_IMG = OW_PATH_IMG + File.separator+"officialwebsiteNewsImg";
	//官网业务图片资源路径
	public static final String OW_PATH_SERVICE_IMG = OW_PATH_IMG + File.separator+"officialwebsiteServiceImg";
	//官网轮播资源的默认图片
	public static final String OW_PATH_DEFAULT_IMG_NAME = "default.png";
	
	
	
	
	
	
	/*****************************表名**************************/
	/**官网模块的表名**/
	public static final String OW_HQL_TABLE_NAME_ABOUT_US = "OfficialwebsiteAboutUs";
	public static final String OW_HQL_TABLE_NAME_CONTACT_US = "OfficialwebsiteContactUs";
	public static final String OW_HQL_TABLE_NAME_IMGS = "Imgs";
	public static final String OW_HQL_TABLE_NAME_MENUTREE = "Menutree";
	public static final String OW_HQL_TABLE_NAME_MEMBERS = "OfficialwebsiteMembers";
	public static final String OW_HQL_TABLE_NAME_NEWS = "OfficialwebsiteNews";
	public static final String OW_HQL_TABLE_NAME_SERVICE = "OfficialwebsiteService";
	public static final String OW_HQL_TABLE_NAME_IMGS_AND_INFO = "ImgsAndInfo";
	public static final String OW_HQL_TABLE_NAME_RELATIIONAL_SYSTEMDDL = "Systemddl";

	/*****************************字典代码**************************/
	public static final String WORDS_CODE_MEMBERS_SEX = "001";
	public static final String WORDS_CODE_MEMBERS_NATION = "002";
	public static final String WORDS_CODE_MEMBERS_FAITH = "003";
	public static final String WORDS_CODE_MEMBERS_LANGUAGE = "004";
	

	/*****************************图片表中的relation字段取值**************************/
	//储存新闻的的记录，该字段的取值
	public static final String TABLE_RELATION_NEWS = "news_img";
	

}
