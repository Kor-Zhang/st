package com.st.back.officialwebsite.action;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.PubStatic;
import com.st.back.exception.AdminsException;
import com.st.back.officialwebsite.OwBackStatic;
import com.st.back.officialwebsite.exception.OwImgsAndInfoBackException;
import com.st.back.officialwebsite.pageModel.PageOwImgsAndInfoBack;
import com.st.back.officialwebsite.pageModel.PageOwNewsBack;
import com.st.back.officialwebsite.service.OwImgsAndInfoBackServiceI;
import com.st.back.officialwebsite.service.OwNewsBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.back.util.BackTools;
import com.st.model.Admins;
@Action(value="owNewsBackAction")
public class OwNewsBackAction extends OfficialwebsiteBackBaseAction  implements ModelDriven<PageOwNewsBack>{
	//注入owNewsBackService
	private OwNewsBackServiceI owNewsBackService;
	
	public OwNewsBackServiceI getOwNewsBackService() {
		return owNewsBackService;
	}
	@Autowired
	public void setOwNewsBackService(OwNewsBackServiceI owNewsBackService) {
		this.owNewsBackService = owNewsBackService;
	}

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
	private PageOwNewsBack pageModel = new PageOwNewsBack();
	
	@Override
	public PageOwNewsBack getModel() {
		return pageModel;
	}
	/**
	 * 获取新闻信息列表
	 */
	public void getDatagrid(){
		OwBackReturnJSON<PageOwNewsBack> retJSON = new OwBackReturnJSON<PageOwNewsBack>();
		try {
			Admins onlineAdmin = OwBackTools.getOnlineAdmin();
			retJSON = owNewsBackService.getDatagrid(onlineAdmin,pageModel);
			retJSON.setSuccess(true);
			retJSON.setMsg("读取信息成功！");
		}catch (Exception e) {
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
			e.printStackTrace();
		}finally{
			super.writeJSON(retJSON);
		}
	}
	
	/**
	 * 上传新闻的文本信息
	 */
	public void uploadTextNews(){
		OwBackReturnJSON retJSON = new OwBackReturnJSON();
		
        try {
        	Admins onlineAdmin = BackTools.getOnlineAdmin();
			//执行业务
        	owNewsBackService.uploadTextNews(onlineAdmin,pageModel);
			retJSON.setMsg("添加成功！");
			retJSON.setSuccess(true);
		} catch (Exception e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}finally{
			OwBackTools.writeJSON(retJSON);
			
		}
		
		
	}
	/**
	 * 更新新闻的文本信息
	 */
	public void updateTextNews(){
		OwBackReturnJSON retJSON = new OwBackReturnJSON();
		
        try {
        	Admins onlineAdmin = BackTools.getOnlineAdmin();
			//执行业务
        	owNewsBackService.updateTextNews(onlineAdmin,pageModel);
			retJSON.setMsg("更新成功！");
			retJSON.setSuccess(true);
		} catch (Exception e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}finally{
			OwBackTools.writeJSON(retJSON);
			
		}
		
		
	}
	public void deleteNews(){
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
			owNewsBackService.deleteNews(onlineAdmin,pageModel);
			retJSON.setMsg("删除信息成功！");
			retJSON.setSuccess(true);
		} catch (AdminsException e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}catch (Exception e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}finally{
			//返回结果
			super.writeJSON(retJSON);
		}
	}
	
	

	
	
}
