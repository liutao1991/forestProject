<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
//http://ip+port+projectName
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>静态表格</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="../head.jsp"%>

</head>
<body>

<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-card-body" style="padding: 15px;">
            <div align="center"><h1>添加小班</h1></br>
                <form class="layui-form" action="addClassAfter.lovo" method="post" id="formId" lay-filter="component-form-group">

                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="className" autocomplete="off" class="layui-input"  lay-verify="required">
                            </div>
                        </div>
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">负责人</label>
                            <div class="layui-input-inline">
                                <input type="text" name="classLeader" autocomplete="off" class="layui-input"  lay-verify="required">
                            </div>
                        </div>
                    </div>

                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">负责人电话</label>
                            <div class="layui-input-inline">
                                <input type="text" name="classLeaderTel" autocomplete="off" class="layui-input"  lay-verify="required">
                            </div>
                        </div>
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">人员数量</label>
                            <div class="layui-input-inline">
                                <input type="text" name="classNum" autocomplete="off" class="layui-input"  lay-verify="required">
                            </div>
                        </div>

                    </div>

                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md4 layui-col-xs4">
                            <label class="layui-form-label">负责区域</label>
                            <div class="layui-input-block"  >
                                <select  name="areaId" lay-verify="required"  lay-verify="required" >
                                    <option value=""></option>
                                    <c:forEach items="${areaList}" var="s">
                                        <option value="${s.areaId}">${s.areaName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>

                    <button class="layui-btn" lay-submit=""id="bid" lay-filter="component-form-demo1">添加</button>

                </form>
            </div>
        </div>
    </div>
</div>


<script>
    //下拉框显示
    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
    // 添加按钮
    $("#bid").click(function () {
        $("#formId").submit();
    });

</script>
</body>
</html>
