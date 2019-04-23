<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" %>
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
                $.ajax({
                    type:"post",
                    url:"${pageContext.request.contextPath}/upload/upload/findOne",
                    data:"id:21",
                    success:function (result) {
                        var idLi=$("<li/>");
                        var nameLi=$("<li/>");var ageLi=$("<li/>");
                        var birLi=$("<li/>");
                        idLi.text(result.id);
                        nameLi.text(result.name);
                        ageLi.text(result.age);
                        birLi.text(result.bir);
                        $("#ul").append(idLi).append(nameLi).append(ageLi).append(birLi);


                    }
                    }
                )
            })
        })
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="aaa"/>
    <input type="submit">
</form>
<a href="${pageContext.request.contextPath}/upload/download?fileName=148           .xlsx">148           .xlsx</a>
<a href="${pageContext.request.contextPath}/upload/download?fileName=a">a.txt</a>


<input type="button" id="btn" value="添加一个对象">
<ul id="ul"></ul>
</body>
</html>
