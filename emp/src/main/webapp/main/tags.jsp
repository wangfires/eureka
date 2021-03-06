<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/3/6
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>主页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/boot/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/main/boot/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/main/boot/js/bootstrap.min.js"></script>
    <style>
        .page-header{
            margin-top: 0px;
            margin-bottom: 12px;
        }

        taglist {
            margin-top: 15px;
        }
        .taglist .alert {
            margin: 0 10px 10px 0;
        }

    </style>
    <script>
        //删除数据
        function delRow(a){

            if(confirm("确定要删除吗?")){

                var id = $(a).next().text()
                window.location.href="${pageContext.request.contextPath}/tag/removeTag?id="+id;
            }else{

            }
        }
    </script>
</head>
<body>


<nav class="navbar navbar-default">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="#">员工管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form action="${pageContext.request.contextPath}/user/login" class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" id="name" name="user.username" class="form-control" placeholder="请输入用户名...">
                    <input type="password" id="password" name="user.password" class="form-control" placeholder="请输入密码...">
                </div>
                <button type="submit" class="btn btn-default">登录</button>
            </form>
            <span>${message}</span>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">欢迎:<span class="text-danger">${login.username}</span></a></li>
                <li><a href="#" >退出登录</a></li>
            </ul>
        </div>
    </div>
</nav>

<c:if test="${!empty login}">
<div class="container">

    <div class="row">
        <!--页面菜单-->
        <div class="col-md-2">
            <ul class="list-group">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/emp/findByPage">员工管理</a></li>
                <li class="list-group-item active" >标签管理</li>
            </ul>
        </div>
        <!--页面中心布局 头 选项卡 和 table 和 分页-->
        <div class="col-md-10">
            <div class="page-header">员工管理</div>
            <ul class="nav nav-tabs">
                <li role="presentation" class="active"><a href="">标签管理</a></li>
            </ul>

            <div style="margin-top: 30px;margin-bottom: 20px;">
                <form action="${pageContext.request.contextPath}/tag/saveTag" class="">
                    <div class="form-group" style="width: 100%;">
                        <input type="text" style="width: 90%;" class="form-control" id="exampleInputName2" placeholder="请输入标签名" name="tag.name">
                        <button type="submit" class="btn btn-primary">添加标签</button>
                    </div>
                </form>
            </div>


            <div class="taglist">
                <!--
                <div class="alert alert-info alert-dismissible pull-left" role="alert">
                    <button type="button" class="close"  onclick="delRow(this);"  aria-label="Close"><span aria-hidden="true"  >&times;</span></button>
                    <strong>勤劳</strong>
                </div>

                <div class="alert alert-info alert-dismissible pull-left" role="alert">
                    <button type="button" class="close"  onclick="delRow(this);"  aria-label="Close"><span aria-hidden="true"  >&times;</span></button>
                    <strong>任劳任怨</strong>
                </div>
                <div class="alert alert-info alert-dismissible pull-left hide" role="alert">
                    <button type="button" class="close"  onclick="delRow(this);"  aria-label="Close"><span aria-hidden="true"  >&times;</span></button>
                    <strong>笨笨</strong>
                </div>
                -->
                <c:forEach items="${tags}" var="tag">
                <div class="alert alert-info alert-dismissible pull-left" role="alert">
                    <button type="button" class="close"  onclick="delRow(this);"  aria-label="Close"><span aria-hidden="true" >&times;</span></button>
                    <span style="display:none">${tag.id}</span>
                    <strong>${tag.name}</strong>
                </div>
                </c:forEach>

            </div>


        </div>
    </div>



</div>
</c:if>


</body>
</html>
