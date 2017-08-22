var nav = undefined;
var navWord = undefined;
//当前被选中的导航栏项目节点
var currtSelectNavDom = undefined;
//被选择的项目颜色
var selectNavWordColor = 'gray';
//未被选择的项目颜色
var unSelectNavWordColor = 'black';
$(function(){
	navWord = $('#navWord');
	nav = $('#nav');

	//默认显示navword中的第一个a标签为selectNavWordColor色
	currtSelectNavDom = $('#navWord').find('a').eq(0).css('color',selectNavWordColor);

	//根据session中的信息设置当前点亮的语言标志
	$("#lang_"+userLang).css("color",selectNavWordColor);
});


