<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 导航栏 start -->
<div id="nav">
	<div id="logo">
		&nbsp;&nbsp;&nbsp;S&nbsp;T&nbsp;&nbsp;
	</div>
	<div id="navWord">
		<!-- navItem，用于点亮项目时使用 -->
		<a navItem='view_aboutUs' href="javascript:toView('view_aboutUs','right','view_aboutUs','loadAboutUsDisplayView()');"><s:text name="front.ow.pc.view_aboutUs"/></a>
		<a navItem='view_membersDisplay' href="javascript:toView('view_membersDisplay','left','view_membersDisplay','loadMembersDisplayView()');"><s:text name="front.ow.pc.view_membersDisplay"/></a>
		<a navItem='view_newsDisplay' href="javascript:toView('view_newsDisplay','right','view_newsDisplay','loadNewsDisplayView()');"><s:text name="front.ow.pc.view_newsDisplay"/></a>
		<a navItem='view_serviceDisplay' href="javascript:toView('view_serviceDisplay','left','view_serviceDisplay','loadServiceDisplayView()');"><s:text name="front.ow.pc.view_serviceDisplay"/></a>
		<a navItem='view_contactUs' href="javascript:toView('view_contactUs','right','view_contactUs','loadContactUsView()');"><s:text name="front.ow.pc.view_contactUs"/></a>
	</div>
	
	<div id="search">
		&nbsp;
	</div>
	<div id="setting">
		<a id="lang_zh_CN" href="<c:url value='/languageAction!setLanguage.action?lang=zh_CN'/>"><s:text name="front.ow.pc.zh_CN"/></a>
		&nbsp;|&nbsp;
		<a id="lang_en_US" href="<c:url value='/languageAction!setLanguage.action?lang=en_US'/>"><s:text name="front.ow.pc.en_US"/></a>
	</div>
</div>
<!-- 导航栏 end -->


