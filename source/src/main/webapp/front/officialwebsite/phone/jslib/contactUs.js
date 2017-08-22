var contactUsInputs = undefined;
var contactUs_advice_left = undefined;
var contactUs_advice_right = undefined;
var contactUsTextarea = undefined;
var contactUS_form = undefined;
$(function($){
	
	//必须初始化；不然监听窗口变化时，调整dom会跑出异常
	initContactUsDom();
	
	//监听浏览器尺寸变化，解决浏览器尺寸变化时，页面出现变形
	$(window).resize(function(){
		//调用fun，调整界面
		setContactUsUI();
	});
	
});
/**
 * 设置默认
 */
function defaultContactUsDom(){
	contactUS_form.find("input[type='text']").val("");
	contactUS_form.find("textarea").html("");
	contactUS_form.find("textarea").val("");
}
/**
 * 初始化dom
 */
function initContactUsDom(){
	contactUS_form = $('#contactUS_form');
	contactUsInputs = $('#contactUs_advice_left>input');
	contactUs_advice_left = $('#contactUs_advice_left');
	contactUs_advice_right = $('#contactUs_advice_right');
	contactUsTextarea = $('#contactUs_advice_right>textarea');
}
/**
 * 设置监听事件
 */
function setContactUsListners(){
	
	
}
/**
 * 设置界面
 */
function setContactUsUI(){
	/**设置textarea的高**/
	/*var height = contactUsInputs.length*contactUsInputs.height()+contactUsInputs.height()*(contactUsInputs.length-1);
	contactUsTextarea.height(height);*/
}

/**
 * 加载页面，在切换到该页面之前调用
 */
function loadContactUsView(params){
	//初始化页面dom
	initContactUsDom();
	//设置界面
	setContactUsUI();
	//设置监听事件
	setContactUsListners();
	//设置默认
	defaultContactUsDom();
		
}


/**
 * 提交意见，建议
 */
function submitContactUs(){
	
	//开始等待界面
	showLoadingModel(0,function(){

		//延时加载在信息，关闭等待界面
		
		
		//获取数据
		var formData = serializeObject(contactUS_form);
		//发送请求
		zkAjaxData(NAMESPACE_OW_FRONT+'/contactUsFrontAction!addContactUs.action',formData,function(data,success){
			//如果请求成功
			if(success){
				if(data.success){
					//如果成功，清空填写的信息
					contactUS_form.find("input[type='text']").val("");
					contactUS_form.find("textarea").html("");
					contactUS_form.find("textarea").val("");
				}
				popMsg(undefined, data.msg, 0);
				hideLoadingModel(0);
			}
			
			
			
		},false);
	},500);
	
}