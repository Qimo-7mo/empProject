<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>人事管理系统主页</title>

<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js">
</script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js">
</script>
</head>
<body class="easyui-layout">


	<div class="easyui-layout" style="width:100%;height:100%;">
		<!--顶部 -->
		<div data-options="region:'north'" style="height:50px;background-color: #e0ecff;">
			<div class="topLeft" style="float:left;">
				<h2 style="margin-left:20px;color:lightslategray;">人事管理系统</h2>
			</div>
			<div class="topRight" style="float:right;position:relative;">
				<span style="position:absolute;right:210px;">首页</span>
				<span style="position:absolute;right:80px;">退出登陆</span><br>
				<div style="padding:5px;width:800px;height:25px;background-color:whitesmoke;border-radius:5px;margin-bottom:0px;">
					<span style="position:absolute;left:10px;">当前用户：${user.username}</span>
					
					<span id="ptime" style="position:absolute;right:20px;"></span>

				</div>

			</div>
		</div>
		<!--底部 -->
		<div data-options="region:'south'" style="height:30px;text-align:center;line-height:30px;font-size:12px;">@2020年  五邑大学智能制造学部网络工程专业第33小组J2EE作业 </div><!-- 南：结束 -->
		<!--右部-->
		<div data-options="region:'east',split:true" title="系统说明" style="width:100px;"></div>
		<!--左部 开始-->
		<div data-options="region:'west'" title="<center>公司人事管理</center>" style="width:200px;">
			
			<!-- 手风琴开始 -->
			<div class="easyui-accordion" style="width:100%;height:100%;">
				<!-- 用户管理-->
				<div title="用户管理" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
					<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" id="but1">用户查询</a><br>
					<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="margin-top:10px;" id="but2">添加用户</a>
				</div>
				<!-- 部门管理-->
				<div title="部门管理" data-options="iconCls:'icon-help'" style="padding:10px;">
				</div>
				<!-- 职位管理-->
				<div title="职位管理" data-options="iconCls:'icon-edit'" style="padding:10px;">
				</div>
				<!-- 员工管理-->
				<div title="员工管理" data-options="iconCls:'icon-man'" style="padding:10px;">
				</div>
				<!-- 公告管理-->
				<div title="公告管理" data-options="iconCls:'icon-ok'" style="padding:10px;">
					<a class="easyui-linkbutton" data-options="iconCls:'icon-print'" id="but3">公告查询</a><br>
					<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="margin-top:10px;" id="but4">添加公告</a>
				</div>
				<!-- 下载中心-->
				<div title="下载中心" data-options="iconCls:'icon-print'" style="padding:10px;">
					<a class="easyui-linkbutton" data-options="iconCls:'icon-save'" id="but5">文件下载</a><br>
					<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="margin-top:10px;" id="but6">文件上传</a>
				</div>
			</div><!-- 手风琴结束 -->
			
		</div><!-- 西：左部 结束-->
		<!--中部 -->
		<div data-options="region:'center'">
			<!-- 选项卡  开始 -->
			<div class="easyui-tabs" style="width:100%;height:100%" id="tt">
			  
			  
			</div><!-- 选项卡  结束 -->
		</div>
	</div>
	
	<script>
	$(function (){
        $("#but1").click(function (){
        	addTabs("#tt", "用户查询", "searchUsers.jsp", 'icon-search');
        });

        $("#but2").click(function (){
        	addTabs("#tt", "添加用户", "addUsers.jsp", 'icon-add');
        });
        
        $("#but3").click(function (){
        	addTabs("#tt", "公告查询", "findNotice.jsp", 'icon-add');
        });
        
        $("#but4").click(function (){
        	addTabs("#tt", "添加公告", "addNotice.jsp", 'icon-add');
        });
        
        $("#but5").click(function (){
        	addTabs("#tt", "文件下载", "download.jsp", 'icon-save');
        });
        
        $("#but6").click(function (){
        	addTabs("#tt", "文件上传", "upload.jsp", 'icon-add');
        });
        
      //添加tabs函数
        function addTabs(tabId, titleName, url, icons){
            var res = $(tabId).tabs("exists",titleName);
            if(res){
                $(tabId).tabs("select",titleName);
            }else{
                // 添加一个新的标签页面板（tab panel）
                $(tabId).tabs('add',{
                    title:titleName,
                    content:'<iframe scrolling="auto" src="'+url+'" style="width:100%;height:100%;"></iframe>',
                    closable:true,
                    iconCls:icons,
                    tools:[{
                        iconCls:'icon-mini-refresh',
                        handler:function(){
                            alert('refresh');
                        }
                    }]
                });
            }
        }
    });
</script>
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
</body>
</html>