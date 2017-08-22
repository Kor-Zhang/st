//div视图缩小比例
var divViewScale = 0.7;
var content = undefined;
var aboutUs = undefined;
//视图切换时间
var viewChangeTime = 555;
//视图切换的冻结时间（切换的间隔时间），viewChangeTime<=changeDivFrozenTime
var changeDivFrozenTime = viewChangeTime;
//等待图片显示的时间
var loadingTime = viewChangeTime;
//记录下每次开始切换的时间
var changeDivStartTime = 0;
//切换视图时的透明度
var changeViewOpacity = 0.5;
//切换视图的锁,当divViewChangeLock=0表示未上锁，可以切换，=1，表示上锁，不能切换
var divViewChangeLock = 0;
//当前的视图，默认为aboutUs
var currtViewId = undefined;
//当前正在显示的div视图
var currtDivView = undefined;


/*//视图动画延迟时间，calfunWaitTime必须大于viewAnimateWaitTime
var viewAnimateWaitTime = 10;*/

/*//回调方法内部的等待时间
var callfunWaitTime = 10;*/
$(function($){
	/****初始化dom****/
	content = $('#content');
	aboutUs = $('#aboutUs');
	
	//默认显示content中的第一个div视图
	currtDivView = $('#content>div').eq(0).show();
	currtViewId = currtDivView.attr('id');
	
	//设置用户界面尺寸，布局
	setUISize();
	//监听浏览器尺寸变化，解决浏览器尺寸变化时，页面出现变形
	$(window).resize(function(){
		//调用fun，调整界面
		setUISize();
	});
});


/**
 * 设置用户界面尺寸，布局
 */
function setUISize(){
	//设置content的高度（屏幕高度减去nav的高度）
	var htmlHeight = html.height();
	content.height(htmlHeight-nav.height());
	
}


/**
 * 根据新的div视图的的id，切换新旧div视图
 * @param newDivViewId ；需要切换到的新的视图的id
 * @param newNavItem ；需要点亮的导航栏文字
 * @param beforeFun ；视图切换之前执行的回调函数，含有一个json参数；注意，1.这里的回调函数是字符串，如果不加‘’，那么回调函数会自己执行；2.抛出异常可终止动画
 * @param afterFun ；视图切换之前执行的回调函数，含有一个json参数；注意，1.这里的回调函数是字符串，如果不加‘’，那么回调函数会自己执行；2.抛出异常不终止动画，因为这是所有动作完成后的最后回调函数
 * @param newDivViewFrom ；newDivViewFrom新的div从何处出现（left or right）
 */
function toView(newDivViewId,newDivViewFrom,newNavItem,beforeFun,afterFun){
	
	
	//暂时储存新选择，和旧的项目导航
	var oldSelectNavDom = currtSelectNavDom;
	var newSelectNavDom = $('a[navItem='+newNavItem+']');
	//先点亮新的项目导航
	activityNewsNavItem(newDivViewId, currtViewId, oldSelectNavDom,newSelectNavDom);
	//显示加载图片，然后执行回调方法，然后隐藏加载图片
	showLoadingModel(0,function(){
		//需要等待“显示加载图片，点亮新的项目”动作完成后，才能开始其他动作，不然，这两项动作会被快速跳过，无法进行
		c('切换到视图：'+newDivViewId+'，执行前的回调方法为：'+beforeFun);
		c('切换到视图：'+newDivViewId+'，执行后的回调方法为：'+afterFun);
		
		//获取现在时间，对用户快速重复点击同一项目进行限制
		var now = new Date().getTime();
		//判断冻结是否结束
		if(now-changeDivStartTime<=changeDivFrozenTime){
			return;
		}
		
		//记录开始时间
		changeDivStartTime = now;
		
		//获取content下的新的div视图
		var newDivView = content.children("#"+newDivViewId);
		if(newDivViewId!=currtViewId){
			//显示新的视图，为回调方法设置条件，（因为隐藏在最右边的div不能获取和设置宽度）
			newDivView.show();
			newDivView.css("left",content.width()-1);
		}
		
		try{
			//在执行之前做一些通用动作；比如清除轮播，不然会出现假面很不友好的情况；（目前能想到的比较合适方法）
			beforeExeDoSomething();
		}catch(e){
			
			failFun(e,newDivViewId,currtViewId,oldSelectNavDom,newSelectNavDom);
			return;
		}
		
		try{
			//执行动画前的回调方法
			eval(beforeFun);
		}catch(e){
			failFun(e,newDivViewId,currtViewId,oldSelectNavDom,newSelectNavDom);
			return;
		}
		c("回调函数理想结束点！");
		
		//延时隐藏加载图片，添加上了动画执行的时间，目的是防止用户在动画未执行完时，点击了新的项目
		setTimeout(function(){
			hideLoadingModel(0);
		}, loadingTime);

		
		//如果不是点击相同视图,那么执行切换动画
		if(newDivViewId!=currtViewId){
			//设置视图的显示未知，与newDivView.show();newDivView.css("left",content.width()-1);对应
			newDivView.css("left","0px");
			
			//执行切换动画
			executeToView(newDivView,newDivViewFrom);
			
			
		}

		//执行动画完成后的回调方法
		setTimeout(function(){
			try{
				
				//所有基本动作介绍后，记录新的项目导航
				currtSelectNavDom = $('a[navItem='+newNavItem+']');
				//执行最后的回调方法
				eval(afterFun);
				
			}catch(e){
				failFun(e,newDivViewId,currtViewId,oldSelectNavDom,newSelectNavDom);
				return;
			} 
			
			
		}, viewChangeTime);
	},undefined);
	
		
	
	
}

