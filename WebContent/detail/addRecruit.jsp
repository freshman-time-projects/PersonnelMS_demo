<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="detail/style/css/index_1.css" />
<style type="text/css">
select{
	height:30px;
}
*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;}
.form label, .form input, .form select, .form textarea, .form button, .form .label{float:left;font-size:12px;}
.fl{float:left;}.fr{float:right;}.fn{float:none;}
.hide{display:none;}.invisible{visibility:hidden;}.overflow{overflow:hidden;}
.clear{display:block;clear:both;height:0;overflow:hidden;}
body{font:12px/180% Arial, Helvetica, sans-serif,"宋体";}
/* yellow_button */
.yellow_button{background:url(images/yellow_button.png);border:none;cursor:pointer;height:36px;line-height:36px; overflow:hidden; display:inline-block; text-align:center; font-size:14px; font-weight:800; color:#fff;background-position:0 0;width:139px;}
#registsubmit.disabled{background-position:0 -36px;cursor:default!important;}
.red{color:#ff0000;font-family:"宋体";font-weight:normal;}
/* formbox */
#formbox{padding:20px;border:solid 1px #D1D1D1;margin:20px auto;width:880px;}
#formbox h3{font-size:16px;height:32px;color:#3366cc;font-weight:800;border-bottom:solid 1px #D1D1D1;margin:0 0 20px 0;padding:0 10px;}
#formbox .item{padding-top:5px;height:50px;overflow:hidden;line-height:26px;}
#formbox .item a:link,#formbox .item a:visited{text-decoration:underline;}
#formbox .label{width:300px;text-align:right;font-size:14px;}
#formbox .span-150{width:150px;}
#formbox .text{width:240px;height:28px;padding:4px 3px;border:1px solid #bbb;font-size:14px;font-family:arial,"宋体";}
#formbox .text-1{width:100px;}
#formbox .blank{width:16px;height:16px;margin:2px 5px 0;}
#formbox .img img{height:26px;margin:0 5px;}
#formbox .succeed{background:url(images/pwdstrength.gif) no-repeat -105px 0;}
#formbox .yellow_button{font-size:14px;font-weight:bold;color:#fff;border:none;cursor:pointer;}
#formbox .highlight1{border:1px solid #EFA100;outline:2px solid #FFDC97;*border:2px solid #ffcc66;*padding:3px 2px;}
#formbox .highlight2{border:1px solid #f00;outline:1px solid #FFC1C1;color:#f00;}
#formbox .pwdbg{background:#FFF8EB;}
#formbox .focus{color:#999;line-height:22px;*line-height:20px;}
#formbox .null,#formbox .error{color:red;line-height:22px;*line-height:20px;}
#formbox .checkbox{margin-top:6px;*margin-top:2px;}
#formbox #referrer{color:#999;font-size:12px;}
#formbox #protocol{margin:0px 5px 0 0;display:inline;}
#pwdstrength{color:#999;line-height:22px;padding-right:10px;}
#pwdstrength b{float:left;width:104px;height:13px;overflow:hidden;margin-top:5px;*margin-top:3px;}
.strengthA b{background:url(images/pwdstrength.gif) no-repeat 0 0;}
.strengthB b{background:url(images/pwdstrength.gif) no-repeat 0 -13px;}
.strengthC b{background:url(images/pwdstrength.gif) no-repeat 0 -26px;}
</style>
</head>
<body>

<div id="formbox">
	<form  id="formpersonal" action="recruitmethod?RecruitMethod=add&username=<%=username %>" method="post" >
	<div class="form">
		<h3>招聘人员信息录入</h3>
	<div class="item">
			<span class="label"><span class="red">*</span>员工姓名：</span>
			<div class="fl">
				<input type="text" id="username" placeholder="请输入真实姓名！" name="name" class="text" tabindex="1" pattern="^([a-zA-Z0-9\u4e00-\u9fa5\·]{1,10})$" />
				<label id="username_succeed" class="blank"></label>
				<span class="clear"></span>
				<div id="username_error"></div>
			</div>
		</div><!--item end-->
		 <div class="item">
			<span class="label"><span class="red">*</span>性别：</span>
			<div class="fl">
				<select rel="select" id="department" name="sex" tabindex="8">
					<option value="-1"  >请选择</option>
					<option value="男"  >男</option>
					<option value="女"  >女</option>
				</select>
				<label id="department_succeed" class="blank"></label>
				<span class="clear"></span>
				<label id="department_error"></label>
			</div>
		</div><!--item end-->
		 <div class="item">
			<span class="label"><span class="red">*</span> 学历：</span>
			<div class="fl">
				<select rel="select" id="department" name="edu" tabindex="8">
					<option value="-1"  >请选择</option>
					<option value="高中"  >高中</option>
					<option value="中专"  >中专</option>
					<option value="专科"  >专科</option>
					<option value="本科"  >本科</option>
					<option value="硕士研究生"  >硕士研究生</option>
					<option value="博士研究生"  >博士研究生</option>
				</select>
				<label id="referrer_succeed" class="blank invisible"></label>
				<span class="clear"></span>
				<label id="referrer_error"></label>
			</div>
		</div><!--item end-->
        <div class="item">
			<span class="label"><span class="red">*</span>毕业院校：</span>
			<div class="fl">
				<input type="text" id="referrer" name="school" class="text" tabindex="5" />
				<label id="referrer_succeed" class="blank invisible"></label>
				<span class="clear"></span>
				<label id="referrer_error"></label>
			</div>
		</div><!--item end-->
		 <div class="item">
			<span class="label"><span class="red">*</span>简历：</span>
			<div class="fl">
				<textarea name="cv"rows="3" cols="30">简历</textarea>
				<label id="referrer_succeed" class="blank invisible"></label>
				<span class="clear"></span>
				<label id="referrer_error"></label>
			</div>
		</div><!--item end-->
	</div>

     <input type=submit value=提交 onclick="return check()"style="width:150px;" class="button_blue">
   
	 </form>
    </div>
<!--formbox end-->

<script type="text/javascript" src="js/Validate.js"></script>
<script type="text/javascript" src="js/Validate.form.js"></script>

<!-- 过滤条件 -->
<!-- 主内容区域（数据列表或表单显示） -->
 
</body>
</html>
