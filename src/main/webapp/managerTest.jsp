<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务员测试页面</title>
</head>
<body>
	<!-- 
	<form action="managerTest/arrange">
		教师ID：<input type="text" name="teacher_id" value=""><br>
		课程ID：<input type="text" name="course_id" value=""><br>
		学年：<input type="text" name="year" value=""><br>
		学期：<input type="text" name="semester" value=""><br>
		<input type="submit" value="增加">
	</form>
	 -->
	 
	 <form action="managerTest/getTeachers">
	 	课程ID：<input type="text" name="course_id" value=""><br>
	 	学年year：<input type="text" name="year" value=""><br>
	 	学期semester：<input type="text" name="semester" value=""><br>
	 	<input type="submit" value="查询">
	 </form>
</body>
</html>