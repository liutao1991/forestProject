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
    <meta charset="utf-8">
    <title>森林病虫害防治系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%@include file="head.jsp"%>
</head>
<body>

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2>森林病虫害防治系统</h2>
            <p>登录</p>
        </div>

        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <!--form start  -->
            <form action="login.lovo" id="formId" method="post">
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
                    <input type="text" name="userName" id="LAY-user-login-username" lay-verify="required" placeholder="用户名" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
                    <input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
                </div>

            </form>
            <!--form end -->

            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit" id="summitId">登录</button>
            </div>
            <%--<div class="layui-trans layui-form-item layadmin-user-login-other">--%>


                <%--<a href="reg.html" class="layadmin-user-jump-change layadmin-link">注册帐号</a>--%>
            <%--</div>--%>
        </div>

    </div>



    <div class="layui-trans layadmin-user-login-footer">

        <p>© 2019 j168 周周小组</p>

    </div>

</div>

<script>

    $("#summitId").click(function () {
        $("#formId").submit();
    });

</script>


</body>
</html>