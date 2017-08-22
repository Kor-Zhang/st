package com.st.back.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.BackStatic;
import com.st.back.exception.AdminsException;
import com.st.back.exception.AdminsIsLoginException;
import com.st.back.officialwebsite.OwBackStatic;
import com.st.back.pageModel.PageAdminLoginRecord;
import com.st.back.pageModel.PageAdmins;
import com.st.back.service.AdminsServiceI;
import com.st.back.util.BackReturnJSON;
import com.st.back.util.BackTools;
import com.st.model.Adminloginrecord;
import com.st.model.Admins;
import com.st.util.SessionMap;

/**
 * 配置action
 * 
 * @author Jhon
 * 
 */
@Action(value = "adminsAction", 
results = { @Result(name = "adminLogoff_success",type="redirect",location = "/back/jsps/index.jsp") })
public class AdminsAction extends BackBaseAction implements ModelDriven<PageAdmins> {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = OwBackStatic.L;
	public PageAdmins pageAdmin = new PageAdmins();

	@Override
	public PageAdmins getModel() {
		return pageAdmin;
	}
	private AdminsServiceI adminsService;
	public AdminsServiceI getAdminsService() {
		return adminsService;
	}
	@Autowired
	public void setAdminsService(AdminsServiceI adminsService) {
		this.adminsService = adminsService;
	}
	//获取app中的sessionmap
	public static SessionMap<String, HttpSession> adminsSessionMap = new SessionMap<String, HttpSession>(BackStatic.SESSION_MAP_ADMIN);

