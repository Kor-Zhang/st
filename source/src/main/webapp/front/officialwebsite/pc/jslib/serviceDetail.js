



/**************************newDetail命名空间******************/
//注册命名空间
var serviceDetailNamespace = window.NameSpace || {};
//声明各种变量函数
serviceDetailNamespace.a = function(){
	
};




/*****************************声明变量*************************/
var serviceDetail = undefined;
//右部
var serviceDetail_right = undefined;
//左部
var serviceDetail_left = undefined;
//业务图片列表的ul对象
var serviceImgUl = undefined;
//业务图片列表的li对象
var serviceImgLi = undefined;
//业务图片的外边据
var serviceImgMargin = 3;
//业务图片的个数
var serviceImgNumber = 8;
//li对象中的img对像
var serviceImgLiImg = undefined;
//li对象中中的漠版
var serviceImgLiModel = undefined;
//图片展示区域
var serviceDetail_serviceImgDisplay = undefined;
//图片展示
var serviceDisplayImg = undefined;
//展示图片切换时间间隔
var newDisplyaImgChangeTime = 500;

//eys切出现/消失期间用的时间
var eyeInOutTime = 0;

var serviceDetail_serviceImgList = undefined;
//当前被选择的展示的图片的对象
var currtSelectDisplayserviceImgLi = undefined;
var selectDisplayserviceImgLibg = 'black';
var unSelectDisplayserviceImgLibg = '';

 var serviceDetail_content = undefined;
 
 var serviceNextPage = undefined;
 var servicePrePage = undefined;
/*************延时加载***********/
$(function($){
	/**初始化dom**/
	initServiceDetailDom();
	
	//监听浏览器尺寸变化，解决浏览器尺寸变化时，页面出现变形
	$(window).resize(function(){
		//调用fun，调整界面
		setServiceDetailUI();
	});

	
});
/**
 * 初始化dom
 */
function initServiceDetailDom(){
	serviceDetail = $('#serviceDetail');
	serviceDetail_right = $('#serviceDetail_right');
	serviceDetail_left = $('#serviceDetail_left');
	serviceImgUl = $('#serviceImgUl');
	serviceImgLi = $('.serviceImgLi');
	serviceImgLiImg = $('.serviceImgLiImg');
	serviceImgLiModel = $('.serviceImgLiModel');
	serviceDetail_serviceImgDisplay = $('#serviceDetail_serviceImgDisplay');
	serviceDisplayImg = $('#serviceDisplayImg');
	serviceDetail_serviceImgList = $('#serviceDetail_serviceImgList');
	
	serviceDetail_content = $("#serviceDetail_content");
	serviceNextPage =  serviceDetail.find("#nextPage");
	servicePrePage =  serviceDetail.find("#prePage");
}
/**
 * 设置监听事件
 */
