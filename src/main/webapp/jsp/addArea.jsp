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
            <div align="center"><h1>区域一览</h1></br>
                <form class="layui-form" action="" lay-filter="component-form-group">

                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md3 layui-col-xs3"></div>
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">名称</label>
                            <div class="layui-input-inline">
                                <input type="text" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md3 layui-col-xs3"></div>
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">林种</label>
                            <div class="layui-input-inline">
                                <input type="text" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md3 layui-col-xs3"></div>
                        <div class="layui-col-md6 layui-col-xs6">
                            <label class="layui-form-label">优势树种</label>
                            <div class="layui-input-inline">
                                <input type="text" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-row layui-col-space10 layui-form-item">
                        <div class="layui-col-md3 layui-col-xs3"></div>
                        <div class="layui-col-md4 layui-col-xs4">
                            <label class="layui-form-label">地类</label>
                            <div class="layui-input-block"  >
                                <select  name="city" lay-verify="required"  >
                                    <option value=""></option>
                                    <option value="0">北京</option>
                                    <option value="1">上海</option>
                                    <option value="2">广州</option>
                                    <option value="3">深圳</option>
                                    <option value="4">杭州</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <button class="layui-btn" lay-submit="" lay-filter="component-form-demo1">添加</button>

                </form>
            </div>
        </div>
    </div>
</div>


<script>
    layui.config({
        base: 'layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form', 'laydate'], function () {
        var $ = layui.$
            , admin = layui.admin
            , element = layui.element
            , layer = layui.layer
            , laydate = layui.laydate
            , form = layui.form;

        form.render(null, 'component-form-group');

        laydate.render({
            elem: '#LAY-component-form-group-date'
        });

        /* 自定义验证规则 */
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            }
            , pass: [/(.+){6,12}$/, '密码必须6到12位']
            , content: function (value) {
                layedit.sync(editIndex);
            }
        });

        /* 监听指定开关 */
        form.on('switch(component-form-switchTest)', function (data) {
            layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        /* 监听提交 */
        form.on('submit(component-form-demo1)', function (data) {
            parent.layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });
    });
</script>
</body>
</html>
