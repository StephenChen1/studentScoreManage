<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl -->
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@include file="common/head.jsp"%>
<title>登录</title>
</head>
<body>
<br><br><br><br>
	<div align = "center">
	   <span  id = "loginTip"></span><br>
	   <label for="userId">账号：</label>
	   <input name= "userId" type = "text" id = "userId"><br>
	   <label for="password">密码：</label>
	   <input name = "password" type = "password" id = "password"><br>
	   <label class = "radio_inline">
	    <input type = "radio" name = "position" id = "student" value = "student" checked>学生
	 </label> 
	 <label class = "radio_inline">
	    <input type = "radio" name = "position" id = "teacher" value = "teacher">教师
	 </label>
	 <label class = "radio_inline">
	    <input type = "radio" name = "position" id = "manager" value = "manager">教务员
	 </label>
	 <br>
	 <button class = "btn btn_login" id = "login">登录</button>   
	</div>

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="${basePath}resources/js/loginOld.js"  type="text/javascript"></script>
</body>
</html>