<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="easyui-layout" data-options="fit:true">
	<div class="" data-options="region:'north'" style="height:50%">
		<div id="cc" class="easyui-calendar" data-options="fit:true"></div>
	</div>
	<div class="" data-options="fit:true,region:'center'">
		<div id="cc" class="easyui-panel" data-options="fit:true,title:'在线用户'">
			<table id="admins_index_east_onlineAdminsDatagrid"></table>
		</div>
	</div>
</div>

<script type="text/javascript">
	var onlineAdminsDatagrid = undefined;
	
	//记录当前查看的admmin的id
	var indexEastCurrtAdminId = undefined;
	var indexEastCheckAdminDialog = undefined;

	//设置持续查询在线管理员的定时器
	var getOnlineAdminsTimer = undefined;
	//持续查询在线管理员的的时间间隔，<=0代表只查询一次吗，不启用储蓄查询公告的模式
	var getOnlineAdminsDuring = -1;
	$(function($){
		
	});
	
	
	/**
	* 加载在线管理员
	*/
	function loadOnlineAdmins(){
		
		if(getOnlineAdminsTimer){
			clearInterval(getOnlineAdminsTimer);
			getOnlineAdminsTimer = undefined;
		}
		//是否启动持续查询模式
		if(getOnlineAdminsDuring>0){
			getOnlineAdmins();
			getOnlineAdminsTimer = setInterval(function(){
				getOnlineAdmins();
			}, getOnlineAdminsDuring);
		}else{
			getOnlineAdmins();
		}
		
		
		
	}
	function getOnlineAdmins(){
		//不是第一次查询在线的admin，那么只需刷新列表
		if(onlineAdminsDatagrid){
			onlineAdminsDatagrid.datagrid('reload');
			return;
		}
		onlineAdminsDatagrid = $('#admins_index_east_onlineAdminsDatagrid').datagrid({
			url:'${pageContext.request.contextPath}'+NAMESPACE_BACK+'/adminsAction!getOnlineAdmins.action?page=1&rows=1',
			/* pagination:true, */
			fit:true,
			idField:'loginTime',
			sortName:'loginTime',
			sortOrder:'desc',
			multiSort:false,
			/* remoteSort:true, */
			selectOnCheck:true,
			checkOnSelect:true,
			singleSelect:true,
			columns:[[{
				field : 'loginRecordId',
				hidden:true
			},{
				field : 'adminId',
				title : '管理员账户',
				formatter: function(value,row,index){
					
					return "<a href=javascript:checkAdmin('"+value+"');>"+value+"</a>";
				}
				
			},{
				field : 'loginAddress',
				title : '地址'
			}/* ,{
				field : 'loginIp',
				title : 'ip'
			},{
				field : 'loginTime',
				title : '登录时间'
			} */
			]],toolbar: [/* {
				text:'查看更多',
				iconCls: 'icon-add',
				handler: function(){
					checkMoreOnlineAdmins();
				}
			},'-', */
			{
				text:'刷新',
				iconCls: 'icon-add',
				handler: function(){
					onlineAdminsDatagrid.datagrid('load');
				}
			}]
		});
		return true;
	}
	
</script>