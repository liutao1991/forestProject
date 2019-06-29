package com.zhou.forestProject.servlet;

import com.zhou.forestProject.bean.SysArea;
import com.zhou.forestProject.bean.SysType;
import com.zhou.forestProject.service.IAreaService;
import com.zhou.forestProject.service.ITypeService;
import com.zhou.forestProject.service.impl.AreaServiceImpl;
import com.zhou.forestProject.service.impl.TypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddClassBeforeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //查询没有小班管理的区域，添加到request
        IAreaService areaService = new AreaServiceImpl();
        List<SysArea> areaList = areaService.findWithoutClass();
        request.setAttribute("areaList", areaList);

        //转发到添加addClass.jsp页面
        request.getRequestDispatcher("jsp/addClass.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
