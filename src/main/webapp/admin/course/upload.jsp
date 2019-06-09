<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>导入</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
    function doUpload() {  
        var formData = new FormData($("#myform"));  
        $.ajax({  
             url: '${pageContext.request.contextPath}/admin/course/importFile.action' ,  
             type: 'POST',  
             data: formData,  
             async: false,  
             cache: false,  
             contentType: false,  
             processData: false,  
             success: function (data) {  
                 alert(data.msg);  
             }
             
        });  
   }
    </script>
</head>
<body>
    <form id="myform"  enctype="multipart/form-data">
        文件：<input type="file" name="uploadFile"/>
        <br></br>
        <input type="button" onclick="doUpload()" value="提交" />
       
    </form>    
</body>
</html>