function setServiceDetailLiteners(){
	c(1);
	//业务图片列表的悬浮事件
	//显示、隐藏eye
	serviceImgLi.unbind('hover');
	serviceImgLi.hover(function(){
		var temp = $(this);
		temp.find('.serviceImgLiModel').fadeIn(eyeInOutTime);
	},function(){
		var temp = $(this);
		temp.find('.serviceImgLiModel').fadeOut(eyeInOutTime);
	});
	

	//业务图片列表的点击事件
	serviceImgLi.unbind('click');
	serviceImgLi.click(function(){
		//点击显示图片
		//获取需要展示的图片的src
		var temp = $(this);
		var src = temp.find('.serviceImgLiImg').attr('src');
		//切换显示新图片
		serviceDisplayImg.fadeTo(newDisplyaImgChangeTime,0.2,function(){
			serviceDisplayImg.attr('src',src);
			serviceDisplayImg.fadeTo(newDisplyaImgChangeTime,1.0);
		});
		if(currtSelectDisplayserviceImgLi){
			currtSelectDisplayserviceImgLi.css('background',unSelectDisplayserviceImgLibg);
			
		}
		//替换就图片
		currtSelectDisplayserviceImgLi = temp;
		//获取未被选择的背景颜色
		if(unSelectDisplayserviceImgLibg){
			unSelectDisplayserviceImgLibg = currtSelectDisplayserviceImgLi.css('background');
		}
		//设置被选泽的背景颜色
		currtSelectDisplayserviceImgLi.css('background',selectDisplayserviceImgLibg);
		
		
	});
	
	

    //用于记录进入业务图片列表的起始x坐标
	var startX = 0;
	//开始移动的x坐标
	
	//滑动比例
	var bili = serviceImgUl.width()/serviceDetail_serviceImgList.width();
	
    var minX = serviceDetail_serviceImgList.get(0).offsetLeft;
    var maxX = minX + serviceDetail_serviceImgList.get(0).offsetWidth;
	serviceDetail_serviceImgList.bind('mouseenter',function(e){
		if(startX==0){
			

			//记录起始位置
			startX = e.clientX;
			var move = (startX-minX)*bili-(startX-minX);
			
			serviceImgUl.animate({
				left:"-"+move
			},100);
			
			
		}
	});
	serviceDetail_serviceImgList.bind('mouseleave',function(e){
		//记录起始位置
		startX = 0;
		/*serviceImgUl.animate({
    		left:'0px'
		});*/
	});
	serviceDetail_serviceImgList.bind('mouseover',function(e){
		 //获取当前的鼠标坐标
	    var currtX =e.clientX;
	    var currtY =e.clientY;
	    //获取列表的区域
		var div = serviceDetail_serviceImgList.get(0);
	    var x1 = div.offsetLeft;
	    var y1 = div.offsetTop;
	    var x2 = div.offsetLeft + div.offsetWidth;
	    var y2 = div.offsetTop + div.offsetHeight;
	    
	    if(currtX>=x1 && currtX<=x2 ){
	    	 //记录起始位置
			var move = (currtX-minX)*bili-(currtX-minX);
			serviceImgUl.animate({
				left:"-"+move
			},1);
	    }
	   
	});
}

/**
 * 设置界面布局
 */
function setServiceDetailUI(){
	
	
	/**设置每个图片列表的宽高**/
	//获得每张图片的宽度
	var liWidth = serviceDetail_right.width()/serviceImgNumber;
	var liHeight =  liWidth;
	
	
	serviceImgLi.width(liWidth);
	serviceImgLi.height(liHeight);
	
	serviceImgLiImg.width(liWidth-2*serviceImgMargin);
	serviceImgLiImg.height(liHeight-2*serviceImgMargin);
	
	/**设置业务图片列表div高度 和 图片展示区域高度（用8个业务图片的宽度决定了整个“右部”的布局）**/
	serviceImgUl.height(liHeight);
	//设置ul的宽
	serviceImgUl.width(serviceImgLi.length*liWidth);
	//业务图片展示列表回退到最左边
	serviceImgUl.animate({
		left:'0px'
	});
	//右部的下部
	serviceDetail_serviceImgList.height(liHeight);
	//右部的上部
	serviceDetail_serviceImgDisplay.height(serviceDetail_right.height()-serviceImgUl.height());
	
	
	/**设置每个图片列表中的图片的边距**/
	serviceImgLiImg.css('margin-left',serviceImgMargin);
	serviceImgLiImg.css('margin-top',serviceImgMargin);
	serviceImgLiImg.css('margin-right',serviceImgMargin);
	serviceImgLiImg.css('margin-bottom',serviceImgMargin);
	
	/**设置每个展示图片的模糊面板**/
	serviceImgLiModel.width(serviceImgLiImg.width());
	serviceImgLiModel.height(serviceImgLiImg.height());
	
	serviceImgLiModel.css('margin-left',serviceImgMargin);
	serviceImgLiModel.css('margin-top',serviceImgMargin);
	serviceImgLiModel.css('margin-right',serviceImgMargin);
	serviceImgLiModel.css('margin-bottom',serviceImgMargin);
	
	
}
/**
 * 默认设置
 */
