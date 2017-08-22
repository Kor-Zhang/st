package com.st.back.officialwebsite.action;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.BackStatic;
import com.st.back.exception.AdminsException;
import com.st.back.officialwebsite.OwBackStatic;
import com.st.back.officialwebsite.exception.OfficialwebsiteBackException;
import com.st.back.officialwebsite.pageModel.PageOwAboutUsBack;
import com.st.back.officialwebsite.service.OwAboutUsBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.back.util.BackTools;
import com.st.model.Admins;
@Action(value="owAboutUsBackAction")
public class OwAboutUsBackAction extends OfficialwebsiteBackBaseAction  implements ModelDriven<PageOwAboutUsBack>{
	private OwAboutUsBackServiceI owAboutUsBackService;
	//注入owIndexCarouselBackService
	public OwAboutUsBackServiceI getOwIndexCarouselBackService() {
		return owAboutUsBackService;
	}
	@Autowired
	public void setOwIndexCarouselBackService(
			OwAboutUsBackServiceI owIndexCarouselBackService) {
		this.owAboutUsBackService = owIndexCarouselBackService;
	}
	//注入pageModel
	private PageOwAboutUsBack pageModel = new PageOwAboutUsBack();
	@Override
	public PageOwAboutUsBack getModel() {
		return pageModel;
	}
	
	/**
	 * 获取官网轮播的图片信息列表
	 * @throws Exception 
	 */
	public void getDatagrid(){
		OwBackReturnJSON<PageOwAboutUsBack> retJSON = new OwBackReturnJSON<PageOwAboutUsBack>();
		try {
			Admins onlineAdmin = OwBackTools.getOnlineAdmin();
			retJSON = owAboutUsBackService.getDatagrid(onlineAdmin,pageModel);
			retJSON.setSuccess(true);
			retJSON.setMsg("读取信息成功！");
		}catch (OfficialwebsiteBackException e) {
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
			e.printStackTrace();
		}finally{
			super.writeJSON(retJSON);
		}
	}
	/**
	 * 获取官网轮播的图片
	 */
	public void getImgByImgName(){
		File imgFile = null;
		try {
			String imgName = pageModel.getImgName();
			imgFile = new File(OwBackStatic.OW_PATH_ABOUT_US_IMG,imgName);
			//如果没有img，那么抛出异常
			if(OwBackTools.isEmptyTrimString(imgName)||!imgFile.exists()){
				throw new Exception("没有该图片！");
			}
			
			
			
			
		} catch (Exception e) {
			imgFile = new File(OwBackStatic.OW_PATH_ABOUT_US_IMG,BackStatic.OW_PATH_DEFAULT_IMG_NAME);
			e.printStackTrace();
		}finally{
			super.writeImg(imgFile);
		}
	}
	/**
	 * 删除
	 */
	public void deleteAboutUs(){
		/**
		 * 获取当前在线admin
		 * 执行事务
		 * 返回结果
		 */
		OwBackReturnJSON retJSON = new OwBackReturnJSON();
		try {
			//1.获取当前在线admin
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			//2.执行事务
			owAboutUsBackService.deleteAboutUs(onlineAdmin,pageModel);
			retJSON.setMsg("删除信息成功！");
			retJSON.setSuccess(true);
		}catch (OfficialwebsiteBackException e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}finally{
			//返回结果
			super.writeJSON(retJSON);
		}
		
	}
	
}
