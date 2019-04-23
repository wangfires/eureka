<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; utf-8" %>
<%--

  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/4/21
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
    <script src="jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                self.location='/order/save';
            })
        })
    </script>
</head>
<body>
<ul id="ul">
    <c:forEach var="cart" items="${cart}">
        <li>id:${cart.value.id} name:${cart.value.name} price:${cart.value.price} count:${cart.value.count} total:${cart.value.total}</li>
    </c:forEach>
</ul>
<button id="btn">生成订单</button>
</body>
</html>
