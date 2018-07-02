<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	  <b>遍历List集合的全部元素：</b>
     <br>
     <c:forEach items="${teachers}" var="teacher">
     	教师姓名：${teacher.getName()}、
     	教师手机号：${teacher.getPhone()}<br>
     </c:forEach>

</body>
</html>