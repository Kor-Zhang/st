var service = undefined;
//滚动轴
var service_ul_scroll = undefined;
var service_ul = undefined;
//ul的列数
var service_ul_li_number = 1;
//li的外边距
var service_ul_li_margin = 3;
var service_ul_li = undefined;
//li的宽高比
var service_ul_li_widthAndHeightScale = 0.5;
var service_displayDiv = undefined;
var service_imgDiv = undefined;
var service_infoDiv = undefined;
//业务业务信息显示，隐藏时间
var service_infoDiv_InOutTime = 100;
//业务业务文字的背景
var service_infoDiv_model = undefined;
//放图片的div
var service_imgDiv = undefined;
//业务业务信息-日期的div
var service_dateDiv = undefined;
//业务业务信息-标题的div
var service_titleDiv = undefined;

var serviceDisplay_right = undefined;
var serviceDisplay_left = undefined;

var serviceDetail_filter = undefined;
//过滤项目
var serviceFiler_Items = undefined;
//选择/未选择的图标变换
var serviceFiler_Items_select_status = "▼";
var serviceFiler_Items_unSelect_status = "▲";
//过滤条件的名称
var serviceFilterName = undefined;
//存放过滤条件的div
var serviceFilterConditionDiv = undefined;

//复选框
var serviceCheckBox = undefined;

var serviceDetail_filter_form = undefined;
$(function($){
	initServiceDsiplayDom();
	/*//设置界面
	setServiceUI();
	
	//设置监听事件
	setServiceListners();*/
	
	
	
	//监听浏览器尺寸变化，解决浏览器尺寸变化时，页面出现变形
	$(window).resize(function(){
		//调用fun，调整界面
		setServiceUI();
	});
	
});

/**
 * 初始化dom
 */
function initServiceDsiplayDom(){
	service = $('#service');
	service_ul = $('#service_ul');
	service_ul_li = service_ul.find('li');
	service_displayDiv = $('.service_displayDiv');
	service_imgDiv = $('.service_imgDiv');
	service_infoDiv = $('.service_infoDiv');
	service_infoDiv_model = $('.service_infoDiv_model');
	service_imgDiv = $('.service_imgDiv');
	service_dateDiv = $('.service_dateDiv');
	service_titleDiv = $('.service_titleDiv');
	service_ul_scroll = $('#service_ul_scroll');
	serviceDisplay_right = $('#serviceDisplay_right');
	serviceDisplay_left = $('#serviceDisplay_left');
	serviceDetail_filter = $("#serviceDetail_filter");
	serviceFiler_Items = $('.serviceFiler_Items');
	serviceFilterName = $('.serviceFilterName');
	serviceFilterConditionDiv = $('.serviceFilterConditionDiv');
	serviceCheckBox = $('.serviceCheckBox');
	serviceDetail_filter_form = $("#serviceDetail_filter_form");
}
/**
 * 设置监听事件
 */
function setServiceListners(){
	/*//业务业务悬浮事件
	service_displayDiv.hover(function(){
		//显示业务业务信息
		var infoDiv = $(this).find('.service_infoDiv');
		infoDiv.fadeIn(service_infoDiv_InOutTime);
	},function(){
		//隐藏业务业务信息
		var infoDiv = $(this).find('.service_infoDiv');
		infoDiv.fadeOut(service_infoDiv_InOutTime);
	});*/
	/**设置筛选条件点击事件**/
	cleanListener('click',serviceFilterName);
	serviceFilterName.click(function(){
		//点击滑动出选择条件
		var temp = $(this);
		var currtDomIndex = serviceFilterName.index(temp);
		var currtFilterConditionDiv = $(serviceFilterConditionDiv[currtDomIndex]);
		//判断进行什么动作，变化三角图标
		var status = temp.find('.status');
		if(serviceFiler_Items_select_status==status.html()){
			currtFilterConditionDiv.slideDown(500);
			status.html(serviceFiler_Items_unSelect_status);
		}else{
			currtFilterConditionDiv.slideUp(500);
			status.html(serviceFiler_Items_select_status);
		}
		
	});
	/*//滚动轴鼠标点击事件
	service_ul_scroll.mousedown(function(e){
		service.bind('mouseover',function(e){
			c(e.clientY);
			if(e.clientY==service_ul.offset().top){
				
			}
			var y = e.clientY - service_ul.offset().top;
			service_ul_scroll.css('top',y-service_ul_scroll.height()/2);
		});
	}).mouseup(function(e){
		service.unbind('mouseover',function(e){
			
		});
	});
	
	一般鼠标按下，会配合mouseup()来使用，就是鼠标弹起。
	*/
	
}
/**
 * 设置界面
 */
