package com.st.back.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.exception.AdminsException;
import com.st.back.exception.SystemddlException;
import com.st.back.pageModel.PageSystemddl;
import com.st.back.service.SystemddlServiceI;
import com.st.back.util.BackReturnJSON;
import com.st.back.util.BackTools;
import com.st.model.Admins;


/**
 * 在struts2.xml中配置
 * 添加car
 * @author Jhon
 * 
 */
@Action(value = "systemddlAction")

public class SystemddlAction extends BackBaseAction implements ModelDriven<PageSystemddl> {
	
	private PageSystemddl pageModel = new PageSystemddl();

	@Override
	public PageSystemddl getModel() {
		return pageModel;
	}
	private SystemddlServiceI systemddlService;

	
	public SystemddlServiceI getSystemddlService() {
		return systemddlService;
	}

	@Autowired
	public void setSystemddlService(SystemddlServiceI systemddlService) {
		this.systemddlService = systemddlService;
	}


	
	

	/**
	 * 通过传来的父节点id，获取当前节点的子节点
	 */
	public void getSystemddlByParentId(){
		/**
		 * 获取当前在线admin
		 * 执行事务
		 * 返回结果
		 */
		BackReturnJSON<PageSystemddl> retJSON = new BackReturnJSON<PageSystemddl>();
		try {
			List<PageSystemddl> systemddls = null;
			//1.获取当前在线admin
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			//2.执行事务
			systemddls = systemddlService.getSystemddlByParentId(onlineAdmin,pageModel.getId());
			retJSON.setRows(systemddls);
			retJSON.setMsg("");
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
	 * 通过传来的id，添加一个新节点
	 */
	public void addSystemddl(){
		/**
		 * 获取当前在线admin
		 * 执行事务
		 * 返回结果
		 */
		BackReturnJSON<PageSystemddl> retJSON = new BackReturnJSON<PageSystemddl>();
		try {
			PageSystemddl systemddl = new PageSystemddl();
			//1.获取当前在线admin
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			//2.执行事务
			systemddl = systemddlService.addSystemddl(onlineAdmin,pageModel.getId());
			retJSON.setObj(systemddl);
			retJSON.setSuccess(true);
			retJSON.setMsg("添加成功！");
		} catch (AdminsException e) {
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
			e.printStackTrace();
		
		} catch (SystemddlException e) {
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
			e.printStackTrace();
		}finally{
			
			//返回结果
			super.writeJSON(retJSON);
		}
	}
	
	/**
	 * 通过传来的id，和text修改节点的文本信息
	 */
	public void updateSystemddl(){
		/**
		 * 获取当前在线admin
		 * 执行事务
		 * 返回结果
		 */
		BackReturnJSON retJSON = new BackReturnJSON();
		try {
			//1.获取当前在线admin
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			//2.执行事务
			systemddlService.updateSystemddlText(onlineAdmin,pageModel);
			retJSON.setMsg("更新成功！");
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
	 * 通过传来的id，修改节点的rank
	 */
	public void updateSystemddlRank(){
		/**
		 * 获取当前在线admin
		 * 执行事务
		 * 返回结果
		 */
		BackReturnJSON retJSON = new BackReturnJSON();
		try {
			//1.获取当前在线admin
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			//2.执行事务
			systemddlService.updateSystemddlRank(onlineAdmin,pageModel);
			retJSON.setMsg("更新成功！");
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
	 * 通过传来的id删除节点
	 */
	public void deleteSystemddl(){
		/**
		 * 获取当前在线admin
		 * 执行事务
		 * 返回结果
		 */
		BackReturnJSON retJSON = new BackReturnJSON<>();
		try {
			//1.获取当前在线admin
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			//2.执行事务
			systemddlService.deleteSystemddl(onlineAdmin,pageModel);

			retJSON.setMsg("删除成功！");
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
