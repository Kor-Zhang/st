<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="easyui-panel"
	data-options="title:'功能导航',border:false,fit:'true',selected:true">

	<div id="aa" class="easyui-accordion" data-options="fit:true">
		<div title="系统管理" data-options="">
			<ul id="menuTree" class="easyui-tree"
				data-options="lines:true,
						url:'${pageContext.request.contextPath}'+NAMESPACE_BACK+'/menuTreeAction!getTree.action',
						onClick: function(node){
							<!-- 获取树节点url和设置tabs的href，如果href为undefined，那么不会显示tabs -->
							var href = undefined;
							if(!(node.attrbutes.url==undefined||node.attrbutes.url=='')){
								href = '${pageContext.request.contextPath}'+node.attrbutes.url;
							}
							<!-- 如果href为undefined，那么不会显示tabs -->
							addTabs($('#admins_index_centerTabs'),{title:node.text,
								closable:true,
								href:href,
								tools:[{    
							        iconCls:'icon-mini-refresh',    
							        handler:function(){
							            refreshTab($('#admins_index_centerTabs'),href);
							        }    
					    		}]    
				    		});
						}
						
			">
			</ul>
			
		</div>
		<div title="字典管理">

			<ul id="admins_index_systemddl">

			</ul>

			<!-- 右键弹出打开的菜单 -->
			<div id=systemddlChangeMenu class="easyui-menu">
				<div id="systemddlRightMenuAddBtn" onclick="systemddlRightMenuAdd()"
					class="" iconCls="icon-remove">添加</div>
				<div id="systemddlRightMenuEditBtn"
					onclick="systemddlRightMenuEdit()" class="" iconCls="icon-remove">编辑</div>
				<div id="systemddlRightMenuDeleteBtn"
					onclick="systemddlRightMenuDelete()" class="" iconCls="icon-remove">删除</div>
			</div>
		</div>
		<!-- <div title="目录三">content3</div> -->
	</div>

</div>

