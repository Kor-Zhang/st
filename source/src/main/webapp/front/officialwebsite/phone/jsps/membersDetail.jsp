<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 成员详情 start -->
<div id="membersDetail">
	<!-- 左部div start -->
	<div id="membersDetail_left">
		
		<!-- 位置导航 start -->
		<div id="membersDetail_position">
			<span>◄</span>
			<span id="up"><a href="javascript:toView('view_membersDisplay','right','view_membersDisplay','')"><s:text name="front.ow.phone.view_membersDisplay"/></a></span>
			>
			<span id="now"><s:text name="front.ow.phone.membersDetail"/> </span>
		</div>
		<!-- 位置导航 end -->
		
		<!-- 翻页 start -->
		<div id="membersDetail_changePage">
			<span id="prePage">
			
				<<a href="javascript:void(0);"><s:text name="front.ow.phone.prePage"/></a>
			</span>
			<span id="nextPage">
			
				<a href="javascript:void(0);"><s:text name="front.ow.phone.nextPage"/></a>>
			</span>
			
		</div>
		<!-- 翻页 end -->
		<!-- 内容 start  -->
		<div id="membersDetail_content">
			
			<div id="membersDetail_name">
				<label>姓名：</label>
				<label name="name">未知</label>
			</div>
			<div>
				<label>职位：</label>
				<label name="position">未知</label>
			</div>
			<div>
				<label>生日：</label>
				<label name="birthday">未知</label>
			</div>
			<div>
				<label>年龄：</label>
				<label name="age">未知</label>
			</div>
			<div>
				<label>性别：</label>
				<label name="sex">未知</label>
			</div>
			<div>
				<label>国家：</label>
				<label name="nation">未知</label>
			</div>
			<div>
				<label>语言：</label>
				<label name ="language">未知</label>
			</div>
			<div>
				<label>信仰：</label>
				<label name ="faith">未知</label>
			</div>
			<div>
				<label>QQ：</label>
				<label name="qq">未知</label>
			</div>
			<div>
				<label>邮箱：</label>
				<label name="email">未知</label>
			</div>
			<div>
				<label>电话：</label>
				<label name="phone">未知</label>
			</div>
			<div>
				<label>加入日期：</label>
				<label name="joinTime">未知</label>
			</div>
			<div>
				<label>离职日期：</label>
				<label name="outTime">未知</label>
			</div>
			<div>
				<label>毕业学校：</label>
				<label name="lastGraduateSchool">未知</label>
			</div>
			<div>
				<label>成员状态：</label>
				<label name="membersStatus">未知</label>
			</div>
			<div>
				<label>备注：</label>
				<label name="note">无</label>
			</div>
			<div id="membersDetail_text">
				<label name="introduction">无</label>
			</div>
		</div>
		<!-- 内容 end  -->
		
	</div>
	<!-- 左部div end -->
	
	
	<!-- 右部div start -->
	<div id="membersDetail_right">
		<!-- 图片展示start -->
		<img id="membersDisplayImg" src="" />
		<!-- 图片展示end -->
	</div>
	<!-- 右部div end -->
</div>
<!-- 成员详情 end -->