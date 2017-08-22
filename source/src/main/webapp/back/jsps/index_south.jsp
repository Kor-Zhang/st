<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="text-align: center">
	<div style="display: inline-block;margin-left: 120px;">
		版权所有 © 2016 幸福假日.筑梦ST工作室
	</div>
	<!-- 时间 -->
	<div id="admins_index_south_currtTime" style="float:right;margin-right: 20px;">
		<!-- 显示时间区域 -->
	</div>
</div>

<script type="text/javascript">
	var currtTimer = undefined;
	var currtTime = undefined;
	$(function($){
		currtTimer = $('#admins_index_south_currtTime');
		//设置当前时间
		zkAjax("/adminsSrcAction!getCurrtTime.action",function(data){
			var currtTime = data.currtTime;
			currtTimer.html(new Date(currtTime).toLocaleString());
			setInterval(function(){
				currtTimer.html(new Date(currtTime+=1000).toLocaleString());
			}, 1000);
		});
	});
</script>