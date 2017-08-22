<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div class="" data-options="region:'north',title:'筛选',border:false,collapsed:true" style="height:100px;">
		<form id="admins_gggl_searchForm" style="display: inline-block;" method="post">
			<input type="text" id="admins_gggl_searchId" name="searchId" placeholder="检索有户名(可模糊查询)"/>	
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onClick="searchFun();">查询</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onClick="clearFun();">清空</a>
		</form>
	</div>	
	<div class="" data-options="region:'center'">
		<table id="admins_gggl_datagrid" data-options="fit:true,border:false">

		</table>	
	</div>
</div>


<script type="text/javascript">
	var ggglDatagrid = undefined;
	//添加窗口
	var ggglAddDialog = undefined;
	//添加form
	var ggglAddForm = undefined;
	//编辑窗口
	var ggglEditDialog = undefined;
	//编辑form
	var ggglEditForm = undefined;
	$(function($) {
		ggglDatagrid = $('#admins_gggl_datagrid').datagrid({
			
			url :'${pageContext.request.contextPath}'+NAMESPACE_BACK+'/noticesAction!getNoticesDatagrid.action',
			pagination:true,
			fit:true,
			idField:'id',
			sortName:'createTime',
			sortOrder:'desc',
			multiSort:false,
			/* remoteSort:true, */
			selectOnCheck:true,
			checkOnSelect:true,
			singleSelect:true,
			fitColumns:true,
			/* {"creatTime":"2016-07-07 14:28:59","deleteIds":"","id":"12313","isDelete":false,"order":"desc","page":0,"rows":0,"searchId":"","sort":"id","status":1 */
			frozenColumns:[[
			{
				field : 'checkbox',
				checkbox:true
			}, {
				field : 'id',
				hidden:true
			},{
				field : 'title',
				title : '标题',
				width:200,
				formatter: function(value,row,index){
					
					return "<span title='"+value+"'>"+value+"</span>";
				},
				sortable:true
			},{
				field : 'text',
				title : '内容',
				width:280,
				formatter: function(value,row,index){
					
					return "<span title='"+value+"'>"+value+"</span>";
				},
				sortable:true
			},{
				field : 'updateTime',
				title : '更新时间',
				sortable:true
			},{
				field : 'adminId',
				title : '创建管理员',
				formatter: function(value,row,index){
					
					return "<a href=javascript:checkAdmin('"+value+"');>"+value+"</a>";
				},
				sortable:true
			},{
				field : 'createTime',
				title : '创建时间',
				sortable:true
			},{
				field : 'status',
				title : '状态',
				sortable:true,
				formatter: function(value,row,index){
					if(value==1){
						return "<font style='color:green;'>可查阅</font>";
					}
					return "<font style='color:red;'>不可查阅</font>";
				}
			}] ],toolbar: [
			{
				text:'添加',
				iconCls: 'icon-edit',
				handler: function(){
					ggglAdd();
				}
			},'-',{
				text:'编辑',
				iconCls: 'icon-edit',
				handler: function(){
					ggglEdit();
				}
			},'-', {
				text:'删除',
				iconCls: 'icon-remove',
				handler: function(){
					ggglRemove();
				}
			},'-',{
				text:'帮助',
				iconCls: 'icon-help',
				handler: function(){
					help();
				}
			}],
			onLoadSuccess:function(data){
				showMsg(data);
				console.info(data);
				//判断管理员是否在线
				try{
					isOnline(data);
				}catch(e){
					return;
				}
				
			}


		});
		
		
	});
	/**
	*查询
	**/
	function searchFun(){
		//获取查询的form参数
		var params = serializeObject($('#admins_gggl_searchForm'));
		ggglDatagrid.datagrid('load', params);
	}
	/**
	*清空
	**/
	function clearFun(){
		$('#admins_gggl_searchId').val("");
		ggglDatagrid.datagrid('load', {});
		
	};
	/**
	*添加一条记录
	*/
	function ggglAdd(){
		//添加节点
		ggglAddDialog = $('<div/>').dialog({
			title:'添加',
			width:400,
			height:400,
			maximizable:true,
			modal:true,
			href:'${pageContext.request.contextPath}/back/sys/jsps/gggl_adddialog.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
				ggglAddDialog = undefined;
			},
			onOpen:function(){
				
				
			},
			onLoad:function(){
				
				
			}
		});
	}
	/**
	*修改记录
	*/
	function ggglEdit(){

		var checkedRow = ggglDatagrid.datagrid('getChecked');
		//是否选择一行
		if(checkedRow.length==1){
			
			//添加节点
			ggglEditDialog = $('<div/>').dialog({
				title:'编辑',
				width:400,
				height:400,
				modal:true,
				href:'${pageContext.request.contextPath}/back/sys/jsps/gggl_editdialog.jsp',
				onClose:function(){
					//删除以前的节点
					$(this).dialog('destroy');
					ggglEditDialog = undefined;
				},
				onOpen:function(){
					
					
				},
				onLoad:function(){
					//初始化dialog及其内部标签
					ggglEditForm = $('#admins_gggl_editdialog_editForm');
					ggglEditForm.form('load',checkedRow[0]);
					
				}
			});
			
			
		}else{
			//提示是否选择一行
			$.messager.show({
				title:'提示',
				msg:'只能同时操作一行'
			});
		}
		
	}
	/**
	*删除
	*/
	function ggglRemove(){
		//选择的需要删除的行
		var checkedRows = ggglDatagrid.datagrid('getChecked');
		
		//判断是否选择行 
		if(checkedRows.length<1){
			$.messager.show({
				title:'提示',
				msg:'请勾选需要删除的记录！'
			});
		}else{
			//询问是否确认删除
			$.messager.confirm('提示','确认删除这'+checkedRows.length+'行？',function(r){
				if(r){
					var ids = [];
					for(var i = 0;i<checkedRows.length;i++){
						ids.push(checkedRows[i].id);
					}
					//链接服务器删除
					zkAjax(NAMESPACE_BACK+"/noticesAction!deleteNotices.action?deleteIds="+ids.join(','),function(data){
						
						var success = data.success;
						//提示结果
						showMsg(data);
						try{
							//判断是否在线
							isOnline(data);
						}catch(e){
							return;
						}
						if(success){
							//重新加载
							ggglDatagrid.datagrid('load');
							//取消选择的行
							ggglDatagrid.datagrid('unselectAll');
							ggglDatagrid.datagrid('uncheckAll');
						}else{
							
						}
						
					});
				}else{
					//提示取消删除
					$.messager.show({
						title:'提示',
						msg:'取消删除！'
					});
				}
			});
		}
	}
</script>


