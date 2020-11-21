<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加用户</title>

<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<div class="easyui-panel" title="New Topic" style="width:65%;">
		<div style="padding:60px 30px 20px 30px">
	    <form id="ff" method="post" action="addUser">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>用户编号：</td>
	    			<td><input class="easyui-textbox" type="text" name="number" data-options="required:true"></input></td>
	    			<td>用户名称：</td>
	    			<td><input class="easyui-textbox" type="text" name="username" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>密码：</td>
	    			<td><input class="easyui-textbox" type="text" name="password" data-options="required:true"></input></td>
	    			<td>确认密码：</td>
	    			<td><input class="easyui-textbox" type="text" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>手机电话：</td>
	    			<td><input class="easyui-textbox" type="text" name="phone" data-options="required:true,validType:'phone'"></input></td>
	    			<td>角色：</td>
	    			<td>
	    				<select class="easyui-combobox" name="roleId" style="width:100px;">
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
	    				<input class="easyui-textbox" type="text" name="remark" style="border-color:skyblue;radius:5px;"></input>
	    			</td>
	    		</tr>
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" id="addBlink">添加</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	    </div>
	    </div>
	</div>

<div id="win" class="easyui-window" title="My Window" closed="true" style="width:300px;height:100px;padding:5px;">
    Some Content.
</div>
	<script>
		function submitForm(){
			$('#ff').form('submit');
		}
		function clearForm(){
			$('#ff').form('clear');
		}
		
	</script>
		<script>
		
		$(function () {
			var addInfo = "${addInfo}";
			console.log(typeof(addInfo));
			if(addInfo=="0"){
				$.messager.alert('提示','添加失败','error');
				//alert("添加失败");
			}
			if(addInfo=="1"){
				//console.log("hahah");
				//$.messager.alert('结果','添加成功',function(){//有问题
					//window.location.reload();
				//});
				//$.messager.alert('提示','添加成功','info');//有问题
				//return false;
				//$('#win').remove("closed");//有问题
				alert("添加成功");
				//console.log("heihei");
			}
		});
		</script>

</body>
</html>