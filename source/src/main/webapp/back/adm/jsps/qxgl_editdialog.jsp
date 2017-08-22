<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="admins_qxgl_editdialog_editForm" method="post">
	<table>
		<tr>
			<th>账户：</th>
			<td><input readonly="true" name="id"/></td>
			<th>状态：</th>
			<td>
				<select autocomplete="off" id="id_status" name="status">
					<option value="1" >激活</option>
					<option value="0" >冻结</option>
				</select>
			</td>
		</tr>
		<!-- <tr>
			<th>密码：</th>
			<td>
				<input class="easyui-textbox" data-options=" readonly:"1",required:"1",validType:'length[10,15]'" type="password" name="password" id="adminPwd"/>
				
				
			</td>
			<th>
				点击修改密码按钮
				<input id="admins_qxgl_editdialog_updatePwdBtn" class="easyui-linkbutton" data-options="width:30,
				onClick:function(){
					var pwdInput = $('#adminPwd'); 
					var updatePwdBtn = $('#admins_qxgl_editdialog_updatePwdBtn');
					var confirmPwdBtn = $('#admins_qxgl_editdialog_confirmUpdatePwdBtn');
					var cancelPwdBtn = $('#admins_qxgl_editdialog_cancelUpdatePwdBtn');
					confirmPwdBtn.show();	
					cancelPwdBtn.show();
					pwdInput.textbox('readonly',false);
					pwdInput.textbox('setText','');
					updatePwdBtn.val('取消修改');
					updatePwdBtn.hide();
					
				}" value="修改"/>
			</th>
			<td>
				
			</td>
			<th>再次输入密码：</th>
			<td>
				<input class="easyui-validatebox" data-options="required:"1",validType:'eqTwoInput[\'#adminPwd\']'" type="password" id="adminRePwd"/>
			</td>
		</tr>
		<tr>
			<th></th>
			<td>
				<input style="display:none;" value="确认" id="admins_qxgl_editdialog_confirmUpdatePwdBtn" class="easyui-linkbutton" data-options="width:30,
				onClick:function(){
					if(!$('#adminPwd').textbox('validate')){
						return ;
					}
					zkAjax('/adminsAction!updateAdminPwd.action?password='+$('#adminPwd').val(),function(data){
						var success = data.success;
						var msg = data.msg;
						if(success){
							editDialog.dialog('close');
						}else{
							
						}
					});
					
				}"/>
				<input style="display:none;" value="取消" id="admins_qxgl_editdialog_cancelUpdatePwdBtn" class="easyui-linkbutton" data-options="width:30,
				onClick:function(){
					var pwdInput = $('#adminPwd'); 
					var updatePwdBtn = $('#admins_qxgl_editdialog_updatePwdBtn');
					var confirmPwdBtn = $('#admins_qxgl_editdialog_confirmUpdatePwdBtn');
					var cancelPwdBtn = $('#admins_qxgl_editdialog_cancelUpdatePwdBtn');
					updatePwdBtn.val('修改密码');
					pwdInput.textbox('readonly',"1");
					pwdInput.textbox('setText','**********');
					
					updatePwdBtn.show();
					confirmPwdBtn.hide();	
					cancelPwdBtn.hide();
				}"/>
			</td>
		</tr> -->
		<tr>
			<th>身份：</th>
			<td>
				
				<!-- <select autocomplete="off"  name="isSuperAdmin">
					<option value="0" >普通管理员</option>
					<option value="1" >超级管理员</option>
				</select> -->
				<input value="普通管理员" readonly/>
				<input type="hidden" name="isSuperAdmin" value="false"/>
			</td>
			<th>主题：</th>
			<td>
				<select autocomplete="off"  name="theme">
					<option value="bootstrap" >bootstrap</option>
					<option value="default" >default</option>
					<option value="black" >black</option>
					<option value="gray" >gray</option>
					<option value="metro" >metro</option>
				</select>
			</td>
		</tr>
		
		<!-- <tr>
			<th style="color: red;font-size: 15px;">权限：</th>
			
		</tr>
		<tr>
			<th>增加用户：</th>
			<td>
				<select autocomplete="off"  name="canAdd">
					<option value="0" >否</option>
					<option value="1" >是</option>
				</select>
			</td>
			<th>删除用户：</th>
			<td>
				<select autocomplete="off"  name="canDelete">
					<option value="0" >否</option>
					<option value="1" >是</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>查看用户：</th>
			<td>
				<select autocomplete="off"  name="canQuery">
					<option value="0" >否</option>
					<option value="1" >是</option>
				</select>
			</td>
			<th>修改用户：</th>
			<td>
				<select autocomplete="off"  name="canUpdate">
					<option value="0" >否</option>
					<option value="1" >是</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>增加管理员：</th>
			<td>
				<select autocomplete="off"  name="canAddAdmin">
					<option value="0">否</option>
					<option value="1">是</option>
				</select>
			</td>
			<th>删除管理员：</th>
			<td>
				<select autocomplete="off"  name="canDeleteAdmin">
					<option value="0" >否</option>
					<option value="1" >是</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>查看管理员：</th>
			<td>
				<select autocomplete="off"  name="canQueryAdmin">
					<option value="0" >否</option>
					<option value="1" >是</option>
				</select>
			</td>
			<th>修改管理员：</th>
			<td>
				<select autocomplete="off" name="canUpdateAdmin">
					<option value="0" selected="selected">否</option>
					<option value="1" >是</option>
				</select>
			</td>
		</tr> -->
		<tr>
			<th>备注（介绍）：</th>
			<td>
				<input class="easyui-validatebox" data-options="validType:'length[0,255]'" type="text" name="introduction"/>
			</td>
			
		</tr>
	</table>
	<a class="easyui-linkbutton"
		style="float:right;margin-right: 20px;"
		href="javascript:void(0);"
		data-options="iconCls:'icon-add',
		onClick:function(){
			editForm.form('submit',{
				url:'${pageContext.request.contextPath}'+NAMESPACE_BACK+'/adminsAction!editAdmin.action',
				success:function(data){
					data = $.parseJSON(data);
					var msg = data.msg;
					var success = data.success;
					var obj = data.obj;
					<!-- 提示信息 -->
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
						<!--更新datagrid -->
						qxglDatagrid.datagrid('reload');
						<!-- 关闭编辑框 -->
						editDialog.dialog('close');
					}
					
				}
			 });
		}">提交</a>
</form>
<script type="text/javascript">
</script>