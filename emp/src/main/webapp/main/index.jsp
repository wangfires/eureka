<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; utf-8" %>

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
    </style>
    <script>
        $(function () {
            $("#add").click(function () {
                $("#username").attr("value","");
                $("#password1").attr("value","");
                $("#bir").attr("value","");
                $("#salary").attr("value","");

                <%--$("#checkbox").html("");--%>


                <%--$.ajax({--%>
                    <%--type:"post",--%>
                    <%--url:"${pageContext.request.contextPath}/emp/findTags",--%>

                    <%--success:function (result) {--%>
                        <%--for (var i = 0;i<result.length;i++){--%>
                        <%--&lt;%&ndash;<label>&ndash;%&gt;--%>

                            <%--&lt;%&ndash;<input id="${tag.id}" class="tagid" type="checkbox" value="${tag.id}" name="tagids">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<a>${tag.name}&nbsp;<span class="badge">${tag.count}</span></a>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</label>&ndash;%&gt;--%>
                            <%--var input=$("<input/>");--%>
                            <%--var a=$("<a/>");--%>
                            <%--var span=$("<span/>");--%>
                            <%--var lable=$("<lable/>");--%>
                            <%--input.attr("id",result[i].id).attr("type","checkbox").attr("value",result[i].id).attr("name","tagids");--%>
                            <%--lable.attr("style","padding-right:15px;");--%>
                            <%--a.text(result[i].name);--%>

                            <%--span.attr("class","badge").text(result[i].count);--%>
                            <%--a.append(span);--%>
                            <%--lable.append("&nbsp;&nbsp;").append(input);--%>
                            <%--lable.append(a);--%>
                            <%--$("#checkbox").append(lable);--%>
                            <%--console.log($("#checkbox")[0])--%>
                        <%--}--%>
                    <%--}--%>


                <%--})--%>
            })
            $("#btn").click(function () {
                //$("#checkbox").remove();
                console.log($("#empid").val());
                if($("#empid").val()==null){
                    $("#f").attr("action","${pageContext.request.contextPath}/emp/saveEmp").attr("method","post");
                    $("#f").submit();
                }else{
                    $("#f").attr("action","${pageContext.request.contextPath}/emp/updateEmp").attr("method","post");
                    $("#f").submit();
                }
            })

            $(".u").click(function () {


                var tagid =$(".tagid");

                // for(var j = 0;j<tagid.length;j++){
                //     var tid=$(tagid[j]).val();
                //     $("#"+tid).prop("checked",false);
                // }
                // console.log($(tagid[0]).val());
                // console.log($(tagid[1]).val());
                var id=$(this).parent().parent().children().first().text()
                $.ajax({
                    type:"post",
                    url:"${pageContext.request.contextPath}/emp/findOne",
                    data:"id="+id,
                    success:function (result) {
                        $("#username").attr("value",result.name);
                           $("#password1").attr("value",result.age);
                           $("#bir").attr("value",result.bir);
                           $("#salary").attr("value",result.salary);

                        <%--<c:forEach var="t" items="result.tags">--%>
                        <%--&lt;%&ndash;<c:if test="${t.id eq empid}">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;$(".tagid").attr("checked",true);&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</c:if>&ndash;%&gt;--%>
                        <%--console.log(t);--%>
                        <%--</c:forEach>--%>

                        for (var i=0;i<result.tags.length;i++){
                            // console.log(tagid);
                            // console.log(result.tags[i].id);
                            // console.log(empid===(result.tags[i]).id)

                            for(var j = 0;j<tagid.length;j++){
                                var tid=$(tagid[j]).val();
                                if(tid==result.tags[i].id){
                                    console.log($("#tid"));
                                    $("#"+tid).prop("checked",true);
                                 }
                            }

                        }
                    }
                })



            })
        })
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
                <li class="list-group-item active">员工管理</li>
                <li class="list-group-item" ><a href="${pageContext.request.contextPath}/tag/findAll">标签管理</a></li>
            </ul>
        </div>
        <!--页面中心布局 头 选项卡 和 table 和 分页-->
        <div class="col-md-10">
            <div class="page-header">员工管理</div>
            <ul class="nav nav-tabs">
                <li role="presentation" class="active"><a href="#">员工列表</a></li>
                <li role="presentation"><a href="javascript:;" data-toggle="modal" data-target="#myModal" id="add">添加员工</a></li>
            </ul>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>姓名</th>
                        <th>年龄</th>
                        <th>生日</th>
                        <th>薪资</th>
                        <th>标签</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="e" items="${emps}">
                    <tr>
                            <td>${e.id}</td>
                            <td>${e.name}</td>
                            <td>${e.age}</td>
                            <td>${e.bir}</td>
                            <td>${e.salary}</td>
                            <td>
                                <c:forEach items="${e.tags}" var="tag">
                                    ${tag.name}
                                </c:forEach>
                            </td>
                            <td><a href="${pageContext.request.contextPath}/emp/removeEmp?id=${e.id}" class="btn btn-primary">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="" class="btn btn-primary u" data-toggle="modal" data-target="#myModal">修改</a></td>

                    </tr>
                </c:forEach>
                    <%--<tr>--%>
                        <%--<td>1</td>--%>
                        <%--<td>张三</td>--%>
                        <%--<td>23</td>--%>
                        <%--<td>2012/12/12</td>--%>
                        <%--<td>2300.12</td>--%>
                        <%--<td>勤劳,踏实,热血</td>--%>
                        <%--<td><a href="" class="btn btn-primary">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="" class="btn btn-primary" data-toggle="modal" data-target="#myModal">修改</a></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td>1</td>--%>
                        <%--<td>张三</td>--%>
                        <%--<td>23</td>--%>
                        <%--<td>2012/12/12</td>--%>
                        <%--<td>2300.12</td>--%>
                        <%--<td>勤劳,踏实,热血</td>--%>
                        <%--<td><a href="" class="btn btn-primary">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="" class="btn btn-primary" data-toggle="modal" data-target="#myModal">修改</a></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td>1</td>--%>
                        <%--<td>张三</td>--%>
                        <%--<td>23</td>--%>
                        <%--<td>2012/12/12</td>--%>
                        <%--<td>2300.12</td>--%>
                        <%--<td>勤劳,踏实,热血</td>--%>
                        <%--<td><a href="" class="btn btn-primary">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="" class="btn btn-primary" data-toggle="modal" data-target="#myModal">修改</a></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td>1</td>--%>
                        <%--<td>张三</td>--%>
                        <%--<td>23</td>--%>
                        <%--<td>2012/12/12</td>--%>
                        <%--<td>2300.12</td>--%>
                        <%--<td>勤劳,踏实,热血</td>--%>
                        <%--<td><a href="" class="btn btn-primary">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="" class="btn btn-primary" data-toggle="modal" data-target="#myModal">修改</a></td>--%>
                    <%--</tr>--%>
                </tbody>
            </table>
            <nav aria-label="Page navigation" class="pull-right">
                <ul class="pagination">
                    <li class="disabled">
                        <a href="#" aria-label="Previous" >
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="active">

                        <c:forEach begin="1" end="${count}" varStatus="status">
                        <c:if test="${status.index le count}">
                    <li><a href="${pageContext.request.contextPath}/emp/findByPage?page=${status.index}">${status.index}</a></li>
                            </c:if>
                            </c:forEach>
                        <%--<a href="#" >1</a></li>--%>
                    <%--<li><a href="#">2</a></li>--%>
                    <%--<li><a href="#">3</a></li>--%>
                    <%--<li><a href="#">4</a></li>--%>
                    <%--<li><a href="#">5</a></li>--%>
                    <li class="disabled">
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>



