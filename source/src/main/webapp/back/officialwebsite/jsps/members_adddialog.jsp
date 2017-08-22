<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<form id="admins_gwcygl_adddialog_addForm"  method="post" action="" enctype="multipart/form-data">

	<table>
		<tr>
			<th>照片：</th>
			
			<td>
				<input class="easyui-filebox" value="原来图片" data-options="" name="uploadFile"/>
			</td>
			
		</tr>
	
		<tr>
			<th>名字：</th>
			<td>
				<input class="easyui-validatebox" data-options="required:true" name="name"/>
			</td>
			
		</tr>
		
		<tr>
			<th>年龄：</th>
			<td>
				<input class="easyui-numberbox" data-options="required:true,min:1,max:99,precision:0" name="age"/>
			</td>
			
		</tr>
		<tr>
			<th>生日：</th>
			<td>
				<input class="easyui-datebox" data-options="required:true" name="birthday"/>
			</td>
			
		</tr>
		
		<tr>
			<th>职位：</th>
			<td>
				<input class="easyui-validatebox" data-options="required:true" name="position"/>
			</td>
		</tr>
		
		<tr>
			<th>最后毕业学校：</th>
			<td>
				<input class="easyui-validatebox" data-options="" name="lastGraduateSchool"/>
			</td>
		</tr>
		<tr>
			<th>加入时间：</th>
			<td>
				<input class="easyui-datebox" data-options="required:true" name="joinTime"/>
			</td>
		</tr>
		
		<tr>
			<th>离职时间：</th>
			<td>
				<input class="easyui-datebox" data-options="" name="outTime"/>
			</td>
		</tr>
		<tr>
			<th>备注：</th>
			<td>
				<input class="easyui-validatebox" data-options="" name="note"/>
			</td>
		</tr>
		<tr>
			<th>qq：</th>
			<td>
				<input class="easyui-validatebox" data-options="" name="qq"/>
			</td>
		</tr>
		<tr>
			<th>email：</th>
			<td>
				<input class="easyui-validatebox" data-options="" name="email"/>
			</td>
		</tr>
		<tr>
			<th>phone：</th>
			<td>
				<input class="easyui-validatebox" data-options="" name="phone"/>
			</td>
		</tr>
		<tr>
			<th>介绍/说明：</th>
			<td>
				<textarea name="introduction"></textarea>
			</td>
			
		</tr>
		<tr>
			<th>展示/不展示：</th>
			<td>
				<select name="status">
					<option value="1">展示</option>
					<option value="0">不展示</option>
				</select>
			</td>
		</tr>
	</table>

	<a class="easyui-linkbutton"
		style="margin-left:190px;margin-top: 20px;"
		href="javascript:void(0);"
		data-options="iconCls:'icon-add',
		onClick:function(){
			$('#admins_gwcygl_adddialog_addForm').form('submit',{
				url:'${pageContext.request.contextPath}'+NAMESPACE_OW_BACK+'/owMembersUploadBackAction!uploadMembers.action',
				success:function(data){
					data = $.parseJSON(data);
					console.info(data);
					var msg = data.msg;
					var success = data.success;
					var obj = data.obj;
					<!-- 提示信息 -->
					showMsg(data);
					try{
						//判断是否在线
						isOnline(data);
					}catch(e){
						return;
					}
					if(success){
						gwcyglAddDialog.dialog('close');
						gwcyglDatagrid.datagrid('reload');
					}
				}
			 });
		}">提交</a>
</form>
<script type="text/javascript">
	$(function($){
		$(function($){
			

			
			loadOptionData(gwcyglAddDialog,'01');
			
			
			
			
		});
	});
</script>