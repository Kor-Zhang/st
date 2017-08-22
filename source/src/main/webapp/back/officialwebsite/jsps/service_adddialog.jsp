<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="admins_service_adddialog_addForm"  method="post" action="" enctype="multipart/form-data">
	<table>
		<tr><th>标题：</th></tr>
		<tr>
			<td>
				<input style="width:90%;" placeholder="请输入标题" class="easyui-validatebox" data-options="required:true" name="title"/>
			</td>
			
		</tr>
		<tr>
			<th>内容：</th>
		</tr>
		<tr>
			
			<td>
				<textarea name="introduction" style="width:1000px; height:200px;">请输入内容</textarea> 
				
			</td>
			
		</tr>
		
		<tr>
			<th>投资者：</th>
		</tr>
		<tr>
			
			<td>
				<input style="width:90%;" placeholder="请输入投资者" class="easyui-validatebox" data-options="required:true" name="investor"/> 
				
			</td>
			
		</tr>
		<tr>
			<th>开发者：</th>
		</tr>
		<tr>
			
			<td>
				<input style="width:90%;" placeholder="请输入开发者" class="easyui-validatebox" data-options="required:true" name="developers"/> 
				
			</td>
			
		</tr>
		<tr>
			<th>展示/不展示：</th>
		</tr>
		<tr>
			
			<td>
				<select name="status">
					<option value="1">展示</option>
					<option value="0">不展示</option>
				</select>
			</td>
		</tr>
	</table>
	<a class="easyui-linkbutton"
		style="margin-left:10px;margin-top: 20px;"
		href="javascript:void(0);"
		data-options="iconCls:'icon-add',
		onClick:function(){
			$('#admins_service_adddialog_addForm').form('submit',{
				url:'${pageContext.request.contextPath}'+NAMESPACE_OW_BACK+'/owServiceBackAction!uploadTextService.action',
				success:function(data){
					console.info(data);
					data = $.parseJSON(data);
					var msg = data.msg;
					var success = data.success;
					var obj = data.obj;
					<!-- 提示信息 -->
					showMsg(data);
					try{
						//判断是否在线
						isOnline(data);
					}catch(e){
						serviceAddDialog.dialog('close');
						return;
					}
					if(success){
						serviceAddDialog.dialog('close');
						serviceDatagrid.datagrid('reload');
					}
				}
			 });
		}">提交</a>
</form>








<script type="text/javascript" charset="utf-8">
	loadOptionData(serviceAddDialog,'02');
	
</script>