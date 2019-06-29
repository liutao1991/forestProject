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

<div class="layui-card layadmin-header">
    <div class="layui-breadcrumb" lay-filter="breadcrumb">
        <a lay-href="">主页</a>
        <a><cite>组件</cite></a>
        <a><cite>静态表格</cite></a>
    </div>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-card">
                <div align="center" style="font-size: 40px" class="layui-card-header">区域一览</div>
                <!--表格开始-->
                <div class="layui-card-body">
                    <table class="layui-table">
                        <colgroup>
                            <col width="150">
                            <col width="150">
                            <col width="200">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>区域名称</th>
                            <th>林种</th>
                            <th>地类</th>
                            <th>优势树种</th>
                            <th>负责小班</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="c" items="${areaList}" >
                            <tr>
                                <td>${c.areaName}</td>
                                <td>${c.areaTreeType}</td>
                                <td>${c.typeVal}</td>
                                <td>${c.areaGoodTree}</td>
                                <td>${c.className}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!--表格结束-->
                <!--分页开始-->
                <div class="layui-card">
                <div class="layui-card-body">
                    <div id="test-laypage-demo3"></div>
                </div>
                </div>
                <!--分页结束-->
            </div>
        </div>
    </div>

    <div class="layui-row layui-col-space15" >
        <!--添加按钮开始-->
        <div class="layui-col-md6 layui-col-xs6" >
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="layui-btn-container">

                        <button class="layui-btn layui-btn-primary" style="margin-bottom: 70px" onclick="add()">添加区域</button>

                    </div>
                </div>
            </div>

        </div>
        <!--添加按钮结束-->

        <div class="layui-col-md6 layui-col-xs6">
            <div class="layui-card">
                <div class="layui-card-header">查询区域信息</div>

                    <form class="layui-form" id="formId" action="showArea.lovo" method="post" lay-filter="component-form-element">

                        <div class="layui-row layui-col-space10 layui-form-item">
                            <div class="layui-col-lg6">
                                <%--隐藏表单type名字--%>
                                <%--<input type="hidden"  name="typeName" id="typeName" value="DL123">--%>
                                  <%--隐藏当前页--%>
                                    <input type="hidden" id="cr1" value="${currentPage}" name="currentPage">

                                    <label class="layui-form-label">区域名称：</label>
                                <div class="layui-input-block">
                                    <input type="text" style="width: 100px" name="areaName" value="${areaName}" lay-verify="required"
                                           placeholder=""
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-col-lg6">
                                <label class="layui-form-label">林种：</label>
                                <div class="layui-input-block">
                                    <input type="text" style="width: 100px" name="areaTreeType" value="${areaTreeType}" lay-verify="required"
                                           placeholder=""
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-col-lg6">
                                <label class="layui-form-label">负责小班：</label>
                                <div class="layui-input-block">
                                    <input type="text" style="width: 100px" name="className" value="${className}" lay-verify="required"
                                           placeholder=""
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>

                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" id="bid" lay-submit lay-filter="component-form-element">查询
                                </button>
                            </div>
                        </div>
                    </form>

            </div>
        </div>
    </div>

</div>
</div>
</div>

<script>
    layui.config({
        base: 'layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'laypage'], function(){
        var laypage = layui.laypage;
        //自定义首页、尾页、上一页、下一页文本
        laypage.render({
            elem: 'test-laypage-demo3'
            ,count:${allCount}
            ,limit:${showPage}
            ,curr:$("#cr1").val()
            ,first: '首页'
            ,last: '尾页'
            ,prev: '<em>←</em>'
            ,next: '<em>→</em>'
            ,jump:function (obj,first) {
                if(!first){
                    // alert(obj.curr);
                    $("#cr1").val(obj.curr)
                    $("#formId").submit();
                }
            }
        });

    });
    // 查詢按鈕
    $("#bid").click(function () {
        $("#cr1").val("1");
        $("#formId").submit();
    });
    function add(){
        location.href="addAreaBefore.lovo";
        <%--location.href="${basePath}type.lovo";--%>

    }

</script>

</body>