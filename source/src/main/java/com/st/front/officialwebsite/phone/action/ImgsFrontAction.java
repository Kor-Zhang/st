package com.st.front.officialwebsite.phone.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.officialwebsite.service.OwImgsBackServiceI;
import com.st.front.officialwebsite.phone.pageModel.PageImgsFront;
import com.st.front.officialwebsite.phone.service.ImgsFrontServiceI;
@Action(value="imgsFrontAction")
public class ImgsFrontAction extends OfficialwebsiteFrontPhoneBaseAction  implements ModelDriven<PageImgsFront>{
	//注入imgsFrontPhoneService
	private ImgsFrontServiceI imgsFrontPhoneService;
	

	

	public ImgsFrontServiceI getImgsFrontPhoneService() {
		return imgsFrontPhoneService;
	}
	@Autowired
	public void setImgsFrontPhoneService(ImgsFrontServiceI imgsFrontPhoneService) {
		this.imgsFrontPhoneService = imgsFrontPhoneService;
	}

	//注入pageModel
	private PageImgsFront pageModel = new PageImgsFront();
	
	@Override
	public PageImgsFront getModel() {
		return pageModel;
	}
	
	
}
