<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 底部信息导航 start -->
<div id="newsNav">
	<div id="newsTip"><s:text name="front.ow.phone.newsNavTip"/></div>
	<div id="newsItemsList">
		
		<%-- <a class="newsItems" href="javascript:toView('view_newsDetail','right','view_newsDisplay',beforeNewsDetailShow({'id':'999','name':'zkk'}))">
			<span class="newsDate">19/7</span>
			<span class="newsTitle">这是新闻</span>
			<span class="newsImg">
				<img 
				src="<c:url value='/front/officialwebsite/imgslib/bg/pic02.png'/>" />
			</span>
		</a> --%>
	</div>
	
</div>
<!-- 底部信息导航 end -->