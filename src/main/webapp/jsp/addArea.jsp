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
            <div align="center"><h1>区域一览</h1></br>
                <%--<form action="${basePath}type.lovo" method="post" id="fid">--%>
                    <%--&lt;%&ndash;隐藏表单type名字&ndash;%&gt;--%>
                    <%--<input type="hidden" name="typeName" id="typeName" value="DL">--%>
                <%--</form>--%>
                <form class="layui-form" action="${basePath}addArea.lovo" method="post" lay-filter="component-form-group" id="fromId">

                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md3 layui-col-xs3"></div>
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">名称</label>
                            <div class="layui-input-inline">
                                <input type="text" autocomplete="off" class="layui-input" name="areaName">
                            </div>
                        </div>
                    </div>
                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md3 layui-col-xs3"></div>
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">林种</label>
                            <div class="layui-input-inline">
                                <input type="text" autocomplete="off" class="layui-input" name="areaTreeType">
                            </div>
                        </div>
                    </div>
                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md3 layui-col-xs3"></div>
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">优势树种</label>
                            <div class="layui-input-inline">
                                <input type="text" autocomplete="off" class="layui-input" name="areaGoodTree">
                            </div>
                        </div>
                    </div>
                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md3 layui-col-xs3"></div>
                        <div class="layui-col-md4 layui-col-xs4">
                            <label class="layui-form-label">地类</label>

                            <div class="layui-input-block">
                                <select  id="s" lay-verify="required" name="typeVal" class="layui-input">
                                    <%--<c:forEach items="${typeList}" var="c">--%>
                                    <%--<option value="${c.typeKey}">${c.typeVal}</option>--%>
                                    <%--</c:forEach>--%>
                                     <option value=""></option>
                                    <option value="1">林地</option>
                                    <option value="2">疏林地</option>
                                    <option value="3">灌木林</option>
                                    <option value="4">苗圃地</option>
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
