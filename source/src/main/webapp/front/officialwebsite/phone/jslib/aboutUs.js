//轮播
var calousel = undefined;
var calouselItems = undefined;
//轮播展示的图片
var diplayPics = undefined;
//轮播展示的文字
var diplayFonts = undefined;
//diplayFonts距离top的比例
var diplayFontsTopScale = 0.4;
/*//记录下diplayFonts的字体大小
var maxCarousleFontSize = undefined;
var minCarousleFontSize = undefined;*/
//轮播循环器
var calouselTimer = undefined;
//轮播图片切换间隔
var calouselChangeTime = 8000;
//轮播图片切换用时，小于等于calouselChangeTime
var toNextCarouselUseTime = 3000;
//轮播缩小比例
var carouselScale = 0.6;
//轮播使用的数据
var carouselPicMinLeft = undefined;
var carouselPicMinTop = undefined;
var carouselPicMinWidth = undefined;
var carouselPicMinHeight = undefined;
var contentWidth =  undefined;
var contentHeight =  undefined;
//轮播宽高比
var calouselWidthAndHeight = 0.5;
$(function(){
	/**初始化dom**/
	//不直接执行loadAboutUsDisplayView，而是执行toView，然后回调不直接执行loadAboutUsDisplayView，为的是显示加载界面
	toView('view_aboutUs','right','view_aboutUs','loadAboutUsDisplayView()');
	/*loadAboutUsDisplayView();*/
	
	//监听浏览器尺寸变化，解决浏览器尺寸变化时，页面出现变形
	$(window).resize(function(){
		
		
		//调用fun，调整界面
		setAboutUsUI();
		//重新开始轮播
		startCarousel();
	});
	
});
function initAboutUsDom(){
	//更新节点
	calouselItems = $('.carouselItems');
	diplayPics = $('.diplayPics');
	diplayFonts = $('.diplayFonts');
	calousel = $('#calousel');
	calouselItems = $('.carouselItems');
	diplayPics = $('.diplayPics');
	diplayFonts = $('.diplayFonts');
	
}

/**
 * 设置界面布局
 */
function setAboutUsUI(){
	initCarouselParams();
	//设置轮播的高度
	calousel.height(contentHeight);
	
	
}
/**
 * 初始化轮播的参数，布局
 */

function initCarouselParams(){
	//设置轮播参数
	contentWidth = content.width();
	contentHeight = contentWidth*calouselWidthAndHeight;
	//轮播图片的默认位置，大小
	carouselPicMinLeft = (contentWidth-contentWidth*carouselScale)/2;
	carouselPicMinTop = (contentHeight-contentHeight*carouselScale)/2;
	carouselPicMinWidth = contentWidth*carouselScale;
	carouselPicMinHeight = contentHeight*carouselScale;
	
	//设置所有轮播属性,边距为0，宽高位全部；将所有的轮播移到最右部
	calouselItems.css('left',contentWidth);
	calouselItems.css('top',"0px");
	calouselItems.width(contentWidth);
	calouselItems.height(contentHeight);
	calouselItems.hide();
	//设置图片属性
	setAbsolute(diplayPics);
	diplayPics.width(carouselPicMinWidth);
	diplayPics.height(carouselPicMinHeight);
	diplayPics.css("top",carouselPicMinTop);
	diplayPics.css("left",carouselPicMinLeft);
	diplayPics.hide();
	//设置文字属性
	diplayFonts.hide();
	
	//设置轮播文字位置
	setAbsolute(diplayFonts);
	diplayFonts.css('left','0px');
	diplayFonts.css('top',calousel.height()*diplayFontsTopScale);
}
/**
 * 开始轮播
 */
function startCarousel(){

	//清除旧的轮播
	clearCarousel();
	/**
	 * 初始化轮播的参数，布局，调整轮播（当用户调整窗口大小时调用）
	 */
	initCarouselParams();
	/**
	 * 设置默认显示的第一张轮播
	 */
	//默认展示第一张轮播
	calouselItems.eq(0).css('left',"0px");
	diplayFonts.eq(0).show();
	currtCarouselIndex = 0;
	//默认显示第一张轮播图片
	diplayPics.eq(0).width(contentWidth);
	diplayPics.eq(0).height(contentHeight);
	diplayPics.eq(0).css("top","0px");
	diplayPics.eq(0).css("left","0px");
	diplayPics.eq(0).show();
	
	//默认的轮播为id为carousel 下的第一个div
	calouselItems.eq(0).show();
	
	

	/**
	 * 设置循环，正式执行轮播
	 */
	var index = 0;
	calouselTimer = setInterval(function (){
		index = executeCalousel(index);
	}, calouselChangeTime);
}
/**
 * 清除轮播
 */
