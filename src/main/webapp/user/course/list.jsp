
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<title>课程信息列表</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>


</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">

			<li>课程管理</li>
			<li>显示课程信息</li>

		</ul>
	</div>
	<form
		action="${pageContext.request.contextPath}/user/course/listByPage.action"
		method="post" id="f1" class="form-inline">
		<div class="row alert alert-info form-inline"
			style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>课程号</label> <input type="text" class="form-control"
					name="courseId" placeholder="请输入课程编号" />
			</div>
			<input type="submit" value="查询课程" class="btn btn-success" />

		</div>
	</form>
	<div class="row" style="padding: 15px;">
		<table class="table ">
			<tr>
				
				<th>编号</th>
				<th>名称</th>
				
				<th>学分</th>
				<th>课时</th>
				<th>附加說明</th>
				<th>类别</th>
			</tr>

			<c:forEach items="${pageInfo.list}" var="course" varStatus="v">
				<tr>
					<td><input type="checkbox" id="ids" class="bianhao" name="ck"
						value="${course.courseId}"></td>

					<td>${course.courseId }</td>
					<td>${course.courseName}</td>
					
					<td>${course.courseScore}</td>
					<td>${course.courseHour}</td>
					<td>${course.courseRemark}</td>
                    <td>${course.courseKind.kindName}</td> 


				</tr>

			</c:forEach>
		</table>
		<nav class="navbar navbar-default navbar-fixed-bottom">
			<ul class="pagination">
				<li><a
					href="?courseId=${courseId}&pageNum=${pageInfo.pageNum-1 }"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach var="i" begin="1" end="${pageInfo.pages}" step="1">
					<li><a
						href="?courseId=${courseId}&pageNum=${i}">${i}</a></li>
				</c:forEach>
				<li><a
					href="?courseId=${courseId}&pageNum=${pageInfo.pageNum+1 }"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>
</body>
</html>
