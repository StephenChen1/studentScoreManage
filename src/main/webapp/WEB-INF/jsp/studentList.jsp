<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl -->
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@include file="common/head.jsp"%>
<title>学生列表页</title>
</head>
<body>
	<!-- 页面显示部分 -->
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>学生列表</h2>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>班级</th>
							<th>电话</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="sk" items="${list}">
							<tr>
								<td>${sk.id}</td>
								<td>${sk.name}</td>
								<td>${sk.classes}</td>
								<td>${sk.phone}</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>