function setServiceUI(){
	//设置service的宽高
	service.width(content.width());
	service.height(content.height());
	//设置ul的宽，外边距
	service_ul.width(serviceDisplay_right.width());
	service_ul.height(serviceDisplay_right.height());
	//设置业务业务显示ul的li的大小，外边距;-scrollWidth是减去右部的滚轴
	var scrollWidth = getDomScrollWidth(service_ul.get(0));
	//去除了外边距的宽度
	var liWidth = (service_ul.width()-scrollWidth)/service_ul_li_number-2*service_ul_li_margin;
	var liHeight =liWidth* service_ul_li_widthAndHeightScale;
	service_ul_li.width(liWidth);
	service_ul_li.height(liHeight);
	setMargin(service_ul_li,service_ul_li_margin);
	
	
	//设置图片显示
	service_imgDiv.find('img').show();
	//设置图片宽高
	service_imgDiv.find('img').width(liWidth);
	service_imgDiv.find('img').height(liHeight);
	
	//设置每行每列的展示业务业务宽高
	service_displayDiv.width(liWidth);
	service_displayDiv.height(liHeight);
	
	
	
	
}
/**
 * 默认设置
 */
function defaultServiceDisplayDom(){
	/**设置条件复选框为全选状态**/
	setCheckBoxF(serviceCheckBox);
}
/**
 * 点击筛选条件后，加载成员头像信息数据
 */
function loadServiceImgDataByClickConditions(){
	//点击筛选条件后，出现加载界面
	showLoadingModel(0, function(){
		loadServiceImgData();
		hideLoadingModel(0);
	}, 500);
}


/**
 * 加载筛选条件
 */
function loadServiceDisplayFilterConditions(){
	//清空条件
	serviceDetail_filter.html("");
	//获取用户筛选的所有条件
	zkAjax(NAMESPACE_FRONT+"/systemddlFrontAction!querySystemddlByParentId.action?id=02",function(data,success){
		if(success&&data.success){
			/*<div class="serviceFiler_Items">
				<div class="serviceFilterName">
					<a href="#">性别</a>
					<span class="status">▲</span>
				</div>
				
				<div class="serviceFilterConditionDiv">
					<div class="serviceFilterConditions">
						
						<input onClick="loadServiceData()" type="checkbox" class="serviceCheckBox" checked name="eqSex" value="男"  id="man" />
							
						<label for="man">男性</label>
					</div>
					<div class="serviceFilterConditions">
						
						<input onClick="loadServiceData()" type="checkbox" class="serviceCheckBox" checked name="eqSex" value="女" id="woman" />
						<label for="woman">女性</label>
						
					</div>
					
				 </div>
			  </div>*/
			//遍历sex，nation，faith等节点
			var rows = data.rows;
			for(var index = 0;index<rows.length;index++){
				var r = rows[index];
				var serviceFiler_Items = $("<div class='serviceFiler_Items'></div>");
				var serviceFilterName = $("<div class='serviceFilterName'></div>");
				var name =  $("<a href='#'>"+r.text+"</a>");
				var span = $("<span class='status'>▲</span>");
				
				serviceFilterName.append(name);
				serviceFilterName.append(span);
				serviceFiler_Items.append(serviceFilterName);
				var serviceFilterConditionDiv = $("<div class='serviceFilterConditionDiv'></div>");
				//获取子节点，即获取sex的值 男，女
				//将sex等转化为eqSex
				var firstLetter = r.field.substring(0,1).toLocaleUpperCase();
				var filterName = "eq"+firstLetter+r.field.substring(1,r.field.length);
				zkAjax(NAMESPACE_FRONT+"/systemddlFrontAction!querySystemddlByParentId.action?id="+r.id,function(data,success){
					
					if(success&&data.success){
						var rows = data.rows;
						/*<div class="serviceFilterConditions">
						
						<input onClick="loadServiceData()" type="checkbox" class="serviceCheckBox" checked name="eqSex" value="男"  id="man" />
							
						<label for="man">男性</label>
						</div>*/
						for(var index = 0;index<rows.length;index++){
							var r = rows[index];
							var serviceFilterConditions = $("<div class='serviceFilterConditions'></div>");
							var input = $("<input  onClick='loadServiceImgDataByClickConditions()' type='checkbox'  class='serviceCheckBox' checked name='"+filterName+"'  value='"+r.text+"'  id='"+filterName+"service"+index+"'></input>");
							setCheckBoxF(input);
							var label = $("<label for='"+filterName+"service"+index+"'>"+r.text+"</label>");
							serviceFilterConditions.append(input);
							serviceFilterConditions.append(label);
							serviceFilterConditionDiv.append(serviceFilterConditions);
						}
						
						serviceFiler_Items.append(serviceFilterConditionDiv);
						serviceDetail_filter.append(serviceFiler_Items);
						
					};
				},false);
				
				
			}
			
			//初始化dom，更新dom，因为上面的动作可能添加了新的dom
			initServiceDsiplayDom();

			//设置监听事件，新的dom节点需要重新设置样式
			setServiceListners();

			//默认的dom
			defaultServiceDisplayDom();
		}
		
		
	},false);
}
/**
 * 加载业务图片文字信息的数据
 */
