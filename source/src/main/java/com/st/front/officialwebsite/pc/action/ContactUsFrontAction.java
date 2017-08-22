package com.st.front.officialwebsite.pc.action;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.front.officialwebsite.pc.OwFrontStatic;
import com.st.front.officialwebsite.pc.exception.ContactUsInfoErrorException;
import com.st.front.officialwebsite.pc.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.pc.pageModel.PageContactUsFront;
import com.st.front.officialwebsite.pc.service.ContactUsFrontServiceI;
import com.st.front.officialwebsite.pc.util.OwFrontReturnJSON;
import com.st.front.officialwebsite.pc.util.OwFrontTools;

/**
 * 配置action
 * 
 * @author Jhon
 * 
 */
@Action(value = "contactUsFrontAction")
public class ContactUsFrontAction extends OfficialwebsiteFrontPCBaseAction implements ModelDriven<PageContactUsFront> {
	//注入pageModel
	public PageContactUsFront pageModel = new PageContactUsFront();
	@Override
	public PageContactUsFront getModel() {
		return pageModel;
	}
	//注入contactUsFrontService
	private ContactUsFrontServiceI contactUsFrontService;
	
	public ContactUsFrontServiceI getContactUsFrontService() {
		return contactUsFrontService;
	}
	@Autowired
	public void setContactUsFrontService(ContactUsFrontServiceI contactUsFrontService) {
		this.contactUsFrontService = contactUsFrontService;
	}
	/**
	 * 添加一条记录
	 */

	public void addContactUs(){
		OwFrontReturnJSON<PageContactUsFront> retJSON = new OwFrontReturnJSON<PageContactUsFront>();
		try {
			contactUsFrontService.addContactUs(pageModel);
			retJSON.setSuccess(true);
			retJSON.setMsg(getText("front.ow.pc.acceptAdviceTip"));
		}catch (ContactUsInfoErrorException e) {
			e.printStackTrace();
			//获取国际语言
			String val = getText(e.getMessage());
			retJSON.setMsg(val);
			retJSON.setSuccess(false);
		}catch (OfficialwebsiteFrontException e) {
			e.printStackTrace();
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
		}catch (Exception e) {
			e.printStackTrace();
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
		}finally{
			super.writeJSON(retJSON);
		}
		
	}
	
}
