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
  <title>考勤系统</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <%@include file="../head.jsp" %>

</head>
<body class="layui-layout-body">
  
  <div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
      <div class="layui-header">
        <!-- 头部区域 -->
        <ul class="layui-nav layui-layout-left">
          <li class="layui-nav-item layadmin-flexible" lay-unselect>
            <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
              <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
            </a>
          </li>

        </ul>

      </div>

      <!-- 侧边菜单 -->
      <div class="layui-side layui-side-menu">
        <div class="layui-side-scroll">
          <div class="layui-logo">
            <span>森林病虫害防治系统</span>
          </div>

          <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu-1" lay-filter="layadmin-system-side-menu">
            <li data-name="home" class="layui-nav-item layui-nav-itemed">
              <a href="javascript:;" lay-tips="主页" lay-direction="2">
                <i class="layui-icon layui-icon-home"></i>
                <cite>资料管理</cite>
              </a>
              <dl class="layui-nav-child">
                <dd data-name="console" >
                  <a href="views/group.jsp" target="mainName">虫害一览</a>
                </dd>
                <dd data-name="console" >
                  <a href="findCheck.lovo" target="mainName">病害一览</a>
                </dd>

                <dd data-name="console" >
                  <a href="findCheck.lovo" target="mainName">鼠害一览</a>
                </dd>

              </dl>
            </li>

          </ul>

          <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu-2" lay-filter="layadmin-system-side-menu">
            <li data-name="home" class="layui-nav-item layui-nav-itemed">
              <a href="javascript:;" lay-tips="主页" lay-direction="2">
                <i class="layui-icon layui-icon-home"></i>
                <cite>灾情防治</cite>
              </a>
              <dl class="layui-nav-child">
                <dd data-name="console" >
                  <a href="showArea.lovo" target="mainName">区域一览</a>
                </dd>
                <dd data-name="console" >
                  <a href="showClass.lovo" target="mainName">小班管理</a>
                </dd>
                <dd data-name="console" >
                  <a href="showEvent.lovo" target="mainName">事件记录</a>
                </dd>

              </dl>
            </li>

          </ul>

          <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu-3" lay-filter="layadmin-system-side-menu">
            <li data-name="home" class="layui-nav-item layui-nav-itemed">
              <a href="javascript:;" lay-tips="主页" lay-direction="2">
                <i class="layui-icon layui-icon-home"></i>
                <cite>专家会审</cite>
              </a>
              <dl class="layui-nav-child">
                <dd data-name="console" >
                  <a href="views/group.jsp" target="mainName">专家一览</a>
                </dd>
                <dd data-name="console" >
                  <a href="findCheck.lovo" target="mainName">会商灾情</a>
                </dd>

              </dl>
            </li>

          </ul>

          <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu-4" lay-filter="layadmin-system-side-menu">
            <li data-name="home" class="layui-nav-item layui-nav-itemed">
              <a href="javascript:;" lay-tips="主页" lay-direction="2">
                <i class="layui-icon layui-icon-home"></i>
                <cite>药剂器械出库管理</cite>
              </a>
              <dl class="layui-nav-child">
                <dd data-name="console" >
                  <a href="views/group.jsp" target="mainName">药剂管理</a>
                </dd>
                <dd data-name="console" >
                  <a href="findCheck.lovo" target="mainName">出库管理</a>
                </dd>

              </dl>
            </li>

          </ul>

          <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu-5" lay-filter="layadmin-system-side-menu">
            <li data-name="home" class="layui-nav-item layui-nav-itemed">
              <a href="javascript:;" lay-tips="主页" lay-direction="2">
                <i class="layui-icon layui-icon-home"></i>
                <cite>系统信息</cite>
              </a>
              <dl class="layui-nav-child">
                <dd data-name="console" >
                  <a href="views/group.jsp" target="mainName">用户管理</a>
                </dd>
                <dd data-name="console" >
                  <a href="findCheck.lovo" target="mainName">日志一览</a>
                </dd>

              </dl>
            </li>

          </ul>
        </div>
      </div>

      <!-- 页面标签 -->
      <div class="layadmin-pagetabs" id="LAY_app_tabs">

      </div>

      
      <!-- 主体内容 -->
      <div class="layui-body" id="LAY_app_body">
        <div class="layadmin-tabsbody-item layui-show">
          <iframe src="views/group.jsp" frameborder="0" name="mainName" class="layadmin-iframe"></iframe>
        </div>
      </div>
      
      <!-- 辅助元素，一般用于移动设备下遮罩 -->
      <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
  </div>


  <script>
  layui.config({
    base: 'layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use('index');
  </script>
</body>
</html>


