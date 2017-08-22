package com.st.front.officialwebsite.pc.action;

import java.io.File;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.front.officialwebsite.pc.OwFrontStatic;
import com.st.front.officialwebsite.pc.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.pc.pageModel.PageServiceFront;
import com.st.front.officialwebsite.pc.service.ServiceFrontServiceI;
import com.st.front.officialwebsite.pc.util.OwFrontReturnJSON;
import com.st.front.officialwebsite.pc.util.OwFrontTools;

/**
 * 配置action
 * 
 * @author Jhon
 * 
 */
@Action(value = "serviceFrontAction")
public class ServiceFrontAction extends OfficialwebsiteFrontPCBaseAction implements ModelDriven<PageServiceFront> {
	//注入pageModel
	public PageServiceFront pageModel = new PageServiceFront();
	@Override
	public PageServiceFront getModel() {
		return pageModel;
	}
	//注入serviceFrontService
	private ServiceFrontServiceI serviceFrontService;
	
	public ServiceFrontServiceI getServiceFrontService() {
		return serviceFrontService;
	}
	@Autowired
	public void setServiceFrontService(ServiceFrontServiceI serviceFrontService) {
		this.serviceFrontService = serviceFrontService;
	}
	/**
	 * 获取指定page，rows的业务，分页，排序
	 */
	public void getService(){
		OwFrontReturnJSON<PageServiceFront> retJSON = new OwFrontReturnJSON<PageServiceFront>();
		try {
			List<PageServiceFront> rows = serviceFrontService.getService(pageModel);
			retJSON.setRows(rows);
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
	 * 获取业务
	 */
	public void getServiceById(){
		OwFrontReturnJSON<PageServiceFront> retJSON = new OwFrontReturnJSON<PageServiceFront>();
		try {
			PageServiceFront pageService = serviceFrontService.getServiceById(pageModel);
			retJSON.setObj(pageService);
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
	
}
