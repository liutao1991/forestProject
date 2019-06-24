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
                <div align="center" style="font-size: 40px" class="layui-card-header">事件记录</div>
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
                            <th>人物</th>
                            <th>民族</th>
                            <th>出场时间</th>
                            <th>格言</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>贤心</td>
                            <td>汉族</td>
                            <td>1989-10-14</td>
                            <td>人生似修行</td>
                        </tr>
                        <tr>
                            <td>张爱玲</td>
                            <td>汉族</td>
                            <td>1920-09-30</td>
                            <td>于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里…</td>
                        </tr>
                        <tr>
                            <td>Helen Keller</td>
                            <td>拉丁美裔</td>
                            <td>1880-06-27</td>
                            <td> Life is either a daring adventure or nothing.</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!--表格结束-->
                <!--分页开始-->
                <div class="layui-card-body">
                    <div id="test-laypage-demo0"></div>
                </div>
                <!--分页结束-->
            </div>
        </div>
    </div>

    <div class="layui-row layui-col-space15">
        <!--添加按钮开始-->
        <div class="layui-col-md6 layui-col-xs6" >
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="layui-btn-container">
                        <button id="bid1"  class="layui-btn layui-btn-primary" style="margin-right: 150px;margin-bottom: 70px">
                            添加事件
                        </button>
                        <button class="layui-btn layui-btn-primary" style="margin-bottom: 70px" id="bid2">查看事件信息</button>
                        <p></p>
                        <button class="layui-btn layui-btn-primary" style="margin-right: 120px">申请专家会审</button>
                        <button class="layui-btn layui-btn-primary">修改事件信息</button>
                        <!--<button class="layui-btn">添加小班</button>-->

                    </div>
                </div>
            </div>

        </div>
        <!--添加按钮结束-->

        <div class="layui-col-md6 layui-col-xs6">
            <div class="layui-card">
                <div class="layui-card-header">查询小班信息</div>
                <form class="layui-card-body">
                    <form class="layui-form" action="" lay-filter="component-form-element">
                        <div class="layui-row layui-col-space10 layui-form-item">
                            <div class="layui-col-lg6">
                                <label class="layui-form-label">事件名称：</label>
                                <div class="layui-input-block">
                                    <input type="text" style="width: 100px" name="fullname" lay-verify="required"
                                           placeholder=""
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-col-lg6">
                                <label class="layui-form-label">灾情状态：</label>
                                <div class="layui-input-block">
                                    <input type="text" style="width: 100px" name="fullname" lay-verify="required"
                                           placeholder=""
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-col-lg6">
                                <label class="layui-form-label">发生位置：</label>
                                <div class="layui-input-block">
                                    <input type="text" style="width: 100px" name="fullname" lay-verify="required"
                                           placeholder=""
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-col-lg6">
                                <label class="layui-form-label">起始日期：</label>
                                <div class="layui-input-block">
                                    <input type="date" style="width: 100px" name="fullname" lay-verify="required"
                                           placeholder=""
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-col-lg6">
                                <label class="layui-form-label">结束日期：</label>
                                <div class="layui-input-block">
                                    <input type="date" style="width: 100px" name="fullname" lay-verify="required"
                                           placeholder=""
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>

                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="component-form-element">查询
                                </button>
                            </div>
                        </div>
                    </form>
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
    }).use(['index', 'laypage'], function () {
        var laypage = layui.laypage;
        //总页数低于页码总数
        laypage.render({
            elem: 'test-laypage-demo0'
            , count: 50 //数据总数
        });
    });
    $("#bid1").click(function () {
        location.href="jsp/addEvent.jsp";
    });
</script>

</body>