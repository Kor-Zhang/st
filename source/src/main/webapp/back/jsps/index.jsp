<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<title></title>
<link id="easyuiTheme" rel="stylesheet" type="text/css"
	href="<c:url value='/back/jslib/jquery-easyui-1.4.1/themes/bootstrap/easyui.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/back/jslib/jquery-easyui-1.4.1/themes/icon.css'/>">
<style type="text/css">
	*{
		color:black;
		font-family: "Microsoft YaHei";
		font-weight: bold;
	}
</style>
</head>

<body id="admins_indexBody" class="easyui-layout">
	<!-- 中部 -->
	<div data-options="region:'center',title:'欢迎使用本系统'">
		<!-- 预留动态加载位置 -->
		<div id="admins_index_indexCenter"></div>
		
			

	</div>
	<!-- 东部 -->
	<div data-options="region:'east',title:'日历'" style="width:200px;">
		<!-- 预留动态加载位置 -->
		<div id="admins_index_indexEast"></div>
	</div>
	<!-- 西部 -->
	<div data-options="region:'west'" style="width:200px;">
		<!-- 预留动态加载位置 -->
		<div id="admins_index_indexWest"></div>

	</div>
	<!-- 北部 -->
	<div data-options="region:'north'" style="height:70px;">
		<!-- 预留动态加载位置 -->
		<div id="admins_index_indexNorth"></div>
	
	</div>
	<!-- 南部 -->
	<div data-options="region:'south'" style="height:25px;">
		<!-- 预留动态加载位置 -->
		<div id="admins_index_indexSouth"></div>
	</div>
	

	

</body>
<script type="text/javascript"
	src="<c:url value='/back/jslib/jquery-easyui-1.4.1/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/back/jslib/zkutil_back.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/back/jslib/jquery-easyui-1.4.1/jquery.easyui.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/back/jslib/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/back/jslib/jquery-easyui-1.4.1/extension/etree/jquery.etree.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/back/jslib/jquery-easyui-1.4.1/extension/etree/jquery.etree.lang.js'/>"></script>
