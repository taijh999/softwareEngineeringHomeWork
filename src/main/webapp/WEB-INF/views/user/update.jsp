<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>修改</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	function updateUser() {
		$.ajax({
		    type : 'POST',
		    url : '${pageContext.request.contextPath}/user/update.action',
		    data :  new FormData(document.getElementById("update_user_form")),
		    async : false,
		    cache : false,
		    contentType : false,
		    processData : false,
		    success : function(data) {
		    	if (data.msg == "OK") {
					alert("修改成功！");
					window.location.reload();
				} else {
					alert("修改失败！");
					window.location.reload();
				}
		}});
	}
</script>
</head>
<body>
	<h3 class="title">修改用户信息</h3>
	<img id="pic" alt="照片" width="300" height="250" class="imgShow"
		style="float: right"
		src="${pageContext.request.contextPath}/${user.image}" />
	<br />
	<form id="update_user_form" method="post" enctype="multipart/form-data">
		<input type="hidden" id="userId" name="userId" value="${user.userId}" />

		<div>
			<span>姓名:</span> <input type="text" id="userName" name="userName"
				value="${user.userName}">
		</div>
		<div>
			<span>图片:</span> <input  type="file" name="image1" id="image1"
				size="40" />
		</div>




		<div>
			<input type="submit" value="修改" onclick="updateUser()"/>
		</div>
	</form>
</body>

<script>
	$(function() {$('#image1')
				.on(
						'change',
						function() {
							var file = $(this)
							var fileObj = file[0]; //获取当前元素
							var dataURL;
							var windowURL = window.URL;
							if (fileObj.files[0]) {
								dataURL = windowURL
										.createObjectURL(fileObj.files[0]) //创建一个新的对象URL,该对象URL可以代表某一个指定的File对象或Blob对象.
								$('.imgShow').attr('src', dataURL);
							} else {
								dataURL = file.val();
								console.log(dataURL)
								$('.imgShow').style.filter = 'progid:DXImageTransform.Micsoft.AlphaImageLoader(sizingMethod = scale)'
								$('.imgShow').filters
										.item('DXImageTransform.Microsoft.AlphaImageLoader').src = dataURL;
							}
							$.ajaxFileUpload({
								url : "",
								fileElementId : "uploadImg",
								dataType : "string",
								success : function(data) {
									//图片路径
									$('.imgShow').attr("src", data);
								}
							});
						});
	});
</script>
</html>