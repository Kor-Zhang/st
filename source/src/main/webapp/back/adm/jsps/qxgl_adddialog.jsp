<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="admins_qxgl_adddialog_addForm" method="post">
	<table>
		<tr>
			<th>账户：</th>
			<td><input class="easyui-validatebox" data-options="required:true,validType:'length[6,16]'" name="id"/></td>
			<th>状态：</th>
			<td>
				<select name="status">
					<option value="0" selected="true">冻结</option>
					<option value="1" >激活</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>密码：</th>
			<td>
				<input class="easyui-validatebox" data-options="required:true,validType:'length[6,16]'" type="password" name="password" id="adminPwd"/>
			</td>
			<th>再次输入密码：</th>
			<td>
				<input class="easyui-validatebox" data-options="required:true,validType:'eqTwoInput[\'#admins_qxgl_adddialog_addForm #adminPwd\']'" type="password" id="adminRePwd"/>
			</td>
		</tr>
		<tr>
			<th>身份：</th>
			<td>
				
				<!-- <select name="isSuperAdmin">
					<option value=false selected="true">普通管理员</option>
					<option value=true >超级管理员</option>
				</select> -->
				<input value="普通管理员" readonly="true"/>
				<input type="hidden" name="isSuperAdmin" value="false"/>
			</td>
			<th>主题：</th>
			<td>
				<select name="theme">
					<option value="bootstrap" selected="true">bootstrap</option>
					<option value="bootstrap" >default</option>
					<option value="bootstrap" >black</option>
					<option value="bootstrap" >gray</option>
					<option value="bootstrap" >metro</option>
				</select>
			</td>
		</tr>
		
		<!-- <tr>
			<th style="color: red;font-size: 15px;">权限：</th>
			
		</tr>
		<tr>
			<th>增加用户：</th>
			<td>
				<select name="canAdd">
					<option value=false selected="true">否</option>
					<option value=true >是</option>
				</select>
			</td>
			<th>删除用户：</th>
			<td>
				<select name="canDelete">
					<option value=false selected="true">否</option>
					<option value=true >是</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>查看用户：</th>
			<td>
				<select name="canQuery">
					<option value=false selected="true">否</option>
					<option value=true >是</option>
				</select>
			</td>
			<th>修改用户：</th>
			<td>
				<select name="canUpdate">
					<option value=false selected="true">否</option>
					<option value=true >是</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>增加管理员：</th>
			<td>
				<select name="canAddAdmin">
					<option value=false selected="true">否</option>
					<option value=true >是</option>
				</select>
			</td>
			<th>删除管理员：</th>
			<td>
				<select name="canDeleteAdmin">
					<option value=false selected="true">否</option>
					<option value=true >是</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>查看管理员：</th>
			<td>
				<select name="canQueryAdmin">
					<option value=false selected="true">否</option>
					<option value=true >是</option>
				</select>
			</td>
			<th>修改管理员：</th>
			<td>
				<select name="canUpdateAdmin">
					<option value=false selected="true">否</option>
					<option value=true >是</option>
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
		style="margin-left:190px;margin-top: 20px;"
		href="javascript:void(0);"
		data-options="iconCls:'icon-add',
		onClick:function(){
			addForm = $('#admins_qxgl_adddialog_addForm').form('submit',{
				url:'${pageContext.request.contextPath}'+NAMESPACE_BACK+'/adminsAction!addAdmin.action',
				success:function(data){
					data = $.parseJSON(data);
					console.info(data);
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
						<!-- 清空表单记录 -->
						addForm.find('input').val('');
						<!-- 添加一行 -->
						qxglDatagrid.datagrid('insertRow',{
							index: 0,	// 索引从0开始
							row: obj
						});

						<!-- 关闭添加框 -->
						addDialog.dialog('close');
						
					}
				}
			 });
		}">提交</a>
</form>