



/**************************newDetail命名空间******************/
//注册命名空间
var membersDetailNamespace = window.NameSpace || {};
//声明各种变量函数
membersDetailNamespace.a = function(){
	
};




/*****************************声明变量*************************/
var membersDetail = undefined;
//右部
var membersDetail_right = undefined;
//左部
var membersDetail_left = undefined;
//新闻图片列表的ul对象
var membersImgUl = undefined;
//新闻图片列表的li对象
var membersImgLi = undefined;
//新闻图片的外边据
var membersImgMargin = 3;
//新闻图片的个数
var membersImgNumber = 8;
//li对象中的img对像
var membersImgLiImg = undefined;
//li对象中中的漠版
var membersImgLiModel = undefined;
//图片展示区域
var membersDetail_membersImgDisplay = undefined;
//图片展示
var membersDisplayImg = undefined;
//展示图片切换时间间隔
var newDisplyaImgChangeTime = 500;

//eys切出现/消失期间用的时间
var eyeInOutTime = 0;

var membersDetail_membersImgList = undefined;
//当前被选择的展示的图片的对象
var currtSelectDisplaymembersImgLi = undefined;
var selectDisplaymembersImgLibg = 'black';
var unSelectDisplaymembersImgLibg = '';

var membersDetail_content = undefined;
var membersNextPage = undefined;
var membersPrePage = undefined;
//当前成员id，上一个成员的id，下一个成员的id
var ids = undefined;
/*************延时加载***********/
$(function($){
	/**初始化dom**/
	
	//监听浏览器尺寸变化，解决浏览器尺寸变化时，页面出现变形
	$(window).resize(function(){
		//调用fun，调整界面
		setMembersDetailUI();
	});

	
});
/**
 * 初始化dom
 */
function initMembersDetailDom(){
	membersDetail = $('#membersDetail');
	membersDetail_right = $('#membersDetail_right');
	membersDetail_left = $('#membersDetail_left');
	membersImgUl = $('#membersImgUl');
	membersImgLi = $('.membersImgLi');
	membersImgLiImg = $('.membersImgLiImg');
	membersImgLiModel = $('.membersImgLiModel');
	membersDetail_membersImgDisplay = $('#membersDetail_membersImgDisplay');
	membersDisplayImg = $('#membersDisplayImg');
	membersDetail_membersImgList = $('#membersDetail_membersImgList');
	membersDetail_content = $('#membersDetail_content');
	membersNextPage = $("#membersDetail_changePage #nextPage>a");
	membersPrePage = $("#membersDetail_changePage #prePage>a");
}

/**
 * 切换到该视图之前，执行的回调函数
 */
function loadMembersDetailView(params){
	
		
	
	//初始化dom
	initMembersDetailDom();
	//加载远程数据
	loadMembersDetailData(params);
	//设置界面
	setMembersDetailUI();

	//监听事件
	setMembersDetailLiteners();
	//其他方法
	setFun();
	
}


/**
 * 加载页面数据
 */
function loadMembersDetailData(params){
	var id = params.id;
	ids = params.ids.split(",");
	//获取上一页，下一页的id
	var nextId = undefined;
	var preId = undefined;
	for(var index = 0;index<ids.length;index++){
		var currtId = ids[index];
		if(currtId==id){
			if(index!=ids.length-1){
				nextId = ids[index+1];
			}
			if(index!=0){

				preId = ids[index-1];
			}
			break;
		}
	}
	zkAjax(NAMESPACE_OW_FRONT+'/membersFrontAction!getMembersById.action?id='+id,function(data,success){
		if(success&&data.success){
			var obj = data.obj;
			//加载文本信息，不添加任何效果
			loadLableValue(membersDetail_content,obj,"未知");
			//加载头像，添加渐变效果
			membersDisplayImg.fadeOut(viewChangeTime/2);
			setTimeout(function(){
				membersDisplayImg.attr('src',getWebProjectName()+NAMESPACE_OW_FRONT+"/membersFrontAction!getMembersImgHead.action?head="+obj.head+"&t="+new Date().getTime());
				membersDisplayImg.fadeIn(viewChangeTime/2);
			}, viewChangeTime/2);
			//设置上一页，下一页按钮
			if(nextId){
				membersNextPage.attr('onClick',"toView('view_membersDetail','right','view_membersDisplay','loadMembersDetailView({\"id\":\""+nextId+"\",\"ids\":\""+ids+"\"})')");
			}else{
				//显示提示窗口
				membersNextPage.attr('onClick',"popMsg(undefined,'"+struts2_info_lastPage+"');");
			}
			
			if(preId){
				membersPrePage.attr('onClick',"toView('view_membersDetail','right','view_membersDisplay','loadMembersDetailView({\"id\":\""+preId+"\",\"ids\":\""+ids+"\"})')");
			}else{
				//显示提示窗口
				membersPrePage.attr('onClick',"popMsg(undefined,'"+struts2_info_firstPage+"');");
			}
			
		}
		
	},false);
}
/**
 * 设置监听事件
 */
function setMembersDetailLiteners(){
	
}


/**
 * 设置界面布局
 */
function setMembersDetailUI(){
	
	
	
}

/**
 * 功能性方法
 */
function setFun(){
	
}