<script type="text/javascript">
	/*****************************************申明变量*******************************/
	var systemddlRightMenuAddBtn = undefined;
	var systemddlRightMenuEditBtn = undefined;
	var systemddlRightMenuDeleteBtn = undefined;
	var systemddlChangeMenu = undefined;
	var systemddlETree = undefined;
	//当前右击的node
	var clickNode = undefined;
	$(function($){
		/***********************************初始化systemddl的etree*********************************/
		systemddlRightMenuAddBtn = $('#systemddlRightMenuAddBtn');
		systemddlRightMenuEditBtn = $('#systemddlRightMenuEditBtn');
		systemddlRightMenuDeleteBtn = $('#systemddlRightMenuDeleteBtn');
		systemddlChangeMenu = $('#systemddlChangeMenu');
		//连接服务器加载systemddl数据
		loadSystemddlTree();
		
	});
	
	/***************************************功能方法*************************************/
	
	/**
	*连接服务器获取systemddl数据
	*/
	function loadSystemddlTree(){
		systemddlETree = $('#admins_index_systemddl').tree({});
		systemddlETree.tree({
			data:[]
		});
		//连接服务器判断是否能查询字典
		zkAjax(NAMESPACE_BACK+'/systemddlAction!getSystemddlByParentId.action',function(data){
			//显示信息
			showMsg(data);
			//检测是否在线
			try{
				isOnline(data);
			}catch(e){
				return;
			}
			if(data.success){
				//加载显示systemddl树
				showSystemddlTree(data);
			}
		});
	}
	/**
	*加载显示systemddl树
	*/
	function showSystemddlTree(data){
		systemddlETree = $('#admins_index_systemddl').tree({    
			data:data.rows,
		    lines:true,
		    animate:true,
		    dnd:true,
		    //右击树节点
			onContextMenu:function(e,node){
				e.preventDefault();
				//如果右击和左键选择的节点不同，那么以右击为准
				if(clickNode!=node){
					systemddlETree.tree('select',node.target);
					clickNode = node;
				}
				//预先隐藏按钮
				//隐藏编辑按钮
				systemddlRightMenuEditBtn.hide();
				//隐藏添加按钮
				systemddlRightMenuAddBtn.hide();
				//隐藏删除按钮
				systemddlRightMenuDeleteBtn.hide();
				var currtHigh = node.attrbutes.currtHigh;
				var high = node.attrbutes.high;
				//如果为根节点,或则为不可改变节点（currtHigh=-1||high==-1）
				if(node.id == "root"||currtHigh==-1||high==-1){
					return;
				}
				//为固定节点，即（当前结点的currtHigh==1）
				if(currtHigh==1){
					systemddlRightMenuAddBtn.show();
					//显示menu
					systemddlChangeMenu.menu('show', {
						left: e.pageX,
						top: e.pageY
					});
					return;
				}
				//判断是否为叶子节点，如果非也只节点，可以对节点进行增加，删除操作
				if(node.attrbutes.currtHigh!=node.attrbutes.high){
					systemddlRightMenuDeleteBtn.show();
					systemddlRightMenuAddBtn.show();
					systemddlRightMenuEditBtn.show();
				
				}else{
					systemddlRightMenuEditBtn.show();
					systemddlRightMenuDeleteBtn.show();
					systemddlRightMenuAddBtn.hide();
				}
				//显示menu
				systemddlChangeMenu.menu('show', {
					left: e.pageX,
					top: e.pageY
				});
		
			},
			//树节点展开前
		    onBeforeExpand:function(node){
				clickNode = node;
		    	//判断是否已经家再过该节点数据
		    	var nodeLength = systemddlETree.tree('getChildren',clickNode.target).length;
		    	if(nodeLength==0){
		    		//发送登陆请求
					$.ajax({
				     type: "POST", 
						url:getWebProjectName()+NAMESPACE_BACK+'/systemddlAction!getSystemddlByParentId.action?id='+clickNode.id,
						dataType:"json",
						async:false,
						success:function(data){
							//显示信息
							showMsg(data);
							//检测是否在线
							try{
								isOnline(data);
							}catch(e){
								return;
							}
							if(data.success){
								systemddlETree.tree('append', {
									parent: clickNode.target,
									data: data.rows
								});
							}
						}
					});
				}
				
				
				return true;
			},
			//编辑结束后
			onAfterEdit:function(node){
				clickNode = node;
				//更新信息
				var jsonData={
						"id":clickNode.id,
						"text":clickNode.text
				};
				//发出携带信息的ajax
				zkAjaxData(NAMESPACE_BACK+"/systemddlAction!updateSystemddl.action",jsonData,function(data){
					//检测信息
					showMsg(data);
					//检测是否在线
					try{
						isOnline(data);
					}catch(e){
						return;
					}
					
				});
			},
			//拖动
			onBeforeDrag:function(node){
				return true;
			},
			//放置
			onBeforeDrop:function( target,source,point){
				/* $.messager.show({
					title:'提示',
					msg:'禁止拖动！',
				}); */
				if(point === 'append'){
					$.messager.show({
						title:'提示',
						msg:'禁止越级拖拽！',
					});
					return false;
				}
				
				//更新rank
				var targetNode = systemddlETree.tree("getNode",target);
				var targetRank = Number(targetNode.rank); 
				//发出携带信息的ajax
				zkAjax(NAMESPACE_BACK+"/systemddlAction!updateSystemddlRank.action?id="+source.id+"&rank="+targetRank,function(data){
					//检测信息
					showMsg(data);
					//检测是否在线
					try{
						isOnline(data);
					}catch(e){
						return;
					}
					
				},false);
				
				return true;
			},
			//放置后
			onDrop:function( target,source,point){
				//获取父节点
				var parentNode = systemddlETree.tree("getParent",target);
				
				//清空子节点
				var childrens = systemddlETree.tree('getChildren',parentNode.target);
				for ( var index in childrens) {
					var cs = childrens[index];
					systemddlETree.tree('remove',cs.target);
					
				}
				
				//连接服务器，重新加载父节点
				zkAjax(NAMESPACE_BACK+"/systemddlAction!getSystemddlByParentId.action?id="+parentNode.id,function(data){
					//检测信息
					showMsg(data);
					//检测是否在线
					try{
						isOnline(data);
					}catch(e){
						return;
					}
					if(data.success){
						systemddlETree.tree('append', {
							parent: parentNode.target,
							data: data.rows
						});
					}
				});
				
				
			},
			//编辑前
			onBeforeEdit:function(node){
				//如果为根节点或者固定节点，那么不允许编辑（主要为防止用户双击编辑）
				if(node.attrbutes.currtHigh<=1){
					return false;
				}
				return true;
			}
		});  
	}
	
	//删除节点
	function systemddlRightMenuDelete(){
	    zkAjax(NAMESPACE_BACK+"/systemddlAction!deleteSystemddl.action?id="+clickNode.id,function(data){
	    	//检测信息
			showMsg(data);
			//检测是否在线
			try{
				isOnline(data);
			}catch(e){
				openLoginDialog();
				return;
			}
			//如果删除成功
			if(data.success){
				//删除节点
				systemddlETree.tree('remove',clickNode.target);
			}
			

		});
	}
	//添加结点
	function systemddlRightMenuAdd(){
		zkAjax(NAMESPACE_BACK+"/systemddlAction!addSystemddl.action?id="+clickNode.id,function(data){
			//检测信息
			showMsg(data);
			//检测是否在线
			try{
				isOnline(data);
			}catch(e){
				openLoginDialog();
				return;
			}
			//如果添加成功
			if(data.success){
				var newNode = data.obj;
				//添加节点
				systemddlETree.tree('append', {
					parent: clickNode.target,
					data: [newNode]
				});
			}
			

		},false);
	}
	//编辑节点
	function systemddlRightMenuEdit(){
		//开启当前被右击的节点，开启编辑
		systemddlETree.tree('beginEdit',clickNode.target);
	}
</script>