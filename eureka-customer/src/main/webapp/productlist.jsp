<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="jquery-3.3.1.min.js"></script>
    <script>
        $.ajax({
            url:"/product/list",
            type:"post",
            success:function(result){
                console.log(result.data);

                    for (var j=0;j<result.data.length;j++){
                        //console.log(result.data[j].name);
                        var li=$("<li/>");
                        li.text(result.data[j].name).attr("id",j);
                        //console.log(li[0]);
                        $("#bd").append(li);
                        var ul=$("<ul/>");
                        $("#bd").append(ul);
                        for (var i=0;i<result.data[j].foods.length;i++){
                            //var id =result.data[j].foods[i].id;
                            //console.log(id);
                            var li=$("<li/>");
                            var a =$("<a/>");

                            a.text("加入购物车").attr("id",result.data[j].foods[i].id).click(function () {
                               var id = $(this).attr("id");
                                $.ajax({
                                    url:"/product/add1",
                                    data:{"id":id},
                                    success:function (data) {

                                    }
                                })
                            });
                            li.text("id"+result.data[j].foods[i].id+"name:"+result.data[j].foods[i].name+"￥"+result.data[j].foods[i].price).append(a);
                            ul.append(li);
                        }
                    }


            }
        })
        $(function () {
            $("#btn").click(function () {
                self.location='./cart.jsp';
            })
        })
    </script>
    <title>Document</title>
</head>
<body>
<ul id="bd">

</ul>
<button id="btn">查看购物车</button>
</body>
</html>