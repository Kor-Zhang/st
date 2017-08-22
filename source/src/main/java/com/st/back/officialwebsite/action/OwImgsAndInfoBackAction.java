package com.st.back.officialwebsite.action;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.BackStatic;
import com.st.back.officialwebsite.OwBackStatic;
import com.st.back.officialwebsite.exception.OwImgsAndInfoBackException;
import com.st.back.officialwebsite.pageModel.PageOwImgsAndInfoBack;
import com.st.back.officialwebsite.service.OwImgsAndInfoBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.back.util.BackTools;
import com.st.model.Admins;
@Action(value="owImgsAndInfoBackAction")
public class OwImgsAndInfoBackAction extends OfficialwebsiteBackBaseAction  implements ModelDriven<PageOwImgsAndInfoBack>{
	//注入owImgsAndInfoBackService
	private OwImgsAndInfoBackServiceI owImgsAndInfoBackService;
	
	public OwImgsAndInfoBackServiceI getOwImgsAndInfoBackService() {
		return owImgsAndInfoBackService;
	}
	@Autowired
	public void setOwImgsAndInfoBackService(OwImgsAndInfoBackServiceI owImgsAndInfoBackService) {
		this.owImgsAndInfoBackService = owImgsAndInfoBackService;
	}


	//注入pageModel
	private PageOwImgsAndInfoBack pageModel = new PageOwImgsAndInfoBack();
	
	@Override
	public PageOwImgsAndInfoBack getModel() {
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
		OwBackReturnJSON<PageOwImgsAndInfoBack> retJSON = new OwBackReturnJSON<PageOwImgsAndInfoBack>();
		try {
			//1.获取当前在线admin
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			//2.执行事务
			//copy属性
			retJSON = owImgsAndInfoBackService.getImgsByInfoId(onlineAdmin,pageModel);
			retJSON.setMsg("获取图片成功！");
			retJSON.setSuccess(true);
		} catch (OwImgsAndInfoBackException e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}finally{
			super.writeJSON(retJSON);
		}
		
		
	}
	/**
	 * 删除新闻图片
	 */
	public void deleteImgsByImgsAndInfoId(){
		/**
		 * 获取当前在线admin
		 * 执行事务
		 * 返回结果
		 */
		OwBackReturnJSON<PageOwImgsAndInfoBack> retJSON = new OwBackReturnJSON<PageOwImgsAndInfoBack>();
		try {
			//1.获取当前在线admin
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			//2.执行事务
			owImgsAndInfoBackService.deleteImgsByImgsAndInfoId(onlineAdmin,pageModel);
			retJSON.setMsg("删除图片成功！");
			retJSON.setSuccess(true);
		} catch (OwImgsAndInfoBackException e) {
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
		super.writeImgByPath(OwBackStatic.OW_PATH_NEWS_IMG,imgName);
	}
	/**
	 * 获取业务的图片
	 */
	public void getServiceImgByImgName(){
		
		String imgName = pageModel.getImgName();
		super.writeImgByPath(OwBackStatic.OW_PATH_SERVICE_IMG,imgName);
	}
	public void UpdateImgMainByImgsAndInfoId(){
		OwBackReturnJSON<PageOwImgsAndInfoBack> retJSON = new OwBackReturnJSON<PageOwImgsAndInfoBack>();
		try {
			//1.获取当前在线admin
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			//2.执行事务
			owImgsAndInfoBackService.UpdateImgMainByImgsAndInfoId(onlineAdmin,pageModel.getId());
			retJSON.setMsg("设置主要图片成功！");
			retJSON.setSuccess(true);
		} catch (OwImgsAndInfoBackException e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}finally{
			super.writeJSON(retJSON);
		}
	}
	
}
