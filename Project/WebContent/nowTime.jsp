<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
</head>
<body>
<span id="ptime"></span>

</body>
<script type="text/javascript">
    //定时器：实时调用获取时间函数
    var mytime = setInterval(function () {
        getTime();
    },1000);

  //获取时间的方法
    function getTime() {

        var d = new Date();
        var M = (d.getMonth()+1) < 10 ? ('0'+(d.getMonth()+1)) : (d.getMonth()+1);//月
        var D = d.getDate() < 10 ? ('0'+d.getDate()) : d.getDate();//日
        var H = d.getHours() < 10 ? ('0'+d.getHours()) : d.getHours();//时
        var m = d.getMinutes() < 10 ? ('0'+d.getMinutes()) : d.getMinutes();//分
        var s = d.getSeconds() < 10 ? ('0'+d.getSeconds()) : d.getSeconds();//秒
        var t = d.getFullYear() + "年" + M +  "月" + D + "日&nbsp;&nbsp;&nbsp;&nbsp;" + H + ":" + m + ":" + s + "&nbsp;&nbsp;&nbsp;&nbsp;星期" + "日一二三四五六".charAt(d.getDay());
        $("#ptime").html(t);
    }
</script>
</html>