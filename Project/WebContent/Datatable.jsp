<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>easyui-数据表格</title>

<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js">
</script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js">
</script>
</head>
<body>
	
	
	<table id="dg" title="用户列表" style="width:100%;height:500px"
			data-options="rownumbers:true,singleSelect:true,pagination:true,url:'datagrid_data1.json',method:'get',toolbar:'#tb'">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'itemid',width:80">账号</th>
				<th data-options="field:'productid',width:100">昵称</th>
				<th data-options="field:'listprice',width:80,align:'right'">密码</th>
				<th data-options="field:'unitcost',width:80,align:'right'">角色</th>
				<th data-options="field:'attr1',width:240">注册时间</th>	
			</tr>
		</thead>
	</table>
	
		<div id="tb" style="padding:5px;height:auto">
		<div>
			账号： <input style="width:80px">
			姓名： <input style="width:80px">
			角色: 
			<select class="easyui-combobox" panelHeight="auto" style="width:100px">
				<option value="java">普通用户1</option>
				<option value="c">普通用户2</option>
				<option value="basic">普通用户3</option>
				<option value="perl">普通用户4</option>
				<option value="python">普通用户5</option>
			</select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
		</div>
	</div>
	
		
	<script type="text/javascript">
		$(function(){
			var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				buttons:[{
					iconCls:'icon-cancel',
					handler:function(){
						alert('search');
					}
				},{
					iconCls:'icon-edit',
					handler:function(){
						alert('edit');
					}
				}]
			});			
		})
	</script>
</body>
</html>