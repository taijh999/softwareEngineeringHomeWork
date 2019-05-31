<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>导入</title>
    
    
</head>
<body>
    <form action="${pageContext.request.contextPath}/course/importFile.action" method="post" enctype="multipart/form-data">
        文件：<input type="file" name="uploadFile"/>
        <br></br>
        <input type="submit" value="导入"/>
       
    </form>    
</body>
</html>