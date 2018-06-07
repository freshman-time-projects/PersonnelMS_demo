<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'right.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <style type="text/css">
 body{text-align:center;}
 #right-picture {height:500px;width:624px;float:left;margin:50px 5px 5px 80px;}
 #right-gonggao{border:#33FFFF solid thin;float:left;height:500px;width:200px;margin:50px 200px 0px 10px;}
 #right-title {background-color:00CCFF;font-family:华文新魏;font-size:28px;color:red;margin:0px;}
 #right-neirong {font-family:宋体;font-size:15px;color:black;}
p{
	margin-left:4px;
	margin-right:4px;
	text-indent:2em;
	letter-spacing:1px;
	text-align:left;
}
 </style>
  </head>
  <script>alert("欢迎使用人事管理系统");</script>
	<body>
		<div id="right-picture">
		<img src="detail/style/images/5.jpg"width=100% height=100%;>
		</div>
		<div id="right-gonggao">
    <p id="right-title">    公告</p>
    <hr>
     <p id="right-neirong">
尊敬的领导、同事：
</p>
<p id="right-neirong">
你们好!
</p>
<p id="right-neirong">
为了更好的服务广大客户，可以更方便快捷的了解到我司的产品概况，经过一段时间精心的设计与制作，网站于十二月份正式上线。
</p>
<p id="right-neirong">
网站是以人事管理形式为主题，在内容上，全面反映了公司基本概况等情况，欢迎各位领导同事登陆浏览，同时提出你们的宝贵意见!
</p>
</div>

	</body>
</html>
