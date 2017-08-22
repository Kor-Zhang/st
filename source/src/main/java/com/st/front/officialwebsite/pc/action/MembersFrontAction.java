package com.st.front.officialwebsite.pc.action;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.front.officialwebsite.pc.OwFrontStatic;
import com.st.front.officialwebsite.pc.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.pc.pageModel.PageMembersFront;
import com.st.front.officialwebsite.pc.service.MembersFrontServiceI;
import com.st.front.officialwebsite.pc.util.OwFrontReturnJSON;
import com.st.front.officialwebsite.pc.util.OwFrontTools;

/**
 * 配置action
 * 
 * @author Jhon
 * 
 */
@Action(value = "membersFrontAction")
public class MembersFrontAction extends OfficialwebsiteFrontPCBaseAction implements ModelDriven<PageMembersFront> {
	//注入pageModel
	public PageMembersFront pageModel = new PageMembersFront();
	@Override
	public PageMembersFront getModel() {
		return pageModel;
	}
	//注入membersFrontService
	private MembersFrontServiceI membersFrontService;
	
	public MembersFrontServiceI getMembersFrontService() {
		return membersFrontService;
	}
	@Autowired
	public void setMembersFrontService(MembersFrontServiceI membersFrontService) {
		this.membersFrontService = membersFrontService;
	}
	/**
	 * 获取members
	 */
	public void getMembersByCondition(){
		OwFrontReturnJSON<PageMembersFront> retJSON = new OwFrontReturnJSON<PageMembersFront>();
		try {
			retJSON = membersFrontService.getMembersByCondition(pageModel);
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
	 * 根据head获取轮播图片
	 */
	public void getMembersImgHead(){
		String imgName = pageModel.getHead();
		String dirPath = OwFrontStatic.OW_PATH_MEMBERS_IMG;
		File imgFile = new File(dirPath,imgName);;
		//如果文件名为空，返回默认图片
		if(OwFrontTools.isEmptyTrimString(imgName)||!imgFile.exists()){
			imgFile = new File(dirPath,OwFrontStatic.OW_PATH_DEFAULT_IMG_NAME);
		}
		//返回图片
		super.writeImg(imgFile);
	}
	
	
	/**
	 * 根据id获取记录
	 */
	public void getMembersById(){
		OwFrontReturnJSON<PageMembersFront> retJSON = new OwFrontReturnJSON<PageMembersFront>();
		try {
			retJSON.setObj(membersFrontService.getMembersById(pageModel));
			
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
