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
    <title>事件表格</title>
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
                            <th>事件名称</th>
                            <th>日期</th>
                            <th>发生位置</th>
                            <th>防治方案</th>
                            <th>灾情状态</th>
                        </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${eventList}" var="s">
                            <tr onclick="addId(${s.eventId})">
                            <td>${s.eventName}</td>
                            <td>${s.eventDate}</td>
                            <td>${s.areaName}</td>
                            <td>${s.eventMethod}</td>
                            <td>${s.enevtStage}</td>
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
                        <button class="layui-btn layui-btn-primary" style="margin-right: 120px" id="bid3">申请专家会审</button>
                        <button class="layui-btn layui-btn-primary" id="bid4">修改事件信息</button>
                        <!--<button class="layui-btn">添加小班</button>-->

                    </div>
                </div>
            </div>

        </div>
        <!--添加按钮结束-->

        <div class="layui-col-md6 layui-col-xs6">
            <div class="layui-card">
                <div class="layui-card-header">事件查询</div>

                    <form class="layui-form" action="showEvent.lovo"method="post" id="formId" lay-filter="component-form-element">
                        <div class="layui-row layui-col-space10 layui-form-item">
                            <div class="layui-col-xs6">
                                <%--隐藏当前页--%>
                                <input type="hidden" id="cr1" value="${currentPage}" name="currentPage">
                                    <%--隐藏选中类型--%>
                                <input type="hidden" id="cr2" value="${enevtStage}" >
                                   
                                <label class="layui-form-label">事件名称：</label>
                                <div class="layui-input-block">
                                    <input type="text" style="width: 100px" value="${eventName}" name="eventName" lay-verify=""
                                           placeholder=""
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class=" layui-col-xs6">
                                <label class="layui-form-label">发生位置：</label>
                                <div class="layui-input-block">
                                    <input type="text" style="width: 100px" value="${areaName}" name="areaName" lay-verify=""
                                           placeholder=""
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-col-md6 layui-col-sm6">
                                <%--<div class="layui-form-item">--%>
                                    <label class="layui-form-label">灾情状态：</label>
                                    <div class="layui-input-block">
                                        <select name="enevtStage" id="eventStatus" lay-verify="">
                                            <option value="" selected="selected"></option>
                                            <c:forEach items="${eventStatusList}" var="s">
                                                <option value="${s.typeId}">${s.typeVal}</option>
                                            </c:forEach>

                                        </select>
                                    </div>
                                <%--</div>--%>
                            </div>
                        </div>
                        <div class="layui-row layui-col-space10 layui-form-item">
                            <div class="layui-col-md6 layui-col-sm6">
                                <label class="layui-form-label">起始日期：</label>
                                <div class="layui-input-block">
                                    <input type="date" style="width: 100px" value="${startDate}" name="startDate" lay-verify=""
                                           placeholder=""
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-col-lg6 layui-col-sm6">
                                <label class="layui-form-label">结束日期：</label>
                                <div class="layui-input-block">
                                    <input type="date" style="width: 100px" value="${endDate}" name="endDate" lay-verify=""
                                           placeholder=""
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>

                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="component-form-element" id="bid5">查询
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
<%--放入选中的行--%>
<form action="chooseEvent.lovo" method="post" id="formId2">
    <input type="hidden"  name="eventId"  id="eventId">
    <input type="hidden"  name="tag"  id="tagId">
</form>
<%--提交到申请专家会审--%>
<form action="eventToDoctor.lovo" method="post" id="formId3">
    <input type="hidden"  name="eventId"  id="eventId2">

</form>
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
    //下拉框显示
    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
    //查询
    $("#bid5").click(function () {
        $("#cr1").val("1");
        $("#formId").submit();
    });
    // 申请专家会审
    $("#bid3").click(function () {
       $("#formId3").submit();
    });
    // 修改事件信息
    $("#bid4").click(function () {
        $("#tagId").val("2");
        var evId=$("#eventId").val();
        if(evId!=null && evId!=''){
            $("#formId2").submit();

        }
    });
    // 添加事件
    $("#bid1").click(function () {

        location.href="addEventBefore.lovo";
    });
    //查看选中事件信息
    $("#bid2").click(function () {
        $("#tagId").val("1");
        var evId=$("#eventId").val();
        if(evId!=null && evId!=''){
            $("#formId2").submit();

        }

        // location.href="jsp/showEvent.jsp";
    });
    // 初始化加载选中类型
    $(document).ready(function () {
       var a=$("#cr2").val() 
        $("#eventStatus option").each(function () {
           var c= $(this).val();
           if(a==c){
               $(this).attr("selected","selected");
           }
        })
    });
    // 选中行
    function addId(r) {
        //把选中行id放入隐藏表单
        // alert(r)
        $("#eventId").val(r);
        $("#eventId2").val(r);


    }
</script>

</body>