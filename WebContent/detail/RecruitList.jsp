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
					src="detail/style/images/title_arrow.gif" />招聘信息查看
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0" style="table-layout:fixed">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle" >
					<td>编号</td>
					<td>姓名</td>
					<td>性别</td>
					<td>毕业学校</td>
					<td>学历</td>
					<td style="width:260px">简历</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<c:forEach var="recruit" items='${requestScope.list}'>
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>${recruit.id }</td>
					<td>${recruit.name }</td>
					<td>${recruit.sex }</td>
					<td>${recruit.school }</td>
					<td>${recruit.edu }</td>
					<td style="font-size:14px;padding:8px;">${recruit.cv }</td>
					<td><a href="recruitmethod?id=${recruit.id }&RecruitMethod=gotoFace&username=<%=username %>">通过</a></td>
				</tr>
			</c:forEach>
		</table>
		<!-- 分页 -->
		<div id="TableTail" align="center">
		   <p class="page">
                            <a href="recruitmethod?RecruitMethod=show&page=${page.indexpage_recruit-1}">&lt;&lt; 首页 </a>
                            <a href="recruitmethod?RecruitMethod=show&page=${page.page_recruit-1 }">    &lt; 上一页 </a>
                            <strong>第${page.page_recruit+1}页/共${page.pagenumber_recruit}页</strong>
                            <a href="recruitmethod?RecruitMethod=show&page=${page.page_recruit+1}">下一页 &gt;</a>
                            <a href="recruitmethod?RecruitMethod=show&page=${page.pagenumber_recruit-1}">末页 &gt;&gt;</a>
           </p>
		</div>
		<a href="detail/addRecruit.jsp">添加信息</a>
	</div>
</body>
</html>