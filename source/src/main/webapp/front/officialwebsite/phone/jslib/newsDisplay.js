
var news = undefined;
//滚动轴
var news_ul_scroll = undefined;
var news_ul = undefined;
//ul的列数
var news_ul_li_number = 1;
//li的外边距
var news_ul_li_margin = 3;
var news_ul_li = undefined;
//li的宽高比
var news_ul_li_widthAndHeightScale = 0.5;
var news_displayDiv = undefined;
var news_imgDiv = undefined;
var news_infoDiv = undefined;
//新闻新闻信息显示，隐藏时间
var news_infoDiv_InOutTime = 100;
//新闻新闻文字的背景
var news_infoDiv_model = undefined;
//放图片的div
var news_imgDiv = undefined;
//新闻新闻信息-日期的div
var news_dateDiv = undefined;
//新闻新闻信息-标题的div
var news_titleDiv = undefined;

var newsDisplay_right = undefined;
var newsDisplay_left = undefined;

var newsDetail_filter = undefined;
//过滤项目
var newsFiler_Items = undefined;
//选择/未选择的图标变换
var newsFiler_Items_select_status = "▼";
var newsFiler_Items_unSelect_status = "▲";
//过滤条件的名称
var newsFilterName = undefined;
//存放过滤条件的div
var newsFilterConditionDiv = undefined;

//复选框
var newsCheckBox = undefined;

var newsDetail_filter_form = undefined;
$(function($){
	initNewsDsiplayDom();
	/*//设置界面
	setNewsUI();
	
	//设置监听事件
	setNewsListners();*/
	
	
	
	//监听浏览器尺寸变化，解决浏览器尺寸变化时，页面出现变形
	$(window).resize(function(){
		//调用fun，调整界面
		setNewsUI();
	});
	
});

/**
 * 初始化dom
 */
function initNewsDsiplayDom(){
	news = $('#news');
	news_ul = $('#news_ul');
	news_ul_li = news_ul.find('li');
	news_displayDiv = $('.news_displayDiv');
	news_imgDiv = $('.news_imgDiv');
	news_infoDiv = $('.news_infoDiv');
	news_infoDiv_model = $('.news_infoDiv_model');
	news_imgDiv = $('.news_imgDiv');
	news_dateDiv = $('.news_dateDiv');
	news_titleDiv = $('.news_titleDiv');
	news_ul_scroll = $('#news_ul_scroll');
	newsDisplay_right = $('#newsDisplay_right');
	newsDisplay_left = $('#newsDisplay_left');
	newsDetail_filter = $("#newsDetail_filter");
	newsFiler_Items = $('.newsFiler_Items');
	newsFilterName = $('.newsFilterName');
	newsFilterConditionDiv = $('.newsFilterConditionDiv');
	newsCheckBox = $('.newsCheckBox');
	newsDetail_filter_form = $("#newsDetail_filter_form");
}
/**
 * 设置监听事件
 */
function setNewsListners(){
	/*//新闻新闻悬浮事件
	news_displayDiv.hover(function(){
		//显示新闻新闻信息
		var infoDiv = $(this).find('.news_infoDiv');
		infoDiv.fadeIn(news_infoDiv_InOutTime);
	},function(){
		//隐藏新闻新闻信息
		var infoDiv = $(this).find('.news_infoDiv');
		infoDiv.fadeOut(news_infoDiv_InOutTime);
	});*/
	/**设置筛选条件点击事件**/
	cleanListener('click',newsFilterName);
	newsFilterName.click(function(){
		//点击滑动出选择条件
		var temp = $(this);
		var currtDomIndex = newsFilterName.index(temp);
		var currtFilterConditionDiv = $(newsFilterConditionDiv[currtDomIndex]);
		//判断进行什么动作，变化三角图标
		var status = temp.find('.status');
		if(newsFiler_Items_select_status==status.html()){
			currtFilterConditionDiv.slideDown(500);
			status.html(newsFiler_Items_unSelect_status);
		}else{
			currtFilterConditionDiv.slideUp(500);
			status.html(newsFiler_Items_select_status);
		}
		
	});
	/*//滚动轴鼠标点击事件
	news_ul_scroll.mousedown(function(e){
		news.bind('mouseover',function(e){
			c(e.clientY);
			if(e.clientY==news_ul.offset().top){
				
			}
			var y = e.clientY - news_ul.offset().top;
			news_ul_scroll.css('top',y-news_ul_scroll.height()/2);
		});
	}).mouseup(function(e){
		news.unbind('mouseover',function(e){
			
		});
	});
	
	一般鼠标按下，会配合mouseup()来使用，就是鼠标弹起。
	*/
	
}
/**
 * 设置界面
 */
