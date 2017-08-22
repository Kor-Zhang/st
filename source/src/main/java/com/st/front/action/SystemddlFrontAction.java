package com.st.front.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.util.BackReturnJSON;
import com.st.front.pageModel.PageSystemddlFront;
import com.st.front.service.SystemddlFrontServiceI;




/**
 * 在struts2.xml中配置
 * 添加car
 * @author Jhon
 * 
 */
@Action(value = "systemddlFrontAction")

public class SystemddlFrontAction extends FrontBaseAction implements ModelDriven<PageSystemddlFront> {
	
	private PageSystemddlFront pageModel = new PageSystemddlFront();

	@Override
	public PageSystemddlFront getModel() {
		return pageModel;
	}
	private SystemddlFrontServiceI systemddlFrontService;

	public SystemddlFrontServiceI getSystemddlFrontService() {
		return systemddlFrontService;
	}

	@Autowired
	public void setSystemddlFrontService(
			SystemddlFrontServiceI systemddlFrontService) {
		this.systemddlFrontService = systemddlFrontService;
	}





	/**
	 * 通过传来的父节点id，获取当前节点的子节点，不需要验证权限
	 */
	public void querySystemddlByParentId(){
		/**
		 * 获取当前在线admin
		 * 执行事务
		 * 返回结果
		 */
		BackReturnJSON<PageSystemddlFront> retJSON = new BackReturnJSON<PageSystemddlFront>();
		try {
			List<PageSystemddlFront> systemddls = null;
			//2.执行事务
			systemddls = systemddlFrontService.querySystemddlByParentId(pageModel.getId());
			retJSON.setRows(systemddls);
			retJSON.setMsg("");
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
	/**
	 * 通过传来的id，获取当前节点，不需要验证权限
	 */
	public void querySystemddlById(){
		/**
		 * 获取当前在线admin
		 * 执行事务
		 * 返回结果
		 */
		BackReturnJSON<PageSystemddlFront> retJSON = new BackReturnJSON<PageSystemddlFront>();
		try {
			PageSystemddlFront systemddl = null;
			//2.执行事务
			systemddl = systemddlFrontService.querySystemddlById(pageModel.getId());
			retJSON.setObj(systemddl);
			retJSON.setMsg("");
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
