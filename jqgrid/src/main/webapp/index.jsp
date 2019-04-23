<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<c:set var="app" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="${app}/statics/boot/css/bootstrap.min.css">
    <%--引入jqgrid中主题css--%>
    <link rel="stylesheet" href="${app}/statics/jqgrid/css/trirand/ui.jqgrid-bootstrap.css">
    <%--引入js文件--%>
    <script src="${app}/statics/boot/js/jquery-3.3.1.min.js"></script>
    <script src="${app}/statics/boot/js/bootstrap.min.js"></script>
    <script src="${app}/statics/jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <script src="${app}/statics/jqgrid/js/trirand/jquery.jqGrid.min.js"></script>
    <script>
        $(function () {
            $("#list").jqGrid({
                url:"${app}/emp/findAll",
                datatype:"json",
                styleUI : 'Bootstrap',
                colNames:["ID","姓名","年龄","生日","薪水","所属部门","操作"],
                pager:"#pager",
                autowidth:true,//自适应父容器
                rowNum:3,
                editurl:"${app}/emp/edit",//编辑时的url
                caption:"用户列表信息",
                rownumbers:true,
                sortname:"age",
                viewrecords:true,
                rowList:[2,10,15,20,100],
                toolbar:['true','top'],
                colModel:[
                    {name:"id",align:"center",hidden:false,index:"id"},
                    {name:"name",align:"center",editable:true,//edittype:"select",editoptions:{
                            //value:"1:ONE;2:TWO",//本地数据页面写死数据
                            //dataUrl:"/xxx",//远程获取数据  注意:这个数据格式必须为html <select><option>...</select>
                        // },
                        // width:300,fixed:true,resizable:false,
                    },
                    {name:"age",editable:true,align:"center"

                    },
                    {name:"bir",align:"center",editable:true},
                    {name:"salary",align:"center",editable:true},
                    {name:"deptid",editable:true,edittype:"select",editoptions:{
                            dataUrl:"${app}/emp/findDept"//要求返回值必须是准备好的selecthtml结果
                        },
                        formatter:function(value,options,row){
                            if(row.dept){
                                return row.dept.name;
                            }
                            return "";
                        }
                    },
                    {name: "options",formatter:function(value,options,row){

                var content = "<a class='btn btn-danger'onclick=\"javascript:del('"+row.id+"')\"> 删除</a> " +
                    "<a class='btn btn-primary' onclick=\"javascript:edit('"+row.id+"')\">修改</a>";
                return content;
            }}


                ]
            }).jqGrid("navGrid","#pager",{edit:true,add:true,del:true,search:true,refresh:true});
        })
        function edit(id){
            //根据rowid获取当前行的方法
            $("#list").jqGrid('editGridRow', id, {
                height : 300,
                reloadAfterSubmit : true
            });

        }
        function del(id) {
            $("#list").jqGrid('delGridRow', id, {
                height : 300,
                reloadAfterSubmit : true
            });
        }
    </script>
</head>
<body>

<%--表格--%>
<table id="list"></table>
<%--分页工具栏--%>
<div id="pager"></div>
</body>
</html>
