
//消息页面
var msgModel = undefined;
var msgModelTitle = undefined;
var msgModelMsg = undefined;
$(function($){
	initMsgModelDom();
	setMsgModelUI();
	setMsgModelListener();
	//监听浏览器尺寸变化，解决浏览器尺寸变化时，页面出现变形
	$(window).resize(function(){
		//调用fun，调整界面
		setMsgModelUI();
	});
});
/**
 * 设置界面
 */
function setMsgModelUI(){
	//设置信息显示位置
	var titleHeight = msgModelTitle.height();
	var msgHeight = msgModelMsg.height();
	var msgPaddingTop = msgModel.css('padding-top');
	var tHeight = titleHeight+msgHeight+msgPaddingTop;
	msgModel.css('padding-top',html.height()/2-tHeight/2);
	
}
/**
 * 初始化dom
 */
function initMsgModelDom(){
	/****初始化dom****/
	msgModel = $('#msgModel');
	msgModelTitle = msgModel.find("#title");
	msgModelMsg = msgModel.find("#msg");
}


/**
 * 设置监听器
 */
function setMsgModelListener(){
	
}
/*********消息页面的方法***********/

/**
 * 弹出消息框
 */
function popMsg(title,msg,inTime){
	if(msg==""){
		
		return;
	}
	if(!title){
		title = struts2_info_tip;
	}
	if(!msg){
		msg = struts2_info_linkServerError;
	}
	msgModelTitle.html(title);
	msgModelMsg.html(msg);
	
	
	var realInTime = 500;
	if(inTime!=undefined){
		realInTime = inTime;
	}
	msgModel.fadeIn(realInTime);
}
/**
 * 弹出消息框
 */
function pushMsg(outTime){
	var realOutTime = 500;
	if(outTime!=undefined){
		realOutTime = outTime;
	}
	msgModel.fadeOut(realOutTime);
}

/********触发事件*************/
/**
 * 点击关闭信息窗口
 */
function closeMsgModel(){
	pushMsg();
}