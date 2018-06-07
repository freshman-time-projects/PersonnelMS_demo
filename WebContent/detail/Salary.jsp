<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String username = (String)session.getAttribute("username");
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
					src="detail/style/images/title_arrow.gif" />工资管理
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea" class="ttt">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>ID</td>
					<td>姓名</td>
					<td><a href="showsalary?showkey=salarydesc">月工资<img width="14px" src="detail/style/images/1.png"></a></td>
					<td><a href="showsalary?showkey=bonusdesc">年奖励金额<img width="14px" src="detail/style/images/1.png"></a></td>
					<td><a href="showsalary?showkey=finedesc">年罚款金额<img width="14px" src="detail/style/images/1.png"></a></td>
					<td><a href="showsalary?showkey=salarydesc">年薪<img width="14px" src="detail/style/images/1.png"></a></td>
					<td colspan="3">操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<c:forEach var="Salarys" items='${requestScope.Salarys}'>
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>${Salarys.id }</td>
					<td>${Salarys.name }</td>
					<td>${Salarys.salary }</td>
					<td>${Salarys.bonus}</td>
					<td>${Salarys.fine }</td>
					<td>${12*Salarys.salary +Salarys.bonus-Salarys.fine }</td>
					<td><a href="salarymethod?id=${Salarys.id }&bonus=${Salarys.bonus }&method=updatebonus&username=<%=username %>">奖</a></td>
					<td><a href="salarymethod?id=${Salarys.id }&fine=${Salarys.fine }&method=updatefine&username=<%=username %>">罚</a></td>
					<td><a href="salarymethod?id=${Salarys.id }&level=${Salarys.level }&salary=${Salarys.salary }&method=uplevel&username=<%=username %>">升职</a></td>
					
				</tr>
			</c:forEach>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
		</div>
	</div>
</body>
</html>
