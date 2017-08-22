package com.st.front.officialwebsite.phone.service.impl;


import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.back.officialwebsite.OwBackStatic;
import com.st.front.officialwebsite.phone.dao.ContactUsFrontDaoI;
import com.st.front.officialwebsite.phone.exception.ContactUsInfoErrorException;
import com.st.front.officialwebsite.phone.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.phone.pageModel.PageContactUsFront;
import com.st.front.officialwebsite.phone.service.ContactUsFrontServiceI;
import com.st.front.officialwebsite.phone.util.OwFrontTools;
import com.st.model.OfficialwebsiteContactUs;
import com.st.util.PubMail;
@Service(value="contactUsFrontPhoneService")
public class ContactUsFrontServiceImpl implements ContactUsFrontServiceI{
	//注入contactUsFrontPhoneDao
	private ContactUsFrontDaoI contactUsFrontPhoneDao;
	
	
	
	public ContactUsFrontDaoI getContactUsFrontPhoneDao() {
		return contactUsFrontPhoneDao;
	}


	@Autowired
	public void setContactUsFrontPhoneDao(ContactUsFrontDaoI contactUsFrontPhoneDao) {
		this.contactUsFrontPhoneDao = contactUsFrontPhoneDao;
	}



	@Override
	public void addContactUs(PageContactUsFront pageModel)
			throws OfficialwebsiteFrontException {
		//验证信息完整性
		//验证邮箱
		if(OwFrontTools.isEmptyTrimString(pageModel.getName())){
			throw new ContactUsInfoErrorException("front.ow.phone.fillName");
		}
		if(OwFrontTools.isEmptyTrimString(pageModel.getOrgName())){
			throw new ContactUsInfoErrorException("front.ow.phone.fillOrg");
		}
		
		if(OwFrontTools.isEmptyTrimString(pageModel.getEmail())){
			throw new ContactUsInfoErrorException("front.ow.phone.fillEmail");
		}

		if(OwFrontTools.isEmptyTrimString(pageModel.getPhoneNumber())){
			throw new ContactUsInfoErrorException("front.ow.phone.fillPhoneNumber");
		}
		if(OwFrontTools.isEmptyTrimString(pageModel.getMsg())){
			throw new ContactUsInfoErrorException("front.ow.phone.fillAdvice");
		}
		//验证信息正确性
		//验证手机号
		if(pageModel.getPhoneNumber().length()!=11){
			throw new ContactUsInfoErrorException("front.ow.phone.phoneNumberFormatError");
		}
		//验证邮箱
		String pat = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		if(!pageModel.getEmail().matches(pat)){
			throw new ContactUsInfoErrorException("front.ow.phone.emailFormatError");
		}
		
		
		//过滤textarea的文本信息，\r\n等
		
		
		Timestamp now = new Timestamp(new Date().getTime());
		pageModel.setCreateTime(now);
		pageModel.setUpdateTime(now);
		pageModel.setStatus(OwBackStatic.OFFICIALWEBSITE_CONTACT_US_STATUS_SUBMITED);
		pageModel.setIsDelete(false);
		pageModel.setId(UUID.randomUUID().toString());
		OfficialwebsiteContactUs tableModel = new OfficialwebsiteContactUs();
		BeanUtils.copyProperties(pageModel, tableModel);
		
		contactUsFrontPhoneDao.save(tableModel);
		
		
		//开启一个线程发送邮件
		final String email = pageModel.getEmail();
		final PubMail mail = new com.st.util.PubMail();
		final String content = (String) mail.getConfig("userAdviceContent");
		final String subject = (String) mail.getConfig("userAdviceSubject");
		try{
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// send mail
					
					try {
						mail.sendMessage(email, subject, content);
					} catch (Exception e) {
						e.printStackTrace();
						
					}
				}
			}).start();;
						
		}catch(Exception e){
			e.printStackTrace();
			throw new OfficialwebsiteFrontException("发送邮箱失败");
		}
		
	}
	

}