function loadServiceImgData(){
	//获取过滤条件
	var conditionJSON = serializeObject(serviceDetail_filter_form);
	//清空信息
	service_ul.html("");
	zkAjaxData(NAMESPACE_OW_FRONT+"/serviceFrontAction!getService.action",conditionJSON,function(data,success){
		if(success&&data.success){
			/*<li class="service_li">
				<div class="service_displayDiv">
					<div class="service_imgDiv">
						<img src="<c:url value='/front/officialwebsite/imgslib/bg/pic01.png'/>"/>
					</div>
					<a class="service_infoDiv" href="javascript:toView('view_serviceDetail','right','view_serviceDisplay','beforeServiceDetailShow()')">
						<div class="service_infoDiv_model">
							<div class="service_dateDiv">
								2013/6/13
							</div>
							<div class="service_titleDiv">
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
				var service_li = $("<li class='service_li'></li>");
				var service_displayDiv = $("<div class='service_displayDiv'></div>");
				
				var service_imgDiv = $("<div class='service_imgDiv'></div>");
				//加载时默认图片隐藏
				var img = $("<img style='display:none;' src='"+getWebProjectName()+NAMESPACE_OW_FRONT+"/imgsAndInfoFrontAction!getServiceImgByImgName.action?imgName="+imgName+"'/>");
				service_imgDiv.append(img);
				
				service_displayDiv.append(service_imgDiv);
				
				
				var service_infoDiv = $("<a class='service_infoDiv' href=javascript:toView('view_serviceDetail','right','view_serviceDisplay','loadServiceDetailView({\"id\":\""+r.id+"\",\"ids\":\""+ids+"\"})')></a>");
				
				var service_infoDiv_model = $("<div class='service_infoDiv_model'></div>");
				
				var service_dateDiv = $("<div class='service_dateDiv'>"+r.releaseTime+"</div>");
				var service_titleDiv = $("<div class='service_titleDiv'>"+r.title+"</div>");
				
				
				service_infoDiv_model.append(service_dateDiv);
				service_infoDiv_model.append(service_titleDiv);
				service_infoDiv.append(service_infoDiv_model);
				service_displayDiv.append(service_infoDiv);
				service_li.append(service_displayDiv);
				
				service_ul.append(service_li);
			}
		}
	},false);
	initServiceDsiplayDom();
	//设置界面，添加了了新的dom，重新设置样式
	setServiceUI();

	//设置监听事件，新的dom节点需要重新设置样式
	setServiceListners();
}
/**
 * 加载页面，在切换到该页面之前调用
 */
function loadServiceDisplayView(params){
	initServiceDsiplayDom();
	//设置界面
	setServiceUI();
	//加载筛选条件
	loadServiceDisplayFilterConditions();
	//加载业务图片文字信息的数据
	loadServiceImgData();
		
}

