<%@page import="com.zzupms.entity.Person"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link href="detail/style/css/common_style_blue.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="text/css"
	href="detail/style/css/index_1.css" />
<script>
	 function sure()
	{
		 if(window.confirm('员工离职时使用，删除后，该员工工资信息也会一起删除，且无法恢复，确定要删除吗?')){
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
					src="detail/style/images/title_arrow.gif" />人员信息查看
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<div id="QueryArea">
		<form action="search" method="post">
			<input type="hidden" name="method" value="search"> <input
				type="text" name="name" title="请输入name"> <input
				type="submit" value="搜索">
		</form>
	</div>
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea" class="ttt">
		<table class="MainArea_Content" align="center" cellspacing="0"
			cellpadding="0">
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
					<td colspan="2">操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<c:forEach var="person" items='${requestScope.list}'>
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
						<td><c:choose>
								<c:when test='${person.org==1 }'>办公室</c:when>
								<c:when test='${person.org==2 }'>市场部</c:when>
								<c:when test='${person.org==3 }'>采购部</c:when>
								<c:when test='${person.org==4 }'>技术部</c:when>
								<c:when test='${person.org==5 }'>人力资源</c:when>
								<c:otherwise>其他</c:otherwise>
							</c:choose></td>
						<td><a
							href="personmethod?PersonMethod=update_jsp&username=<%=username%>&id=${person.id }">修改</a></td>
						<td><a
							href="personmethod?PersonMethod=remove&username=<%=username%>&id=${person.id}"
							onclick="return sure()">删除</a></td>
					</tr>
			</c:forEach>
		</table>
		<!-- 分页 -->
		<div id="TableTail" align="center">
			<p class="page">
				<a href="personmethod?PersonMethod=show&page=${page.indexpage-1}">&lt;&lt;
					首页 </a> <a href="personmethod?PersonMethod=show&page=${page.page-1 }">
					&lt; 上一页 </a> <strong>第${page.page+1}页/共${page.pagenumber}页</strong> <a
					href="personmethod?PersonMethod=show&page=${page.page+1}">下一页
					&gt;</a> <a
					href="personmethod?PersonMethod=show&page=${page.pagenumber-1}">末页
					&gt;&gt;</a>
			</p>
		</div>
	</div>
</body>
</html>