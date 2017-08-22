<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	
<table id="admins_checkadmindialog_datagrid">

</table>	
<script type="text/javascript">
	$(function($) {
		$('#admins_checkadmindialog_datagrid').datagrid({
			
			url :'${pageContext.request.contextPath}'+NAMESPACE_BACK+'/adminsAction!getSingleAdminDatagridById.action?id='+currtCheckAdminId,
			fit:true,
			idField:'id',
			sortName:'id',
			sortOrder:'desc',
			maximizable:true,
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
				width:80
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
				field : 'ckqx',
				title : '查看权限',
				sortable:true,
				formatter: function(value,row,index){
					var adminId = row.id;
					return "<a href=javascript:checkAdminPower('"+adminId+"');><font style='color:red;'>查看权限</font></a>";
				}
			}, {
				field : 'isSuperAdmin',
				title : '身份',
				sortable:true,
				formatter: function(value,row,index){
					if(value){
						return "超级管理员";
					}
					return "普通管理员";
				}
			}/* , {
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
			} */, {
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
			}] ],
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
		
		
	});
		
	
</script>


