<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div class="" data-options="region:'north',title:'筛选',border:false,collapsed:true" style="height:240px;">
		<form id="admins_ow_newsImgs_form" style="display: inline-block;" method="post">
			<table width="100%">
				<tr>
					
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onClick="newsImgsSearchFun();">查询</a>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onClick="newsImgsClearFun();">清空</a>
					</td> 
					
					
				</tr>
				
				
			</table>
		</form>
	</div>	
	<div class="" data-options="region:'center'">
		<table id="admins_ow_newsImgs_datagrid" data-options="fit:true,border:false">

		</table>	
	</div>
</div>
	
<script type="text/javascript" charset="utf-8">

//显示图片的datagrid
var newsImgsDatagrid = undefined;
//添加图片的dialog
var imgsAddDialog = undefined;
$(function($) {

	newsImgsDatagrid = $('#admins_ow_newsImgs_datagrid').datagrid({
		
		url :'${pageContext.request.contextPath}'+NAMESPACE_OW_BACK+'/owImgsAndInfoBackAction!getImgsByInfoId.action?infoId='+currtNewsId,
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
			title : '图片',
			width:200,
			formatter: function(value,row,index){
				
				
				var btn = "<img width='200px' src='"+getWebProjectName()+NAMESPACE_OW_BACK+"/owImgsAndInfoBackAction!getNewsImgByImgName.action?imgName="+value+"'/>";
				return btn;
			}
		},{
			field : 'main',
			title : '主要图片',
			sortable:true,
			formatter: function(value,row,index){
				var font = "<font style='color:red'>否</font>";
				if(value==1){
					font = "<font style='color:green'>是</font>";
				}
				return font;
			}
		}
		
        ] ],toolbar: [ {
			text:'添加图片',
			iconCls: 'icon-add',
			handler: function(){
				newsImgsAdd();
			}
		},'-', {
			text:'删除图片',
			iconCls: 'icon-remove',
			handler: function(){
				newsImgsRemove();
			}
		},'-', {
			text:'设置为主要图片',
			iconCls: 'icon-remove',
			handler: function(){
				setMainImg();
			}
		},'-',{
			text:'帮助',
			iconCls: 'icon-help',
			handler: function(){
				newsImgsHelp();
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
	
	
	/**
	* 删除
	**/
	function newsImgsRemove(){
		//选择的需要删除的行
		var checkedRows = newsImgsDatagrid.datagrid('getChecked');
		
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
					zkAjax(NAMESPACE_OW_BACK+"/owImgsAndInfoBackAction!deleteImgsByImgsAndInfoId.action?deleteIds="+ids.join(','),function(data){
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
							newsImgsDatagrid.datagrid('load');
							//取消选择的行
							newsImgsDatagrid.datagrid('unselectAll');
							newsImgsDatagrid.datagrid('uncheckAll');
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
	*添加图片窗口
	**/
	function newsImgsAdd(){
		//添加节点
		imgsAddDialog = $('<div/>').dialog({
			title:'增加图片',
			width:400,
			height:200,
			maximizable:true,
			modal:true,
			href:'${pageContext.request.contextPath}/back/officialwebsite/jsps/news_addImgs.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
				imgsAddDialog = undefined;
			},
			onOpen:function(){
			},
			onLoad:function(){
				//加载id
				$('#news_addImgs_form').find('input[name=id]').val(currtNewsId);
			}
		});
	}
	
	
	function setMainImg(){
		//选择的需要删除的行
		var checkedRows = newsImgsDatagrid.datagrid('getChecked');
		
		//判断是否选择行 
		if(checkedRows.length<1){
			$.messager.show({
				title:'提示',
				msg:'请勾选需要设置的记录！'
			});
		}else if(checkedRows.length==1){
			//询问是否确认删除
			$.messager.confirm('提示','确认设置这'+checkedRows.length+'行？',function(r){
				if(r){
					var id = checkedRows[0].id;
					//链接服务器删除
					zkAjax(NAMESPACE_OW_BACK+"/owImgsAndInfoBackAction!UpdateImgMainByImgsAndInfoId.action?id="+id,function(data){
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
							newsImgsDatagrid.datagrid('load');
							//取消选择的行
							newsImgsDatagrid.datagrid('unselectAll');
							newsImgsDatagrid.datagrid('uncheckAll');
						}else{
							
						}
						
					});
				}else{
					//提示取消删除
					$.messager.show({
						title:'提示',
						msg:'取消设置！'
					});
				}
			});
		}
	}
});
</script>