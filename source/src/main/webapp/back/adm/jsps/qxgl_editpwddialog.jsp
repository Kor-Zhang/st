<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="admins_qxgl_adddialog_editPwdForm" method="post">
	<table>
		<tr>
			<th>账户：</th>
			<td><input readonly="true" name="id"/></td>
			<th>输入新密码：</th>
			<td>
				<input class="easyui-validatebox" data-options="required:true,validType:'length[6,16]'" type="password" name="password" id="adminPwd"/>
			</td>
		</tr>
		
	</table>
	<a class="easyui-linkbutton"
		style="float:right;margin-right: 20px;"
		href="javascript:void(0);"
		data-options="iconCls:'icon-add',
		onClick:function(){
			editPwdForm = $('#admins_qxgl_adddialog_editPwdForm').form('submit',{
				url:'${pageContext.request.contextPath}'+NAMESPACE_BACK+'/adminsAction!editAdminPwd.action',
				success:function(data){
					data = $.parseJSON(data);
					var msg = data.msg;
					var success = data.success;
					var obj = data.obj;
					$.messager.show({
						title:'提示',
						msg:msg
					});
					try{
						//判断是否在线
						isOnline(data);
					}catch(e){
						return;
					}
					if(success){
						<!-- 关闭添加框 -->
						editPwdDialog.dialog('close');
						<!-- 提示信息 -->
						
					}
					
				}
			 });
		}">提交</a>
</form>