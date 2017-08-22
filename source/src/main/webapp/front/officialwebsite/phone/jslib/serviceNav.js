//底部业务导航
var serviceNav = undefined;
//业务列表
var serviceItemsList = undefined;
//“业务”字样的提示
var serviceTip = undefined;
//业务导航栏展示的业务列表
var serviceItems = undefined;
var serviceImg = undefined;
//是否可以关闭业务导航
var canCloseServiceNav = 0;
//关闭业务导航定时器
var closeServiceNavTimer = undefined;
//打开，关闭业务导航的时间
var OpenCloseServiceNavTime = 1000;

//业务图片的宽高比
var newImgWidthAndHeightScale = 0.5;

//鼠标进入，退出导航项目，项目激活状态耗时
var InOutServiceNavItemTime = 100;
$(function($){
	initServiceNavDom();
	

	//监听浏览器尺寸变化，解决浏览器尺寸变化时，页面出现变形
	$(window).resize(function(){
		//调用fun，调整界面
		setServiceNavUI();
	});
	
});

/**
 * 初始化dom
 **/
function initServiceNavDom(){
	serviceNav = $('#serviceNav');
	serviceItemsList = $('#serviceItemsList');
	serviceTip = $('#serviceTip');
	serviceItems = $('.serviceItems');
	serviceImg = $('.serviceImg');
	
}
/**
 * 设置界面
 */
function setServiceNavUI(){
	/*//设置业务图片布局
	for(var index = 0;index<serviceImg.length;index++){
		var temp = $(serviceImg[index]);
		//设置大小
		temp.width(serviceItems.width());
		temp.height(temp.width()*newImgWidthAndHeightScale);
		//设置内部的img
		temp.find('img').width(temp.width());
		temp.find('img').height(temp.height());
		temp.hide();
		//设置位置
		temp.css('left',index*serviceItems.width());
		temp.css('top',"-"+(temp.height()+40)+"px");
	}*/
}
/**
 * 设置监听事件
 */
function setServiceNavListners(){
	
	/*//业务导航的悬浮事件
	serviceNav.unbind("hover");
	serviceNav.hover(function(){
		//清空当前关闭的计时器
		if(closeServiceNavTimer){
			clearTimeout(closeServiceNavTimer);
			closeServiceNavTimer = undefined;
		}
		serviceItemsList.animate({
			top:'0px'
		},200);
		//显示展示的业务
		var index = 0;
		setInterval(function(){
			
			$(serviceItems[index]).slideDown();
			index++;
		}, 50);
		
	},function(){

		//开始关闭计时
		closeServiceNavTimer = setTimeout(function(){
			
			//隐藏业务导航
			serviceItemsList.animate({
				top:serviceNav.height()
			});
			//隐藏业务展示项目
			serviceItems.hide();
			//标志位不可以关闭
			canCloseServiceNav=0;
			
		}, OpenCloseServiceNavTime);
	});
	
	
	//展示业务的悬浮事件
	serviceItems.unbind("hover");
	serviceItems.hover(function(){
		var t = $(this);
		
		t.find('*').animate({
			color:'white'
		},InOutServiceNavItemTime);
		t.animate({
			backgroundColor:'gray'
		},InOutServiceNavItemTime);
		//显示业务图片
		t.find('.serviceImg').show();
	},function(){
		var t = $(this);
		
		t.find('*').animate({
			color:'gray'
		},InOutServiceNavItemTime);
		t.animate({
			backgroundColor:'rgb(28,28,28)'
		},InOutServiceNavItemTime);

		//隐藏业务图片
		t.find('.serviceImg').hide();
	});*/
}
/**
 * 加载业务导航的信息
 */
function loadServiceNavData(){
	serviceItemsList.html("");
	//读取四条业务
	zkAjax(NAMESPACE_OW_FRONT+'/serviceFrontAction!getService.action?page=1&rows=4&order=desc&sort=releaseTime',function(data,success){
		if(success&&data.success){
		/*	<a class="serviceItems" href="javascript:toView('view_serviceDetail','right','view_serviceDisplay',beforeServiceDetailShow({'id':'asdasd','name':'asdad'}))">
				<span class="serviceDate">19/7</span>
				<span title="这是第一业务这是第一业务这是第一业务这是第一业务这是第一业务" class="serviceTitle">这是第一业务这是第一业务这是第一业务这是第一业务这是第一业务</span>
				<span class="serviceImg">
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
				var serviceItems = $("<a class='serviceItems' href=javascript:void(0); onClick=toView('view_serviceDetail','right','view_serviceDisplay','loadServiceDetailView({\"id\":\""+r.id+"\",\"ids\":\""+ids+"\"})')></a>");
				//设置时间
				var t = formatDate(new Date(r.releaseTime).toLocaleDateString());
				var serviceDate = $("<span class='serviceDate'>"+t+"</span>");
				//获取title
				var title = r.title;
				if(title.length>=13){
					title = title.substring(0,13)+"...";
				}
				var serviceTitle = $("<span title='"+r.title+"' class='serviceTitle'>"+title+"</span>");
				/*var serviceImg = $("<span class='serviceImg'></span>");
				//储存业务的imgname
				var imgName = undefined;
				//获取主要图片
				zkAjax(NAMESPACE_OW_FRONT+"/imgsAndInfoFrontAction!getMainImgByInfoId.action?infoId="+infoId,function(data,success){
					if(success&&data.success){
						imgName = data.obj.imgName;
					}
				},false);
				var img = $("<img src='"+getWebProjectName()+NAMESPACE_OW_FRONT+"/imgsAndInfoFrontAction!getServiceImgByImgName.action?imgName="+imgName+"'/>");
				
				//添加节点
				serviceImg.append(img);
				serviceItems.append(serviceImg);
				*/
				serviceItems.append(serviceDate);
				serviceItems.append(serviceTitle);
				
				serviceItemsList.append(serviceItems);
				
			}
		}
	},false);

	initServiceNavDom();
	//设置界面
	setServiceNavUI();
	
	//设置监听事件
	setServiceNavListners();
}


