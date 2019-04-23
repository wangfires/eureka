<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<c:set var="app" value="${pageContext.request.contextPath}"></c:set>
<html>
	<head>
		<title>add Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
		<script src="../static/js/jquery-3.3.1.min.js"></script>
		<script>
            $(function () {
                $("#btn").click(function () {
                    var jQuery = $("#tiJiao").serialize();
                    $.post("${pageContext.request.contextPath}/emp/add",jQuery,function () {
                        window.location.replace("${pageContext.request.contextPath}/emplist.jsp");
                    })
                })
            })

		</script>
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								2009/11/20
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						add Emp info:
					</h1>
					<form action="emplist.jsp" method="post" id="tiJiao">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									name:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									salary:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="price" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									age:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									sex:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="sex" />
								</td>
							</tr>

						</table>
						<p>
							<input type="submit" class="button" value="Confirm" id="btn"/>
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
