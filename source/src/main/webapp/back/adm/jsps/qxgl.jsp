<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div class="" data-options="region:'north',title:'筛选',border:false,collapsed:true" style="height:120px;">
		<form id="admins_qxgl_searchForm" style="display: inline-block;" method="post">
			<table width="100%">
				<tr>
					<th>
						账户：
					</th>
					<td>
						<input type="text" name="searchId" placeholder="检索账户(可模糊查询)"/>	
					</td>
				
					<th>
						备注：
					</th>
					<td>
						<input type="text" name="searchIntroduction" placeholder="检索备注(可模糊查询)"/>	
					</td>
					
				</tr>
				<tr>
				<th>
						状态：
					</th>
					<td>
						<select name="searchStatus">
							<option value="">全部</option>
							<option value="1">激活</option>
							<option value="0">冻结</option>
						</select>		
					</td>
					<th>
						主题：
					</th>
					<td>
						<select name="searchTheme">
							<option value="">全部</option>
							<option value="bootstrap">bootstrap</option>
							<option value="default">default</option>
						</select>		
					</td>
				</tr>
				<!-- 权限 
				<tr>
					<th>
						添加：
					</th>
					<td>
						<select name="searchCanAdd">
							<option value="">全部</option>
							<option value="1">是</option>
							<option value="0">否</option>
						</select>		
					</td>
				
					<th>
						删除：
					</th>
					<td>
						<select name="searchCanDelete">
							<option value="">全部</option>
							<option value="1">是</option>
							<option value="0">否</option>
						</select>		
					</td><th>
						查看：
					</th>
					<td>
						<select name="searchCanQuery">
							<option value="">全部</option>
							<option value="1">是</option>
							<option value="0">否</option>
						</select>		
					</td><th>
						更新：
					</th>
					<td>
						<select name="searchCanUpdate">
							<option value="">全部</option>
							<option value="1">是</option>
							<option value="0">否</option>
						</select>		
					</td>
					
				</tr>
				对管理员的权限
				<tr>
					<th>
						 添加管理员：
					</th>
					<td>
						<select name="searchCanAddAdmin">
							<option value="">全部</option>
							<option value="1">是</option>
							<option value="0">否</option>
						</select>		
					</td>
				
					<th>
						 删除管理员：
					</th>
					<td>
						<select name="searchCanDeleteAdmin">
							<option value="">全部</option>
							<option value="1">是</option>
							<option value="0">否</option>
						</select>		
					</td>
					<th>
						 查看管理员：
					</th>
					<td>
						<select name="searchCanQueryAdmin">
							<option value="">全部</option>
							<option value="1">是</option>
							<option value="0">否</option>
						</select>		
					</td><th>
						 更新管理员：
					</th>
					<td>
						<select name="searchCanUpdateAdmin">
							<option value="">全部</option>
							<option value="1">是</option>
							<option value="0">否</option>
						</select>		
					</td>
				</tr> -->
				<tr>
					
					<th>
						 创建时间：
					</th>
					<td>
						<input name="minCreateTime" style=";" class="easyui-datetimebox" data-options="editable:false"/>-
						
					</td>
					<td>
						<input name="maxCreateTime" style=";" class="easyui-datetimebox" data-options="editable:false"/>
						
					</td>
							
					
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onClick="searchFun();">查询</a>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onClick="clearFun();">清空</a>
					</td>
					
				</tr>
			</table>
		</form>
	</div>	
	<div data-options="region:'center'">
		<table id="admins_qxgl_datagrid">

		</table>	
	</div>
</div>

<!-- 增加弹出框 
<div id="admins_qxgl_addDialog" class="easyui-dialog" data-options="title:'添加',modal:true,closed:true" style="width:500px;height:360px;">
	
		
</div>
 -->

