<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 新闻详情 start -->
<div id="newsDetail">
	<!-- 左部div start -->
	<div id="newsDetail_left">
		
		<!-- 位置导航 start -->
		<div id="newsDetail_position">
			<span>◄</span>
			<span id="up"><a href="javascript:toView('view_newsDisplay','right','view_newsDisplay','loadNewsDisplayView()')"><s:text name="front.ow.phone.view_newsDisplay"/></a></span>
			>
			<span id="now"><s:text name="front.ow.phone.newsDetail"/> </span>
		</div>
		<!-- 位置导航 end -->
		
		<!-- 翻页 start -->
		<div id="newsDetail_changePage">
			<span id="prePage">
			
				<a href="javascript:void(0);"><s:text name="front.ow.phone.prePage"/></a>
			</span>
			<span id="nextPage">
			
				<a href="javascript:void(0);"><s:text name="front.ow.phone.nextPage"/></a>
			</span>
			
		</div>
		<!-- 翻页 end -->
		<!-- 内容 start  -->
		<div id="newsDetail_content">
			<div id="newsDetail_title">
				<label></label>
				<label name="title">未知</label>
			</div>
			<div id="newsDetail_authour">
				<label>作者：</label>
				<label name="authour">未知</label>
			</div>
			<div id="newsDetail_clazz">
				<label>类型：</label>
				<label name="clazz">未知</label>
			</div>
			<div id="newsDetail_releaseTime">
				<label>发布时间：</label>
				<label name="releaseTime">未知</label>
			</div>
			<div id="newsDetail_text">
				<label>内容：</label>
				<label name="text">未知</label>
			</div>
		</div>
		<!-- 内容 end  -->
		
	</div>
	<!-- 左部div end -->
	
	
	<!-- 右部div start -->
	<div id="newsDetail_right">
		<!-- 新闻图片展示 start  -->
		<div id="newsDetail_newsImgDisplay">
			<img id="newsDisplayImg"  
						src="<c:url value='/imgsAndInfoFrontAction!getNewsImgByImgName.action?imgName='/>" />
		</div>
		<!-- 新闻图片展示 end  -->
		<!-- 新闻图片列表 start-->
		<div id="newsDetail_newsImgList">
			<ul id="newsImgUl">
				<%-- <li class="newsImgLi">
					<img class="newsImgLiImg"  
						src="<c:url value='/front/officialwebsite/imgslib/bg/pic01.png'/>" />
					<div class="newsImgLiModel eye"></div>
				</li> --%>
				
				
			</ul>
		</div>
		<!-- 新闻图片列表 end-->
		
	</div>
	<!-- 右部div end -->
</div>
<!-- 新闻详情 end -->