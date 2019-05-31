<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>添加课程信息</title>

        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="this is my page">
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/bootstrap.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>
    </head>
    
    <script type="text/javascript">
    $(document).ready(function(){
                $("#ok").click(function () {
                      var oldPassword = $("#oldPassword").val();
        var password = $("#password").val();
        var password1 = $("#password1").val();
        if (password != password1){
       alert("密码不一致");
       return;
        } 
        $.ajax({type: "post", url: "${pageContext.request.contextPath}/user/updatePassword.action", dataType: "json", data:{"password":password,"oldPassword":oldPassword}, success: function (data) {
        alert(data.msg);  
       // alert("trtrtt");
        }
        });
        });
    });
    </script>
    <body>

        <div style="padding: 0px; margin: 0px;">
            <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
                <li>用户管理</li>
                <li>修改密码</li>

            </ul>
        </div>

        <form method="post" class="form-horizontal">

            <div class="row">
                <div class="col-sm-10">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">原密码</label>
                        <div class="col-sm-9">
                            <input type="" class="form-control" name="oldPassword"
                                   placeholder="请输入原密码"  id="oldPassword"  />
                        </div>
                    </div>
                </div>
                <div class="col-sm-10">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">新密码</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" name="password" id="password"
                                   placeholder="请输入新密码"  id="Name" />
                        </div>
                    </div>
                </div>
                <div class="col-sm-10">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">重复新密码</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" name="password1" id="password1"
                                   placeholder="重复新密码"   />
                        </div>
                    </div>
                </div>




                <div class="row">
                    <div class="col-sm-10" align="center">
                        <input type="button" value="修改密码" class="btn btn-success"  id="ok" /> 
                    </div>
                </div>
        </form>

    </body>
</html>
