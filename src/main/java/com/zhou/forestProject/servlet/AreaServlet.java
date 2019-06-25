package com.zhou.forestProject.servlet;


import com.zhou.forestProject.dto.AreaDto;
import com.zhou.forestProject.service.IAreaService;
import com.zhou.forestProject.service.impl.AreaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AreaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IAreaService service=new AreaServiceImpl();
        Map<String,Object> map=new HashMap<>();
        List<AreaDto> list=service.findAreaBySome(map);
        request.setAttribute("areaList",list);
        request.getRequestDispatcher("jsp/area.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
