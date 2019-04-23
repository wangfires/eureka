<%@page isELIgnored="false" contentType="text/html; utf-8" pageEncoding="UTF-8" %>
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
        $("#p").change(function () {
            $("#c").empty();
            var provinceCode = $(this).val();
            var xhr;
            if(XMLHttpRequest){
                xhr=new XMLHttpRequest();
            }else{
                xhr=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xhr.open("GET","${pageContext.request.contextPath}/province/findCity?provinceCode="+provinceCode);
            xhr.send();
            xhr.onreadystatechange=function () {
                if(xhr.readyState==4&& xhr.status==200){

                    var json=xhr.responseText;
                    var eval1 = eval("("+xhr.responseText+")");
                    for (var i =0;i<eval1.length;i++){
                        var option=$("<option/>").val(eval1[i].code);
                        option.html(eval1[i].name);
                        $("#c").append(option);
                    }
                }
            }
        })
        $("#p").focus(function () {
            var xhr;
            if(XMLHttpRequest){
                xhr=new XMLHttpRequest();
            }else{
                xhr=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xhr.open("GET","${pageContext.request.contextPath}/province/findProvince");
            xhr.send();
            xhr.onreadystatechange=function () {
                if(xhr.readyState==4&& xhr.status==200){

                    var json=xhr.responseText;
                    var eval1 = eval("("+xhr.responseText+")");
                    for (var i =0;i<eval1.length;i++){
                        var option=$("<option/>").val(eval1[i].code);
                        option.html(eval1[i].name);
                        $("#p").append(option);
                    }
                }
            }
        })
        $("#c").change(function () {
            $("#a").empty();
            var cityCode = $(this).val();
            var xhr;
            if(XMLHttpRequest){
                xhr=new XMLHttpRequest();
            }else{
                xhr=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xhr.open("GET","${pageContext.request.contextPath}/province/findArea?cityCode="+cityCode);
            xhr.send();
            xhr.onreadystatechange=function () {
                if(xhr.readyState==4&& xhr.status==200){

                    var json=xhr.responseText;
                    var eval1 = eval("("+xhr.responseText+")");
                    for (var i =0;i<eval1.length;i++){
                        var option=$("<option/>").val(eval1[i].code);
                        option.html(eval1[i].name);
                        $("#a").append(option);
                    }
                }
            }
        })
    })

    </script>
</head>
<body>
    省<select name="province" id="p">
    </select>
    市<select name="city" id="c">
    </select>
    县<select name="area" id="a">
    </select>
</body>
</html>