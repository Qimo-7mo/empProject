<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>用户查询</title>

	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>

<!--用户列表数据-->
<!--  
<table id="dg" class="easyui-datagrid" title="用户列表" style="width:700px;height:auto"
	   data-options="
				singleSelect: true,
				toolbar: '#tb',
				url: 'SearchUsersServlet',
				method: 'get',
				onClickRow: onClickRow
			">	
	<thead>
		<tr>
			<th data-options="field:'ck',checkbox:true"></th>
			<th data-options="field:'number',width:80,align:'center'">账号</th>
			<th data-options="field:'username',width:80,align:'center'">昵称</th>
			<th data-options="field:'password',width:80,align:'center'">密码</th>
			<th data-options="field:'phone',width:80,align:'center'">手机</th>
			<th data-options="field:'roleId',width:60,align:'center'">角色</th>
			<th data-options="field:'remark',width:60,align:'center'">评价</th>
		</tr>
	</thead>
</table>

<div id="tb" style="height:auto">
	<div>
		账号： <input style="width:80px" id="searchId">
		姓名： <input style="width:80px" id="searrchName">
		角色:
		<select class="easyui-combobox" panelHeight="auto" style="width:100px">
			<option value="java">普通用户1</option>
			<option value="c">普通用户2</option>
			<option value="basic">普通用户3</option>
			<option value="perl">普通用户4</option>
			<option value="python">普通用户5</option>
		</select>
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="searchBtn" onclick="submitForm()">查询</a>
	</div>
</div>
-->
	<!-- 查询表单 -->
	<div>
		<form id="ff" method="post" action="">
			<!--账号-->
			<label for="number">账号:</label> <input class="easyui-numberbox"
				style="width: 200px" name="number" id="number" />
			<!--姓名-->
			<label for="name">姓名:</label> <input class="easyui-textbox"
				style="width: 200px" name="name" id="name" />
			<!--角色-->
			<label for="role">角色:</label> <select id="role"
				class="easyui-combobox" name="role" style="width: 150px;">
				<option value="worker">普通员工</option>
				<option value="admin">管理员</option>
				<option value="superAdmin">超级管理员</option>
			</select>
			

			<!--查询按钮-->
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'" onclick="submitForm()">查询</a>
			
		</form>
		
	</div>
	<!-- 显示的table,注意是动态获取的数据 -->
	<table id="dg" style="width: 100%; height: 420px"></table>
	<div class="easyui-panel">
	<div class="easyui-pagination" data-options="total:114,buttons:buttons"></div>
</div>
<!--分页-->
<!--
<div class="easyui-panel">
	<div class="easyui-pagination" data-options="total:114,buttons:buttons"></div>
</div>-->

<!-- 删除数据用 -->

<div id="dlg" class="easyui-dialog" title="Basic Dialog" data-options="iconCls:'icon-save'" style="width:400px;height:200px;padding:10px">
		The dialog content.
</div>


<div  id="dlgDel" class="easyui-dialog" data-options="closed:true"> 
<!-- 修改学生信息 class="easyui-panel" -->

<div title="修改学生信息" style="width:400px;height:450px;"
		data-options="closed:true,iconCls:'icon-edit',toolbar:'#dlg-toolbar',
		buttons:'#dlg-buttons'">
		<div style="padding:60px 30px 20px 30px">
	    <form id="ff" method="post"  class="easyui-form">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>用户编号：</td>
	    			<td><input class="easyui-textbox" type="text" name="number" id="number" data-options="required:true" disabled="disabled"></input></td>
	    		</tr>
	    		<tr>
	    			<td>用户名称：</td>
	    			<td><input class="easyui-textbox" type="text" name="username"  id="username" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>密码：</td>
	    			<td><input class="easyui-textbox" type="text" name="password" id="password" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>手机号码：</td>
	    			<td><input class="easyui-textbox" type="text" name="phone" id="phone" data-options="required:true,validType:'phone'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>角色：</td>
	    			<td>
	    				<select class="easyui-combobox" name="roleId" id="roleId" style="width:100px;">
		    				<option value="1" selected="selected">普通员工</option>
		    				<option value="2">管理员</option>
		    				<option value="3">经理</option>
		    				<option value="4">大老板</option>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>备注：</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" name="remark" id="remark" style="border-color:skyblue;radius:5px;"></input>
	    			</td>
	    		</tr>
	    	</table>
	    </form>

	    <!-- 修改数据用 -->
	  
<div id="dlg-buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="save()">保存</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" id="closeDlg">取消</a>
</div>

	    </div>
	</div>

</div>


