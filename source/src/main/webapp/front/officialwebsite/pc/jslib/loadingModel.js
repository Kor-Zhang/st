
//加载页面
var loadingModel = undefined;
//等待文字dom
var loadFont = undefined;
//等待文字dom当前内容
var loadFontCurrtContent = undefined;
//等待文字dom原始内容
var loadFontOldContent = undefined;
//.
var loadFontPoint = ".";
//加载一个.的时间
var loadAPointTime = 100;
//等待文字的.长度
var loadFontPointNumber = 6;
//是否打开了加载页面的标志
var loadingModelStatus = 0;
$(function(){
	initLoadingModelDom();
	setLoadingModelListener();
	setLoadingModelUI();
	
	//监听浏览器尺寸变化，解决浏览器尺寸变化时，页面出现变形
	$(window).resize(function(){
		//调用fun，调整界面
		setLoadingModelUI();
	});
});
/**
 * 初始化dom
 */
function initLoadingModelDom(){
	/****初始化dom****/
	
	loadingModel = $('#loadingModel').show();
	loadFont = $("#loadFont");
	loadFontCurrtContent = loadFont.html();
	loadFontOldContent = loadFontCurrtContent;
}
/**
 * 设置界面
 */
function setLoadingModelUI(){
	loadingModel.css('padding-top',html.height()/2);
	
	
	//设置加载界面的文字加载
	loadFontCurrtContent = loadFontCurrtContent+loadFontPoint;
	loadFont.html(loadFontCurrtContent);
	setInterval(function(){
		if(loadFontCurrtContent.length-loadFontOldContent.length>loadFontPointNumber){
			loadFontCurrtContent = loadFontOldContent;
		}else{
			loadFontCurrtContent = loadFontCurrtContent+loadFontPoint;
		}
		loadFont.html(loadFontCurrtContent);
	}, loadAPointTime);
	
}

/**
 * 设置监听器
 */
function setLoadingModelListener(){
	
}


/************************加载界面的显示，隐藏方法*********************/
/**
 * 是否打开了加载页面
 * @returns {Number}
 */
function isPop(){
	return loadingModelStatus;
}
/**
 * 修改加载界面的状态
 */
function setPopStatus(){
	loadingModelStatus = 1;
}
function setPushStatus(){
	loadingModelStatus = 0;
}
/**
 *  显示加载界面
 * @param outTime：显示过程的耗时
 * @param callFun：回调函数
 * @param callFunWaitTime：回调函数等待时间
 */
function showLoadingModel(inTime,callFun,callFunWaitTime){
	//如果加载界面已经打开，直接执行回调函数
	if(isPop()){
		executeCallFun(callFun,0);
		return;
	}
	//修改加载界面存在状态
	setPopStatus();
	//执行界面显示
	var realInTime = 500;
	if(inTime!=undefined){
		realInTime = inTime;
	}
	loadingModel.show(realInTime);
	//执行加载界面显示后的回调函数
	executeCallFun(callFun,callFunWaitTime);
}
/**
 * 执行显示加载界面后的回调函数
 * @param callFun：回调方法
 * @param callFunWaitTime：回调函数执行前的等待时间
 */
function executeCallFun(callFun,callFunWaitTime){
	//实现延时回调；寡人也不知为何，
	//如果不延时，360browser和谷歌浏览器将不会显示这个等待界面；
	//分析可能是这个界面的加载需要的资源比较多，耗时比较大，需要给出足够的加载时间
	var realCallFunWaitTime = 10;
	if(callFunWaitTime!=undefined){
		realCallFunWaitTime = callFunWaitTime;
	}
	if(callFun!=undefined){
		
		setTimeout(callFun, realCallFunWaitTime);
	}
}
/**
 * 隐藏加载界面
 * @param outTime
 */
function hideLoadingModel(outTime){

	//修改加载界面存在状态
	setPushStatus();
	//执行界面隐藏
	var realOutTime = 500;
	if(outTime!=undefined){
		realOutTime = outTime;
	}
	loadingModel.hide(realOutTime);
}

