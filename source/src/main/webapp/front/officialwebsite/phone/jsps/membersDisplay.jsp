<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 成员 start -->
<div id="membersDisplay">
	<!-- 左边start -->
	<div id="membersDisplay_left">
		<!-- 位置导航start -->
		<div id="membersDisplay_positionNav">
			<span>◄</span>
			<span id="up"><a href="javascript:toView('view_aboutUs','right','view_aboutUs',loadAboutUsDisplayView({}));"><s:text name="front.ow.phone.view_aboutUs"/></a></span>
			>
			<span id="now"><s:text name="front.ow.phone.members"/> </span>
		</div>
		<!-- 内容 start  -->
		<div id="members_content">
			<div id="membersDetail_title">
				<s:text name="front.ow.phone.teamName"/>
			</div>
			
			<div id="membersDetail_text">
				<s:text name="front.ow.phone.teamIntroduction"/>
			</div>
			<!-- 筛选条件start -->
			<form id="membersDetail_filter_form">
				<div id="membersDetail_filter">
				 
					<%-- <div class="membersFiler_Items">
						<div class="membersFilterName">
							<a href="#">性别</a>
							<span class="status">▲</span>
						</div>
						<div class="membersFilterConditionDiv">
							<div class="membersFilterConditions">
								
								<input onClick="loadMembersData()" type="checkbox" class="membersCheckBox" checked name="eqSex" value="男"  id="man" />
									
								<label for="man">男性</label>
							</div>
							<div class="membersFilterConditions">
								
								<input onClick="loadMembersData()" type="checkbox" class="membersCheckBox" checked name="eqSex" value="女" id="woman" />
								<label for="woman">女性</label>
								
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
	<div id="membersDisplay_right">
		<ul id="membersUl">
			
			<%-- <li class="membersLi" onClick="javascript:toView('view_membersDetail','right','view_membersDisplay',loadMembersDetailView({}))">
				<img class="membersLiImg"  
						src="<c:url value='/front/officialwebsite/imgslib/bg/pic01.png'/>" />
				<div class="membersLiModel eye"></div>
			</li> --%>
		</ul>
	</div>
	<!-- 右边end -->
</div>
<!-- 成员 end -->