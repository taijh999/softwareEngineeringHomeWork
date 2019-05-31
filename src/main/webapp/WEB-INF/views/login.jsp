<%-- 
    Document   : main
    Created on : 2015-11-15, 10:15:22
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title></title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/add.css"
	type="text/css" media="screen" />

<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/bootstrap.min.css">


</head>
<body>
	<div class="jumbotron">


		<div class="div_from_aoto" style="width: 500px;">
			<h3>欢迎使用课程管理系统</h3>

			<FORM action="${pageContext.request.contextPath}/user/login.action"
				method="post">
				<DIV class="control-group">
					<label class="laber_from">用户名</label>
					<DIV class="controls">
						<INPUT class="input_from" type=text name="userName">
						<P class=help-block></P>
					</DIV>
				</DIV>
				<DIV class="control-group">
					<LABEL class="laber_from">密码</LABEL>
					<DIV class="controls">
						<INPUT class="input_from" type=password name="password">${msg}
						<P class=help-block></P>
					</DIV>
				</DIV>


				<DIV class="control-group">
					<LABEL class="laber_from"></LABEL>
					<button class="btn btn-lg btn-primary " type="submit">登 陆</button>
				</DIV>
			</FORM>
		</div>
	</div>
</body>
</html>