function clearCarousel(){
	if(calouselTimer){
		//清除计时
		clearInterval(calouselTimer);
		//stop([clearQueue][,gotoEnd]);
		//结束动画
		calouselItems.stop(true,true);
		diplayPics.stop(true,true);
		diplayFonts.stop(true,true);
		//隐藏轮播
		/*calouselItems.hide();*/
		//重置
		calouselTimer = undefined;
	}

}
/**
 * 执行一次轮播
 */
function executeCalousel(index){
	/*c(index);*/
	//如果没有轮播，或则只有一张轮播，那么不执行
	if(calouselItems.length<=1){
		return 0;
	}
	//隐藏旧的轮播
	hideCarousel(calouselItems[index]);
	//例如diplayPics.length=4 ，那么index=3
	if(calouselItems.length-1==index){
		index = 0;
	}else{
		index ++;
	}
	//显示新的轮播
	showCarousel(calouselItems[index]);
	return index;
};
/**
 * 显示轮播
 */
function showCarousel(calouselItem){
	
	calouselItem =  $(calouselItem);
	//将轮播移到右边
	calouselItem.css("left",contentWidth);
	//获取图片文字
	var pic = calouselItem.find('.diplayPics');
	var font = calouselItem.find('.diplayFonts');
	//显示轮播
	calouselItem.show();
	//显示图片
	pic.show();
	//开始向左移出图片
	setTimeout(function(){
		
		calouselItem.animate({
			left :"0px"
		},toNextCarouselUseTime/3);
		
	}, toNextCarouselUseTime/3*1);
	//放大
	setTimeout(function(){
		//图片放大
		pic.animate({
			left :'0px',
			top :'0px',
			width:contentWidth,
			height:contentHeight,
		},toNextCarouselUseTime/3);
		
		
	}, toNextCarouselUseTime/3*2);
	
	//放大完毕，显示字体
	setTimeout(function(){

		//显示字体
		font.show();
	}, toNextCarouselUseTime/3*3);
	
	
	
};
/**
 * 隐藏轮播
 */
function hideCarousel(calouselItem){
	calouselItem =  $(calouselItem);
	//获取图片文字
	var pic = calouselItem.find('.diplayPics');
	var font = calouselItem.find('.diplayFonts');
	//隐藏文字
	font.hide();
	
	//图片缩小
	pic.animate({
		left :carouselPicMinLeft,
		top :carouselPicMinTop,
		width:carouselPicMinWidth,
		height:carouselPicMinHeight,
	},toNextCarouselUseTime/3);
	
	//移出
	setTimeout(function(){
		calouselItem.animate({
			left :"-="+(contentWidth)
		},toNextCarouselUseTime/3);
		
	}, toNextCarouselUseTime/3);
	
	//移除后，隐藏轮播
	setTimeout(function(){
		
		calouselItem.hide();
	}, toNextCarouselUseTime/3*2);
};

/**
 * 加载数据，设置ui，开始轮播
 */
function loadAboutUsData(){
	//初始化节点
	initAboutUsDom();
	//清空信息
	calousel.html("");
	//停止轮播
	clearCarousel();
	
	
	//发送请求
	zkAjax(NAMESPACE_OW_FRONT+'/aboutUsFrontAction!getCarousels.action',function(data,success){
		if(success&&data.success){
			var rows = data.rows;
			for(var index = 0;index<rows.length;index++){
				var row = rows[index];
				//生成节点
				var carouselItem = $("<div class='carouselItems'></div>");
				var diplayPic = $("<img class='diplayPics' src='"+getWebProjectName()+NAMESPACE_OW_FRONT+"/aboutUsFrontAction!getCarouselByImgName.action?imgName="+row.imgName+"'/>");
				var diplayFont = $("<div class='diplayFonts'>"+row.introduction+"</div>");
				//添加节点
				carouselItem.append(diplayPic);
				carouselItem.append(diplayFont);
				calousel.append(carouselItem);
			}

			
			//初始化dom
			initAboutUsDom();
			//设置界面布局
			setAboutUsUI();
			//开始轮播
			startCarousel();
			
		}
		
	},false);
}

/**
 * 显示页面前调用
 */
function loadAboutUsDisplayView(){
	//加载数据，开始其他的操作：例如设置ui，开始轮播等
	loadAboutUsData();
	//加载新闻导航的信息
	loadNewsNavData();
	//加载新闻导航信息
	loadServiceNavData();
}