<!--表格-->
<!-- 
<script type="text/javascript">

	var editIndex = undefined;
	function endEditing(){
		if (editIndex == undefined){return true}
		if ($('#dg').datagrid('validateRow', editIndex)){
			var ed = $('#dg').datagrid('getEditor', {index:editIndex,field:'productid'});
			var productname = $(ed.target).combobox('getText');
			$('#dg').datagrid('getRows')[editIndex]['productname'] = productname;
			$('#dg').datagrid('endEdit', editIndex);
			editIndex = undefined;
			return true;
		} else {
			return false;
		}
	}
	
	function onClickRow(index){
		if (editIndex != index){
			if (endEditing()){
				$('#dg').datagrid('selectRow', index)
						.datagrid('beginEdit', index);
				editIndex = index;
			} else {
				$('#dg').datagrid('selectRow', editIndex);
			}
		}
	}
	function append(){
		if (endEditing()){
			$('#dg').datagrid('appendRow',{status:'P'});
			editIndex = $('#dg').datagrid('getRows').length-1;
			$('#dg').datagrid('selectRow', editIndex)
					.datagrid('beginEdit', editIndex);
		}
	}
	function removeit(){
		if (editIndex == undefined){return}
		$('#dg').datagrid('cancelEdit', editIndex)
				.datagrid('deleteRow', editIndex);
		editIndex = undefined;
	}
	function accept(){
		if (endEditing()){
			$('#dg').datagrid('acceptChanges');
		}
	}
	function reject(){
		$('#dg').datagrid('rejectChanges');
		editIndex = undefined;
	}
	function getChanges(){
		var rows = $('#dg').datagrid('getChanges');
		alert(rows.length+' rows are changed!');
	}
	
</script>
 -->
<!--分页-->
<script>
	$(function (){
		$("#but111").onclick = function (){
			//获取列
			var row = $('#dg').datagrid('getSelected');
			if(row != null){
				$.messager.confirm('确认是否要删除','确定要删除（'+row.username+'）吗？',function(r){
					if(r){
						$.get("deleteUser?number="+row.number,null,function(data){
							$.messager.alert('结果',data,'info',function(){
								window.location.reload();
							})
						})
					}
				})
			}else{
				$.messager.alert('温馨提示','请先选择一个用户','info');
			}
		};
	});
</script>	
<script>

	var buttons = [{
		iconCls:'icon-cancel',
		handler:function(){
			//获取列
			var row = $('#dg').datagrid('getSelected');
			if(row != null){
				$.messager.confirm('确认是否要删除','确定要删除（'+row.username+'）吗？',function(r){
					if(r){
						$.get("deleteUser?number="+row.number,null,function(data){
							$.messager.alert('结果',data,'info',function(){
								window.location.reload();
							})
						})
					}
				})
			}else{
				$.messager.alert('温馨提示','请先选择一个用户','info');
			}
			//alert('cancel');
		}
	},{
		iconCls:'icon-edit',
		handler:function(){
			//$('#dlg').dialog('close');
			//获取列
			var row = $('#dg').datagrid('getSelected');
			
			if(row != null){
				
				$('#dlgDel').dialog('open');
				
				//var rowD = $('#dlgDel').datagrid('getSelected');
				var row = $('#dg').datagrid('getSelected');
				//console.log(rowD);
				if(row!=null){
					$("#number").textbox('setValue',row.number);
					$("#username").textbox('setValue',row.username);
					$("#password").textbox('setValue',row.password);
					$("#phone").textbox('setValue',row.phone);
					$("#roleId").combobox('setValue',row.roleId);
					$("#remark").textbox('setValue',row.remark);
					$("#dlg").dialog('open');
				}
			}else{
				$.messager.alert('温馨提示','请先选择一列内容','info');
			}
			//alert('edit');
		}
	}];
	
	//保存
	function save(){
		//获得控件中的数据
		var number = $("#number").val();
		var username = $("#username").val();
		var password = $("#password").val();
		var phone = $("#phone").val();
		var roleId = $("#roleId").val();
		var remark = $("#remark").val();
		//将获得的数据改为json数据
		var json = {
				"number":number,
				"username":username,
				"password":password,
				"phone":phone,
				"roleId":roleId,
				"remark":remark,
				
		};
		//ajax操作
		$.post("updateUser",json,function(data){
			var info= "sorry，修改失败";
			var pic = "error";
			if(data == "1"){
				info = "修改成功";
				pic = "info";
			}
			$.messager.alert('结果',info,pic,function(){
				window.location.reload();
			});
		});
		console.log()
	}
	
</script>
<script>

	$(function (){
		$('#dlg').dialog('close');
		
		//查询（查到的显示，没有的隐藏）
		if($("#datagrid-row-r1-2-0")){
			console.log(this);
		}
	
		
		
	});

</script>
<!--分页-->
<script type="text/javascript">
	$(function() {

		//界面加载完成后第一件事情就是去后台服务器端获取数据
		getData("${pageContext.request.contextPath}/findUsers"); //调用获取数据方法
	})

	//用户的列表的方法
	function getData(url, number, username, roleId) {
		$('#dg').datagrid({
			url : url,
			title : '用户列表',
			border : false,
			rownumbers : true,
			toolbar : '#tb',
			pagination : true,
			pageSize : "5",
			queryParams : {
				number : number,
				username : username,
				roleId : roleId,

			},
			pageList : [ 5, 10, 15, 20 ],
			singleSelect : true,
			columns : [ [ {
				field : 'id',
				value : 'number',
				checkbox : true,
				title : '选择',
				width : 50
			}, {
				field : 'number',
				title : '账号',
				width : 80
			}, {
				field : 'username',
				title : '昵称',
				width : 80
			}, {
				field : 'password',
				title : '密码',
				width : 80
			}, {
				field : 'phone',
				title : '手机',
				width : 220
			}, {
				field : 'roleId',
				title : '角色',
				width : 80
			}, {
				field : 'remark',
				title : '备注',
				width : 220
			} ] ]
		});
	}
</script>
	

</body>
</html>