function setNewsUI(){
	//设置news的宽高
	news.width(content.width());
	news.height(content.height());
	//设置ul的宽，外边距
	news_ul.width(newsDisplay_right.width());
	news_ul.height(newsDisplay_right.height());
	//设置新闻新闻显示ul的li的大小，外边距;-scrollWidth是减去右部的滚轴
	var scrollWidth = getDomScrollWidth(news_ul.get(0));
	//去除了外边距的宽度
	var liWidth = (news_ul.width()-scrollWidth)/news_ul_li_number-2*news_ul_li_margin;
	var liHeight =liWidth* news_ul_li_widthAndHeightScale;
	news_ul_li.width(liWidth);
	news_ul_li.height(liHeight);
	setMargin(news_ul_li,news_ul_li_margin);
	
	
	//设置图片显示
	news_imgDiv.find('img').show();
	//设置图片宽高
	news_imgDiv.find('img').width(liWidth);
	news_imgDiv.find('img').height(liHeight);
	
	//设置每行每列的展示新闻新闻宽高
	news_displayDiv.width(liWidth);
	news_displayDiv.height(liHeight);
	
	
	
	
}
/**
 * 默认设置
 */
function defaultNewsDisplayDom(){
	/**设置条件复选框为全选状态**/
	setCheckBoxF(newsCheckBox);
}
/**
 * 点击筛选条件后，加载成员头像信息数据
 */
function loadNewsImgDataByClickConditions(){
	//点击筛选条件后，出现加载界面
	showLoadingModel(0, function(){
		loadNewsImgData();
		hideLoadingModel(0);
	}, 500);
}


/**
 * 加载筛选条件
 */
function loadNewsDisplayFilterConditions(){
	//清空条件
	newsDetail_filter.html("");
	//获取用户筛选的所有条件
	zkAjax(NAMESPACE_FRONT+"/systemddlFrontAction!querySystemddlByParentId.action?id=03",function(data,success){
		if(success&&data.success){
			/*<div class="newsFiler_Items">
				<div class="newsFilterName">
					<a href="#">性别</a>
					<span class="status">▲</span>
				</div>
				
				<div class="newsFilterConditionDiv">
					<div class="newsFilterConditions">
						
						<input onClick="loadNewsData()" type="checkbox" class="newsCheckBox" checked name="eqSex" value="男"  id="man" />
							
						<label for="man">男性</label>
					</div>
					<div class="newsFilterConditions">
						
						<input onClick="loadNewsData()" type="checkbox" class="newsCheckBox" checked name="eqSex" value="女" id="woman" />
						<label for="woman">女性</label>
						
					</div>
					
				 </div>
			  </div>*/
			//遍历sex，nation，faith等节点
			var rows = data.rows;
			for(var index = 0;index<rows.length;index++){
				var r = rows[index];
				var newsFiler_Items = $("<div class='newsFiler_Items'></div>");
				var newsFilterName = $("<div class='newsFilterName'></div>");
				var name =  $("<a href='#'>"+r.text+"</a>");
				var span = $("<span class='status'>▲</span>");
				
				newsFilterName.append(name);
				newsFilterName.append(span);
				newsFiler_Items.append(newsFilterName);
				var newsFilterConditionDiv = $("<div class='newsFilterConditionDiv'></div>");
				//获取子节点，即获取sex的值 男，女
				//将sex等转化为eqSex
				var firstLetter = r.field.substring(0,1).toLocaleUpperCase();
				var filterName = "eq"+firstLetter+r.field.substring(1,r.field.length);
				zkAjax(NAMESPACE_FRONT+"/systemddlFrontAction!querySystemddlByParentId.action?id="+r.id,function(data,success){
					
					if(success&&data.success){
						var rows = data.rows;
						/*<div class="newsFilterConditions">
						
						<input onClick="loadNewsData()" type="checkbox" class="newsCheckBox" checked name="eqSex" value="男"  id="man" />
							
						<label for="man">男性</label>
						</div>*/
						for(var index = 0;index<rows.length;index++){
							var r = rows[index];
							var newsFilterConditions = $("<div class='newsFilterConditions'></div>");
							var input = $("<input  onClick='loadNewsImgDataByClickConditions()' type='checkbox'  class='newsCheckBox' checked name='"+filterName+"'  value='"+r.text+"'  id='"+filterName+"news"+index+"'></input>");
							setCheckBoxF(input);
							var label = $("<label for='"+filterName+"news"+index+"'>"+r.text+"</label>");
							newsFilterConditions.append(input);
							newsFilterConditions.append(label);
							newsFilterConditionDiv.append(newsFilterConditions);
						}
						
						newsFiler_Items.append(newsFilterConditionDiv);
						newsDetail_filter.append(newsFiler_Items);
						
					};
				},false);
				
				
			}
			
			//初始化dom，更新dom，因为上面的动作可能添加了新的dom
			initNewsDsiplayDom();

			//设置监听事件，新的dom节点需要重新设置样式
			setNewsListners();

			//默认的dom
			defaultNewsDisplayDom();
		}
		
		
	},false);
}
/**
 * 加载新闻图片文字信息的数据
 */
