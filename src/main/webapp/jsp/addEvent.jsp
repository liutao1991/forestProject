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
            <div align="center"><h1>添加事件信息</h1></br>
                <form class="layui-form" action="addEventAfter.lovo" method="post" id="formId"
                      lay-filter="component-form-group" enctype="multipart/form-data">

                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">事件名称</label>
                            <div class="layui-input-inline">
                                <input id="a" type="text" autocomplete="off" name="eventName" class="layui-input"  lay-verify="required">
                            </div>
                        </div>
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">灾害图片</label>
                            <div class="layui-input-inline">
                                <input type="file" autocomplete="off" name="eventImgPath" class="layui-input">
                            </div>
                        </div>
                    </div>

                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">时间</label>
                            <div class="layui-input-inline">
                                <input type="date" autocomplete="off" name="eventDate" class="layui-input"  lay-verify="required">
                            </div>
                        </div>
                        <div class="layui-col-md3 layui-col-xs3">
                            <label class="layui-form-label">灾害类型</label>
                            <div class="layui-input-block">
                                <select name="eventType" lay-verify="required"  lay-verify="required">
                                    <option value=""></option>
                                    <c:forEach items="${eventTypeList}" var="a">
                                        <option value="${a.typeId}">${a.typeVal}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md3 layui-col-xs3">
                            <label class="layui-form-label">灾情阶段</label>
                            <div class="layui-input-block">
                                <select name="enevtStage" lay-verify="required"  lay-verify="required">
                                    <option value=""></option>
                                    <c:forEach items="${enevtStagelist}" var="a">
                                        <option value="${a.typeId}">${a.typeVal}</option>
                                    </c:forEach>

                                </select>
                            </div>
                        </div>
                        <div class="layui-col-md3 layui-col-xs3"></div>
                        <div class="layui-col-md3 layui-col-xs3">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">灾情描述</label>
                                <div class="layui-input-block">
                                    <textarea name="eventInfo" style="width: 400px" dirname="" placeholder="请输入内容"
                                              class="layui-textarea"  lay-verify="required"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md3 layui-col-xs3">
                            <label class="layui-form-label">发现途径</label>
                            <div class="layui-input-block">
                                <select name="eventFindWay" lay-verify="required"  lay-verify="required">
                                    <option value=""></option>
                                    <c:forEach items="${eventFindWayList}" var="a">
                                        <option value="${a.typeId}">${a.typeVal}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="layui-col-md3 layui-col-xs3"></div>
                        <div class="layui-col-md3 layui-col-xs3">
                            <label class="layui-form-label">发生位置</label>
                            <div class="layui-input-block">
                                <select  lay-search name="areaId" lay-filter="area"   lay-verify="required" id="selectId" >
                                    <option value="" ></option>
                                    <c:forEach items="${areaList}" var="s">
                                        <option value="${s.areaId},${s.className}">${s.areaName}</option>
                                        <%--<input type="hidden" value="${s.className}" id="${s.areaId}">--%>
                                    </c:forEach>

                                </select>
                            </div>

                        </div>
                    </div>

                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">初步损失</label>
                            <div class="layui-input-inline">
                                <input type="text" name="eventLoss" autocomplete="off" class="layui-input"  lay-verify="required">
                            </div>
                        </div>
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">所在小班</label>
                            <div class="layui-input-inline">
                                <label class="layui-form-label" name="className" id="classId"></label>
                            </div>
                        </div>

                    </div>

                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">影响面积</label>
                            <div class="layui-input-inline">
                                <input type="text" name="eventArea" autocomplete="off" class="layui-input"  lay-verify="required">
                            </div>
                        </div>
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">防治方案</label>
                            <div class="layui-input-inline">
                                <input type="text" name="eventMethod" autocomplete="off" class="layui-input"  lay-verify="required">
                            </div>
                        </div>
                    </div>


                    <button class="layui-btn" lay-submit="" id="bid" lay-filter="component-form-demo1">添加</button>

                </form>
            </div>
        </div>
    </div>
</div>
<div>
    <input type="hidden" id="chooseid">
</div>
<script src="layuiadmin/layui/layui.js"></script>
<script src="js/jquery.min.js"></script>
<script>

     layui.use(['form','layedit','laydate'], function () {
         var form = layui.form;
         // form.render();
         form.on('select(area)', function(data){
             // alert(data.elem); //得到select原始DOM对象
             var areaId=data.value; //得到被选中的值
             // alert(data.othis); //得到美化后的DOM对象
             chooseArea(areaId);

         });
     });


    function chooseArea(areaId){
        // alert(areaId)
        var className=areaId.substring(areaId.indexOf(",")+1,areaId.length);
        // alert(className)
        $("#classId").text(className)
        // $.post("addEventFindClass.lovo",{"areaId":areaId},function (r) {
        //
        // })

    }

    $("#bid").click(function () {
        $("#formId").submit();
    });
</script>
</body>
</html>
