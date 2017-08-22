package com.st.back.action;

import java.io.File;
import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ModelDriven;
import com.st.action.BaseAction;
import com.st.back.BackStatic;
import com.st.back.pageModel.PageSrc;

/**
 * 配置action
 * 
 * @author Jhon
 * 
 */
@Action(value = "adminsSrcAction")
public class AdminsSrcAction extends BaseAction implements ModelDriven<PageSrc> {
	PageSrc pageModel = new PageSrc();
	@Override
	public PageSrc getModel() {
		return pageModel;
	}

	
	/**
	 * 获取背景图片资源，需要的是imgName
	 */
	public void getBgImgSrc(){
		String bgPath = BackStatic.BACK_PATH_BG;
		
		writeImg(new File(bgPath,pageModel.getImgName()));
	}

	/**
	 * 获取图标图片资源，需要的是imgName
	 */
	public void getIconImgSrc(){
		String bgPath = BackStatic.BACK_PATH_ICONS;
		
		writeImg(new File(bgPath,pageModel.getImgName()));
	}
	/**
	 * 获取当前时间
	 */
	public void getCurrtTime(){
		Date currtTime = new Date();
		PageSrc returnModel = new PageSrc();
		returnModel.setCurrtTime(currtTime.getTime());
		writeJSON(returnModel);
	}
	
}