<script type="text/javascript">

	var qxglDatagrid = undefined;
	var addDialog = undefined;
	var editDialog = undefined;
	var addForm = undefined;
	var editForm = undefined;
	var editPwdForm = undefined;
	var editPwdDialog = undefined;
	//权限管理的dialog
	var managePowerDialog = undefined;
	//正在管理权限的dialog
	var managePowerAdminId = undefined;
	$(function($) {
		qxglDatagrid = $('#admins_qxgl_datagrid').datagrid({
			
			url :'${pageContext.request.contextPath}'+NAMESPACE_BACK+'/adminsAction!getDatagrid.action',
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
			frozenColumns:[[
			{
				field : 'checkbox',
				checkbox:true
			},{
				field : 'id',
				title : '账户',
				sortable:true,
			} 
         	]],
			columns : [ [  {
				field : '密码',
				title : 'password',
				sortable:true,
				hidden:true
			}, {
				field : 'status',
				sortable:true,
				title : '状态',
				formatter: function(value,row,index){
					if(value){
						return "<font style='color:green;'>激活</font>";
					}
					return "<font style='color:red;'>冻结</font>";
				}
			} , {
				field : 'isSuperAdmin',
				title : '身份',
				sortable:true,
				formatter: function(value,row,index){
					if(value){
						return "超级管理员";
					}
					return "普通管理员";
				}
			}, {
				field : 'qxgl',
				title : '权限管理',
				sortable:true,
				formatter: function(value,row,index){
					var adminId = row.id;
					return "<a href=javascript:managePower('"+adminId+"');><font style='color:red;'>编辑权限</font></a>";
				}
			}, /* {
				field : 'canAdd',
				title : '添加用户',
				sortable:true,
				formatter: function(value,row,index){
					if(value){
						return "<font style='color:green;'>是</font>";
					}
					return "<font style='color:red;'>否</font>";
				}
			} , {
				field : 'canDelete',
				title : '删除用户',
				sortable:true,
				formatter: function(value,row,index){
					if(value){
						return "<font style='color:green;'>是</font>";
					}
					return "<font style='color:red;'>否</font>";
				}
			}, {
				field : 'canQuery',
				title : '查询用户',
				sortable:true,
				formatter: function(value,row,index){
					if(value){
						return "<font style='color:green;'>是</font>";
					}
					return "<font style='color:red;'>否</font>";
				}
			} , {
				field : 'canUpdate',
				title : '修改用户',
				sortable:true,
				formatter: function(value,row,index){
					if(value){
						return "<font style='color:green;'>是</font>";
					}
					return "<font style='color:red;'>否</font>";
				}
			}, {
				field : 'canAddAdmin',
				title : '添加管理员',
				sortable:true,
				formatter: function(value,row,index){
					if(value){
						return "<font style='color:green;'>是</font>";
					}
					return "<font style='color:red;'>否</font>";
				}
			} , {
				field : 'canDeleteAdmin',
				title : '删除管理员',
				sortable:true,
				formatter: function(value,row,index){
					if(value){
						return "<font style='color:green;'>是</font>";
					}
					return "<font style='color:red;'>否</font>";
				}
			}, {
				field : 'canQueryAdmin',
				title : '查看管理员',
				sortable:true,
				formatter: function(value,row,index){
					if(value){
						return "<font style='color:green;'>是</font>";
					}
					return "<font style='color:red;'>否</font>";
				}
			} , {
				field : 'canUpdateAdmin',
				title : '修改管理员',
				sortable:true,
				formatter: function(value,row,index){
					if(value){
						return "<font style='color:green;'>是</font>";
					}
					return "<font style='color:red;'>否</font>";
				}
			},  */{
				field : 'theme',
				title : '主题',
				sortable:true,
			}, {
				field : 'introduction',
				title : '备注',
				sortable:true,
			}, {
				field : 'createTime',
				title : '创建时间',
				sortable:true,
			}] ],toolbar: [{
				text:'添加',
				iconCls: 'icon-add',
				handler: function(){
					add();
				}
			},'-',{
				text:'删除',
				iconCls: 'icon-remove',
				handler: function(){
					remove();
				}
			},'-',{
				text:'编辑',
				iconCls: 'icon-edit',
				handler: function(){
					edit();
				}
			},'-',{
				text:'修改密码',
				iconCls: 'icon-edit',
				handler: function(){
					editPwd();
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
	function searchFun(){
		//获取查询的form参数
		var params = serializeObject($('#admins_qxgl_searchForm'));
		qxglDatagrid.datagrid('load', params);
	}
	/**
	*清空
	**/
	function clearFun(){
		//清空input
		$('#admins_qxgl_searchForm input').val("");
		//select选择第一个option
		firstOption("admins_qxgl_searchForm");
		//重新加载
		qxglDatagrid.datagrid('load', {});
		
	}
	
	/**
	*点击增加按钮，弹出dialog
	**/
	function add(){
		//添加节点
		addDialog = $('<div/>').dialog({
			title:'增加',
			width:500,
			height:250,
			modal:true,
			href:'${pageContext.request.contextPath}/back/adm/jsps/qxgl_adddialog.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
				addDialog = undefined;
			},
			onOpen:function(){
			},
			onLoad:function(){
				//初始化dialog及其内部标签
				addForm = $('#admins_qxgl_editdialog_addForm');
				/* addDialog = $('#admins_qxgl_editdialog_addDialog'); */
			}
		});
	}
	/**
	*点击删除数据
	**/
	function remove(){
		//选择的需要删除的行
		var checkedRows = qxglDatagrid.datagrid('getChecked');
		
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
					zkAjax(NAMESPACE_BACK+"/adminsAction!deleteAdmins.action?deleteIds="+ids.join(','),function(data){
						var msg = data.msg;
						var success = data.success;
						//提示结果
						$.messager.show({
							title:'提示',
							msg:msg
						});
						try{
							//判断是否在线
							isOnline(data);
						}catch(e){
							return;
						}
						if(success){
							//重新加载
							qxglDatagrid.datagrid('load');
							//取消选择的行
							qxglDatagrid.datagrid('unselectAll');
							qxglDatagrid.datagrid('uncheckAll');
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
	*编辑
	**/
	function edit(){
		
		var checkedRow = qxglDatagrid.datagrid('getChecked');
		//是否选择一行
		if(checkedRow.length==1){
			
			//添加节点
			editDialog = $('<div/>').dialog({
				title:'编辑',
				width:500,
				height:180,
				modal:true,
				href:'${pageContext.request.contextPath}/back/adm/jsps/qxgl_editdialog.jsp',
				onClose:function(){
					//删除以前的节点
					$(this).dialog('destroy');
					editDialog = undefined;
				},
				onOpen:function(){
					
					
				},
				onLoad:function(){
					//初始化dialog及其内部标签
					editForm = $('#admins_qxgl_editdialog_editForm');/* 
					editDialog = $('#admins_qxgl_editdialog_editDialog'); */
					//加载文本信息
					editForm.form('load',checkedRow[0]);
					/* //设置密码显示
					editForm.find("#adminPwd").textbox('setText','**********');
					//加载select
					loadSelect(editForm,checkedRow[0]); */
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
	*修改密码
	**/
	function editPwd(){
		var checkedRow = qxglDatagrid.datagrid('getChecked');
		//是否选择一行
		if(checkedRow.length==1){
			//添加节点
			editPwdDialog = $('<div/>').dialog({
				title:'编辑密码',
				width:500,
				height:100,
				modal:true,
				href:'${pageContext.request.contextPath}/back/adm/jsps/qxgl_editpwddialog.jsp',
				onClose:function(){
					//删除以前的节点
					$(this).dialog('destroy');
					editPwdDialog = undefined;
				},
				onOpen:function(){
					
					
				},
				onLoad:function(){
					//初始化dialog及其内部标签
					editPwdForm = $('#admins_qxgl_adddialog_editPwdForm');/* 
					editDialog = $('#admins_qxgl_editdialog_editDialog'); */
					//加载文本信息
					editPwdForm.form('load',checkedRow[0]);
					//设置密码显示
					editPwdForm.find("#adminPwd").val('');
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
	* 权限管理
	*/
	function managePower(adminId){
		managePowerAdminId = adminId;
		//添加节点
		managePowerDialog = $('<div/>').dialog({
			title:'编辑权限',
			width:600,
			height:400,
			maximizable:true,
			modal:true,
			href:'${pageContext.request.contextPath}/back/adm/jsps/qxgl_managepowerdialog.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
				managePowerDialog = undefined;
			},
			onOpen:function(){
				
				
			},
			onLoad:function(){
				
			}
		});
	}
</script>


