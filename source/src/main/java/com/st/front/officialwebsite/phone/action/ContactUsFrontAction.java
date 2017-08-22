package com.st.front.officialwebsite.phone.action;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.front.officialwebsite.phone.OwFrontStatic;
import com.st.front.officialwebsite.phone.exception.ContactUsInfoErrorException;
import com.st.front.officialwebsite.phone.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.phone.pageModel.PageContactUsFront;
import com.st.front.officialwebsite.phone.service.ContactUsFrontServiceI;
import com.st.front.officialwebsite.phone.util.OwFrontReturnJSON;
import com.st.front.officialwebsite.phone.util.OwFrontTools;

/**
 * 配置action
 * 
 * @author Jhon
 * 
 */
@Action(value = "contactUsFrontAction")
public class ContactUsFrontAction extends OfficialwebsiteFrontPhoneBaseAction implements ModelDriven<PageContactUsFront> {
	//注入pageModel
	public PageContactUsFront pageModel = new PageContactUsFront();
	@Override
	public PageContactUsFront getModel() {
		return pageModel;
	}
	//注入contactUsFrontPhoneService
	private ContactUsFrontServiceI contactUsFrontPhoneService;
	
	
	public ContactUsFrontServiceI getContactUsFrontPhoneService() {
		return contactUsFrontPhoneService;
	}

	@Autowired
	public void setContactUsFrontPhoneService(
			ContactUsFrontServiceI contactUsFrontPhoneService) {
		this.contactUsFrontPhoneService = contactUsFrontPhoneService;
	}


	/**
	 * 添加一条记录
	 */

	public void addContactUs(){
		OwFrontReturnJSON<PageContactUsFront> retJSON = new OwFrontReturnJSON<PageContactUsFront>();
		try {
			contactUsFrontPhoneService.addContactUs(pageModel);
			retJSON.setSuccess(true);
			retJSON.setMsg(getText("front.ow.phone.acceptAdviceTip"));
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
