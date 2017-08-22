package com.st.back.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.exception.AdminsException;
import com.st.back.pageModel.PagePowers;
import com.st.back.service.PowersServiceI;
import com.st.back.util.BackReturnJSON;
import com.st.back.util.BackTools;
import com.st.model.Admins;
/**
 * 配置action
 * 
 * @author Jhon
 * 
 */
@Action(value="powersAction")
public class PowersAction extends BackBaseAction implements ModelDriven<PagePowers>  {
	private PagePowers pageModel = new PagePowers();
	@Override
	public PagePowers getModel() {
		return pageModel;
	}
	
	
	private PowersServiceI powersService;
	//注入powersService
	public PowersServiceI getPowersService() {
		return powersService;
	}

	public void setPowersService(PowersServiceI powersService) {
		this.powersService = powersService;
	}
	/**
	 * 获取权限的tree
	 */
	public void getPowerTree(){
		BackReturnJSON retJSON = new BackReturnJSON();
		try {
			//1.获取当前在线admin
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			//2.执行事务
			List<PagePowers> mTree = powersService.getPowerTree(onlineAdmin,pageModel);
			retJSON.setMsg("获取信息成功！");
			retJSON.setSuccess(true);
			retJSON.setRows(mTree);
		} catch (AdminsException e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			retJSON.setRows(null);
			e.printStackTrace();
		}finally{

			//返回结果
			super.writeJSON(retJSON);
		}
		
	}
	/**
	 * 更新admin的power
	 */
	public void updatePowers(){
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
			powersService.updatePowers(onlineAdmin,pageModel);
			retJSON.setMsg("修改信息成功！");
			retJSON.setSuccess(true);
		} catch (AdminsException e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		} catch (Exception e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}finally{

			//返回结果
			super.writeJSON(retJSON);
		}
	}
}
