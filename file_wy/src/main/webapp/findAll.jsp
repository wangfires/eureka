<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page isELIgnored="false" contentType="text/html; utf-8" pageEncoding="UTF-8"%>
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
            $(".x").click(function () {
                var num=$(this).parent().prev().text();
                num++;
                $(this).parent().prev().text(num);
            })
        })
    </script>
</head>
<body>
用户：${login.username}
<table class="table">
    <tr class="table_header">
        <td>
            文件id
        </td>
        <td>
            原始名称
        </td>
        <td>
            新文件名称
        </td>
        <td>
        文件后缀
        </td>
        <td>
            存储路径
        </td>
        <td>
            大小
        </td>
        <td>
            文件类型
        </td>
        <td>
            是否是图片
        </td>
        <td>
            下载次数
        </td>
        <td>
            操作
        </td>
    </tr>
    <c:forEach var="f" items="${list}">
        <tr>
            <td>${f.id}</td>
            <td>${f.oldname}</td>
            <td>${f.newname}</td>
            <td>${f.suffix}</td>
            <td>${f.path}</td>
            <td>${f.size}</td>

            <td>${f.type}</td>

            <c:if test="${fn:contains(f.type, 'image')}">
            <td><img src="${pageContext.request.contextPath}/file/down?path=${f.path}&newname=${f.newname}" width="100" height="50"></td>
            </c:if>
            <c:if test="${not fn:contains(f.type, 'image')}">
                <td>否</td>
            </c:if>

            <td>${f.num}</td>
            <td><a href="${pageContext.request.contextPath}/file/down?path=${f.path}&newname=${f.newname}">预览</a>
                <a class="x" href="${pageContext.request.contextPath}/file/down?path=${f.path}&newname=${f.newname}&id=${f.id}">下载</a>
                <a href="${pageContext.request.contextPath}/file/remove?id=${f.id}&path=${f.path}&newname=${f.newname}">删除</a>
            </td>

        </tr>
    </c:forEach>
</table>
<form action="${pageContext.request.contextPath}/file/addFile" method="post" enctype="multipart/form-data">
    <input type="file" name="aaa"/>
    <input type="submit">
</form>
</body>
</html>