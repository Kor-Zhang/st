//底部新闻导航
var newsNav = undefined;
//新闻列表
var newsItemsList = undefined;
//“新闻”字样的提示
var newsTip = undefined;
//新闻导航栏展示的新闻列表
var newsItems = undefined;
var newsImg = undefined;
//是否可以关闭新闻导航
var canCloseNewsNav = 0;
//关闭新闻导航定时器
var closeNewsNavTimer = undefined;
//打开，关闭新闻导航的时间
var OpenCloseNewsNavTime = 1000;

//新闻图片的宽高比
var newImgWidthAndHeightScale = 0.5;

//鼠标进入，退出导航项目，项目激活状态耗时
var InOutNewsNavItemTime = 100;
$(function($){
	initNewsNavDom();
	

	//监听浏览器尺寸变化，解决浏览器尺寸变化时，页面出现变形
	$(window).resize(function(){
		//调用fun，调整界面
		setNewsNavUI();
	});
	
});

/**
 * 初始化dom
 **/
function initNewsNavDom(){
	newsNav = $('#newsNav');
	newsItemsList = $('#newsItemsList');
	newsTip = $('#newsTip');
	newsItems = $('.newsItems');
	newsImg = $('.newsImg');
	
}
/**
 * 设置界面
 */
function setNewsNavUI(){
	/*//设置新闻图片布局
	for(var index = 0;index<newsImg.length;index++){
		var temp = $(newsImg[index]);
		//设置大小
		temp.width(newsItems.width());
		temp.height(temp.width()*newImgWidthAndHeightScale);
		//设置内部的img
		temp.find('img').width(temp.width());
		temp.find('img').height(temp.height());
		temp.hide();
		//设置位置
		temp.css('left',index*newsItems.width());
		temp.css('top',"-"+(temp.height()+40)+"px");
	}*/
}
/**
 * 设置监听事件
 */
function setNewsNavListners(){
	
	/*//新闻导航的悬浮事件
	newsNav.unbind("hover");
	newsNav.hover(function(){
		//清空当前关闭的计时器
		if(closeNewsNavTimer){
			clearTimeout(closeNewsNavTimer);
			closeNewsNavTimer = undefined;
		}
		newsItemsList.animate({
			top:'0px'
		},200);
		//显示展示的新闻
		var index = 0;
		setInterval(function(){
			
			$(newsItems[index]).slideDown();
			index++;
		}, 50);
		
	},function(){

		//开始关闭计时
		closeNewsNavTimer = setTimeout(function(){
			
			//隐藏新闻导航
			newsItemsList.animate({
				top:newsNav.height()
			});
			//隐藏新闻展示项目
			newsItems.hide();
			//标志位不可以关闭
			canCloseNewsNav=0;
			
		}, OpenCloseNewsNavTime);
	});
	
	
	//展示新闻的悬浮事件
	newsItems.unbind("hover");
	newsItems.hover(function(){
		var t = $(this);
		
		t.find('*').animate({
			color:'white'
		},InOutNewsNavItemTime);
		t.animate({
			backgroundColor:'gray'
		},InOutNewsNavItemTime);
		//显示新闻图片
		t.find('.newsImg').show();
	},function(){
		var t = $(this);
		
		t.find('*').animate({
			color:'gray'
		},InOutNewsNavItemTime);
		t.animate({
			backgroundColor:'rgb(28,28,28)'
		},InOutNewsNavItemTime);

		//隐藏新闻图片
		t.find('.newsImg').hide();
	});*/
}
/**
 * 加载新闻导航的信息
 */
function loadNewsNavData(){
	newsItemsList.html("");
	//读取四条新闻
	zkAjax(NAMESPACE_OW_FRONT+'/newsFrontAction!getNews.action?page=1&rows=4&order=desc&sort=releaseTime',function(data,success){
		if(success&&data.success){
		/*	<a class="newsItems" href="javascript:toView('view_newsDetail','right','view_newsDisplay',beforeNewsDetailShow({'id':'asdasd','name':'asdad'}))">
				<span class="newsDate">19/7</span>
				<span title="这是第一新闻这是第一新闻这是第一新闻这是第一新闻这是第一新闻" class="newsTitle">这是第一新闻这是第一新闻这是第一新闻这是第一新闻这是第一新闻</span>
				<span class="newsImg">
					<img  
					src="<c:url value='/front/officialwebsite/imgslib/bg/pic02.png'/>" />
				</span>
			</a>*/
			var rows = data.rows;
			//记录下所有的id
			var ids = [];
			for(var i = 0;i<rows.length;i++){
				var r = rows[i];
				ids.push(r.id);
			}
			for (var index = 0; index < rows.length; index++) {
				var r = rows[index];
				/*var infoId = r.id;*/
				var newsItems = $("<a class='newsItems' href=javascript:void(0); onClick=toView('view_newsDetail','right','view_newsDisplay','loadNewsDetailView({\"id\":\""+r.id+"\",\"ids\":\""+ids+"\"})')></a>");
				//设置时间
				var t = formatDate(new Date(r.releaseTime).toLocaleDateString());
				var newsDate = $("<span class='newsDate'>"+t+"</span>");
				//获取title
				var title = r.title;
				if(title.length>=13){
					title = title.substring(0,13)+"...";
				}
				var newsTitle = $("<span title='"+r.title+"' class='newsTitle'>"+title+"</span>");
				/*var newsImg = $("<span class='newsImg'></span>");
				//储存新闻的imgname
				var imgName = undefined;
				//获取主要图片
				zkAjax(NAMESPACE_OW_FRONT+"/imgsAndInfoFrontAction!getMainImgByInfoId.action?infoId="+infoId,function(data,success){
					if(success&&data.success){
						imgName = data.obj.imgName;
					}
				},false);
				var img = $("<img src='"+getWebProjectName()+NAMESPACE_OW_FRONT+"/imgsAndInfoFrontAction!getNewsImgByImgName.action?imgName="+imgName+"'/>");
				
				//添加节点
				newsImg.append(img);
				newsItems.append(newsImg);
				*/
				newsItems.append(newsDate);
				newsItems.append(newsTitle);
				
				newsItemsList.append(newsItems);
				
			}
		}
	},false);

	initNewsNavDom();
	//设置界面
	setNewsNavUI();
	
	//设置监听事件
	setNewsNavListners();
}


