package com.st.front.officialwebsite.pc.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.officialwebsite.service.OwImgsBackServiceI;
import com.st.front.officialwebsite.pc.pageModel.PageImgsFront;
import com.st.front.officialwebsite.pc.service.ImgsFrontServiceI;
@Action(value="imgsFrontAction")
public class ImgsFrontAction extends OfficialwebsiteFrontPCBaseAction  implements ModelDriven<PageImgsFront>{
	//注入imgsFrontService
	private ImgsFrontServiceI imgsFrontService;
	

	public ImgsFrontServiceI getImgsFrontService() {
		return imgsFrontService;
	}
	@Autowired
	public void setImgsFrontService(ImgsFrontServiceI imgsFrontService) {
		this.imgsFrontService = imgsFrontService;
	}

	//注入pageModel
	private PageImgsFront pageModel = new PageImgsFront();
	
	@Override
	public PageImgsFront getModel() {
		return pageModel;
	}
	
	
}
