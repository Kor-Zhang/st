<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div class="" data-options="region:'north',title:'筛选',border:false,collapsed:true" style="height:240px;">
		<form id="admins_ow_gwcygl_form" style="display: inline-block;" method="post">
			<table width="100%">
				<tr>
					
					<td>
						名字：
					</td> 
					<td>
						<input name="searchName"/>
					</td> 
					<td>
						职位：
						<input name="searchPosition"/>
					</td> 
					<td>
						
					</td> 
					
				</tr>
				<tr>
					<td>
						介绍：
					</td> 
					<td>
						<input name="searchIntroduction"/>
					</td> 
					<td>
						状态：
						<select name="eqStatus">
							<option value="null">全部</option>
							<option value="0">不展示</option>
							<option value="1">展示</option>
						</select>
					</td> 
					<td>
						
					</td> 
				</tr>
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
					
				</tr>
				<tr>
					<th>
						 更新时间：
					</th>
					<td>
						<input name="minUpdateTime" style=";" class="easyui-datetimebox" data-options="editable:false"/>-
						
					</td>
					<td>
						<input name="maxUpdateTime" style=";" class="easyui-datetimebox" data-options="editable:false"/>
						
					</td>
				</tr>
				<tr>
					
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onClick="gwcyglSearchFun();">查询</a>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onClick="gwcyglClearFun();">清空</a>
					</td> 
					
					
				</tr>
				
				
			</table>
		</form>
	</div>	
	<div class="" data-options="region:'center'">
		<table id="admins_ow_gwcygl_datagrid" data-options="fit:true,border:false">

		</table>	
	</div>
</div>

