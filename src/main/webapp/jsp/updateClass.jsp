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
    <title>修改班级</title>
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
            <div align="center"><h1>修改小班信息</h1></br>
                <form class="layui-form" id="formId" action="updateClass.lovo" method="post" lay-filter="component-form-group">
                  <div class="layui-row layui-col-space10 layui-form-item">
                    <div class="layui-col-md6 layui-col-xs6">
                        <label class="layui-form-label">名称</label>
                        <div class="layui-input-inline">
                            <label class="layui-form-label">${currentClass.className}</label>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-xs6">
                        <label class="layui-form-label">负责人</label>
                        <div class="layui-input-inline">
                            <input type="text" autocomplete="off" name="classLeader" class="layui-input" value="${currentClass.classLeader}">
                        </div>
                    </div>
                </div>

                <div class="layui-row layui-col-space10 layui-form-item">
                    <div class="layui-col-md6 layui-col-xs6">
                        <label class="layui-form-label">负责人电话</label>
                        <div class="layui-input-inline">
                            <input type="text" autocomplete="off" name="classLeaderTel" class="layui-input" value="${currentClass.classLeaderTel}">
                        </div>
                    </div>
                    <div class="layui-col-md3 layui-col-xs3">
                        <label class="layui-form-label">人员数量</label>
                        <div class="layui-input-block">
                            <label class="layui-form-label">${currentClass.classNum}</label>
                        </div>
                    </div>
                </div>
                <div class="layui-row layui-col-space10 layui-form-item">
                    <div class="layui-col-md6 layui-col-xs6">
                        <label class="layui-form-label">负责区域</label>
                        <div class="layui-input-inline">
                            <label class="layui-form-label">${currentClass.areaName}</label>
                            <%--<input type="text" autocomplete="off" class="layui-input">--%>
                        </div>
                    </div>
                    <div class="layui-col-md3 layui-col-xs3">
                        <label class="layui-form-label">林种</label>
                        <div class="layui-input-block">
                            <label class="layui-form-label">${currentClass.areaTreeType}</label>
                        </div>
                    </div>
                </div>
                <div class="layui-row layui-col-space10 layui-form-item">
                    <div class="layui-col-md6 layui-col-xs6">
                        <label class="layui-form-label">地类</label>
                        <div class="layui-input-inline">
                            <label class="layui-form-label">${currentClass.areaType}</label>
                            <%--<input type="text" autocomplete="off" class="layui-input">--%>
                        </div>
                    </div>
                    <div class="layui-col-md3 layui-col-xs3">
                        <label class="layui-form-label">优势树种</label>
                        <div class="layui-input-block">
                            <label class="layui-form-label">${currentClass.areaGoodTree}</label>
                        </div>
                    </div>
                </div>
                <div class="layui-row layui-col-space10 layui-form-item">
                    <div class="layui-col-md6 layui-col-xs6">
                        <label class="layui-form-label">创建时间</label>
                        <div class="layui-input-inline">
                            <label class="layui-form-label">${currentClass.classStartDate}</label>
                            <%--<input type="text" autocomplete="off" class="layui-input">--%>
                        </div>
                    </div>

                </div>
                    <input type="hidden" name="classId" value="${currentClass.classId}">
                <button class="layui-btn" id="bid" lay-filter="component-form-demo1">修改</button>
                </form>

            </div>
        </div>
    </div>
</div>


<script>
    $("#bid").click(function () {
        $("#formId").submit();
        // location.href="showClass.lovo";
    });
</script>
</body>
</html>
