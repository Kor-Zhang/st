<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul id="admins_checkadminpowerdialog_powerTree">
	 
	        
</ul>

<script type="text/javascript">
	var powerTree = undefined;
	
	//加载树
	zkAjax(NAMESPACE_BACK+'/powersAction!getPowerTree.action?adminId='+checkPowerAdminId,function(data){
		showMsg(data);
		try{
			isOnline(data);
			
		}catch(e){
			//关闭全县修改框
			managePowerDialog.dialog('close');
			return;
		}
		
		if(data.success){
			powerTree = $('#admins_checkadminpowerdialog_powerTree').tree({
				fit:true,
				checkbox:true,
				data:data.rows
			});;
		}
		
	});
</script>