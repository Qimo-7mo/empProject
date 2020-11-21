<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件下载</title>

    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <script type="text/javascript" src="easyui/jquery.min.js">
    </script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js">
    </script>
<style>
div.divide {
	height: 10px;
}
</style>
</head>
<body>
<div class="easyui-panel" title="文件下载"
		style="width: 700px; height: 500px;">
		<div style="padding: 40px 60px 20px 60px;">
	<a href="${pageContext.request.contextPath}/download.action?filename=<%=URLEncoder.encode("小环_20200719223050207_9.jpg","UTF-8")%>">小环_20200719223050207_9.jpg</a>
	<br>
	<a href="${pageContext.request.contextPath}/download.action?filename=<%=URLEncoder.encode("小环_20200719223106131_8.jpg","UTF-8")%>">小环_20200719223106131_8.jpg</a>
	<br>
	<a href="${pageContext.request.contextPath}/download.action?filename=<%=URLEncoder.encode("小环_20200719223115923_1.png","UTF-8")%>">小环_20200719223115923_1.png</a>
	<br>
	<a href="${pageContext.request.contextPath}/download.action?filename=<%=URLEncoder.encode("小环_20200719223115924_2.jpg","UTF-8")%>">小环_20200719223115924_2.jpg</a>
	<br>
	<a href="${pageContext.request.contextPath}/download.action?filename=<%=URLEncoder.encode("小环_20200719223115925_3.jpg","UTF-8")%>">小环_20200719223115925_3.jpg</a>
	<br>
	<a href="${pageContext.request.contextPath}/download.action?filename=<%=URLEncoder.encode("小环_20200719223115926_4.jpg","UTF-8")%>">小环_20200719223115926_4.jpg</a>
	<br>
	<a href="${pageContext.request.contextPath}/download.action?filename=<%=URLEncoder.encode("小环_20200719223115928_5.jpg","UTF-8")%>">小环_20200719223115928_5.jpg</a>
	<br>
	<a href="${pageContext.request.contextPath}/download.action?filename=<%=URLEncoder.encode("小环_20200719223115929_6.jpg","UTF-8")%>">小环_20200719223115929_6.jpg</a>
	<br>
	<a href="${pageContext.request.contextPath}/download.action?filename=<%=URLEncoder.encode("小环_20200719223115929_7.jpg","UTF-8")%>">小环_20200719223115929_7.jpg</a>
	<br>
	<a href="${pageContext.request.contextPath}/download.action?filename=<%=URLEncoder.encode("小环_20200719225748538_b.doc","UTF-8")%>">小环_20200719225748538_b.doc</a>
	<br>
	<a href="${pageContext.request.contextPath}/download.action?filename=<%=URLEncoder.encode("小环_20200720085239832_3.doc","UTF-8")%>">小环_20200720085239832_3.doc</a>
	<br>
	<a href="${pageContext.request.contextPath}/download.action?filename=<%=URLEncoder.encode("小环_20200720085537572_第4章  汇编语言程序设计-D15.pdf","UTF-8")%>">小环_20200720085537572_第4章  汇编语言程序设计-D15.pdf</a>
	</div>
	</div>
	<%-- <div class="easyui-panel" title="文件下载"
		style="width: 700px; height: 500px;">
		<div style="padding: 40px 60px 20px 60px;">
			<c:forEach items="${list}" var="li">
				<form action="download" method="post">
					<input type="hidden" name="filename" value="${li}">${li}
					<input type="submit" value="下载">
				</form>
			</c:forEach>
		</div>
	
	</div> --%>
</body>
</html>