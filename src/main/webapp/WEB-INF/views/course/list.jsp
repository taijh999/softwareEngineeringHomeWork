
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
<script type="text/javascript">
	function checkAll() {
		var d = $("input:checkbox[name='ck']");
		$.each(d, function(i, n) {
			//$(o).attr("checked", "true");
			n.checked = !n.checked;
		})
	}

	function updateCourse() {
		var ck = document.getElementsByName("ck");
		var s = 0;
		var v = "";
		for (var i = 0; i < ck.length; i++) {
			if (ck[i].checked) {
				v = ck[i].value;
				s++;
			}
		}
		if (s != 1) {
			alert("每次只能修改一个，请重新选择");
		} else {
			console.info(v);
			window.location.href = "${pageContext.request.contextPath}/course/updatePage.action?courseId="
					+ v;
		}
	}

	function deleteCourse() {
		var ck = document.getElementsByName("ck");
		var tr = $("input:checked").parent().parent();
		var s = "";
		for (var i = 0; i < ck.length; i++) {
			if (ck[i].checked) {
				s += ck[i].value + ",";
			}
		}
		console.info(s);
		if (s == "") {
			alert("请至少选择一个被删除的课程");
			return;
		}
		if (confirm('确实要删除该课程吗?')) {
			$
					.ajax({
						type : "post",
						url : "${pageContext.request.contextPath}/course/deleteBatch.action",
						dataType : "json",
						data : {
							"courseIds" : s
						},
						success : function(data) {

							if (data.msg == "OK") {
								alert("课程删除成功！");
								tr.remove();
								//window.location.reload();
							} else {
								alert("删除客户失败！");
								//window.location.reload();
							}
						}
					});
		}
	}
</script>

</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">

			<li>课程管理</li>
			<li>显示课程信息</li>

		</ul>
	</div>
	<form
		action="${pageContext.request.contextPath}/course/listByPage.action"
		method="post" id="f1" class="form-inline">
		<div class="row alert alert-info form-inline"
			style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>课程号</label> <input type="text" class="form-control"
					name="courseId" placeholder="请输入课程编号" />
			</div>
			<input type="submit" value="查询课程" class="btn btn-success" /> <a
				href="${pageContext.request.contextPath}/course/savePage.action"
				class="btn btn-info">添加课程</a> <input type="button" id="upd"
				value="修改课程" class="btn btn-info" onclick="updateCourse()" /> <input
				type="button" id="del" value="删除课程" class="btn btn-danger"
				onclick="deleteCourse()" /> <a
				href="${pageContext.request.contextPath}/course/uploadPage.action"
				class="btn btn-info">导入课程</a> <a
				href="${pageContext.request.contextPath}/course/exportFile.action"
				class="btn btn-info">导出课程</a>

		</div>
	</form>
	<div class="row" style="padding: 15px;">
		<table class="table ">
			<tr>
				<th><input type="checkbox" onclick="checkAll()" /></th>
				<th>编号</th>
				<th>名称</th>
				<th>类别</th>
				<th>学分</th>
				<th>课时</th>
				<th>附加說明</th>
			</tr>

			<c:forEach items="${pageInfo.list}" var="course" varStatus="v">
				<tr>
					<td><input type="checkbox" id="ids" class="bianhao" name="ck"
						value="${course.courseId}"></td>

					<td>${course.courseId }</td>
					<td>${course.courseName}</td>
					<td>${course.courseKind.kindName}</td>
					<td>${course.courseScore}</td>
					<td>${course.courseHour}</td>
					<td>${course.courseRemark}</td>



				</tr>

			</c:forEach>
		</table>
		<nav class="navbar navbar-default navbar-fixed-bottom">
			<ul class="pagination">
				<li><a
					href="?courseId=<c:out value="${courseId}"/>&pageNo=<c:out value="${pageNo-1 }"/>"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach var="i" begin="1" end="${pageInfo.pages}" step="1">
					<li><a
						href="?courseId=<c:out value="${courseId}"/>&pageNo=<c:out value="${i}"/>"><c:out
								value="${i}" /></a></li>
				</c:forEach>
				<li><a
					href="?courseId=<c:out value="${courseId}"/>&pageNo=<c:out value="${pageNo+1 }"/>"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>
</body>
</html>
