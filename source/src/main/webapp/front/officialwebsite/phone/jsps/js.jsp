<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	/* 该jsp页面用于转化相关信息,供js使用 */
	var struts2_info_tip = "<s:text name='front.ow.phone.tip'/>";
	var struts2_info_linkServerError = "<s:text name='front.ow.phone.linkServerError'/>";
	var struts2_info_lastPage = "<s:text name='front.ow.phone.lastPage'></s:text>";
	var struts2_info_firstPage = "<s:text name='front.ow.phone.lastPage'></s:text>";
	
	//当前用户选择的语言
	var userLang = "${session.userLang}";
</script>