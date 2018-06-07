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

</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="detail/style/images/title_arrow.gif" />人员信息查看
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
<div id="QueryArea">
	以下是查询结果：
	</div>
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>ID</td>
					<td>姓名</td>
					<td>年龄</td>
					<td>性别</td>
					<td>婚姻状态</td>
					<td>身份证</td>
					<td>学历</td>
					<td>毕业学校</td>
					<td>手机</td>
					<td>家庭住址</td>
					<td>邮箱</td>
					<td>部门</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<c:forEach var="person" items='${requestScope.persons}'>
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>${person.id }</td>
					<td>${person.name }</td>
					<td>${person.age }</td>
					<td>${person.sex }</td>
					<td>${person.married }</td>
					<td>${person.idcard }</td>
					<td>${person.edu }</td>
					<td>${person.school }</td>
					<td>${person.mobile }</td>
					<td>${person.address }</td>
					<td>${person.email }</td>
					<td>${person.org }</td>
				</tr>
			</c:forEach>
		</table>
	
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
		</div>
	</div>
</body>
</html>