</div>

</c:if>

<!--员工添加 修改-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">编辑员工信息</h4>
            </div>
            <div class="modal-body">


                <form id="f">
                    <div class="form-group">
                        <label for="username">用户名</label>
                        <input type="email" class="form-control" id="username" placeholder="用户名" name="emp.name" >
                    </div>
                    <div class="form-group">
                        <label for="password1">年龄</label>
                        <input type="username" class="form-control" id="password1" placeholder="密码" name="emp.age" >
                    </div>
                    <div class="form-group">
                        <label for="bir">生日</label>
                        <input type="username" class="form-control" id="bir" placeholder="生日" name="emp.bir" >
                    </div>
                    <div class="form-group">
                        <label for="salary">薪资</label>
                        <input type="username" class="form-control" id="salary" placeholder="薪资" name="emp.salary" >
                        <input type="hidden" id="empid" value="${emp.id}">
                    </div>
                    <label>
                        请选择标签:
                    </label>
                    <div class="checkbox" id="checkbox">
                        <%--<label>--%>
                            <%--<input type="checkbox">--%>
                            <%--<a>任劳任怨&nbsp;<span class="badge">5</span></a>--%>
                        <%--</label>--%>
                        <%--<label>--%>
                            <%--<input type="checkbox">--%>
                            <%--<a>能干&nbsp;<span class="badge">12</span></a>--%>
                        <%--</label>--%>

                        <c:forEach var="tag" items="${tags}" varStatus="status">

                            <label>

                            <input id="${tag.id}" class="tagid" type="checkbox" value="${tag.id}" name="tagids"/>
                            <a>${tag.name}&nbsp;<span class="badge">${tag.count}</span></a>
                            </label>
                        </c:forEach>
                    </div>



            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="btn">保存员工信息</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
        </form>
    </div>
</div>





</body>

</html>