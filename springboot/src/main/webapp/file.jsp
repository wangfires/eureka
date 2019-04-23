<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/file/up">
    <input type="file" name="aaa"/>
    <input type="submit" value="提交" >
</form>
<hr>
<a href="${pageContext.request.contentType}/file/down?name=pom.xml">pom.xml</a>
<a href="${pageContext.request.contentType}/file/down?name=springmvc.xml">springmvc.xml</a>
<a href="${pageContext.request.contentType}/file/down?name=web.xml">web.xml</a>
<a href="${pageContext.request.contentType}/file/down?name=后台详细设计-分类.docx">后台详细设计-分类.docx</a>
<a href="${pageContext.request.contentType}/file/down?name=当当网标准库表.png">当当网标准库表.png</a>
</body>
</html>