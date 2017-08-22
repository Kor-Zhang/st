<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
	#nav *{
		color: white;background:black;
	}
</style>
<div id="nav" class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'west',border:false" style="width:200px;">
		<div style="font-size: 44px;font-weight: bold;float:left;width:100%;height:100%;text-align: center;vertical-align: middle;">
			S&nbsp;T
		</div>
		
	</div>
	<div data-options="region:'center',border:false">
		
		<div class="panel" data-options="fit:true,border:false">
			
			<%-- <img width="100%" height="100%" src="<c:url value='/adminsSrcAction!getBgImgSrc.action?imgName=oldtown.jpg'/>"/> --%>
			
		</div>
		
	</div>
	<div data-options="region:'east',border:false" style="width:200px;">
	
		<div style="margin: 10px 10px;">当前管理员：<a href="javascript:checkAdmin('${sessionScope.admin.id}');" id="admins_index_north_AdminId">${sessionScope.admin.id}</a></div>
		<!-- 控制面板 -->
		<div>
			<a href="javascript:void(0)"
					id="admins_index_settingMenuBtn" class="easyui-menubutton"
					data-options="menu:'#admins_index_settingMenu',iconCls:'icon-help'">控制面板</a>


			<!-- 时间，设置 -->
			<div id="admins_index_settingMenu" style="width:120px;">

				<div data-options="iconCls:'icon-remove'"
					id="admins_index_logoffBtn">
					<a
						href="${pageContext.request.contextPath}/back/adminsAction!adminLogoff.action"
						style="text-decoration: none;">注销</a>
				</div>
				<div data-options="iconCls:'icon-ok'" id="">
					<span>其他</span>
					<div>
						<!-- <div data-options="iconCls:'icon-add'"
							onClick="showAdminInfo();">个人信息</div> -->
							
						<div data-options="iconCls:'icon-undo'" id="">
							<span>背景</span>

							<div>
								<div onClick="updateThemes('bootstrap');">bootstrap</div>
								<div onClick="updateThemes('default');">default</div>
								<div onClick="updateThemes('black');">black</div>
								<div onClick="updateThemes('gray');">gray</div>
								<div onClick="updateThemes('metro');">metro</div>

							</div>

						</div>
						<div data-options="iconCls:'icon-remove'"
							onClick="submitFrozen();">申请冻结</div>

					</div>

				</div>
			</div>
			
		</div>
		

	</div>
</div>

<script type="text/javascript">
	//冻结本帐户
	function submitFrozen(){
		
		confirmDialog(function(){
			zkAjax("/adminsAction!frozenAdminself.action",function(data){
				showMsg(data);
				try{
					isOnline(data);
				}catch(e){
					return;
				}
				
			});
		});

		
	}
	
</script>