function defaultServiceDetailDom(){
	
	//默认隐藏
	serviceImgLiModel.hide();
	
	//设置展示图片的默认显示
	currtSelectDisplayserviceImgLi = serviceImgLi.eq(0);
	currtSelectDisplayserviceImgLi.css('background',selectDisplayserviceImgLibg);
	var src = currtSelectDisplayserviceImgLi.find('img').attr('src');
	serviceDisplayImg.attr('src',src);
}
/**
 * 功能性方法
 */
function setFun(){
	
}

/**
 * 加载页面数据
 */
function loadServiceDetailData(params){			

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
	zkAjax(NAMESPACE_OW_FRONT+'/serviceFrontAction!getServiceById.action?id='+id,function(data,success){
		if(success&&data.success){
			var obj = data.obj;
			//加载文本信息，不添加任何效果
			loadLableValue(serviceDetail_content,obj,"未知");
			
			//设置上一页，下一页按钮
			if(nextId){
				serviceNextPage.attr('onClick',"toView('view_serviceDetail','right','view_serviceDisplay','loadServiceDetailView({\"id\":\""+nextId+"\",\"ids\":\""+ids+"\"})')");
			}else{
				//显示提示窗口
				serviceNextPage.attr('onClick',"popMsg(undefined,'"+struts2_info_lastPage+"');");
			}
			
			if(preId){
				servicePrePage.attr('onClick',"toView('view_serviceDetail','right','view_serviceDisplay','loadServiceDetailView({\"id\":\""+preId+"\",\"ids\":\""+ids+"\"})')");
			}else{
				//显示提示窗口
				servicePrePage.attr('onClick',"popMsg(undefined,'"+struts2_info_firstPage+"');");
			}

		}
		
	},false);
}
/**
 * 加载图片
 */
function loadServiceDetailImgData(params ){
	//清空图片列表
	serviceImgUl.html("");
	var infoId = params.id;
	zkAjax(NAMESPACE_OW_FRONT+"/imgsAndInfoFrontAction!getImgsByInfoId.action?infoId="+infoId,function(data,success){
		if(success&&data.success){
			/*<li class="serviceImgLi">
				<img class="serviceImgLiImg"  
					src="<c:url value='/front/officialwebsite/imgslib/bg/pic01.png'/>" />
				<div class="serviceImgLiModel eye"></div>
			</li>*/
			var rows = data.rows;
			//判断有无图片
			if(rows.length==0){
				//没有图片，设置默认图片
				rows = [{"imgName":"default.png"}];
				
			}
			for (var index = 0; index < rows.length; index++) {
				var r = rows[index];
				var imgName = r.imgName;
				var serviceImgLi = $("<li class='serviceImgLi'></li>");
				var img = $("<img class='serviceImgLiImg' src='"+getWebProjectName()+NAMESPACE_OW_FRONT+"/imgsAndInfoFrontAction!getServiceImgByImgName.action?imgName="+imgName+"'/>");
				var serviceImgLiModel = $("<div class='serviceImgLiModel eye'></div>");
				
				
				serviceImgLi.append(img);
				serviceImgLi.append(serviceImgLiModel);
				serviceImgUl.append(serviceImgLi);
			}
		}
	},false);
	//初始化dom
	initServiceDetailDom();
	//设置界面
	setServiceDetailUI();

	//监听事件
	setServiceDetailLiteners();
	//默认设置
	defaultServiceDetailDom();
}
/**
 * 切换到该视图之前，执行的回调函数
 */
function loadServiceDetailView(params){
	
	

	//初始化dom
	initServiceDetailDom();
	//加载远程数据
	loadServiceDetailData(params);
	//加载本记录的所有图片
	loadServiceDetailImgData(params);
	//设置界面
	setServiceDetailUI();
	//监听事件
	setServiceDetailLiteners();
	//其他方法
	setFun();
}

