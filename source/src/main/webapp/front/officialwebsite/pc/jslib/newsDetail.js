



/**************************newDetail命名空间******************/
//注册命名空间
var newsDetailNamespace = window.NameSpace || {};
//声明各种变量函数
newsDetailNamespace.a = function(){
	
};




/*****************************声明变量*************************/
var newsDetail = undefined;
//右部
var newsDetail_right = undefined;
//左部
var newsDetail_left = undefined;
//新闻图片列表的ul对象
var newsImgUl = undefined;
//新闻图片列表的li对象
var newsImgLi = undefined;
//新闻图片的外边据
var newsImgMargin = 3;
//新闻图片的个数
var newsImgNumber = 8;
//li对象中的img对像
var newsImgLiImg = undefined;
//li对象中中的漠版
var newsImgLiModel = undefined;
//图片展示区域
var newsDetail_newsImgDisplay = undefined;
//图片展示
var newsDisplayImg = undefined;
//展示图片切换时间间隔
var newDisplyaImgChangeTime = 500;

//eys切出现/消失期间用的时间
var eyeInOutTime = 0;

var newsDetail_newsImgList = undefined;
//当前被选择的展示的图片的对象
var currtSelectDisplaynewsImgLi = undefined;
var selectDisplaynewsImgLibg = 'black';
var unSelectDisplaynewsImgLibg = '';

 var newsDetail_content = undefined;
 
 var newsNextPage = undefined;
 var newsPrePage = undefined;
 
/*************延时加载***********/
$(function($){
	/**初始化dom**/
	initNewsDetailDom();
	
	//监听浏览器尺寸变化，解决浏览器尺寸变化时，页面出现变形
	$(window).resize(function(){
		//调用fun，调整界面
		setNewsDetailUI();
	});

	
});
/**
 * 初始化dom
 */
function initNewsDetailDom(){
	newsDetail = $('#newsDetail');
	newsDetail_right = $('#newsDetail_right');
	newsDetail_left = $('#newsDetail_left');
	newsImgUl = $('#newsImgUl');
	newsImgLi = $('.newsImgLi');
	newsImgLiImg = $('.newsImgLiImg');
	newsImgLiModel = $('.newsImgLiModel');
	newsDetail_newsImgDisplay = $('#newsDetail_newsImgDisplay');
	newsDisplayImg = $('#newsDisplayImg');
	newsDetail_newsImgList = $('#newsDetail_newsImgList');
	
	newsDetail_content = $("#newsDetail_content");
	newsNextPage =  newsDetail.find("#nextPage");
	newsPrePage =  newsDetail.find("#prePage");
}
/**
 * 设置监听事件
 */
function setNewsDetailLiteners(){
	//新闻图片列表的悬浮事件
	//显示、隐藏eye
	newsImgLi.unbind('hover');
	newsImgLi.hover(function(){
		var temp = $(this);
		temp.find('.newsImgLiModel').fadeIn(eyeInOutTime);
	},function(){
		var temp = $(this);
		temp.find('.newsImgLiModel').fadeOut(eyeInOutTime);
	});
	

	//新闻图片列表的点击事件
	newsImgLi.unbind('click');
	newsImgLi.click(function(){
		//点击显示图片
		//获取需要展示的图片的src
		var temp = $(this);
		var src = temp.find('.newsImgLiImg').attr('src');
		//切换显示新图片
		newsDisplayImg.fadeTo(newDisplyaImgChangeTime,0.2,function(){
			newsDisplayImg.attr('src',src);
			newsDisplayImg.fadeTo(newDisplyaImgChangeTime,1.0);
		});
		if(currtSelectDisplaynewsImgLi){
			currtSelectDisplaynewsImgLi.css('background',unSelectDisplaynewsImgLibg);
			
		}
		//替换就图片
		currtSelectDisplaynewsImgLi = temp;
		//获取未被选择的背景颜色
		if(unSelectDisplaynewsImgLibg){
			unSelectDisplaynewsImgLibg = currtSelectDisplaynewsImgLi.css('background');
		}
		//设置被选泽的背景颜色
		currtSelectDisplaynewsImgLi.css('background',selectDisplaynewsImgLibg);
		
		
	});
	
	

    //用于记录进入新闻图片列表的起始x坐标
	var startX = 0;
	//开始移动的x坐标
	
	//滑动比例
	var bili = newsImgUl.width()/newsDetail_newsImgList.width();
	
    var minX = newsDetail_newsImgList.get(0).offsetLeft;
    var maxX = minX + newsDetail_newsImgList.get(0).offsetWidth;
	newsDetail_newsImgList.bind('mouseenter',function(e){
		if(startX==0){
			

			//记录起始位置
			startX = e.clientX;
			var move = (startX-minX)*bili-(startX-minX);
			
			newsImgUl.animate({
				left:"-"+move
			},100);
			
			
		}
	});
	newsDetail_newsImgList.bind('mouseleave',function(e){
		//记录起始位置
		startX = 0;
		/*newsImgUl.animate({
    		left:'0px'
		});*/
	});
	newsDetail_newsImgList.bind('mouseover',function(e){
		 //获取当前的鼠标坐标
	    var currtX =e.clientX;
	    var currtY =e.clientY;
	    //获取列表的区域
		var div = newsDetail_newsImgList.get(0);
	    var x1 = div.offsetLeft;
	    var y1 = div.offsetTop;
	    var x2 = div.offsetLeft + div.offsetWidth;
	    var y2 = div.offsetTop + div.offsetHeight;
	    
	    if(currtX>=x1 && currtX<=x2 ){
	    	 //记录起始位置
			var move = (currtX-minX)*bili-(currtX-minX);
			newsImgUl.animate({
				left:"-"+move
			},1);
	    }
	   
	});
	
	
	
	
}

