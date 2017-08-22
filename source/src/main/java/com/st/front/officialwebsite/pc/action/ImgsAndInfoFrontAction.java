package com.st.front.officialwebsite.pc.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.front.officialwebsite.pc.OwFrontStatic;
import com.st.front.officialwebsite.pc.exception.OwImgsAndInfoFrontException;
import com.st.front.officialwebsite.pc.pageModel.PageImgsAndInfoFront;
import com.st.front.officialwebsite.pc.service.ImgsAndInfoFrontServiceI;
import com.st.front.officialwebsite.pc.util.OwFrontReturnJSON;
import com.st.front.util.FrontTools;
import com.st.model.Admins;
@Action(value="imgsAndInfoFrontAction")
public class ImgsAndInfoFrontAction extends OfficialwebsiteFrontPCBaseAction  implements ModelDriven<PageImgsAndInfoFront>{
	//注入imgsAndInfoFrontService
	private ImgsAndInfoFrontServiceI imgsAndInfoFrontService;

	public ImgsAndInfoFrontServiceI getImgsAndInfoFrontService() {
		return imgsAndInfoFrontService;
	}
	@Autowired
	public void setImgsAndInfoFrontService(
			ImgsAndInfoFrontServiceI imgsAndInfoFrontService) {
		this.imgsAndInfoFrontService = imgsAndInfoFrontService;
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
			retJSON = imgsAndInfoFrontService.getImgsByInfoId(pageModel);
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
			PageImgsAndInfoFront model = imgsAndInfoFrontService.getMainImgByInfoId(pageModel);
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
