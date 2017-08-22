var membersDisplay = undefined;
var membersDetail_filter = undefined;
//过滤项目
var membersFiler_Items = undefined;
//选择/未选择的图标变换
var membersFiler_Items_select_status = "▼";
var membersFiler_Items_unSelect_status = "▲";
//过滤条件的名称
var membersFilterName = undefined;
//存放过滤条件的div
var membersFilterConditionDiv = undefined;
//展示成员们的ul对象
var membersUl = undefined;
//展示成员的li对象
var membersLi = undefined;
var membersLiEyeInOutTime = 100;
//展示成员的li对象的数量
var membersLiNumber = 12;
//展示成员的li对象的外边距
var membersLiMargin = 3;

//展示成员的图片对象
var membersLiImg = undefined;
//条件复选框
var membersCheckBox = undefined;
//筛选条件的表单
var filterFrom = undefined;
$(function($){
	initMembersDisplayDom();
	//监听浏览器尺寸变化，解决浏览器尺寸变化时，页面出现变形
	$(window).resize(function(){
		//调用fun，调整界面
		setMembersDisplayUI();
	});
	
});
/**
 * 设置默认dom
 */
function defaultMembersDisplayDom(){
	/**设置条件复选框为全不选状态**/
	setCheckBoxF(membersCheckBox);
}
/**
 * 初始化dom
 */
function initMembersDisplayDom(){
	membersDetail_filter = $('#membersDetail_filter');
	membersDisplay  = $('#membersDisplay');
	membersFiler_Items = $('.membersFiler_Items');
	membersFilterName = $('.membersFilterName');
	membersFilterConditionDiv = $('.membersFilterConditionDiv');
	membersUl = $('#membersUl');
	membersLi = $('.membersLi');
	membersLiImg = $('.membersLiImg');
	membersLiModel = $('.membersLiModel');
	membersCheckBox = $('.membersCheckBox');
	filterFrom = $('#membersDetail_filter_form');
}
/**
 * 设置监听事件
 */
function setMembersDisplayListners(){
	/**设置筛选条件点击事件**/
	cleanListener('click',membersFilterName);
	membersFilterName.click(function(){
		//点击滑动出选择条件
		var temp = $(this);
		var currtDomIndex = membersFilterName.index(temp);
		var currtFilterConditionDiv = $(membersFilterConditionDiv[currtDomIndex]);
		//判断进行什么动作，变化三角图标
		var status = temp.find('.status');
		if(membersFiler_Items_select_status==status.html()){
			currtFilterConditionDiv.slideDown(500);
			status.html(membersFiler_Items_unSelect_status);
		}else{
			currtFilterConditionDiv.slideUp(500);
			status.html(membersFiler_Items_select_status);
		}
		
	});
	/**设置鼠标悬浮到成元图片时，显示eye**/
	membersLi.hover(function(){
		var temp = $(this);
		temp.find('.membersLiModel').fadeIn(membersLiEyeInOutTime);
	},function(){
		var temp = $(this);
		temp.find('.membersLiModel').fadeOut(membersLiEyeInOutTime);
	});
	
}
/**
 * 设置界面
 */
function setMembersDisplayUI(){
	/**设置成员展示的布局**/
	//设置成员展示的li的宽高
	var membersUlWidth = membersUl.width();
	//计算了去除外边距的总宽度
	var liTotalWidthOutWithMargin = membersUlWidth - 2*membersLiMargin*membersLiNumber-1;
	var membersLiWidth = liTotalWidthOutWithMargin/membersLiNumber;
	membersLi.width(membersLiWidth);
	membersLi.height(membersLiWidth);
	
	//设置外边距
	setMargin(membersLi,membersLiMargin);
	
	
}

/**
 * 点击筛选条件后，加载成员头像信息数据
 */
function loadMembersHeadDataByClickConditions(){
	//点击筛选条件后，出现加载界面
	showLoadingModel(0, function(){
		loadMembersHeadData();
		hideLoadingModel(0);
	}, 500);
}


/**
 * 加载成员头像信息数据
 */
