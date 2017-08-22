<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'south'" style="height:30px;">
		<a class="easyui-linkbutton" 
			style="float:right;margin-right: 20px;"
			href="javascript:void(0);"
			data-options="iconCls:'icon-add',
			onClick:function(){
				var checkedId = [];
		        var nodes = powerTree.tree('getChecked');
		        var i = 0;
		        <!-- 获取新的权限 -->
		        for( i = 0;i<nodes.length;i++){
		        	var node = nodes[i];
	        		if(powerTree.tree('isLeaf',node.target)){
		        		checkedId.push(node.id);
	      	    	}
		        }
		        <!-- 添加分隔符 -->
	         	checkedId = checkedId.join(',');
				zkAjax(NAMESPACE_BACK+'/powersAction!updatePowers.action?adminId='+managePowerAdminId+'&checkedId='+checkedId,function(data){
					
					<!-- 提示信息 -->
					showMsg(data);
					try{
						//判断是否在线
						isOnline(data);
					}catch(e){
						return;
					}
					
				        
				});
			}">提交</a>
	</div>
	<div data-options="region:'center',title:'请为该管理员分配权限'">
		<ul id="powerTree">
	 
	        
		</ul>
	</div>
	<div data-options="region:'east',title:'请谨慎分权限'" style="width:200px;">
		请谨慎分权限，不合理的分配可能造成您网站的业务方面的错误，甚至是程序的逻辑错误，所以，请您谨慎分配权限！
	</div>
</div>

<script type="text/javascript">
	var powerTree = undefined;
	//加载树
	zkAjax(NAMESPACE_BACK+'/powersAction!getPowerTree.action?adminId='+managePowerAdminId,function(data){
		showMsg(data);
		try{
			isOnline(data);
			
		}catch(e){
			//关闭全县修改框
			managePowerDialog.dialog('close');
			return;
		}
		
		if(data.success){
			powerTree = $('#powerTree').tree({
				fit:true,
				checkbox:true,
				data:data.rows
			});;
		}
		
	});
</script>