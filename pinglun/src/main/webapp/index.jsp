<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" %>
<!doctype html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {

            $("#btn").click(function () {
                var a=$("#aa").val();
                $("#aa").val("");


                $.ajax({
                    url:"${pageContext.request.contextPath}/comments/updateContent",
                    type:"get",
                    data:{content:a},
                    success:function (result) {
                        var li=$("<li/>");
                        var span=$("<span/>")
                        var input=$("<input/>");
                        var aa=$("<a/>");
                        aa.attr("href","javascript:void(0)")
                        input.attr("type","hidden");
                        input.text(result.id);
                        aa.text("支持");

                        span.text(result.count);
                        li.text(result.matters+"票数:");

                        li.append(span).append(input).append(aa);

                        $("#bd").append(li);
                        aa.click(function () {
                            var id = $(this).prev().val();
                            $.ajax({
                                url:"${pageContext.request.contextPath}/comments/updateCount",
                                type:"get",
                                data:{id:result.id},
                            })
                            var count = $(this).prev().prev().text();
                            count++;
                            $(this).prev().prev().text(count);
                        })
                    }

                });

        })
            $(".s").click(function () {

                var id = $(this).prev().val();
                $.ajax({
                    url:"${pageContext.request.contextPath}/comments/updateCount",
                    type:"get",
                    data:{id:id},
                })
                var count = $(this).prev().prev().text();
                count++;
                $(this).prev().prev().text(count);


            })
        });
        
    </script>
</head>
<body id="bd">
<img src="${pageContext.request.contextPath}/img/timg%20(1).jpg" width="300" height="400">
<br>
<input id="aa" type="text"/><button id="btn" >提交</button>
<hr>
<c:forEach var="c" items="${list}">

    <li>${c.matters} 票数：<span>${c.count}</span> <input type="hidden" value="${c.id}"><a class="s" href="javascript:void(0)">支持</a></li>
</c:forEach>
</body>
</html>