<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<form id="news_addImgs_form" method="post" action="" enctype="multipart/form-data">
	<input type="hidden" name="id"/>
	<table>
		<tr>
			<th>选择新图片：</th>
			<td><input name="uploadFile" class="easyui-filebox"/></td>
		</tr>
		
	</table>
	<a class="easyui-linkbutton"
		style="margin-right:20px;float:right;"
		href="javascript:void(0);"
		data-options="iconCls:'icon-add',
		onClick:function(){
			$('#news_addImgs_form').form('submit',{
				url:'${pageContext.request.contextPath}'+NAMESPACE_OW_BACK+'/owNewsUploadImgsBackAction!uploadNewsImgs.action',
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
						imgsAddDialog.dialog('close');
						return;
					}
					if(success){
						imgsAddDialog.dialog('close');
						newsImgsDatagrid.datagrid('load');
					}
				}
			 });
		}">提交</a>
</form>