
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
                <li>管理</li>
                <li>分类管理</li>

            </ul>
        </div>
        
        <div class="row" style="padding: 15px;">
            <table class="table ">
                <tr>
                   
                    <th>分类编号</th>
                    <th>分类名称</th>
                    <th>说明</th>
                    <th>操作</th>
                </tr>

                <c:forEach items="${list}" var ="courseKind" varStatus="v">
                    <tr>
                        <td>${courseKind.kindId}</td>
                        <td>${courseKind.kindName}</td>
                        <td>${courseKind.kindRemark}</td>
                        <td><a href="${pageContext.request.contextPath}/courseKind/getByKindId.action?kindId=${courseKind.kindId}">查看课程</a></td>
                    </tr>
                </c:forEach>
            </table>
           
        </div>
    </body>
</html>
