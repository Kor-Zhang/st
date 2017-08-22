<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 内容 start -->
<div id="content">
	<!-- 默认显示第一div -->
	<div id="view_aboutUs">
		<jsp:include page="./aboutUs.jsp"></jsp:include>
	</div>
	<div id="view_membersDisplay">
		<jsp:include page="./membersDisplay.jsp"></jsp:include>
	</div>
	<div id="view_newsDisplay">
		<jsp:include page="./newsDisplay.jsp"></jsp:include>
	</div>
	<div id="view_serviceDisplay">
		<jsp:include page="./serviceDisplay.jsp"></jsp:include>
	</div>
	<div id=view_contactUs>
		<jsp:include page="./contactUs.jsp"></jsp:include>
	</div>
	
	
	<!-- 新闻详情页面 start -->
	<div id="view_newsDetail">
		<jsp:include page="./newsDetail.jsp"></jsp:include>
	</div>
	<!-- 新闻详情页面 end -->
	<!-- 业务详情页面 start -->
	<div id="view_serviceDetail">
		<jsp:include page="./serviceDetail.jsp"></jsp:include>
	</div>
	<!-- 业务详情页面 end -->
	<!-- 成员详情页面 start -->
	<div id="view_membersDetail">
		<jsp:include page="./membersDetail.jsp"></jsp:include>
	</div>
	<!-- 成员详情页面 end -->
</div>

<!-- 内容 end -->


