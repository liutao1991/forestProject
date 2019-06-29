<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
//http://ip+port+projectName
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>静态表格</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="../head.jsp" %>

</head>
<body>

<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-card-body" style="padding: 15px;">
            <div align="center"><h1>添加区域</h1></br>

                <form class="layui-form" action="addAreaAfter.lovo" method="post" lay-filter="component-form-group" id="fromId">

                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md3 layui-col-xs3"></div>
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">名称</label>
                            <div class="layui-input-inline">
                                <input type="text" autocomplete="off" class="layui-input" name="areaName"  lay-verify="required">
                            </div>
                        </div>
                    </div>
                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md3 layui-col-xs3"></div>
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">林种</label>
                            <div class="layui-input-inline">
                                <input type="text" autocomplete="off" class="layui-input" name="areaTreeType"  lay-verify="required">
                            </div>
                        </div>
                    </div>
                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md3 layui-col-xs3"></div>
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">优势树种</label>
                            <div class="layui-input-inline">
                                <input type="text" autocomplete="off" class="layui-input" name="areaGoodTree"  lay-verify="required">
                            </div>
                        </div>
                    </div>
                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md3 layui-col-xs3"></div>
                        <div class="layui-col-md4 layui-col-xs4">
                            <label class="layui-form-label">地类</label>

                            <div class="layui-input-block">
                                <select  id="s" lay-verify="required" name="typeVal" class="layui-input"  lay-verify="required">
                                    <option value=""></option>
                                    <c:forEach items="${typeList}" var="c">
                                    <option value="${c.typeId}">${c.typeVal}</option>
                                    </c:forEach>

                                </select>
                            </div>
                        </div>
                    </div>

                    <button class="layui-btn" lay-submit="" lay-filter="component-form-demo1" id="bid">添加</button>

                </form>
            </div>
        </div>
    </div>
</div>


<script>
    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
    $("#bid").click(function () {

        form.on('select', function(data){
            console.log(data.elem); //得到select原始DOM对象
            console.log(data.value); //得到被选中的值]
            $("#s").val(data.value)
            console.log(data.othis); //得到美化后的DOM对象
        });

        // $("#fromId").submit();
    });

    // $(document).ready(function () {
    //     $("#fid").submit();
    <%--var typeName=$("#typeName").val();--%>
    <%--$.post("${basePath}type.lovo",{"typeName":typeName},function (r) {--%>
    <%--alert(r)--%>
    <%--var typeA--%>
    <%--$("#sid").html()--%>

    <%--})--%>
    // });
</script>
</body>
</html>
