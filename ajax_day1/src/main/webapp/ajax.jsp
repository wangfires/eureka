<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" %>
<!doctype html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            $("#aa").blur(function () {
                //获取用户名
                var username = $(this).val();

                //发送ajax的get方式请求
                    //创建xhr核心对象  js对象存在浏览器差异
                var xhr;
                if(window.XMLHttpRequest){//true webkit
                    xhr=new XMLHttpRequest();
                }else{
                    xhr=new ActiveXObject("Microsoft.XMLHttp");
                }
                //发送个体请求并传递参数
                //post方式传参
                xhr.open("post",url="${pageContext.request.contextPath}/user/check");
                xhr.setRequestHeader("content-type","application/x-www-form-urlencoded")
                xhr.send("username="+username);
                //get方式传参
                //xhr.open("get","${pageContext.request.contextPath}/user/check?username="+username);
                //xhr.send();
                //处理完整且正确的响应并刷新局部页面
                xhr.onreadystatechange =function(){

                    if(xhr.readyState==4 && xhr.status==200){

                        console.log(xhr.responseText);
                        $("#mm").html(xhr.responseText);
                    }
                }
            })
        })

    </script>
</head>
<body>
<form >
    用户名：<input type="text" id="aa" name="username"><span id="mm"></span>
</form>
</body>
</html>