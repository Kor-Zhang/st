package com.st.front.officialwebsite.pc.service.impl;


import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.back.officialwebsite.OwBackStatic;
import com.st.front.officialwebsite.pc.dao.ContactUsFrontDaoI;
import com.st.front.officialwebsite.pc.exception.ContactUsInfoErrorException;
import com.st.front.officialwebsite.pc.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.pc.pageModel.PageContactUsFront;
import com.st.front.officialwebsite.pc.service.ContactUsFrontServiceI;
import com.st.front.officialwebsite.pc.util.OwFrontTools;
import com.st.model.OfficialwebsiteContactUs;
import com.st.util.PubMail;
@Service(value="contactUsFrontService")
public class ContactUsFrontServiceImpl implements ContactUsFrontServiceI{
	//注入contactUsFrontDao
	private ContactUsFrontDaoI contactUsFrontDao;
	
	public ContactUsFrontDaoI getContactUsFrontDao() {
		return contactUsFrontDao;
	}
	@Autowired
	public void setContactUsFrontDao(ContactUsFrontDaoI contactUsFrontDao) {
		this.contactUsFrontDao = contactUsFrontDao;
	}
	
	@Override
	public void addContactUs(PageContactUsFront pageModel)
			throws OfficialwebsiteFrontException {
		//验证信息完整性
		//验证邮箱
		if(OwFrontTools.isEmptyTrimString(pageModel.getName())){
			throw new ContactUsInfoErrorException("front.ow.pc.fillName");
		}
		if(OwFrontTools.isEmptyTrimString(pageModel.getOrgName())){
			throw new ContactUsInfoErrorException("front.ow.pc.fillOrg");
		}
		
		if(OwFrontTools.isEmptyTrimString(pageModel.getEmail())){
			throw new ContactUsInfoErrorException("front.ow.pc.fillEmail");
		}

		if(OwFrontTools.isEmptyTrimString(pageModel.getPhoneNumber())){
			throw new ContactUsInfoErrorException("front.ow.pc.fillPhoneNumber");
		}
		if(OwFrontTools.isEmptyTrimString(pageModel.getMsg())){
			throw new ContactUsInfoErrorException("front.ow.pc.fillAdvice");
		}
		//验证信息正确性
		//验证手机号
		if(pageModel.getPhoneNumber().length()!=11){
			throw new ContactUsInfoErrorException("front.ow.pc.phoneNumberFormatError");
		}
		//验证邮箱
		String pat = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		if(!pageModel.getEmail().matches(pat)){
			throw new ContactUsInfoErrorException("front.ow.pc.emailFormatError");
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
		
		contactUsFrontDao.save(tableModel);
		
		
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
