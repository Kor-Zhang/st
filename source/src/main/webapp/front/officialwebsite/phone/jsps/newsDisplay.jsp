<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 新闻 start -->
<div id="news">
<!-- 左边start -->
	<div id="newsDisplay_left">
		<!-- 位置导航start -->
		<div id="newsDisplay_positionNav">
			<span>◄</span>
			<span id="up"><a href="javascript:toView('view_aboutUs','right','view_aboutUs',loadAboutUsDisplayView({}));"><s:text name="front.ow.phone.view_aboutUs"/></a></span>
			>
			<span id="now"><s:text name="front.ow.phone.news"/> </span>
		</div>
		<!-- 内容 start  -->
		<div id="news_content">
			<div id="newsDetail_title">
				<s:text name="front.ow.phone.newsDisplay"/>
			</div>
			
			<div id="newsDetail_text">
				<s:text name="front.ow.phone.newsIntroduction"/>

			</div>
			<!-- 筛选条件start -->
			
			<form id="newsDetail_filter_form">
				<div id="newsDetail_filter">
					<%-- <div class="newsFiler_Items">
						<div class="newsFilterName">
							<a href="#">项目进度</a>
							<span class="status">▲</span>
						</div>
						<div class="newsFilterConditionDiv">
							<div class="newsFilterConditions">
								
								<input type="checkbox" class="newsCheckBox" checked name="project" value="finished"  id="finished" />
									
								<label for="finished">完成</label>
							</div>
							<div class="newsFilterConditions">
								
								<input type="checkbox" class="newsCheckBox" checked name="project" value="unfinished" id="unfinished" />
								<label for="unfinished">未完成</label>
								
							</div>
							
						</div>
					
					</div> --%>
					
					
				</div>
			</form>
			<!-- 筛选条件end -->
		</div>
		<!-- 内容 end  -->
		<!-- 位置导航end -->
	</div>
	<!-- 左边end -->
	<!-- 右边start -->
	<div id="newsDisplay_right">
		<!-- 新闻展示 start -->
		<ul id="news_ul">
			
			<%-- <li class="news_li">
				<div class="news_displayDiv">
					<div class="news_imgDiv">
						<img src="<c:url value='/front/officialwebsite/imgslib/bg/pic01.png'/>"/>
					</div>
					<a class="news_infoDiv" href="javascript:toView('view_newsDetail','right','view_newsDisplay','beforeNewsDetailShow()')">
						<div class="news_infoDiv_model">
							<div class="news_dateDiv">
								2013/6/13
							</div>
							<div class="news_titleDiv">
								这是上海
							</div>
						</div>
					</a>				
				</div>
				
			</li> --%>
			
			
		</ul>
		<!-- 新闻展示 end -->
	</div>
	<!-- 右边end -->
</div>
<!-- 新闻 end -->