<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="detail/style/js/jquery.js"></script>
<script type="text/javascript" src="detail/style/js/page_common.js"></script>
<link href="detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="detail/style/css/index_1.css" />
<script>
	 function sure()
	{
		 if(window.confirm('确定要删除吗?')){
                 //alert("确定");
                 return true;
              }else{
                 //alert("取消");
                 return false;
             }
   }
</script>
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="detail/style/images/title_arrow.gif" />账户管理中心
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
<div id="QueryArea">
		<form action="search" method="post">
			<input type="hidden" name="method" value="search">
			<input type="text" name="name" title="请输入name">
			<input type="submit" value="搜索">
		</form>
	</div>
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea" class="ttt">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>账号</td>
					<td>密码</td>
					<td colspan="2">操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<c:forEach var="user" items='${requestScope.user}'>
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>${user.username }</td>
					<td>${user.password }</td>
                    <td><a href="detail/modifyUser.jsp?username=${user.username }">修改</a></td>
                    <td><a href="usermethod?UserKey=remove&username=${user.username }" onclick="return sure()">删除</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>