/**
 * 当回调方法失败：可能是连接服务器失败等原因
 */
function failFun(e,newDivViewId,currtViewId,oldSelectNavDom,newSelectNavDom){
	
	if(e){
		c("出现异常："+e.message); 
	}
	backOldNavItem(newDivViewId,currtViewId,oldSelectNavDom,newSelectNavDom);
	
}
/**
 * 点亮的新的项目导航
 */
function activityNewsNavItem(newDivViewId,currtViewId,oldSelectNavDom,newSelectNavDom){
	//判断是否点击的自己
	if(newDivViewId!=currtViewId){
		//根据navItem属性，点亮导航栏文字
		if(oldSelectNavDom){
			oldSelectNavDom.css('color',unSelectNavWordColor);
			
		}
		newSelectNavDom.css('color',selectNavWordColor);
	}
}
/**
 * 回退已经点亮的项目导航
 */
function backOldNavItem(newDivViewId,currtViewId,oldSelectNavDom,newSelectNavDom){
	if(newDivViewId!=currtViewId){
		//根据navItem属性，点亮导航栏文字
		if(oldSelectNavDom){
			oldSelectNavDom.css('color',selectNavWordColor);
		}
		newSelectNavDom.css('color',unSelectNavWordColor);
	}
	
}
/**
 * 在执行切换动作之前，执行一些其他通用动作；比如，国币轮播
 */
function beforeExeDoSomething(){
	//清除轮播的通用动作
	clearCarousel();
}



/**
 * 执行视图切换的动画,不对导航条的颜色等其他事项进行设置，不进行验证
 * newDivView：新的视图
 * newDivViewFrom ：新的视图从何出现
 */
function executeToView(newDivView,newDivViewFrom){
	
	newDivView = $(newDivView);
	//显示新的视图
	newDivView.show();
	
	/**
	 * 执行动画，left，right动作
	 */
	//如果需要新的div从右部出现
	if(newDivViewFrom=='right'){
		//如果存在旧的视图，那么隐藏
		if(currtDivView){
			//向左移动
			currtDivView.animate({
				left : '-'+content.width()
				
			},viewChangeTime);
			
			
		}

		
		//开始新的界面移出动画
		newDivView.css('left',content.width());
		newDivView.show();
		//新的div视图向左移出
		newDivView.animate({
			left :'0px'
			
		},viewChangeTime);
	}else if(newDivViewFrom=='left'){
		//如果需要新的div从左部出现
	
		//如果存在旧的视图，那么隐藏
		if(currtDivView){
			//向左移动
			currtDivView.animate({
				left : content.width()
				
			},viewChangeTime);
			
		}
		
		//开始新的界面移出动画
		setAbsolute(newDivView);
		newDivView.css('left','-'+content.width()+'px');
		//新的div视图向左移出
		newDivView.show();
		newDivView.animate({
			left :'0px'
			
		},viewChangeTime);
		
	}
	/**
	 * 动画执行过程中的其他动作
	 */
	//隐藏当前视图，防止新旧视图重叠干扰
	hideCurrtView(currtDivView,viewChangeTime);
	
	//记录当前的视图id
	currtViewId = newDivView.attr('id');
	//记录当前的视图
	currtDivView = newDivView;

}

/**
 * 隐藏当前视图，防止新旧视图重叠干扰
 */
function hideCurrtView(currtView,waitTime){
	var needHideView = currtView;
	if(needHideView){
		//隐藏旧的视图，防止新旧视图之间的干扰
		setTimeout(function(){
			needHideView.hide();
		}, waitTime);
	}
	
}

