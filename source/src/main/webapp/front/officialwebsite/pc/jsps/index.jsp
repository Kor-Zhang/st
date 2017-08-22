<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 

SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS

TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT

	----	Maker:Kor_Zhang
 -->

<%
	//如果用户没有设置语言，那么转发到语言设置的action，将当前的浏览器默认语言设置为网站显示的语言
	if(session.getAttribute("userLang")==null){
		request.getRequestDispatcher("/languageAction!setLanguage.action").forward(request, response);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="front.ow.pc.owTiele"/></title>
<!-- 导入index及其子页面的css start -->
<!-- 最先加载等待页面，以便访问网站时，当网站未加载好，显示等待界面 -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/front/officialwebsite/pc/csslib/loadingModel.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/front/officialwebsite/pc/csslib/index.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/front/officialwebsite/pc/csslib/msgModel.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/front/officialwebsite/pc/csslib/nav.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/front/officialwebsite/pc/csslib/content.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/front/officialwebsite/pc/csslib/aboutUs.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/front/officialwebsite/pc/csslib/newsNav.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/front/officialwebsite/pc/csslib/newsDisplay.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/front/officialwebsite/pc/csslib/newsDetail.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/front/officialwebsite/pc/csslib/serviceDisplay.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/front/officialwebsite/pc/csslib/serviceDetail.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/front/officialwebsite/pc/csslib/membersDisplay.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/front/officialwebsite/pc/csslib/membersDetail.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/front/officialwebsite/pc/csslib/contactUs.css'/>">
<!-- 导入index及其子页面的css end -->
</head>
<body>

	<!-- 导航栏 start -->
	<jsp:include page="./nav.jsp"></jsp:include>
	<!-- 导航栏 end -->
	
	<!-- 内容展示 start -->
	<jsp:include page="./content.jsp"></jsp:include>
	
	<!-- 内容展示 end -->
	
	<!-- 加载页面 start -->
	
	<jsp:include page="./loadingModel.jsp"></jsp:include>
	<!-- 加载页面 end -->
	
	
	<!-- 消息页面 start -->
	
	<jsp:include page="./msgModel.jsp"></jsp:include>
	<!-- 消息页面 end -->
	
	<!-- 导入信息转换页面 start -->
	<jsp:include page="./js.jsp"></jsp:include>
	<!-- 导入信息转换页面 end -->
</body>
<!-- 导入index及其子页面的js start -->
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/jquery.min.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/jquery-easyui-1.4.1/jquery.easyui.min.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/jquery.color.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/jslib/front_static.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/jslib/zkutil_front.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/front_ow_static.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/zkutil_front_ow.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/index.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/loadingModel.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/msgModel.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/nav.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/content.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/aboutUs.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/newsNav.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/newsDisplay.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/newsDetail.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/serviceDisplay.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/serviceDetail.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/membersDisplay.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/membersDetail.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/front/officialwebsite/pc/jslib/contactUs.js'/>"></script>
<!-- 导入index其子页面的js end -->
</html>