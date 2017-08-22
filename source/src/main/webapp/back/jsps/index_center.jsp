<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="admins_index_centerTabs" class="easyui-tabs"
	data-options="fit:true,border:false">


	<div title="首页" data-options="closable:false" fit="true"
		style="width: 100%; height: 100%;">



		<div fit="true" class="easyui-layout" width="100%;" height="100%;">

			<div region="west" width="50%" height="" split="true" border="false">
				<div fit="true" class="easyui-layout" width="100%;" height="100%;">
					<!-- 关于 -->
					<div region="north" width="100%" height="50%" split="true"
						border="false">
						<div id="about" class="easyui-panel" title="关于" fit="true"
							style="height: 100%; width: 100%" data-options="collapsible:true">
							<table>


								<tr>
									<td>
										<p>ST后台管理是一个对ST数据管理的后台系统。</p>
									</td>
								</tr>
								<tr>
									<td>
										<p>该后台系统涵盖的功能包括：**管理等。</p>
									</td>
								</tr>
							</table>
						</div>

					</div>
					<!-- 链接 -->
					<div region="south" width="100%" height="50%" split="true"
						border="false">
						<div id="link" class="easyui-panel" title="链接" fit="true"
							style="height: 100%; width: 100%" data-options="collapsible:true">

							<table>

								<tr>
									<td>
										<p><a target="blank" href="<c:url value='/front/officialwebsite/jsps/index.jsp'/>">ST首页</a></p>
									</td>
								</tr>
								
							</table>
						</div>
					</div>
				</div>

			</div>
			<div region="east" width="50%" height="" split="true" border="false">
				<div fit="true" class="easyui-layout" width="100%;" height="100%;">
					<!-- 说明 -->
					<div region="north" width="100%" height="50%" split="true"
						border="false">
						<div id="explain" class="easyui-panel" title="说明" fit="true"
							style="height: 100%; width: 100%" data-options="collapsible:true">
							<table>

								<tr>
									<td>
										<p>该系统拥有一个超级管理和不限量的普通管理员。</p>
									</td>
								</tr>
								
								<tr>
									<td>
										<p>超级管理对管理食物拥有所有权限，普通管理员可以被分配权限。</p>
									</td>
								</tr>
								<tr>
									<td>
										<p>请所有管理员遵守<a style="color:red;" href="javascript:showRule();">ST管理准则</a>。</p>
									</td>
								</tr>
							</table>
						</div>
					</div>
					<!-- 公告 -->
					<div region="south" width="100%" height="50%" split="true"
						border="false">
						<div id="post" class="easyui-panel" title="公告" fit="true"
							style="height: 100%; width: 100%" data-options="collapsible:true">
							<table id="admins_index_center_noticeTable">


								<!-- <tr>
									<td>
										<p>ST是一个提供综合旅游网站的网站。</p>
									</td>
								</tr>
								<tr>
									<td>
										<p>该后台为管理人员提供编辑管理网站的途径。</p>
									</td>
								</tr>
								<tr>
									<td>
										<p>。。。。。。</p>
									</td>
								</tr> -->
							</table>
						</div>
					</div>
				</div>


			</div>
		</div>

	</div>
</div>

<script type="text/javascript">
	var noticeTable = undefined;
	//设置定时获取公告的定时器
	var getNewNoticesTimer = undefined;
	//获取公告的时间间隔，<=0代表只查询一次吗，不启用储蓄查询公告的模式
	var getNewNoticesDuring = -1;
	function showRule(){
		//加载管理规则
		$('<div/>').dialog({
			title:'管理准则',
			width:900,
			height:600,
			border:false,
			maximizable:true,
			href:'${pageContext.request.contextPath}/back/jsps/glzz.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
			},
		});
	}
	
	$(function($){
		noticeTable = $('#admins_index_center_noticeTable');
		
	});
	/**
	* 定时远程加载公告信息，并且设置
	*/
	function loadNotices(){
		if(getNewNoticesTimer){
			clearInterval(getNewNoticesTimer);
			getNewNoticesTimer = undefined;
		}
		//是否启动持续查询模式
		if(getNewNoticesDuring>0){
			linkServletSetNotices();
			getNewNoticesTimer = setInterval(function(){
				linkServletSetNotices();
			}, getNewNoticesDuring);
		}else{
			linkServletSetNotices();
		}
		
		
	}
	/**
	* 连接服务器获取公告信息，并且设置信息
	*/
	function linkServletSetNotices(){
		zkAjax(NAMESPACE_BACK+"/noticesAction!getNoticesList.action?order=desc&sort=createTime",function(data){
			//清空公告
			noticeTable.html('');
			var rows = data.rows;
			for (var i = 0; i < rows.length; i++) {
				var tr = $('<tr></tr>');
				var td = $('<td></td>');
				var p = $('<p></p>');
				//javascript:checkNotice在index.jsp
				var a = $("<span title="+rows[i].text+"><a href=javascript:checkNotice('"+rows[i].id+"');><font style='color:red'>"+rows[i].title+"</font></a></span><br/><font style='color:gray'>时间：</font><font style='color:green'>"+rows[i].createTime+"</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font style='color:gray'>发布信息的管理员：</font><a href=javascript:checkAdmin('"+rows[i].adminId+"');><font style='color:green'>"+rows[i].adminId+"</font></a>");
				p.append(a);
				td.append(p);
				tr.append(td);
				noticeTable.append(tr);
			}
			
			
		});
	}
</script>