function loadNewsImgData(){
	//获取过滤条件
	var conditionJSON = serializeObject(newsDetail_filter_form);
	//清空信息
	news_ul.html("");
	zkAjaxData(NAMESPACE_OW_FRONT+"/newsFrontAction!getNews.action",conditionJSON,function(data,success){
		if(success&&data.success){
			/*<li class="news_li">
				<div class="news_displayDiv">
					<div class="news_imgDiv">
						<img src="<c:url value='/front/officialwebsite/imgslib/bg/pic01.png'/>"/>
					</div>
					<a class="news_infoDiv" href="javascript:toView('view_newsDetail','right','view_newsDisplay','beforeNewsDetailShow()')">
						<div class="news_infoDiv_model">
							<div class="news_dateDiv">
								2013/6/13
							</div>
							<div class="news_titleDiv">
								这是上海
							</div>
						</div>
					</a>				
				</div>
				
			</li>*/
			var rows = data.rows;
			//记录下所有的id
			var ids = [];
			for(var i = 0;i<rows.length;i++){
				var r = rows[i];
				ids.push(r.id);
			}
			//遍历声称节点
			for (var index = 0; index < rows.length; index++) {

				var r = rows[index];
				var infoId = r.id;
				var imgName = undefined;
				//获取主要图片
				zkAjax(NAMESPACE_OW_FRONT+"/imgsAndInfoFrontAction!getMainImgByInfoId.action?infoId="+infoId,function(data,success){
					
					if(success&&data.success){
						imgName = data.obj.imgName;
					}
				},false);
				var news_li = $("<li class='news_li'></li>");
				var news_displayDiv = $("<div class='news_displayDiv'></div>");
				
				var news_imgDiv = $("<div class='news_imgDiv'></div>");
				//加载时默认图片隐藏
				var img = $("<img style='display:none;' src='"+getWebProjectName()+NAMESPACE_OW_FRONT+"/imgsAndInfoFrontAction!getNewsImgByImgName.action?imgName="+imgName+"'/>");
				news_imgDiv.append(img);
				
				news_displayDiv.append(news_imgDiv);
				
				
				var news_infoDiv = $("<a class='news_infoDiv' href=javascript:toView('view_newsDetail','right','view_newsDisplay','loadNewsDetailView({\"id\":\""+r.id+"\",\"ids\":\""+ids+"\"})')></a>");
				
				var news_infoDiv_model = $("<div class='news_infoDiv_model'></div>");
				
				var news_dateDiv = $("<div class='news_dateDiv'>"+r.releaseTime+"</div>");
				var news_titleDiv = $("<div class='news_titleDiv'>"+r.title+"</div>");
				
				
				news_infoDiv_model.append(news_dateDiv);
				news_infoDiv_model.append(news_titleDiv);
				news_infoDiv.append(news_infoDiv_model);
				news_displayDiv.append(news_infoDiv);
				news_li.append(news_displayDiv);
				
				news_ul.append(news_li);
			}
		}
	},false);
	initNewsDsiplayDom();
	//设置界面，添加了了新的dom，重新设置样式
	setNewsUI();

	//设置监听事件，新的dom节点需要重新设置样式
	setNewsListners();
}
/**
 * 加载页面，在切换到该页面之前调用
 */
function loadNewsDisplayView(params){
	initNewsDsiplayDom();
	//设置界面
	setNewsUI();
	//加载筛选条件
	loadNewsDisplayFilterConditions();
	//加载新闻图片文字信息的数据
	loadNewsImgData();
}

