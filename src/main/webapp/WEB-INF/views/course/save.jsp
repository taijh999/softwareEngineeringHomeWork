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


//         $("#courseId").ready(function () {

//             $("#courseId").blur(function (e) {

//                 var courseId = $("#courseId").val();
//                 if ($.trim($("#courseId").val()).length > 0) {

//                     $.ajax({type: "post", url: "checkCourseId.action", dataType: "json", data: {"courseId": courseId}, success: function (data) {

//                             if (data != null) {
//                                 alert("该课程编号以被注册,请检查后重新输入课程号");
//                             }
//                         }})
//                 }
//             })
//         })
function createCourse() {
	$.post("${pageContext.request.contextPath}/course/save.action",
	$("#new_course_form").serialize(),function(data){
	        if(data.msg =="OK"){
	            alert("课程创建成功！");
	            window.location.reload();
	        }else{
	            alert("课程创建失败！");
	            window.location.reload();
	        }
	    });
	}


    </script>
    <body>

        <div style="padding: 0px; margin: 0px;">
            <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
                <li>课程管理</li>
                <li>添加课程</li>
            </ul>
        </div>

        <form  method="post" class="form-horizontal" id="new_course_form"> 
            <h5 class="page-header alert-info"
                style="margin: 0px; padding: 10px; margin-bottom: 10px">课程基本信息</h5>
            <div class="row">
                <div class="col-sm-5">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">课程编号</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="courseId"
                                   placeholder="请输入课程编号"  id="courseId"  />
                        </div>
                    </div>
                </div>
                <div class="col-sm-5">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">课程名称</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="courseName"
                                   placeholder="请输入课程名称"   />
                        </div>
                    </div>
                </div>
                <div class="col-sm-5">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">课时</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="courseHour"
                                   placeholder="请输入课时"   />
                        </div>
                    </div>
                </div>

                <div class="col-sm-5">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">课程学分</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="courseScore"
                                   placeholder="请输入课程学分"   />
                        </div>
                    </div>
                </div>


                <div class="col-sm-5">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">课程类别</label>
                        <div class="col-sm-5">
                            <select  class="form-control" id="courseKindId" name="courseKindId" >
                            <c:forEach items="${list}" var ="ck" >
								<option value="${ck.kindId}">${ck.kindName}</option>
							</c:forEach>
                             
                            </select>
                        </div>
                    </div>
                </div>
                
                <div class="col-sm-5">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">附加说明</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="courseRemark"
                                   placeholder="请输入课程附加说明"   />
                        </div>
                    </div>
                </div>


            </div>


            <div class="row">
                <div class="col-sm-10" align="center">
                    <input type="button" value="添加课程" class="btn btn-success"  onclick="createCourse()"/> 
                    
                    <a
                        href="${pageContext.request.contextPath}/course/listByPage.action" class="btn btn-danger">返回上一级</a>
                </div>
            </div>
        </form>

    </body>
</html>
