<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 登录页面 -->

<form id="admins_login_loginForm" method="post">
	<table>
		<tr>
			<th>用户名</th>
			<td>
				<input name="id" class="easyui-validatebox" data-options="required:true" autocomplete="off"/>
			</td>
		</tr>
		<tr>
			<th>密码</th>
			<td><input name="password" type="password" class="easyui-validatebox" data-options="required:true" autocomplete="off"/></td>
		</tr>
	</table>
</form>

<script type="text/javascript">

	
	$(function($){
		//初始化变量
		loginForm = $('#admins_login_loginForm');
		//清空输入框
		loginForm.find('input').val("");
	});
	//回车键触发登陆事件
	loginForm.find('input[type=password]').keyup(function(e){
		if(e.keyCode==13){
			submitLoginForm();
		}
	});
	/**
	*提交登陆表单
	*/
	function submitLoginForm(){
		$('#admins_login_loginForm').form('submit', {    
		    url:'${pageContext.request.contextPath}/back/adminsAction!adminLogin.action',    
		    success:function(data){    
		    	c(data);
		    	data = $.parseJSON(data);
		    	var success = data.success;
		    	var theme = data.theme;
		    	var id = data.id;
		    	if(success){
		    		loginDialog.dialog('close');
					//那么加载在线用户列表
					loadOnlineAdmins();
					//加载主题
		    		setThemes(theme);
					//设置登陆的用户显示信息
		    		setDisplayCurrtAdmin(data);
		    		//延时加载公告，字典tree
					setTimeout(function(){
						loadNotices();	
						loadSystemddlTree();
					}, 0);
		    	}
		    	showMsg(data);
		    	
		    }    
		});
	}
</script>