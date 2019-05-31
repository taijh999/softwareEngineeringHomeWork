
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
    <head>
        <title>课程信息列表</title>

        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="this is my page">
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/bootstrap.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>
       

    </head>

    <body>
        <div style="padding: 0px; margin: 0px;">
            <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
              
                <li>课程分类:${requestScope.courseKind.kindName}</li>

            </ul>
        </div>
        
        <div class="row" style="padding: 15px;">
            <table class="table ">
                <tr>
                    <th>序号</th>
                    <th>编号</th>
                    <th>名称</th>
                    <th>学分</th>
                    <th>课时</th>
                </tr>

                <c:forEach items="${courseKind.courseList}" var ="course" varStatus="v">
                    <tr>
                       
                        <td>${v.index+1}</td>
                        <td>${course.courseId }</td>
                        <td>${course.courseName}</td>
                       
                        <td>${course.courseScore}</td>
                        <td>${course.courseHour }</td>


                    </tr>

                </c:forEach>
           
        </div>
    </body>
</html>
