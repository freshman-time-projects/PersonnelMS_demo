<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String username = (String)session.getAttribute("username");
	if(username==null){
		out.print("<script>alert('请先登录!');location.href='../index.html'</script>");
	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事后台管理</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  	<frameset rows="100px,*,19px" framespacing="0" border="0" frameborder="0">
		<frame src="detail/top.jsp" scrolling="no" noresize /> 
		<frameset cols="178px,*">
			<frame noresize src="detail/left.jsp" scrolling="yes" /> 
			<frame noresize name="right" src="detail/right.jsp" scrolling="yes" /> 
		</frameset>
		<frame noresize name="status_bar" scrolling="no" src="detail/bottom.jsp" />
	</frameset>
 <noframes>
		<body>
			你的浏览器不支持框架布局，推荐你使用<a href="http://www.firefox.com.cn/download/" style="text-decoration: none;">火狐浏览器</a>,
			<a href="http://www.google.cn/intl/zh-CN/chrome/" style="text-decoration: none;">谷歌浏览器</a>
		</body>
		
	</noframes>
</html>
