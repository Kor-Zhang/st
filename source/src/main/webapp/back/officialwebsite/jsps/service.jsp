<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div class="" data-options="region:'north',title:'筛选',border:false,collapsed:true" style="height:240px;">
		<form id="admins_ow_service_form" style="display: inline-block;" method="post">
			<table width="100%">
				<tr>
					
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onClick="serviceSearchFun();">查询</a>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onClick="serviceClearFun();">清空</a>
					</td> 
					
					
				</tr>
				
				
			</table>
		</form>
	</div>	
	<div class="" data-options="region:'center'">
		<table id="admins_ow_service_datagrid" data-options="fit:true,border:false">

		</table>	
	</div>
</div>


<script type="text/javascript">
	var serviceDatagrid = undefined;
	
	//添加窗口
	var serviceAddDialog = undefined;
	
	//编辑窗口和表单
	var serviceEditForm = undefined;
	var serviceEditDialog = undefined;
	
	//保存需要编辑的json信息
	var editData = new Object();
	//显示new图片的dialog
	var imgsDialog = undefined;
	//当前查看的service 的id
	var currtServiceId = undefined;
	$(function($) {
		serviceDatagrid = $('#admins_ow_service_datagrid').datagrid({
			
			url :'${pageContext.request.contextPath}'+NAMESPACE_OW_BACK+'/owServiceBackAction!getDatagrid.action',
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
			columns : [ [ {
				field : 'id',
				hidden:true
			},{
				field : 'checkbox',
				checkbox:true
				
			},{
				field : 'xstp',
				title : '图片',
				formatter: function(value,row,index){
					var id = row.id;
					var btn = "<a href=javascript:showImgsDialog('"+id+"');>查看图片</a>";
					return btn;
				}
			},{
				field : 'title',
				title : '标题',
				width:350,
				sortable:true,
				formatter: function(value,row,index){
					var tip = "<span title='"+value+"'>"+value+"</span>";
					return tip;
				}
			},{
				field : 'introduction',
				title:'内容',
				sortable:true,
				width:300,
				formatter: function(value,row,index){
					var tip = "<span title='"+value+"'>"+value+"</span>";
					return tip;
				} 
			},{
				field : 'clazz',
				title : '类型',
				sortable:true
			},{
				field : 'rateOfProgress',
				title : '阶段',
				sortable:true
			},{
				field : 'developers',
				title : '开发者',
				sortable:true
			},{
				field : 'investor',
				title : '投资者',
				sortable:true
			},{
				field : 'status',
				title:'状态',
				sortable:true,
				formatter: function(value,row,index){
					var btn = "未知状态";
					if(value==1){
						btn =  "<font style='color:green'>展示</font>";
					}
					if(value==0){

						btn =  "<font style='color:red'>不展示</font>";
					}
					return btn;
				}
			},{
				field : 'releaseTime',
				title:'发布时间',
				sortable:true
			},{
				field : 'createTime',
				title:'创建时间',
				sortable:true
			},{
				field : 'updateTime',
				title:'最后修改时间',
				sortable:true
			}
			
            ] ],toolbar: [ {
				text:'添加',
				iconCls: 'icon-add',
				handler: function(){
					serviceAdd();
				}
			},'-', {
				text:'删除',
				iconCls: 'icon-remove',
				handler: function(){
					serviceRemove();
				}
			},'-',{
				text:'编辑',
				iconCls: 'icon-edit',
				handler: function(){
					serviceEdit();
				}
			},'-',{
				text:'帮助',
				iconCls: 'icon-help',
				handler: function(){
					serviceHelp();
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
			},
			onLoadError:function(data){
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
		/* //点击回车查询
		$('#admins_service_searchId').keyup(function(e){
			if(e.keyCode==13){
				searchFun();
			}
		}); */
		
	});
	/**
	* 删除
	**/
	function serviceRemove(){
		//选择的需要删除的行
		var checkedRows = serviceDatagrid.datagrid('getChecked');
		
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
					zkAjax(NAMESPACE_OW_BACK+"/owServiceBackAction!deleteService.action?deleteIds="+ids.join(','),function(data){
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
							serviceDatagrid.datagrid('load');
							//取消选择的行
							serviceDatagrid.datagrid('unselectAll');
							serviceDatagrid.datagrid('uncheckAll');
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
	
	/**
	* 添加
	*/
	function serviceAdd(){
		//添加节点
		serviceAddDialog = $('<div/>').dialog({
			title:'增加',
			width:600,
			height:400,
			maximizable:true,
			maximized:true,
			modal:true,
			href:'${pageContext.request.contextPath}/back/officialwebsite/jsps/service_adddialog.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
				serviceAddDialog = undefined;
			},
			onOpen:function(){
			},
			onLoad:function(){
				
			}
		});
	}
	

	
	/**
	* 修改
	*/
	function serviceEdit(){
		var checkedRow = serviceDatagrid.datagrid('getChecked');
		//是否选择一行
		if(checkedRow.length==1){
			//添加节点
			serviceEditDialog = $('<div/>').dialog({
				title:'编辑',
				width:600,
				height:400,
				maximizable:true,
				maximized:true,
				modal:true,
				href:'${pageContext.request.contextPath}/back/officialwebsite/jsps/service_editdialog.jsp',
				onClose:function(){
					//删除以前的节点
					$(this).dialog('destroy');
					serviceEditDialog = undefined;
				},
				onOpen:function(){
					//暂存需要编辑的行数据
					editData = checkedRow[0];
					console.info(editData);
				},
				onLoad:function(){
					serviceEditForm = $('#admins_service_editdialog_editForm');
					//加载文本信息
					serviceEditForm.form('load',checkedRow[0]);
					
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
	*查询
	**/
	function serviceSearchFun(){
		//获取查询的form参数
		var params = serializeObject($('#admins_service_searchForm'));
		serviceDatagrid.datagrid('load', params);
	}
	/**
	*清空
	**/
	function serviceClearFun(){
		//清空input
		$('#admins_service_searchForm input').val("");
		//select选择第一个option
		firstOption("admins_service_searchForm");
		//重新加载
		serviceDatagrid.datagrid('load', {});
		
	}

	/**
	*显示new图片的窗口
	**/
	function showImgsDialog(id){
		currtServiceId = id;
		//添加节点
		imgsDialog = $('<div/>').dialog({
			title:'新闻图片列表',
			width:600,
			height:400,
			maximizable:true,
			/* maximized:true, */
			modal:true,
			href:'${pageContext.request.contextPath}/back/officialwebsite/jsps/service_imgs.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
				imgsDialog = undefined;
			},
			onOpen:function(){
			},
			onLoad:function(){
				
			}
		});
	}
</script>


