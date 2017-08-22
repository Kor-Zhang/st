<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="admins_gwlxwmgl_editstatusdialog_editForm"  method="post" action="" enctype="multipart/form-data">
	<input type="hidden" name="id"/>
	<table>
		<tr>
			<th>状态：</th>
			
			<td>
				<select name="status">
					<option value="1" Onclick="selectOpt('1');">受理</option>
					<option value="2" Onclick="selectOpt('2');">处理结束</option>
				</select>
			</td>
			
		</tr>
		<tr> 
			<th>受理管理员：</th>
			
			<td>
				<input name="dealAdminId" value="无" readonly/>
			</td>
		</tr>
		<tr class="adminNote" style="display: none;"> 
			<th>备注：</th>
			
			<td>
				<textarea name="adminNote"></textarea>
			</td>
		</tr>
		
	</table>
	<a class="easyui-linkbutton"
		style="margin-left:20px;margin-top: 20px;"
		href="javascript:void(0);"
		data-options="iconCls:'icon-edit',
		onClick:function(){
			gwlxwmglEditStatusForm.form('submit',{
				url:'${pageContext.request.contextPath}'+NAMESPACE_OW_BACK+'/owContactUsBackAction!UpdateContactUsStatus.action',
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
						return;
					}
					if(success){
						gwlxwmglEditStatusDialog.dialog('close');
						gwlxwmglDatagrid.datagrid('reload');
					}
				}
			 });
		}">提交</a>
</form>

<script type="text/javascript">
	//储存受理的adminid
	var oldAdminId = undefined;
	function selectOpt(n){
		$('.adminNote').hide();
		$('input[name=dealAdminId]').val(oldAdminId);
		if(n==2){
			$('.adminNote').show();
		}
		if(n==1){
			$('input[name=dealAdminId]').val("${sessionScope.admin.id}");
		}
		
	}
</script>