<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>easyui-文件上传</title>

<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<style>
div.divide {
	height: 10px;
}
</style>
</head>
<body>
	<div class="easyui-panel" title="多文件上传"
		style="width: 700px; height: 500px;">
		<div style="padding: 40px 60px 20px 60px;">
			<form method="post" multiple="multiple" enctype="multipart/form-data"
				id="form">
				上传人: <input type="text" name="name" value="${user.username}"
					readonly="readonly"> <br> <br> <input
					class="easyui-filebox" style="width: 300px" buttonText="添加文件"
					buttonIcon="icon-search" multiple="true" name="upload"> <br>
				<br> <input type="button" value="上传文件" onclick="submitForm()"
					style="width: 300px;">
			</form>
		</div>
		</div>
</body>
<script>
	function submitForm() {
		$('#form').form('submit', {
			url : "upload",
			success : function(data) {
				if (data == "1") {
					//easyui的信息提示框: 1. 标题，2.提示信息，3.图标
					$. messager.alert('上传成功','恭喜你,上传成功!','info');
				} else {
					$.messager.alert('上传失败','对不起，上传失败!','error');
				}
			}
		});
	}
</script>
</html>