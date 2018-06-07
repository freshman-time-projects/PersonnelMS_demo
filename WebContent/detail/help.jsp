<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'help.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">

#yi {float:left;width:15%;border:black solid thin;position:fixed;margin:0px 20px 0px 50px; }
#er {float:right;width:70%;border:black dashed thin;margin:0px 50px 0px 20px;}
ul {color:red;}
h2 {color:red;}
</style>
  </head>
  
  <body>
<center><h1>快速入门</h1></center>
<div id="yi">
<h2>功能介绍</h2><hr><ul>板块一<li><img src="detail/style/images/11.PNG"width=70%;></li></ul>  <ul>板块二<li><img src="detail/style/images/12.PNG"width=70%;></li></ul>
</div>
<div id="er"><h2>功能内容</h2>
<hr>
<ul>
  <li>信息录入<img src="detail/style/images/13.PNG"width=70%;></li>
  <hr>
  <li>信息查看<img src="detail/style/images/14.PNG"width=70%;></li>
  <hr>
  <li>用户管理<img src="detail/style/images/15.PNG"width=70%;></li>
  <hr>
  <li>工资管理<img src="detail/style/images/16.PNG"width=70%;></li>
  <hr>
  <li>添加招聘<img src="detail/style/images/17.PNG"width=70%;></li>
  <hr>
  <li>招聘管理<img src="detail/style/images/18.PNG"width=70%;></li>
  <hr>
  <li>面试列表<img src="detail/style/images/19.PNG"width=70%;></li>
   </ul>
</div>
  </body>
</html>
