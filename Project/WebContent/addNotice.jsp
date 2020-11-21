<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加公告</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"></script>
</head>
<body>

<form id="ffNotice" method="post" action="addNotice">
    <!--公告名称-->
    <div style="margin:10px;">
        <lable for="title">公告名称：</lable><input type="text" name="noticeName" id="noticeName" style="width:300px;">
    </div>
    <!--公告主题-->
    <div style="margin:10px;">
        <lable for="name">公告主题：</lable><input type="text" name="title" id="title" style="width:300px;">
    </div>
    <div style="margin:10px;">
        <textarea name="content" id="container" style="width:100%;height:500px;"></textarea>

    </div>
    <input type="submit" value="发布公告">

</form>
</body>
<script text="text/javascript">
    function submitForm() {
        $("#ffNotice").form('submit');
    }
 var ue = UE.getEditor("container");
    
</script>
</html>