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
    <%@include file="../head.jsp"%>
</head>
<body>


<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div align="center" style="font-size: 40px" class="layui-card-header">虫害一览</div>
                <!--表格开始-->
                <div class="layui-card-body">
                    <table class="layui-table">
                        <colgroup>
                            <col width="150">
                            <col width="150">
                            <col width="200">
                            <col>
                        </colgroup><thead>
                    <tr>
                        <th>名称</th>
                        <th>寄主</th>
                        <th>主要危害</th>
                    </tr>
                    </thead>
                        <c:forEach items="${PestList}" var="pest">
                            <tr>
                                <td>${pest.pestName}</td>
                                <td>${pest.pestHost}</td>
                                <td>${pest.pestHarm}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div><!--表格结束-->


        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div id="test-laypage-demo3"></div>
                </div>
            </div>
        </div>

    </div>
</div>


<div class="layui-row layui-col-space15">
    <!--添加按钮开始-->
    <div class="layui-col-md6">
        <div class="layui-card">
            <div class="layui-card-body">
                <div class="layui-btn-container">
                    <button id="bbId" class="layui-btn layui-btn-primary" style="margin-right: 150px;margin-bottom: 70px">
                        添加新虫害
                    </button>
                    <button class="layui-btn layui-btn-primary" style="margin-bottom: 70px">查看详细信息</button>
                </div>
            </div>
        </div>

    </div>
    <!--添加按钮结束-->

    <div class="layui-col-md6">
        <div class="layui-card">
            <div class="layui-card-header">查询虫害信息</div>
            <form action="showPest" method="post" id="findForm" >
                    <input type="hidden" id="cr1" value="${pageNow}" name="pageNow">
                <div class="layui-row layui-col-space10 layui-form-item">
                    <div class="layui-col-lg6">
                        <label class="layui-form-label">害虫名：</label>
                        <div class="layui-input-block">
                            <input value="${pestName}" type="text" style="width: 100px" name="pestName" lay-verify="required"
                                   placeholder=""
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-col-lg6">
                        <label class="layui-form-label">寄主：</label>
                        <div class="layui-input-block">
                            <input value="${pestHost}" type="text" style="width: 100px" name="pestHost" lay-verify="required"
                                   placeholder=""
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div  class="layui-col-md12">
                        <div class="layui-input-block">
                            <button id="findPestId" class="layui-btn" lay-submit lay-filter="component-form-element">查询
                            </button>
                        </div>
                    </div>
                </div>
            </form>
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
                $("#findForm").submit();
                }
            }
        });

    });
    // 添加按钮的方法
    $("#bbId").click(function () {
        location.href="jsp/addPest.jsp";
    })
    // 查询按钮的方法
    $("#findPestId").click(function () {
        //提交查找的表单
        $("#findForm").submit();
    })

</script>
</body>
</html>