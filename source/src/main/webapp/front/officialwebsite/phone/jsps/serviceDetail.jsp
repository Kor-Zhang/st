<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 业务详情 start -->
<div id="serviceDetail">
	<!-- 左部div start -->
	<div id="serviceDetail_left">
		
		<!-- 位置导航 start -->
		<div id="serviceDetail_position">
			<span>◄</span>
			<span id="up"><a href="javascript:toView('view_serviceDisplay','right','view_serviceDisplay','loadServiceDisplayView()')"><s:text name="front.ow.phone.view_serviceDisplay"/></a></span>
			>
			<span id="now"><s:text name="front.ow.phone.serviceDetail"/> </span>
		</div>
		<!-- 位置导航 end -->
		
		<!-- 翻页 start -->
		<div id="serviceDetail_changePage">
			<span id="prePage">
			
				<a href="javascript:void(0);"><s:text name="front.ow.phone.prePage"/></a>
			</span>
			<span id="nextPage">
			
				<a href="javascript:void(0);"><s:text name="front.ow.phone.nextPage"/></a>
			</span>
			
		</div>
		<!-- 翻页 end -->
		<!-- 内容 start  -->
		<div id="serviceDetail_content">
			<div id="serviceDetail_title">
				<label></label>
				<label name="title">未知</label>
			</div>
			<div id="">
				<label>投资者：</label>
				<label name="investor">未知</label>
			</div>
			<div id="">
				<label>开发者：</label>
				<label name="developers">未知</label>
			</div>
			<div id="serviceDetail_clazz">
				<label>类型：</label>
				<label name="clazz">未知</label>
			</div>
			<div id="">
				<label>阶段/进度：</label>
				<label name="rateOfProgress">未知</label>
			</div>
			<div id="serviceDetail_releaseTime">
				<label>发布时间：</label>
				<label name="releaseTime">未知</label>
			</div>
			<div id="serviceDetail_text">
				<label>介绍：</label>
				<label name="introduction">未知</label>
			</div>
		</div>
		<!-- 内容 end  -->
		
	</div>
	<!-- 左部div end -->
	
	
	<!-- 右部div start -->
	<div id="serviceDetail_right">
		<!-- 业务图片展示 start  -->
		<div id="serviceDetail_serviceImgDisplay">
			<img id="serviceDisplayImg"  
						src="<c:url value='/imgsAndInfoFrontAction!getServiceImgByImgName.action?imgName='/>" />
		</div>
		<!-- 业务图片展示 end  -->
		<!-- 业务图片列表 start-->
		<div id="serviceDetail_serviceImgList">
			<ul id="serviceImgUl">
				<%-- <li class="serviceImgLi">
					<img class="serviceImgLiImg"  
						src="<c:url value='/front/officialwebsite/imgslib/bg/pic01.png'/>" />
					<div class="serviceImgLiModel eye"></div>
				</li> --%>
				
				
			</ul>
		</div>
		<!-- 业务图片列表 end-->
		
	</div>
	<!-- 右部div end -->
</div>
<!-- 业务详情 end -->