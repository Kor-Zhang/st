package com.st.front.officialwebsite.phone.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.front.officialwebsite.phone.OwFrontStatic;
import com.st.front.officialwebsite.phone.exception.OwImgsAndInfoFrontException;
import com.st.front.officialwebsite.phone.pageModel.PageImgsAndInfoFront;
import com.st.front.officialwebsite.phone.service.ImgsAndInfoFrontServiceI;
import com.st.front.officialwebsite.phone.util.OwFrontReturnJSON;
import com.st.front.util.FrontTools;
import com.st.model.Admins;
@Action(value="imgsAndInfoFrontAction")
public class ImgsAndInfoFrontAction extends OfficialwebsiteFrontPhoneBaseAction  implements ModelDriven<PageImgsAndInfoFront>{
	//注入imgsAndInfoFrontPhoneService
	private ImgsAndInfoFrontServiceI imgsAndInfoFrontPhoneService;

	
	public ImgsAndInfoFrontServiceI getImgsAndInfoFrontPhoneService() {
		return imgsAndInfoFrontPhoneService;
	}
	@Autowired
	public void setImgsAndInfoFrontPhoneService(
			ImgsAndInfoFrontServiceI imgsAndInfoFrontPhoneService) {
		this.imgsAndInfoFrontPhoneService = imgsAndInfoFrontPhoneService;
	}
	//注入pageModel
	private PageImgsAndInfoFront pageModel = new PageImgsAndInfoFront();
	
	@Override
	public PageImgsAndInfoFront getModel() {
		return pageModel;
	}
	/**
	 * 通过实体的id获取图片对象
	 */
	public void getImgsByInfoId(){
		/**
		 * 获取当前在线admin
		 * 执行事务
		 * 返回结果
		 */
		OwFrontReturnJSON<PageImgsAndInfoFront> retJSON = new OwFrontReturnJSON<PageImgsAndInfoFront>();
		try {
			//2.执行事务
			//copy属性
			retJSON = imgsAndInfoFrontPhoneService.getImgsByInfoId(pageModel);
			retJSON.setMsg("获取图片成功！");
			retJSON.setSuccess(true);
		} catch (OwImgsAndInfoFrontException e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}finally{
			super.writeJSON(retJSON);
		}
		
		
	}
	
	/**
	 * 通过实体的id获取图片对象及其name
	 */
	public void getMainImgByInfoId(){
		/**
		 * 获取当前在线admin
		 * 执行事务
		 * 返回结果
		 */
		OwFrontReturnJSON<PageImgsAndInfoFront> retJSON = new OwFrontReturnJSON<PageImgsAndInfoFront>();
		try {
			//2.执行事务
			//copy属性
			PageImgsAndInfoFront model = imgsAndInfoFrontPhoneService.getMainImgByInfoId(pageModel);
			retJSON.setObj(model);
			retJSON.setMsg("获取图片成功！");
			retJSON.setSuccess(true);
		} catch (OwImgsAndInfoFrontException e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}finally{
			super.writeJSON(retJSON);
		}
		
		
	}
	
	/**
	 * 获取新闻的图片
	 */
	public void getNewsImgByImgName(){
		
		String imgName = pageModel.getImgName();
		super.writeImgByPath(OwFrontStatic.OW_PATH_NEWS_IMG,imgName);
	}
	/**
	 * 获取业务的图片
	 */
	public void getServiceImgByImgName(){
		
		String imgName = pageModel.getImgName();
		super.writeImgByPath(OwFrontStatic.OW_PATH_SERVICE_IMG,imgName);
	}
	
	
}
