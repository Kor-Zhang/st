<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	
<table id="admins_checkuserdialog_datagrid">

</table>	



<script type="text/javascript" src="<c:url value='/jslib/zkutil.js'/>"></script>
<script type="text/javascript">
	$(function($) {
		//checkUserDatagrid变量位于index.jsp
		$('#admins_checkuserdialog_datagrid').datagrid({
			
			url :'${pageContext.request.contextPath}/usersAction!getSingleUserDatagridById.action?id='+currtCheckUserId,
			idField:'id',
			fit:true,
			border:false,
			sortName:'id',
			sortOrder:'desc',
			multiSort:false,
			/* remoteSort:true, */
			selectOnCheck:true,
			checkOnSelect:true,
			singleSelect:true,
			fitColumns:true,
			frozenColumns:[[
			{
				field : 'id',
				title : '账户',
				hidden:true
			}, {
				field : 'head',
				title : '头像',
				sortable:true,
				width:50,
				height:50,
				formatter: function(value,row,index){
					var carImg = "<span  style='width:50px;height:50px;' title='点击更新头像'><img style='width:50px;height:50px;' src='${pageContext.request.contextPath}/usersAction!getUserHead.action?head="+value+"&t="+new Date().getTime()+"'/></span>";
					return carImg;
				}
			} , {
				field : 'phone',
				title : '电话',
				width:100,
				sortable:true
			}
         	]],
			columns : [ [  {
				field : 'userName',
				sortable:true,
				title : '昵称'
			} , {
				field : 'realName',
				title : '真实姓名',
				sortable:true
			}, {
				field : 'password',
				title : '密码',
				formatter: function(value,row,index){
					
					return "******";
				}
			} , {
				field : 'status',
				title : '状态',
				sortable:true,
				formatter: function(value,row,index){
					if(value){
						return "<font style='color:green;'>激活</font>";
					}
					return "<font style='color:red;'>冻结</font>";
				}
			}, {
				field : 'email',
				title : '邮件',
				sortable:true
			} , {
				field : 'cardClazz',
				title : '证件类型',
				sortable:true
			}, {
				field : 'cardNumber',
				title : '证件号',
				sortable:true
			} ] ],
			onLoadSuccess:function(data){
				showMsg(data);
				try{
					//判断是否在线
					isOnline(data);
				}catch(e){
					return;
				}
				
			}


		});
		
		
	});
	
</script>