<script type="text/javascript" src="<c:url value='/back/jslib/static.js'/>"></script>
<script type="text/javascript">

	

	/*****************************************申明变量*******************************/
	
	//登陆的dialog
	var loginDialog = undefined;
	//登陆表单
	var loginForm = undefined;
	//保存当前查询你的用户id，用于checkuser.jsp调用
	//电泳checkuser.jsp前需要设置currtCheckUserId
	var currtCheckUserId = undefined;
	//查看user的dialog
	var checkUserDialog = undefined;
	//保存当前查询的admin的id，用于checkadmin.jsp调用
	//电泳checkuser.jsp前需要设置currtCheckAdminId
	var currtCheckAdminId = undefined;
	//查看admin的dialog
	var checkAdminDialog = undefined;
	//保存当前查询的notice的id，用于checknotice.jsp调用
	//电泳checknotice.jsp前需要设置checknoticeId
	var currtCheckNoticeId = undefined;
	//查看Notice的dialog
	var checkNoticeDialog = undefined;
	//保存当前查询的car的id，用于checkcar.jsp调用
	//电泳checkcar.jsp前需要设置checkcar
	var currtCheckCarId = undefined;
	//查看car的dialog
	var checkCarDialog = undefined;
	//保存当前查询的car的id，用于checkcarimg.jsp调用
	//电泳checkcarimg.jsp前需要设置checkcarimg
	var currtCheckCarImgsId = undefined;
	//查看car的dialog
	var checkCarImgsDialog = undefined;
	//检测权限
	var checkPowerAdminDialog = undefined;
	var checkPowerAdminId = undefined;

	/*****************************************延时加载开始***************************/
	$(function($){

		/************************动态加载中，东，西，南，北，登陆模块*************************/
		
		//加载东部模块
		$('#admins_index_indexEast').panel({
			fit:true,
			border:false,
			href:'${pageContext.request.contextPath}/back/jsps/index_east.jsp'
		});
		//加载西部模块
		$('#admins_index_indexWest').panel({
			fit:true,
			border:false,
			href:'${pageContext.request.contextPath}/back/jsps/index_west.jsp'
		});
		//加载北部模块
		$('#admins_index_indexNorth').panel({
			fit:true,
			border:false,
			href:'${pageContext.request.contextPath}/back/jsps/index_north.jsp'
		});
		
		//加载南部模块
		$('#admins_index_indexSouth').panel({
			fit:true,
			border:false,
			href:'${pageContext.request.contextPath}/back/jsps/index_south.jsp'
		});
		//加载中部模块
		$('#admins_index_indexCenter').panel({
			fit:true,
			border:false,
			href:'${pageContext.request.contextPath}/back/jsps/index_center.jsp'
		});
		
		//加载登录页面
		loginDialog = $('<div/>').dialog({
			title:'登录',
			modal:true,
			closable:false,
			buttons:[{
				text:'登录',
				handler:function(){
					submitLoginForm(); 
				}
			}],
			closed:true,
			width:250,
			height:150,
			border:false,
			href:'${pageContext.request.contextPath}/back/jsps/login.jsp',
			onLoad:function(){
				
			},
			onOpen:function(){
			}
		});
		/********************************延时执行方法*************************/
		loginForm = loginDialog.find('form');
		//检测用户是否在线
		zkAjax(NAMESPACE_BACK+"/adminsAction!isAdminOnline.action",function(data){

			//显示信息
			showMsg(data);
			try{
				//判断是否在线
				isOnline(data);
				//加载主题
				setThemes(data.theme);
				//在线，隐藏登陆dialog
				closeLoginDialog();
				//延时加载公告，字典tree
				setTimeout(function(){
					//那么加载在线用户列表（方法在index_east.jsp中）
					loadOnlineAdmins();
					//加载公告
					loadNotices();	
					//连接服务器获取systemddl数据
					loadSystemddlTree();
				}, 0);
			}catch(e){
				//不在线，显示登陆dialog
				return;
			}
			
			
			
		});
		
	});
	

	/************************************功能方法****************************/
	/**
	* 添加tab
	*/
	function addTabs(Tabs, options) {
		if (options.href == "" || options.href == undefined) {
			return;
		}
		if (Tabs.tabs('exists', options.title)) {
			Tabs.tabs('select', options.title);
			return;
		}
		;
		Tabs.tabs('add', options);
	}
	/**
	* 刷新tab
	*/
	function refreshTab(Tabs, url) {
		var tab = Tabs.tabs('getSelected'); // 获取选择的面板
		tab.panel('refresh', url);

	}
	/**
	*判断管理员是否在线
	*不在线，抛出异常，打开登陆框
	//在线，无操作
	**/
	function isOnline(data){
		//判断管理员是否在线
		var online = data.online;
		if(online==false){
			openLoginDialog();
			throw new error();
		}
		
	}
	
	/**
	*显示不为空的信息
	**/
	function showMsg(data){
		var msg = data.msg;
		if(msg==""){
			return;
		}
		$.messager.show({
			title:'提示',
			msg:msg
			
		});
		
	}
	//显示Progress
	function showProgress(msg){
		if(msg){
			$.messager.progress({
				title:"请稍等",
				msg:msg,
				text:msg,
				interval:300

			});	
		}
		
	}
	//显示Progress
	function closeProgress(){
		$.messager.progress('close');
	}
	
	
	/**
	 * 修改主题，更新数据库数据
	 */
	function updateThemes(newThemeString) {
		
		zkAjax(NAMESPACE_BACK+"/adminsAction!updateTheme.action?theme="+newThemeString,function(data){
			var success = data.success;
			showMsg(data);
			try{
				isOnline(data);
			}catch(e){
				return;
			}
			if(success){
				setThemes(newThemeString);
			}
		});
	}

	/**
	 * 设置主题
	 * 将easyui导入主题的的css添加id为 easyuiTheme
	 * @param newThemeString
	 */
	function setThemes(newThemeString) {
		
		setTimeout(function(){
			showProgress("正在加载主题");
		}, 1);
		setTimeout(function(){
			/* 得到现有主题信息 */
			/* ../jquery-easyui-1.4.1/themes/default/easyui.css */
			var currtThemeString = $("#easyuiTheme").attr("href");
			/* 得到替代结束位置 */
			var replaceEndPosition = currtThemeString.indexOf("themes") + 7;
			/* 替代就主题 */
			var newTheme = currtThemeString.substring(0, replaceEndPosition)
					+ newThemeString + "/easyui.css";
			$("#easyuiTheme").attr("href", newTheme);
			/* 保存cookkie主题信息 
			$.cookie("easyuiTheme", newTheme, {
				expires : 365,
				path : '/'
			});*/
		}, 250);
		setTimeout(function(){
			closeProgress();
		}, 500);
		
	}
	/**
	*通过id查看user
	*/
	function checkUser(userId){
		currtCheckUserId = userId;
		//添加节点
		checkUserDialog = $('<div/>').dialog({
			title:'查看',
			width:700,
			height:250,
			resizable:true,
			maximizable:true,
			modal:true,
			href:'${pageContext.request.contextPath}/back/jsps/checkuserdialog.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
				checkUserDialog = undefined;
			},
			onOpen:function(){
			},
			onLoad:function(){
			}
		});
	}
	
	
	/**
	*通过id查看admins
	*/
	function checkAdmin(adminId){
		currtCheckAdminId = adminId;
		//添加节点
		checkAdminDialog = $('<div/>').dialog({
			title:'查看',
			width:700,
			height:200,
			modal:true,
			href:'${pageContext.request.contextPath}/back/jsps/checkadmindialog.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
				checkAdminDialog = undefined;
			},
			onOpen:function(){
			},
			onLoad:function(){
			}
		});
	}
	
	/**
	*设置显示的admin及其相关信息
	*/
	function setDisplayCurrtAdmin(onlineAdmin){
		var id = onlineAdmin.id;
		//设置显示的id
		$('#admins_index_north_AdminId').html(id);
		//设置按钮方法
		$('#admins_index_north_AdminId').attr('href',"javascript:checkAdmin('"+id+"');");
	}
	/**
	*关闭登陆框
	*/
	function closeLoginDialog(){
		loginDialog.dialog('close');
	}
	/**
	*显示登陆框
	*/
	function openLoginDialog(){
		loginDialog.dialog('open');
	}
	
	/**
	*确认弹窗
	*callfun:确认操作的回掉函数
	*/
	function confirmDialog(callfun){
		$.messager.confirm('确认', '您确认要执行吗？', function(r){
			if (r){
			    // 退出操作;
				callfun();
			}
		});
	}
	/**
	*查看公告
	*/
	function checkNotice(noticeId){
		currtCheckNoticeId = noticeId;
		//添加节点
		checkNoticeDialog = $('<div/>').dialog({
			title:'查看',
			width:400,
			height:400,
			modal:true,
			href:'${pageContext.request.contextPath}/back/jsps/checknoticedialog.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
				checkNoticeDialog = undefined;
			},
			onOpen:function(){
				
			},
			onLoad:function(){
			}
		});
	}
	/**
	*查看汽车
	*/
	function checkCar(carId){
		currtCheckCarId = carId;
		//添加节点
		checkCarDialog = $('<div/>').dialog({
			title:'查看',
			width:700,
			height:200,
			modal:true,
			href:'${pageContext.request.contextPath}/back/jsps/checkcardialog.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
				checkCarDialog = undefined;
			},
			onOpen:function(){
			},
			onLoad:function(){
			}
		});
	}
	/**
	*查看汽车图片
	*/
	function checkCarImg(carId){
		currtCheckCarImgsId = carId;
		//添加节点
		checkCarImgsDialog = $('<div/>').dialog({
			title:'查看',
			width:600,
			height:400,
			modal:true,
			href:'${pageContext.request.contextPath}/back/jsps/checkcarimgdialog.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
				checkCarImgsDialog = undefined;
			},
			onOpen:function(){
			},
			onLoad:function(){
			}
		});
	}
	/**
	*查看指定adminid的管理员权限
	*/
	function checkAdminPower(adminId){
		checkPowerAdminId = adminId;
		checkPowerAdminDialog = $('<div/>').dialog({
			title:'查看权限',
			width:400,
			height:400,
			maximizable:true,
			modal:true,
			href:'${pageContext.request.contextPath}/back/jsps/checkadminpowerdialog.jsp',
			onClose:function(){
				//删除以前的节点
				$(this).dialog('destroy');
				checkPowerAdminDialog = undefined;
			},
			onOpen:function(){
				
				
			},
			onLoad:function(){
				
			}
		});
	}
</script>
</html>
