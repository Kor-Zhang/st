<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- 轮播 start -->
<div id="calousel">
	
	<%-- <div class="carouselItems">
		<img class="diplayPics"  
		src="<c:url value='/owf/aboutUsFrontAction!getCarouselByImgName.action?imgName=12.png'/>" />
		<div class="diplayFonts">这是是们飒是是们飒沓是是们飒沓是们飒沓是的</div>
	</div> --%>
	
</div>
<!-- 轮播 end -->

<!-- 新闻导航 start -->
<jsp:include page="./newsNav.jsp"></jsp:include>
<!-- 新闻导航 end -->
<!-- 业务导航 start -->
<jsp:include page="./serviceNav.jsp"></jsp:include>
<!-- 业务导航 end -->