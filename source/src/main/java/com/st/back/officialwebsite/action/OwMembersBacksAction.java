package com.st.back.officialwebsite.action;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.exception.AdminsException;
import com.st.back.officialwebsite.OwBackStatic;
import com.st.back.officialwebsite.exception.OfficialwebsiteBackException;
import com.st.back.officialwebsite.pageModel.PageOwMembersBack;
import com.st.back.officialwebsite.service.OwMembersBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.back.util.BackTools;
import com.st.model.Admins;
@Action(value="owMembersBackAction")
public class OwMembersBacksAction extends OfficialwebsiteBackBaseAction  implements ModelDriven<PageOwMembersBack>{
	//注入owMembersBackService
	private OwMembersBackServiceI owMembersBackService;
	
	
	public OwMembersBackServiceI getOwMembersBackService() {
		return owMembersBackService;
	}
	@Autowired
	public void setOwMembersBackService(OwMembersBackServiceI owMembersBackService) {
		this.owMembersBackService = owMembersBackService;
	}


	//注入pageModel
	private PageOwMembersBack pageModel = new PageOwMembersBack();
	
	@Override
	public PageOwMembersBack getModel() {
		return pageModel;
	}
	
	
	/**
	 * 获取官网成员信息列表
	 */
	public void getDatagrid(){
		OwBackReturnJSON<PageOwMembersBack> retJSON = new OwBackReturnJSON<PageOwMembersBack>();
		try {
			Admins onlineAdmin = OwBackTools.getOnlineAdmin();
			retJSON = owMembersBackService.getDatagrid(onlineAdmin,pageModel);
			retJSON.setMsg("");
			retJSON.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
		}finally{
			super.writeJSON(retJSON);
		}
	}
	/**
	 * 获取官网日常展示的图片
	 */
	public void getImgByHead(){
		File imgFile = null;
		try {
			String head = pageModel.getHead();
			imgFile = new File(OwBackStatic.OW_PATH_MEMBERS_IMG,head);
			//如果没有img，那么抛出异常
			if(OwBackTools.isEmptyTrimString(head)||!imgFile.exists()){
				throw new Exception("没有该图片！");
			}
			
		} catch (Exception e) {
			imgFile = new File(OwBackStatic.OW_PATH_MEMBERS_IMG,OwBackStatic.OW_PATH_DEFAULT_IMG_NAME);
			e.printStackTrace();
		}finally{
			super.writeImg(imgFile);
		}
	}
	/**
	 * 删除
	 */
	public void deleteMembers(){
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
			owMembersBackService.deleteMembers(onlineAdmin,pageModel);
			retJSON.setMsg("删除信息成功！");
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
