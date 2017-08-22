<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 消息页面 start -->
<div id="msgModel">
	<div onClick="closeMsgModel();" id="closeBtn">X</div>
	<div id="title">
		<s:text name="front.ow.pc.tip"/>
	</div>
	<div id="msg">
		<s:text name="front.ow.pc.linkServerError"/>
	</div>
</div>
<!-- 消息页面 end -->
