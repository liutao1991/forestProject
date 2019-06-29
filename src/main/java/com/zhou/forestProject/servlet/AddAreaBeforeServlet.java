package com.zhou.forestProject.servlet;

import com.zhou.forestProject.bean.SysType;
import com.zhou.forestProject.service.ITypeService;
import com.zhou.forestProject.service.impl.TypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddAreaBeforeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ITypeService service=new TypeServiceImpl();
        List<SysType> list=service.findListTypeByTypeName("DL");
        request.setAttribute("typeList",list);
        request.getRequestDispatcher("jsp/addArea.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
