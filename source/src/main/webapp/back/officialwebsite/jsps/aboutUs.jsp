<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div class="" data-options="region:'north',title:'筛选',border:false,collapsed:true" style="height:240px;">
		<form id="admins_ow_gwlbgl_form" style="display: inline-block;" method="post">
			<table width="100%">
				<tr>
					
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onClick="gwlbglSearchFun();">查询</a>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onClick="gwlbglClearFun();">清空</a>
					</td> 
					
					
				</tr>
				
				
			</table>
		</form>
	</div>	
	<div class="" data-options="region:'center'">
		<table id="admins_ow_gwlbgl_datagrid" data-options="fit:true,border:false">

		</table>	
	</div>
</div>


<%-- <script type="text/javascript" src="<c:url value='/jslib/zkutil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/jslib/back/static.js'/>"></script> --%>
<script type="text/javascript">
	var gwlbglDatagrid = undefined;
	
	//添加窗口
	var gwlbglAddDialog = undefined;
	
	//编辑窗口和表单
	var gwlbglEditForm = undefined;
	var gwlbglEditDialog = undefined;
	$(function($) {
		gwlbglDatagrid = $('#admins_ow_gwlbgl_datagrid').datagrid({
			
			url :'${pageContext.request.contextPath}'+NAMESPACE_OW_BACK+'/owAboutUsBackAction!getDatagrid.action',
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
				field : 'imgName',
				title : '头像',
				sortable:true,
				width:200,
				formatter: function(value,row,index){
					var carImg = "<span style='width:200px;' title='点击更新头像'><img style='width:200px;' src= ${pageContext.request.contextPath}"+NAMESPACE_OW_BACK+"/owAboutUsBackAction!getImgByImgName.action?imgName="+value+"&t="+new Date().getTime()+"'/></span>";
					return carImg;
				}
			},{
				field : 'introduction',
				title:'介绍',
			},{
				field : 'createTime',
				title:'创建时间',
			},{
				field : 'updateTime',
				title:'最后修改时间'
			},{
				field : 'status',
				title:'状态',
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
			}
			
            ] ],toolbar: [ {
				text:'添加',
				iconCls: 'icon-add',
				handler: function(){
					gwlbglAdd();
				}
			},'-', {
				text:'删除',
				iconCls: 'icon-remove',
				handler: function(){
					gwlbglRemove();
				}
			},'-',{
				text:'编辑',
				iconCls: 'icon-edit',
				handler: function(){
					gwlbglEdit();
				}
			},'-',{
				text:'帮助',
				iconCls: 'icon-help',
				handler: function(){
					gwlbglHelp();
				}
			}],
			onLoadSuccess:function(data){
				showMsg(data);
				//判断管理员是否在线
				try{
					isOnline(data);
				}catch(e){
					return;
				}
			}


		});
		/* //点击回车查询
		$('#admins_gwlbgl_searchId').keyup(function(e){
			if(e.keyCode==13){
				searchFun();
			}
		}); */
		
	});
	
	
	/**
	* 添加
	*/
	function gwlbglAdd(){
		//添加节点
		gwlbglAddDialog = $('<div/>').dialog({
			title:'增加',
			width:300,
			height:250,
			maximizable:true,
			modal:true,
			href:'${pageContext.request.contextPath}/back/officialwebsite/jsps/aboutUs_adddialog.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
				gwlbglAddDialog = undefined;
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
	function gwlbglEdit(){
		var checkedRow = gwlbglDatagrid.datagrid('getChecked');
		//是否选择一行
		if(checkedRow.length==1){
			//添加节点
			gwlbglEditDialog = $('<div/>').dialog({
				title:'编辑',
				width:400,
				height:230,
				modal:true,
				href:'${pageContext.request.contextPath}/back/officialwebsite/jsps/aboutUs_editdialog.jsp',
				onClose:function(){
					//删除以前的节点
					$(this).dialog('destroy');
					gwlbglEditDialog = undefined;
				},
				onOpen:function(){
					
					
				},
				onLoad:function(){

					gwlbglEditForm = $('#admins_gwlbgl_editdialog_editForm');
					//加载文本信息
					gwlbglEditForm.form('load',checkedRow[0])
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
	* 删除
	**/
	function gwlbglRemove(){
		//选择的需要删除的行
		var checkedRows = gwlbglDatagrid.datagrid('getChecked');
		
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
					zkAjax(NAMESPACE_OW_BACK+"/owAboutUsBackAction!deleteAboutUs.action?deleteIds="+ids.join(','),function(data){
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
							gwlbglDatagrid.datagrid('load');
							//取消选择的行
							gwlbglDatagrid.datagrid('unselectAll');
							gwlbglDatagrid.datagrid('uncheckAll');
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
	*查询
	**/
	function gwlbglSearchFun(){
		//获取查询的form参数
		var params = serializeObject($('#admins_gwlbgl_searchForm'));
		gwlbglDatagrid.datagrid('load', params);
	}
	/**
	*清空
	**/
	function gwlbglClearFun(){
		//清空input
		$('#admins_gwlbgl_searchForm input').val("");
		//select选择第一个option
		firstOption("admins_gwlbgl_searchForm");
		//重新加载
		gwlbglDatagrid.datagrid('load', {});
		
	}
</script>


