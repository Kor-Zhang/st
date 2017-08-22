package com.st.back.officialwebsite.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.exception.AdminsException;
import com.st.back.officialwebsite.pageModel.PageOwContactUsBack;
import com.st.back.officialwebsite.service.OwContactUsBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.back.util.BackTools;
import com.st.model.Admins;


@Action(value="owContactUsBackAction")
public class OwContactUsBackAction extends OfficialwebsiteBackBaseAction  implements ModelDriven<PageOwContactUsBack>{
	private OwContactUsBackServiceI owContactUsBackService;
	//注入owContactUsBackService
	public OwContactUsBackServiceI getOwContactUsBackService() {
		return owContactUsBackService;
	}
	@Autowired
	public void setOwContactUsBackService(OwContactUsBackServiceI owContactUsBackService) {
		this.owContactUsBackService = owContactUsBackService;
	}
	
	//注入pageModel
	private PageOwContactUsBack pageModel = new PageOwContactUsBack();
	@Override
	public PageOwContactUsBack getModel() {
		return pageModel;
	}

	/**
	 * 获取用户反馈信息列表
	 * @throws Exception 
	 */
	public void getDatagrid(){
		OwBackReturnJSON<PageOwContactUsBack> retJSON = new OwBackReturnJSON<PageOwContactUsBack>();
		try {
			Admins onlineAdmin = OwBackTools.getOnlineAdmin();
			retJSON = owContactUsBackService.getDatagrid(onlineAdmin,pageModel);
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
	 * 删除
	 */
	public void deleteContactUs(){
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
			owContactUsBackService.deleteContactUs(onlineAdmin,pageModel);
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
	/**
	 * 更新状态
	 */
	public void UpdateContactUsStatus(){
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
			owContactUsBackService.UpdateContactUsStatus(onlineAdmin,pageModel);
			retJSON.setMsg("更新状态成功！");
			retJSON.setSuccess(true);
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