function loadMembersHeadData(){
	
	//获取过滤条件
	var conditionJSON = serializeObject(filterFrom);
	zkAjaxData(NAMESPACE_OW_FRONT+'/membersFrontAction!getMembersByCondition.action',conditionJSON,function(data,success){
		/*<li class="membersLi" Onclick="javascript:toView('view_membersDetail','right','view_membersDisplay',loadMembersDetailView({}))" Onclick="javascript:toView('view_membersDetail','right','view_membersDisplay',loadMembersDetailView({}))">
			<img class="membersLiImg"  
					src="<c:url value='/front/officialwebsite/imgslib/bg/pic04.png'/>" />
			<div class="membersLiModel eye"></div>
		</li>*/
		
		//如果获取数据成功
		if(success&&data.success){
			//必须在这里初始化一次，不能使用全局的membersUl；原因：因为这是async:true，坑爹的异步
			var membersUl = $('#membersUl');
			membersUl.html("");
			var rows = data.rows;
			//将读取出的所有成员id整合到一个数组，传递到成员详情页面
			var ids = [];
			for(var index = 0;index<rows.length;index++){
				var r = rows[index];
				ids.push(r.id);
			}
			for(var index = 0;index<rows.length;index++){
				var r = rows[index];
				var tipInfo = "名字："+r.name+"\r\n职位："+r.position+"\r\n性别："+r.sex+"\r\n年龄："+r.age+"\r\n生日："+r.birthday+"\r\n国家："+r.nation+"\r\n信仰："+r.faith+"\r\n语言："+r.language+"\r\nqq："+r.qq+"\r\n邮箱："+r.email+"\r\n电话："+r.phone+"\r\n学历："+r.degree+"\r\n毕业学校："+r.lastGraduateSchool+"\r\n成员状态："+r.membersStatus+"\r\n加入时间："+r.joinTime+"\r\n离职时间："+r.outTime+"\r\n备注："+r.note+"\r\n介绍："+r.introduction;
				var li = $("<li class='membersLi' title='"+tipInfo+"' onClick=javascript:toView('view_membersDetail','right','view_membersDisplay','loadMembersDetailView({\"id\":\""+r.id+"\",\"ids\":\""+ids+"\"})')></li>");
				var img = $("<img class='membersLiImg' src='"+getWebProjectName()+NAMESPACE_OW_FRONT+"/membersFrontAction!getMembersImgHead.action?head="+r.head+"&t="+new Date().getTime()+"'/>");
				var div = $("<div class='membersLiModel eye'></div>");
				li.append(img);
				li.append(div);
				membersUl.append(li);
			}
			
			//初始化dom，更新dom，因为上面的动作可能添加了新的dom
			initMembersDisplayDom();
			//设置界面，添加了了新的dom，重新设置样式
			setMembersDisplayUI();

			//设置监听事件，新的dom节点需要重新设置样式
			setMembersDisplayListners();
			/*setTimeout(function(){
				
			}, 1000);*/
			
			
		}
		
	},false);
		
	
	

	
}

/**
 * 加载过滤条件
 * @param filterNames
 * @param filterIds
 */
function loadFilterConditions(){
	//清空条件
	membersDetail_filter.html("");
	//获取用户筛选的所有条件
	zkAjax(NAMESPACE_FRONT+"/systemddlFrontAction!querySystemddlByParentId.action?id=01",function(data,success){
		if(success&&data.success){
			/*<div class="membersFiler_Items">
				<div class="membersFilterName">
					<a href="#">性别</a>
					<span class="status">▲</span>
				</div>
				
				<div class="membersFilterConditionDiv">
					<div class="membersFilterConditions">
						
						<input onClick="loadMembersData()" type="checkbox" class="membersCheckBox" checked name="eqSex" value="男"  id="man" />
							
						<label for="man">男性</label>
					</div>
					<div class="membersFilterConditions">
						
						<input onClick="loadMembersData()" type="checkbox" class="membersCheckBox" checked name="eqSex" value="女" id="woman" />
						<label for="woman">女性</label>
						
					</div>
					
				 </div>
			  </div>*/
			//遍历sex，nation，faith等节点
			var rows = data.rows;
			for(var index = 0;index<rows.length;index++){
				var r = rows[index];
				var membersFiler_Items = $("<div class='membersFiler_Items'></div>");
				var membersFilterName = $("<div class='membersFilterName'></div>");
				var name =  $("<a href='#'>"+r.text+"</a>");
				var span = $("<span class='status'>▲</span>");
				
				membersFilterName.append(name);
				membersFilterName.append(span);
				membersFiler_Items.append(membersFilterName);
				var membersFilterConditionDiv = $("<div class='membersFilterConditionDiv'></div>");
				//获取子节点，即获取sex的值 男，女
				//将sex等转化为eqSex
				var firstLetter = r.field.substring(0,1).toLocaleUpperCase();
				var filterName = "eq"+firstLetter+r.field.substring(1,r.field.length);
				zkAjax(NAMESPACE_FRONT+"/systemddlFrontAction!querySystemddlByParentId.action?id="+r.id,function(data,success){
					
					if(success&&data.success){
						var rows = data.rows;
						/*<div class="membersFilterConditions">
						
						<input onClick="loadMembersData()" type="checkbox" class="membersCheckBox" checked name="eqSex" value="男"  id="man" />
							
						<label for="man">男性</label>
						</div>*/
						for(var index = 0;index<rows.length;index++){
							var r = rows[index];
							var membersFilterConditions = $("<div class='membersFilterConditions'></div>");
							var input = $("<input  onClick='loadMembersHeadDataByClickConditions()' type='checkbox'  class='membersCheckBox' checked name='"+filterName+"'  value='"+r.text+"'  id='"+filterName+"members"+index+"'></input>");
							setCheckBoxF(input);
							var label = $("<label for='"+filterName+"members"+index+"'>"+r.text+"</label>");
							membersFilterConditions.append(input);
							membersFilterConditions.append(label);
							membersFilterConditionDiv.append(membersFilterConditions);
						}
						
						membersFiler_Items.append(membersFilterConditionDiv);
						membersDetail_filter.append(membersFiler_Items);
						
					};
				},false);
				
				
			}
			
			//初始化dom，更新dom，因为上面的动作可能添加了新的dom
			initMembersDisplayDom();
			//设置界面，添加了了新的dom，重新设置样式
			setMembersDisplayUI();
			//设置监听事件，新的dom节点需要重新设置样式
			setMembersDisplayListners();

			//默认的dom
			defaultMembersDisplayDom();
		}
		
		
	},false);
}



/**
 * 加载页面，在切换到该页面之前调用
 */
function loadMembersDisplayView(params){
	
	//初始化dom
	initMembersDisplayDom();
	
	//加载筛选条件
	
	loadFilterConditions();

	//加载成员头像数据
	loadMembersHeadData();

}
