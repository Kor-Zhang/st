<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="admins_gggl_editdialog_editForm"  method="post" action="" enctype="multipart/form-data">
	<input name="id" type="hidden"/>
	<table>
		<tr>
			<th align="">标题：</th>
			
		</tr>
		<tr>
			<td align="">
				<input name="title"/>
			</td>
		</tr>
		<tr>
			<td>内容：</td>
			
		</tr>
		<tr>
			<td>
				<textarea name="text" style="resize:none;width:360px;height:160px;"></textarea>
			</td>
			
		</tr>
		<tr>
			<td>状态：</td>
			
		</tr>
		<tr>
			<td>
				<select name="status">
					<option value="0">不可查阅</option>
					<option value="1">可查阅</option>
				</select>
			</td>
			
		</tr>
	</table>
	<a class="easyui-linkbutton"
		style="margin-left:170px;margin-top: 20px;"
		href="javascript:void(0);"
		data-options="iconCls:'icon-add',
		onClick:function(){
			ggglAddForm = $('#admins_gggl_editdialog_editForm').form('submit',{
				url:'${pageContext.request.contextPath}'+NAMESPACE_BACK+'/noticesAction!editNotices.action',
				success:function(data){
					data = $.parseJSON(data);
					console.info(data);
					var msg = data.msg;
					var success = data.success;
					var obj = data.obj;
					<!-- 提示信息 -->
					showMsg(data);
					try{
						//判断是否在线
						isOnline(data);
					}catch(e){
						return;
					}
					if(success){
						ggglEditDialog.dialog('close');
						ggglDatagrid.datagrid('reload');
					}
				}
			 });
		}">提交</a>
</form>