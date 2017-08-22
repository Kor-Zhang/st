<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 工具栏 -->
<div class="easyui-layout" data-options="fit:true,border:false">
	<div class="" data-options="region:'north',title:'筛选',border:false,collapsed:true" style="height:100px;">
		<form id="admins_qxglrz_searchForm" style="display: inline-block;" method="post">
			<input type="text" id="admins_qxglrz_searchId" name="searchId" placeholder="检索有户名(可模糊查询)"/>	
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onClick="qxglrzSearchFun();">查询</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onClick="qxglrzClearFun();">清空</a>
		</form>
	</div>	
	<div class="" data-options="region:'center'">
		<table id="admins_qxglrz_qxglrzDataGrid">
	
	
		</table>
	</div>
</div>

<script type="text/javascript">
	var qxglrzDataGrid = undefined;
	var qxglrzCurrtAdminId = undefined;
	var qxglrzCheckAdminDialog = undefined;
	$(function($) {
		qxglrzDataGrid = $('#admins_qxglrz_qxglrzDataGrid').datagrid({
			
			url :'${pageContext.request.contextPath}'+NAMESPACE_BACK+'/adminUpdateRecordAction!getDatagrid.action',
			pagination:true,
			fit:true,
			idField:'updateTime',
			sortName:'updateTime',
			sortOrder:'desc',
			multiSort:false,
			/* remoteSort:true, */
			selectOnCheck:true,
			checkOnSelect:true,
			singleSelect:true,
			frozenColumns:[[
			{
				field : 'checkbox',
				checkbox:true
			},{
				field : 'doAdminId',
				title : '操作管理员',
				sortable:true,
				formatter: function(value,row,index){
					
					return "<a href=javascript:checkAdmin('"+value+"');>"+value+"</a>";
				}
			},{
				field : 'doneAdminId',
				title : '被操作管理员',
				sortable:true,
				formatter: function(value,row,index){
					
					return "<a href=javascript:checkAdmin('"+value+"');>"+value+"</a>";
				}
			}
	     	]],
			columns : [ [ {
				field : 'updateRecordId',
				hidden:true
			}, {
				field : 'item',
				title : '操作项目'
			} ,{
				field : 'updateTime',
				title : '操作时间',
				sortable:true
			} ] ],toolbar: [{
				text:'帮助',
				iconCls: 'icon-help',
				handler: function(){
					help();
				}
			}],
			onLoadSuccess:function(data){
				$.messager.show({
					title:'提示',
					msg:data.msg
					
				});
				//判断管理员是否在线
				try{
					isOnline(data);
				}catch(e){
					return;
				}
				
			}
	
	
		});
		/* //点击回车查询
		$('#admins_qxgl_searchId').keyup(function(e){
			if(e.keyCode==13){
				searchFun();
			}
		}); */
		
	});
	
	/**
	*查询
	**/
	function qxglrzSearchFun(){
		//获取查询的form参数
		var params = serializeObject($('#admins_qxglrz_searchForm'));
		qxglrzDataGrid.datagrid('load', params);
	}
	/**
	*清空
	**/
	function qxglrzClearFun(){
		$('#admins_qxglrz_searchId').val("");
		qxglrzDataGrid.datagrid('load', {});
		
	}
	
</script>