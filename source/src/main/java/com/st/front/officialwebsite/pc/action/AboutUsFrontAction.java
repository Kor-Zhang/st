package com.st.front.officialwebsite.pc.action;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.front.officialwebsite.pc.OwFrontStatic;
import com.st.front.officialwebsite.pc.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.pc.pageModel.PageAboutUsFront;
import com.st.front.officialwebsite.pc.service.AboutUsFrontServiceI;
import com.st.front.officialwebsite.pc.util.OwFrontReturnJSON;
import com.st.front.officialwebsite.pc.util.OwFrontTools;

/**
 * 配置action
 * 
 * @author Jhon
 * 
 */
@Action(value = "aboutUsFrontAction")
public class AboutUsFrontAction extends OfficialwebsiteFrontPCBaseAction implements ModelDriven<PageAboutUsFront> {
	//注入pageModel
	public PageAboutUsFront pageModel = new PageAboutUsFront();
	@Override
	public PageAboutUsFront getModel() {
		return pageModel;
	}
	//注入aboutUsFrontService
	private AboutUsFrontServiceI aboutUsFrontService;
	
	public AboutUsFrontServiceI getAboutUsFrontService() {
		return aboutUsFrontService;
	}
	@Autowired
	public void setAboutUsFrontService(AboutUsFrontServiceI aboutUsFrontService) {
		this.aboutUsFrontService = aboutUsFrontService;
	}
	/**
	 * 获取轮播
	 */
	public void getCarousels(){
		OwFrontReturnJSON<PageAboutUsFront> retJSON = new OwFrontReturnJSON<PageAboutUsFront>();
		try {
			retJSON = aboutUsFrontService.getCarousels(pageModel);
			retJSON.setSuccess(true);
			retJSON.setMsg("");
		} catch (OfficialwebsiteFrontException e) {
			e.printStackTrace();
			retJSON.setMsg(e.toString());
			retJSON.setSuccess(false);
		}catch (Exception e) {
			e.printStackTrace();
			retJSON.setMsg(e.toString());
			retJSON.setSuccess(false);
		}finally{
			super.writeJSON(retJSON);
		}
		
	}
	/**
	 * 根据imgname获取轮播图片
	 */
	public void getCarouselByImgName(){
		String imgName = pageModel.getImgName();
		String dirPath = OwFrontStatic.OW_PATH_ABOUT_US_IMG;
		File imgFile = new File(dirPath,imgName);;
		//如果文件名为空，返回默认图片
		if(OwFrontTools.isEmptyTrimString(imgName)||!imgFile.exists()){
			imgFile = new File(dirPath,OwFrontStatic.OW_PATH_DEFAULT_IMG_NAME);
		}
		OwFrontStatic.L.info(imgFile.getAbsolutePath());
		//返回图片
		super.writeImg(imgFile);
	}
}