	/**
	 * 管理员注册
	 *//*
	public void adminRegist() {
		ReturnJSON retJSON = new ReturnJSON();
		try {
			// 保存用户
			adminsService.adminRegist(pageAdmin);
			retJSON.setSuccess(true);
			retJSON.setMsg("注册成功！");
		} catch (Exception e) {
			e.printStackTrace();
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
		} finally {
			super.writeJSON(retJSON);

		}
	}*/
	/**
	 * 管理员登陆
	 */
	public void adminLogin() {
		PageAdmins returnAdmin = new PageAdmins();
		try {
			if(BackTools.getOnlineAdmin()!=null){
				throw new AdminsIsLoginException("您已在此客户端登录，请勿重复登陆，点击刷新页面即可！");
			}
			String msg = "登陆成功！";
			//obj[0]为admin对象，obj[1]为登陆记录对象
			Object[] objs = adminsService.adminLogin(pageAdmin);
			Admins objAdmin = (Admins)objs[0];
			Adminloginrecord objAdminLoginRecord = (Adminloginrecord)objs[1];
			//session设置amdin参数
			BackTools.getSession().setAttribute(BackStatic.ONLINE_ADMIN, objAdmin);
			//将信息存入session，session销毁时更新logoggtime
			BackTools.getSession().setAttribute(BackStatic.adminLoginRecordSessionName, objAdminLoginRecord);
			//复制返回信息
			BeanUtils.copyProperties(objAdmin, returnAdmin);
			//在app中设置在线状态
			logger.info(adminsSessionMap.getValues().size());
			
			//查看该用户是否已经登陆
			String onlineAdminId = objAdmin.getId();
			logger.info(adminsSessionMap.containKey(onlineAdminId));
			if(adminsSessionMap.containKey(onlineAdminId)){
				//session失效
				HttpSession session = adminsSessionMap.getAttribute(onlineAdminId);
				//获取上一个登陆客户端的登陆记录
				Adminloginrecord alr = (Adminloginrecord) session.getAttribute(BackStatic.adminLoginRecordSessionName);
				msg = "该管理员 "+alr.getLoginTime()+" 在 "+alr.getLoginAddress()+"（ip："+alr.getLoginIp()+"） 登陆！";
				session.invalidate();
				session = null;
				
				
			}
			//添加当前登陆用户到sessionmap
			adminsSessionMap.addAttribute(onlineAdminId,BackTools.getSession());
			
			returnAdmin.setSuccess(true);
			returnAdmin.setMsg(msg); 
		}catch(AdminsIsLoginException e){
			e.printStackTrace();
			returnAdmin.setSuccess(false);
			returnAdmin.setMsg(e.getMessage());
		}catch (AdminsException e) {
			e.printStackTrace();
			returnAdmin.setSuccess(false);
			returnAdmin.setMsg(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			returnAdmin.setSuccess(false);
			returnAdmin.setMsg(e.getMessage());
		} finally {

			super.writeJSON(returnAdmin);

		}
	}
	/**
	 * 根据id获取admin
	 * @author Jhon
	 */
	public void getSingleAdminDatagridById(){
		/**
		 * 获取当前在线admin
		 * 执行事务
		 * 返回结果
		 */
		BackReturnJSON<PageAdmins> retJSON = new BackReturnJSON<PageAdmins>();
		try {
			//1.获取当前在线admin
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			//2.执行事务
			retJSON = adminsService.getSingleAdminDatagridById(onlineAdmin,pageAdmin);
			retJSON.setMsg("读取信息成功！");
			retJSON.setSuccess(true);
		} catch (AdminsException e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}finally{

			super.writeJSON(retJSON);
		}
	}
	/**
	 * 获取权限管理的datagrid数据
	 * @author Jhon
	 */
	public void getDatagrid(){
		/**
		 * 获取当前在线admin
		 * 执行事务
		 * 返回结果
		 */
		BackReturnJSON<PageAdmins> retJSON = new BackReturnJSON<PageAdmins>();
		try {
			//1.获取当前在线admin
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			//2.执行事务
			logger.info(pageAdmin);
			retJSON = adminsService.getDatagrid(onlineAdmin,pageAdmin);
			retJSON.setMsg("读取信息成功！");
			retJSON.setSuccess(true);
		} catch (AdminsException e) {
			retJSON.setMsg(e.getMessage());
			retJSON.setSuccess(false);
			e.printStackTrace();
		}finally{

			super.writeJSON(retJSON);
		}
	}
	/**
	 * 检测当前session是否有用户在线
	 */
	public void isAdminOnline(){
		
		Admins onlineAdmin = BackTools.getOnlineAdmin();
		PageAdmins onlinePageAdmin = new PageAdmins();
		
		
		if(onlineAdmin!=null){
			BeanUtils.copyProperties(onlineAdmin, onlinePageAdmin);
			onlinePageAdmin.setOnline(true);
			onlinePageAdmin.setMsg("");
		}else{
			onlinePageAdmin.setOnline(false); 
			onlinePageAdmin.setMsg("你是离线状态！");
		}
		
		super.writeJSON(onlinePageAdmin);
		
		

	}
	/**
	 * 添加admin
	 * @author Jhon
	 * @param
	 */
	public void addAdmin(){
		BackReturnJSON retJSON = new BackReturnJSON();
		try{
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			Admins admin = adminsService.addAdmin(onlineAdmin,pageAdmin);
			retJSON.setSuccess(true);
			BeanUtils.copyProperties(admin,pageAdmin);
			retJSON.setObj(pageAdmin);
			retJSON.setMsg("添加成功！");
		}catch(AdminsException e){
			
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
		}catch(Exception e){
			
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
		}finally{

			super.writeJSON(retJSON);
		}
	}
	/**
	 * 根据admin的id字符串，删除admins
	 * @author Jhon
	 * @param
	 */
	public void deleteAdmins(){
		/**
		 * 1.获取需要删除的记录的id
		 * 	-id是一个字符串，格式为"1,2,5,3"
		 * 2.传入id集合到service，进行删除
		 * 3.设置json返回结果
		 * 4.返回json结果
		 */
		BackReturnJSON retJSON = new BackReturnJSON();
		try{
			//1.获取需要删除的记录的id
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			String deleteIds = pageAdmin.getDeleteIds();
			//2.传入id集合到service，进行删除
			adminsService.deleteAdmins(onlineAdmin,deleteIds);
			
			//3.设置json返回结果
			retJSON.setSuccess(true);
			retJSON.setMsg("删除成功！");
		}catch(AdminsException e){
			
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
		}finally{

			super.writeJSON(retJSON);
		}
	}
	/**
	 * 获取指定id的admin
	 * @author Jhon
	 * 
	 *//*
	public void getAdmin(){
		ReturnJSON retJSON = new ReturnJSON();
		try{
			Admins admin = adminsService.getAdmin(pageAdmin);
			retJSON.setSuccess(true);
			retJSON.setMsg("读取信息成功！");
			retJSON.setObj(admin);
		}catch(AdminsException e){
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
		}
	}*/
	/**
	 * 修改admin
	 */
	public void editAdmin(){
		/**
		 * 实现admin更新，无法跟新id，密码
		 */
		BackReturnJSON retJSON = new BackReturnJSON();
		try{
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			PageAdmins admin = adminsService.editAdmin(onlineAdmin,pageAdmin);
			retJSON.setSuccess(true);
			retJSON.setMsg("修改信息成功！");
			retJSON.setObj(admin);
		}catch(AdminsException e){
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
		}catch(Exception e){
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
		}finally{

			super.writeJSON(retJSON);
		}
	}
	public String adminLogoff(){
		/**
		 * 实现amin注销
		 * 
		 */
		
		BackReturnJSON retJSON = new BackReturnJSON();
		try{
			HttpSession session = BackTools.getSession();
			session.removeAttribute(BackStatic.ONLINE_ADMIN);
			session.invalidate();
			session = null;
			retJSON.setSuccess(true);
			retJSON.setMsg("注销成功！");
		}catch(Exception e){
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
		}
		return "adminLogoff_success";
	}
	/**
	 * 更新密码
	 */
	public void editAdminPwd(){
		BackReturnJSON retJSON = new BackReturnJSON();
		try{
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			adminsService.updateAdminPwd(onlineAdmin,pageAdmin);
			retJSON.setSuccess(true);
			retJSON.setMsg("修改密码成功！");
		}catch(Exception e){
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
		}
		super.writeJSON(retJSON);
	}
	/**
	 * 更新自己的theme
	 */
	public void updateTheme(){
		BackReturnJSON retJSON = new BackReturnJSON();
		try{
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			adminsService.updateTheme(onlineAdmin,pageAdmin);
			retJSON.setSuccess(true);
			retJSON.setMsg("修改主题成功！");
		}catch(Exception e){
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
		}finally{

			super.writeJSON(retJSON);
		}
	}
	/**
	 * 获取所有的admin在线用户的登陆记录
	 */
	public void getOnlineAdmins(){
		BackReturnJSON<PageAdminLoginRecord> retJSON = new BackReturnJSON<PageAdminLoginRecord>();
		try{
			List<PageAdminLoginRecord> onlineAdmins = BackTools.getArrayList();
			//获取当前在线的admins的所有session
			List<HttpSession> sessions = adminsSessionMap.getValues();
			//设置分页参数
			Integer page = pageAdmin.getPage();
			Integer rows = pageAdmin.getRows();
			Integer start = (page-1)*rows;
			//防止分页大于session集合最大索引
			Integer end = sessions.size();
			if(end > (start+10)){
				end = (start+10);
			}
			//获取session的登陆记录
			for (int i = start;i< end ;i++) {
				//获取session
				HttpSession httpSession = sessions.get(i);
				Adminloginrecord onlineAdmin = (Adminloginrecord) httpSession.getAttribute(BackStatic.adminLoginRecordSessionName);
				//如果存在登陆记录，传转化为爬page模型，返回
				if(onlineAdmin!=null){
					PageAdminLoginRecord pageOnlineAdmin = new PageAdminLoginRecord();
					BeanUtils.copyProperties(onlineAdmin, pageOnlineAdmin);
					//设置page模型的adminid
					pageOnlineAdmin.setAdminId(onlineAdmin.getAdmins().getId());
					onlineAdmins.add(pageOnlineAdmin);
				}
				
			}
			retJSON.setRows(onlineAdmins);
			retJSON.setSuccess(true);
			retJSON.setMsg("获取在线用户成功！");
		}catch(Exception e){
			e.printStackTrace();
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
			retJSON.setRows(null);
		}finally{
			super.writeJSON(retJSON);
		}		
		
	}
	/**
	 * 冻结本人账户
	 */
	public void frozenAdminself(){
		BackReturnJSON retJSON = new BackReturnJSON();
		try{
			Admins onlineAdmin = BackTools.getOnlineAdmin();
			adminsService.updateAdminStatus(onlineAdmin);
			//销毁session
			BackTools.getSession().invalidate();
			retJSON.setSuccess(true);
			//解除上线状态
			retJSON.setOnline(false);
			retJSON.setMsg("冻结成功！");
		}catch(Exception e){
			retJSON.setSuccess(false);
			retJSON.setMsg(e.getMessage());
		}finally{

			super.writeJSON(retJSON);
		}
	}
}
