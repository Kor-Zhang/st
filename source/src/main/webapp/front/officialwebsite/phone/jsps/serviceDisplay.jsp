<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 业务 start -->
<div id="service">
<!-- 左边start -->
	<div id="serviceDisplay_left">
		<!-- 位置导航start -->
		<div id="serviceDisplay_positionNav">
			<span>◄</span>
			<span id="up"><a href="javascript:toView('view_aboutUs','right','view_aboutUs',loadAboutUsDisplayView({}));"><s:text name="front.ow.phone.view_aboutUs"/></a></span>
			>
			<span id="now"><s:text name="front.ow.phone.service"/> </span>
		</div>
		<!-- 内容 start  -->
		<div id="service_content">
			<div id="serviceDetail_title">
				<s:text name="front.ow.phone.serviceDisplay"/>
			</div>
			
			<div id="serviceDetail_text">
				<s:text name="front.ow.phone.serviceIntroduction"/>
			</div>
			<!-- 筛选条件start -->
			
			<form id="serviceDetail_filter_form">
				<div id="serviceDetail_filter">
					
					<%-- <div class="serviceFiler_Items">
						<div class="serviceFilterName">
							<a href="#">项目语言</a>
							<span class="status">▲</span>
						</div>
						<div class="serviceFilterConditionDiv">
							<div class="serviceFilterConditions">
								
								<input type="checkbox" class="serviceCheckBox" checked name="projectlanguage" value="projectenglish" id="projectenglish"/>
								<label for="projectenglish">英语</label>
							</div>
							<div class="serviceFilterConditions">
								
								<input type="checkbox" class="serviceCheckBox" checked name="projectlanguage" value="projectchinese"  id="projectchinese"/>
								<label for="projectchinese">中文</label>
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
	<div id="serviceDisplay_right">
		<!-- 业务展示 start -->
		<ul id="service_ul">
			
			<%-- <li class="service_li">
				<div class="service_displayDiv">
					<div class="service_imgDiv">
						<img src="<c:url value='/front/officialwebsite/imgslib/bg/pic01.png'/>"/>
					</div>
					<a class="service_infoDiv" href="javascript:toView('view_serviceDetail','right','view_serviceDisplay','beforeServiceDetailShow()')">
						<div class="service_infoDiv_model">
							<div class="service_dateDiv">
								2013/6/13
							</div>
							<div class="service_titleDiv">
								这是上海
							</div>
						</div>
					</a>				
				</div>
				
			</li> --%>
		</ul>
		<!-- 业务展示 end -->
	</div>
	<!-- 右边end -->
</div>
<!-- 业务 end -->