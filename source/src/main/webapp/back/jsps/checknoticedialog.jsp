<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	
<form id="admins_checknotice_checkNoticeForm">
	<table>
		<tr>
			<th align="">标题：</th>
			
		</tr>
		<tr>
			<td align="">
				<input readonly name="title"/>
			</td>
		</tr>
		<tr>
			<td>内容：</td>
			
		</tr>
		<tr>
			<td>
				<textarea readonly name="text" style="resize:none;width:360px;height:160px;"></textarea>
			</td>
			
		</tr>
		<tr>
			<td>状态：</td>
			
		</tr>
		<tr>
			<td>
				<select onfocus="this.blur();" name="status">
					<option value="0">不可查阅</option>
					<option value="1">可查阅</option>
				</select>
			</td>
			
		</tr>
		<tr>
			<td>发布的管理员：</td>
			
		</tr>
		<tr>
			<td>
				<input readonly name="adminId"/>
			</td>
			
		</tr>
	</table>
</form>
<%-- <script type="text/javascript" src="<c:url value='/jslib/zkutil.js'/>"></script> --%>
<script type="text/javascript">
	var checkNoticeForm = undefined;
	//更具noticeid加载notice，并且显示
	$(function($){
		checkNoticeForm = $('#admins_checknotice_checkNoticeForm');
		zkAjax(NAMESPACE_BACK+"/noticesAction!getSingleNoticeDatagridById.action?id="+currtCheckNoticeId,function(data){
			showMsg(data);
			try{
				isOnline(data);
			}catch(e){
				//关闭弹出框
				checkNoticeDialog.dialog('close');
				return;
			}
			if(data.success){
				console.info(data.obj);
				checkNoticeForm.form('load',data.obj);	
			}
			
		});
	});
	/* $(function($) {
		$('#notices_checknoticedialog_datagrid').datagrid({
			
			url :'${pageContext.request.contextPath}/noticesAction!getSingleNoticeDatagridById.action?id='+currtCheckNoticeId,
			fit:true,
			idField:'id',
			sortName:'id',
			sortOrder:'desc',
			maximizable:true,
			multiSort:false,
			remoteSort:true, 
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
				field : 'isSuperNotice',
				title : '身份',
				sortable:true,
				formatter: function(value,row,index){
					if(value){
						return "超级管理员";
					}
					return "普通管理员";
				}
			}, {
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
				field : 'canAddNotice',
				title : '添加管理员',
				sortable:true,
				formatter: function(value,row,index){
					if(value){
						return "<font style='color:green;'>是</font>";
					}
					return "<font style='color:red;'>否</font>";
				}
			} , {
				field : 'canDeleteNotice',
				title : '删除管理员',
				sortable:true,
				formatter: function(value,row,index){
					if(value){
						return "<font style='color:green;'>是</font>";
					}
					return "<font style='color:red;'>否</font>";
				}
			}, {
				field : 'canQueryNotice',
				title : '查看管理员',
				sortable:true,
				formatter: function(value,row,index){
					if(value){
						return "<font style='color:green;'>是</font>";
					}
					return "<font style='color:red;'>否</font>";
				}
			} , {
				field : 'canUpdateNotice',
				title : '修改管理员',
				sortable:true,
				formatter: function(value,row,index){
					if(value){
						return "<font style='color:green;'>是</font>";
					}
					return "<font style='color:red;'>否</font>";
				}
			}, {
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
		 */
	
</script>