<%-- 
<script type="text/javascript" src="<c:url value='/jslib/zkutil.js'/>"></script>
<script type="text/javascript" src="<c:url value='/jslib/admins/static.js'/>"></script> --%>
<script type="text/javascript">
	var gwcyglDatagrid = undefined;
	
	//添加窗口
	var gwcyglAddDialog = undefined;
	
	//编辑窗口和表单
	var gwcyglEditForm = undefined;
	var gwcyglEditDialog = undefined;
	$(function($) {
		gwcyglDatagrid = $('#admins_ow_gwcygl_datagrid').datagrid({
			
			url :'${pageContext.request.contextPath}'+NAMESPACE_OW_BACK+'/owMembersBackAction!getDatagrid.action',
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
				title:'c',
				checkbox:true
			},{
				field : 'head',
				title : '头像',
				sortable:true,
				width:150,
				height:150,
				formatter: function(value,row,index){
					var carImg = "<span style='width:150px;height:150px;' title=''><img style='width:150px;height:150px;' src= ${pageContext.request.contextPath}"+NAMESPACE_OW_BACK+"/owMembersBackAction!getImgByHead.action?head="+value+"&t="+new Date().getTime()+"'/></span>";
					return carImg;
				}
			},{
				field : 'name',
				title:'名字',
				sortable:true,
				formatter: function(value,row,index){
					var tipInfo = "<span title='"+value+"'>"+value+"</span>"
					return tipInfo;
				}
			},{
				field : 'sex',
				title:'性别',
				sortable:true
			},{
				field : 'age',
				title:'年龄',
				sortable:true
			},{
				field : 'birthday',
				title:'生日',
				sortable:true
			},{
				field : 'nation',
				title:'国家',
				sortable:true
			},{
				field : 'faith',
				title:'信仰',
				sortable:true
			},{
				field : 'language',
				title:'语言',
				sortable:true
			},{
				field : 'position',
				title:'职位',
				width:100,
				sortable:true,
				formatter: function(value,row,index){
					var tipInfo = "<span title='"+value+"'>"+value+"</span>"
					return tipInfo;
				}
			},{
				field : 'degree',
				title:'学位',
				sortable:true,
				formatter: function(value,row,index){
					if(value==""){
						return "未知";
					}
					return value;
				}
			},{
				field : 'lastGraduateSchool',
				title:'最后毕业学校',
				sortable:true,
				formatter: function(value,row,index){
					if(value==""){
						return "未知";
					}
					return value;
				}
			},{
				field : 'joinTime',
				title:'加入时间',
				sortable:true,
				formatter: function(value,row,index){
					if(value==""){
						return "未知";
					}
					return value;
				}
			},{
				field : 'outTime',
				title:'离职时间',
				sortable:true,
				formatter: function(value,row,index){
					if(value==""){
						return "未知";
					}
					return value;
				}
			},{
				field : 'membersStatus',
				title:'成员状态',
				sortable:true,
				formatter: function(value,row,index){
					if(value==""){
						return "未知";
					}
					return value;
				}
			},{
				field : 'note',
				title:'备注',
				sortable:true,
				formatter: function(value,row,index){
					if(value==""){
						return "未知";
					}
					return value;
				}
			},{
				field : 'qq',
				title:'qq',
				sortable:true,
				formatter: function(value,row,index){
					if(value==""){
						return "未知";
					}
					return value;
				}
			},{
				field : 'email',
				title:'邮箱',
				sortable:true,
				formatter: function(value,row,index){
					if(value==""){
						return "未知";
					}
					return value;
				}
			},{
				field : 'phone',
				title:'电话',
				sortable:true,
				formatter: function(value,row,index){
					if(value==""){
						return "未知";
					}
					return value;
				}
			},{
				field : 'introduction',
				title:'介绍',
				width:250,
				sortable:true,
				formatter: function(value,row,index){
					var tipInfo = "<span title='"+value+"'>"+value+"</span>"
					return tipInfo;
				}
				
			},{
				field : 'createTime',
				title:'创建时间',
				sortable:true
			},{
				field : 'updateTime',
				title:'最后修改时间',
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
			}
			
            ] ],toolbar: [ {
				text:'添加',
				iconCls: 'icon-add',
				handler: function(){
					gwcyglAdd();
				}
			},'-', {
				text:'删除',
				iconCls: 'icon-remove',
				handler: function(){
					gwcyglRemove();
				}
			},'-',{
				text:'编辑',
				iconCls: 'icon-edit',
				handler: function(){
					gwcyglEdit();
				}
			},'-',{
				text:'帮助',
				iconCls: 'icon-help',
				handler: function(){
					gwcyglHelp();
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
		$('#admins_gwcygl_searchId').keyup(function(e){
			if(e.keyCode==13){
				searchFun();
			}
		}); */
		
	});
	
	
	/**
	* 添加
	*/
	function gwcyglAdd(){
		//添加节点
		gwcyglAddDialog = $('<div/>').dialog({
			title:'增加',
			width:400,
			height:450,
			maximizable:true,
			modal:true,
			href:'${pageContext.request.contextPath}/back/officialwebsite/jsps/members_adddialog.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
				gwcyglAddDialog = undefined;
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
	function gwcyglEdit(){
		var checkedRow = gwcyglDatagrid.datagrid('getChecked');
		//是否选择一行
		if(checkedRow.length==1){
			//添加节点
			gwcyglEditDialog = $('<div/>').dialog({
				title:'编辑',
				width:400,
				height:450,
				modal:true,
				href:'${pageContext.request.contextPath}/back/officialwebsite/jsps/members_editdialog.jsp',
				onClose:function(){
					//删除以前的节点
					$(this).dialog('destroy');
					gwcyglEditDialog = undefined;
				},
				onOpen:function(){
					
					
				},
				onLoad:function(){

					gwcyglEditForm = $('#admins_gwcygl_editdialog_editForm');
					//加载文本信息
					gwcyglEditForm.form('load',checkedRow[0]);
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
	function gwcyglRemove(){
		//选择的需要删除的行
		var checkedRows = gwcyglDatagrid.datagrid('getChecked');
		
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
					zkAjax(NAMESPACE_OW_BACK+"/owMembersBackAction!deleteMembers.action?deleteIds="+ids.join(','),function(data){
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
							gwcyglDatagrid.datagrid('load');
							//取消选择的行
							gwcyglDatagrid.datagrid('unselectAll');
							gwcyglDatagrid.datagrid('uncheckAll');
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
	function gwcyglSearchFun(){
		//获取查询的form参数
		var params = serializeObject($('#admins_ow_gwcygl_form'));
		gwcyglDatagrid.datagrid('load', params);
	}
	/**
	*清空
	**/
	function gwcyglClearFun(){
		//清空input
		$('#admins_ow_gwcygl_form input').val("");
		//select选择第一个option
		firstOption("admins_ow_gwcygl_form");
		//重新加载
		gwcyglDatagrid.datagrid('load', {});
		
	}
	
	
	

	
	
</script>


