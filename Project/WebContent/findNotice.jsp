<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公告查询</title>

<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js">
</script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js">
</script>
</head>
<body>
公告名称：<input class="easyui-textbox" type="text" name="title" style="width:150px;">
公告主题：<input class="easyui-textbox" type="text" name="title" style="width:150px;">
公告内容：<input class="easyui-textbox" type="text" name="title" style="width:150px;">
<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px">查询</a>
<br><br>
<table id="dg" class="easyui-datagrid" title="CheckBox Selection on DataGrid" style="width:700px;height:250px"
			data-options="rownumbers:true,singleSelect:true,url:'selectNoticeServlet',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'name',width:80">公告名称</th>
				<th data-options="field:'title',width:300">公告标题</th>
			</tr>
		</thead>
	</table>
	<div style="margin:10px 0;">
		<span>Selection Mode: </span>
		<select onchange="$('#dg').datagrid({singleSelect:(this.value==0)})">
			<option value="0">Single Row</option>
			<option value="1">Multiple Rows</option>
		</select><br/>
		SelectOnCheck: <input type="checkbox" checked onchange="$('#dg').datagrid({selectOnCheck:$(this).is(':checked')})"><br/>
		CheckOnSelect: <input type="checkbox" checked onchange="$('#dg').datagrid({checkOnSelect:$(this).is(':checked')})">
	</div>
</body>
<script type="text/javascript">
		$(function(){
			var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				buttons:[{
					iconCls:'icon-search',
					handler:function(){
						alert('search');
					}
				},{
					iconCls:'icon-add',
					handler:function(){
						alert('add');
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