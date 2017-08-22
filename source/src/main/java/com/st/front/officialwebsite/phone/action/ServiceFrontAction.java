package com.st.front.officialwebsite.phone.action;

import java.io.File;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.front.officialwebsite.phone.OwFrontStatic;
import com.st.front.officialwebsite.phone.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.phone.pageModel.PageServiceFront;
import com.st.front.officialwebsite.phone.service.ServiceFrontServiceI;
import com.st.front.officialwebsite.phone.util.OwFrontReturnJSON;
import com.st.front.officialwebsite.phone.util.OwFrontTools;

/**
 * 配置action
 * 
 * @author Jhon
 * 
 */
@Action(value = "serviceFrontAction")
public class ServiceFrontAction extends OfficialwebsiteFrontPhoneBaseAction implements ModelDriven<PageServiceFront> {
	//注入pageModel
	public PageServiceFront pageModel = new PageServiceFront();
	@Override
	public PageServiceFront getModel() {
		return pageModel;
	}
	//注入serviceFrontPhoneService
	private ServiceFrontServiceI serviceFrontPhoneService;
	
	
	public ServiceFrontServiceI getServiceFrontPhoneService() {
		return serviceFrontPhoneService;
	}
	@Autowired
	public void setServiceFrontPhoneService(
			ServiceFrontServiceI serviceFrontPhoneService) {
		this.serviceFrontPhoneService = serviceFrontPhoneService;
	}
	/**
	 * 获取指定page，rows的业务，分页，排序
	 */
	public void getService(){
		OwFrontReturnJSON<PageServiceFront> retJSON = new OwFrontReturnJSON<PageServiceFront>();
		try {
			List<PageServiceFront> rows = serviceFrontPhoneService.getService(pageModel);
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
			PageServiceFront pageService = serviceFrontPhoneService.getServiceById(pageModel);
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
