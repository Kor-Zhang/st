<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 联系我们 start -->
<div id="contactUs">
	<div id="contactUs_center">
		<div id="contactUs_title">
				 <s:text name="front.ow.pc.contactUs"></s:text>
		 </div>
		<div id="contactUs_address">
			<div id="contactUs_address_city">
				 <s:text name="front.ow.pc.teamAddress"></s:text>
			</div>
			<div id="contactUs_address_info">
				 <s:text name="front.ow.pc.teamDetailAddress"></s:text>
			</div>
		</div>
		
		<div id="contactUs_advice">
			<div id="contactUs_advice_tip">
				
				 <s:text name="front.ow.pc.adviceTip"></s:text>
			</div>
			
			<div id="contactUs_advice_content">
				<form id="contactUS_form">
					<div id="contactUs_advice_left">
						<input name="name" type="text" placeholder="<s:text name='front.ow.pc.youtName'></s:text>" autocomplete="off"/>
						<input name="orgName" type="text" placeholder="<s:text name='front.ow.pc.yourOrg'></s:text>" autocomplete="off"/>
						<input name="email" type="text" placeholder="<s:text name='front.ow.pc.email'></s:text>" autocomplete="off"/>
						<input name="phoneNumber" type="text" placeholder="<s:text name='front.ow.pc.phoneNumber'></s:text>" autocomplete="off"/>
					</div>
					<div id="contactUs_advice_right">
						<textarea name="msg" placeholder="<s:text name='front.ow.pc.yourMsg'></s:text>0/255"></textarea>
					</div>
					<div class="clear"></div>
				</form>
			</div>
			<div id="contactUs_advice_submitBtnDiv">
				<input id="contactUs_advice_submitBtn" onClick="submitContactUs();" value="<s:text name='front.ow.pc.adviceSubmit'></s:text>" type="button"/>
			</div>
		</div>
	</div>
</div>
<!-- 联系我们 end -->