/**
 * 设置界面布局
 */
function setNewsDetailUI(){
	
	
	/**设置每个图片列表的宽高**/
	//获得每张图片的宽度
	var liWidth = newsDetail_right.width()/newsImgNumber;
	var liHeight =  liWidth;
	
	
	newsImgLi.width(liWidth);
	newsImgLi.height(liHeight);
	
	newsImgLiImg.width(liWidth-2*newsImgMargin);
	newsImgLiImg.height(liHeight-2*newsImgMargin);
	
	/**设置新闻图片列表div高度 和 图片展示区域高度（用8个新闻图片的宽度决定了整个“右部”的布局）**/
	newsImgUl.height(liHeight);
	//设置ul的宽
	newsImgUl.width(newsImgLi.length*liWidth);
	//新闻图片展示列表回退到最左边
	newsImgUl.animate({
		left:'0px'
	});
	//右部的下部
	newsDetail_newsImgList.height(liHeight);
	//右部的上部
	newsDetail_newsImgDisplay.height(newsDetail_right.height()-newsImgUl.height());
	
	
	/**设置每个图片列表中的图片的边距**/
	newsImgLiImg.css('margin-left',newsImgMargin);
	newsImgLiImg.css('margin-top',newsImgMargin);
	newsImgLiImg.css('margin-right',newsImgMargin);
	newsImgLiImg.css('margin-bottom',newsImgMargin);
	
	/**设置每个展示图片的模糊面板**/
	newsImgLiModel.width(newsImgLiImg.width());
	newsImgLiModel.height(newsImgLiImg.height());
	
	newsImgLiModel.css('margin-left',newsImgMargin);
	newsImgLiModel.css('margin-top',newsImgMargin);
	newsImgLiModel.css('margin-right',newsImgMargin);
	newsImgLiModel.css('margin-bottom',newsImgMargin);
	
	
}
/**
 * 默认设置
 */
function defaultNewsDetailDom(){
	
	//默认隐藏
	newsImgLiModel.hide();
	
	//设置展示图片的默认显示
	currtSelectDisplaynewsImgLi = newsImgLi.eq(0);
	currtSelectDisplaynewsImgLi.css('background',selectDisplaynewsImgLibg);
	var src = currtSelectDisplaynewsImgLi.find('img').attr('src');
	newsDisplayImg.attr('src',src);
}
/**
 * 功能性方法
 */
function setFun(){
	
}

/**
 * 加载页面数据
 */
function loadNewsDetailData(params){			

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
	zkAjax(NAMESPACE_OW_FRONT+'/newsFrontAction!getNewsById.action?id='+id,function(data,success){
		if(success&&data.success){
			var obj = data.obj;
			//加载文本信息，不添加任何效果
			loadLableValue(newsDetail_content,obj,"未知");
			
			//设置上一页，下一页按钮
			if(nextId){
				newsNextPage.attr('onClick',"toView('view_newsDetail','right','view_newsDisplay','loadNewsDetailView({\"id\":\""+nextId+"\",\"ids\":\""+ids+"\"})')");
			}else{
				//显示提示窗口
				newsNextPage.attr('onClick',"popMsg(undefined,'"+struts2_info_lastPage+"');");
			}
			
			if(preId){
				newsPrePage.attr('onClick',"toView('view_newsDetail','right','view_newsDisplay','loadNewsDetailView({\"id\":\""+preId+"\",\"ids\":\""+ids+"\"})')");
			}else{
				//显示提示窗口
				newsPrePage.attr('onClick',"popMsg(undefined,'"+struts2_info_firstPage+"');");
			}

		}
		
	},false);
}
/**
 * 加载图片
 */
function loadNewsDetailImgData(params ){
	//清空图片列表
	newsImgUl.html("");
	var infoId = params.id;
	zkAjax(NAMESPACE_OW_FRONT+"/imgsAndInfoFrontAction!getImgsByInfoId.action?infoId="+infoId,function(data,success){
		if(success&&data.success){
			/*<li class="newsImgLi">
				<img class="newsImgLiImg"  
					src="<c:url value='/front/officialwebsite/imgslib/bg/pic01.png'/>" />
				<div class="newsImgLiModel eye"></div>
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
				var newsImgLi = $("<li class='newsImgLi'></li>");
				var img = $("<img class='newsImgLiImg' src='"+getWebProjectName()+NAMESPACE_OW_FRONT+"/imgsAndInfoFrontAction!getNewsImgByImgName.action?imgName="+imgName+"'/>");
				var newsImgLiModel = $("<div class='newsImgLiModel eye'></div>");
				
				
				newsImgLi.append(img);
				newsImgLi.append(newsImgLiModel);
				newsImgUl.append(newsImgLi);
			}
		}
	},false);
	//初始化dom
	initNewsDetailDom();
	//设置界面
	setNewsDetailUI();

	//监听事件
	setNewsDetailLiteners();
	//默认设置
	defaultNewsDetailDom();
}
/**
 * 切换到该视图之前，执行的回调函数
 */
function loadNewsDetailView(params){
	
	

	//初始化dom
	initNewsDetailDom();
	//加载远程数据
	loadNewsDetailData(params);
	//加载本记录的所有图片
	loadNewsDetailImgData(params);
	//设置界面
	setNewsDetailUI();
	//监听事件
	setNewsDetailLiteners();
	//其他方法
	setFun();
}

