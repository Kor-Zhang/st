package com.st.front.officialwebsite.phone.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.front.officialwebsite.phone.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.phone.pageModel.PageNewsFront;
import com.st.front.officialwebsite.phone.service.NewsFrontServiceI;
import com.st.front.officialwebsite.phone.util.OwFrontReturnJSON;

/**
 * 配置action
 * 
 * @author Jhon
 * 
 */
@Action(value = "newsFrontAction")
public class NewsFrontAction extends OfficialwebsiteFrontPhoneBaseAction implements ModelDriven<PageNewsFront> {
	//注入pageModel
	public PageNewsFront pageModel = new PageNewsFront();
	@Override
	public PageNewsFront getModel() {
		return pageModel;
	}
	//注入newsFrontPhoneService
	private NewsFrontServiceI newsFrontPhoneService;
	
	
	public NewsFrontServiceI getNewsFrontPhoneService() {
		return newsFrontPhoneService;
	}
	@Autowired
	public void setNewsFrontPhoneService(NewsFrontServiceI newsFrontPhoneService) {
		this.newsFrontPhoneService = newsFrontPhoneService;
	}
	/**
	 * 获取指定page，rows,排序的新闻
	 */
	public void getNews(){
		OwFrontReturnJSON<PageNewsFront> retJSON = new OwFrontReturnJSON<PageNewsFront>();
		try {
			List<PageNewsFront> rows = newsFrontPhoneService.getNews(pageModel);
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
	 * 获取新闻
	 */
	public void getNewsById(){
		OwFrontReturnJSON<PageNewsFront> retJSON = new OwFrontReturnJSON<PageNewsFront>();
		try {
			PageNewsFront pageNews = newsFrontPhoneService.getNewsById(pageModel);
			retJSON.setObj(pageNews);
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
