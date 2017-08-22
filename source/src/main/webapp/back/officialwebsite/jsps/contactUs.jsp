<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div class="" data-options="region:'north',title:'筛选',border:false,collapsed:true" style="height:240px;">
		<form id="admins_ow_gwlxwmgl_form" style="display: inline-block;" method="post">
			<table width="100%">
				<tr>
					
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onClick="gwlxwmglSearchFun();">查询</a>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onClick="gwlxwmglClearFun();">清空</a>
					</td> 
					
					
				</tr>
				
				
			</table>
		</form>
	</div>	
	<div class="" data-options="region:'center'">
		<table id="admins_ow_gwlxwmgl_datagrid" data-options="fit:true,border:false">

		</table>	
	</div>
</div>


<script type="text/javascript">
	var gwlxwmglDatagrid = undefined;
	
	//添加窗口
	var gwlxwmglAddDialog = undefined;
	
	//编辑窗口和表单
	var gwlxwmglEditStatusForm = undefined;
	var gwlxwmglEditStatusDialog = undefined;
	$(function($) {
		gwlxwmglDatagrid = $('#admins_ow_gwlxwmgl_datagrid').datagrid({
			
			url :'${pageContext.request.contextPath}'+NAMESPACE_OW_BACK+'/owContactUsBackAction!getDatagrid.action',
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
				title:'id',
				hidden:true
			},{
				title:'c',
				field : 'checkbox',
				checkbox:true
			}, {
				field : 'status',
				title:'状态',
				formatter: function(value,row,index){
					var btn = "未知状态";
					if(value==0){

						btn =  "<a style='color:red' href=javascript:gwlxwmglEditStatus('"+index+"');>未处理</a>";
					}
					
					if(value==1){
						btn =  "<a style='color:green' href=javascript:gwlxwmglEditStatus('"+index+"');>已受理</a>";
					}
					
					if(value==2){
						btn =  "<font style='color:black'>已处理</font>";
					}
					return btn;
				}
			},{
				field : 'dealAdminId',
				title : '受理的管理员',
				sortable:true,
				formatter: function(value,row,index){
					if(!value||value == ""){
						return "无";
					}
					return "<a href=javascript:checkAdmin('"+value+"');>"+value+"</a>";
				},
				sortable:true
			},{
				field : 'email',
				title : '意见者邮箱',
				sortable:true,
				/* width:200,
				formatter: function(value,row,index){
					var carImg = "<span style='width:200px;' title='点击更新头像'><img style='width:200px;' src= ${pageContext.request.contextPath}"+NAMESPACE_OW_BACK+"/owIndexCarouselBackAction!getImgByImgName.action?imgName="+value+"&t="+new Date().getTime()+"'/></span>";
					return carImg;
				} */
			},{
				field : 'name',
				title:'名字',
				sortable:true,
				width:150
			},{
				field : 'orgName',
				title:'组织',
				width:200,
				sortable:true,
				formatter: function(value,row,index){
					var info = "<span  title='"+value+"'>"+value+"</span>";
					return info;
				}
			},{
				field : 'phoneNumber',
				title:'电话',
				sortable:true
			},{
				field : 'msg',
				title:'留言信息',
				sortable:true,
				width:250,
				formatter: function(value,row,index){
					var info = "<span  title='"+value+"'>"+value+"</span>";
					return info;
				}
			},{
				field : 'adminNote',
				title : '管理员备注',
				sortable:true,
				width:100,
				formatter: function(value,row,index){
					if(!value||value == ""){
						return "无";
					}
					return "<span  title='"+value+"'>"+value+"</span>";
				},
			},{
				field : 'createTime',
				title:'创建时间',
				sortable:true
			}/* ,{
				field : 'updateTime',
				title:'最后修改时间',
				sortable:true
			} */
			
            ] ],toolbar: [ /* {
				text:'添加',
				iconCls: 'icon-add',
				handler: function(){
					gwlxwmglAdd();
				}
			},'-', {
				text:'删除',
				iconCls: 'icon-remove',
				handler: function(){
					gwlxwmglRemove();
				}
			},'-',{
				text:'编辑',
				iconCls: 'icon-edit',
				handler: function(){
					gwlxwmglEdit();
				}
			},'-', */{
				text:'帮助',
				iconCls: 'icon-help',
				handler: function(){
					gwlxwmglHelp();
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
		/* //点击回车查询
		$('#admins_gwlxwmgl_searchId').keyup(function(e){
			if(e.keyCode==13){
				searchFun();
			}
		}); */
		
	});
	
	
	/**
	* 添加
	*/
	function gwlxwmglAdd(){
		//添加节点
		gwlxwmglAddDialog = $('<div/>').dialog({
			title:'增加',
			width:300,
			height:250,
			maximizable:true,
			modal:true,
			href:'${pageContext.request.contextPath}/admins/officialwebsite/gwlxwmgl_adddialog.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
				gwlxwmglAddDialog = undefined;
			},
			onOpen:function(){
			},
			onLoad:function(){
				
			}
		});
	}
	

	
	/**
	* 修改状态
	* index：行号
	*/
	function gwlxwmglEditStatus(index){
		
		//添加节点
		gwlxwmglEditStatusDialog = $('<div/>').dialog({
			title:'编辑状态',
			width:400,
			height:230,
			modal:true,
			href:'${pageContext.request.contextPath}/back/officialwebsite/jsps/contactUs_editstatusdialog.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
				gwlxwmglEditStatusDialog = undefined;
			},
			onOpen:function(){
				
				
			},
			onLoad:function(){
				var row = gwlxwmglDatagrid.datagrid('getRows')[index];
				gwlxwmglEditStatusForm = $('#admins_gwlxwmgl_editstatusdialog_editForm');
				//加载文本信息
				gwlxwmglEditStatusForm.form('load',row);
				oldAdminId = row.dealAdminId;
			}
		});
		
		
	}

	/**
	* 删除
	**/
	function gwlxwmglRemove(){
		//选择的需要删除的行
		var checkedRows = gwlxwmglDatagrid.datagrid('getChecked');
		
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
					zkAjax(NAMESPACE_OW_BACK+"/owContactUsBackAction!deleteContactUs.action?deleteIds="+ids.join(','),function(data){
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
							gwlxwmglDatagrid.datagrid('load');
							//取消选择的行
							gwlxwmglDatagrid.datagrid('unselectAll');
							gwlxwmglDatagrid.datagrid('uncheckAll');
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
	function gwlxwmglSearchFun(){
		//获取查询的form参数
		var params = serializeObject($('#admins_gwlxwmgl_searchForm'));
		gwlxwmglDatagrid.datagrid('load', params);
	}
	/**
	*清空
	**/
	function gwlxwmglClearFun(){
		//清空input
		$('#admins_gwlxwmgl_searchForm input').val("");
		//select选择第一个option
		firstOption("admins_gwlxwmgl_searchForm");
		//重新加载
		gwlxwmglDatagrid.datagrid('load', {});
		
	}
</script>


