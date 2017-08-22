<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*"%>          
<%@taglib prefix="s" uri="/struts-tags"  %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="owTiele"/></title>

</head>
<body>
	<%
		//判断手机端还是电脑端
		String url = null;
		Enumeration typestr = request.getHeaderNames();
		String device = request.getHeader("user-agent");
		if (device.contains("Android")) {
			System.out.println("Android移动客户端");
			url = "/front/officialwebsite/phone/jsps/index.jsp";
		} else if (device.contains("iPhone")) {
			System.out.println("iPhone移动客户端");
			url = "/front/officialwebsite/phone/jsps/index.jsp";
		} else if (device.contains("iPad")) {
			System.out.println("iPad客户端");
			url = "/front/officialwebsite/pc/jsps/index.jsp";
		} else {
			System.out.println("其他客户端");
			url = "/front/officialwebsite/pc/jsps/index.jsp";
		}

		//转发到目标页面
		request.getRequestDispatcher(url).forward(request, response);
	%>
</body>
</html>
