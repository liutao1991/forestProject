package com.zhou.forestProject.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhou.forestProject.bean.SysType;
import com.zhou.forestProject.service.ITypeService;
import com.zhou.forestProject.service.impl.TypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ITypeService service=new TypeServiceImpl();
        String typeName=request.getParameter("typeName");
        List<SysType> list=service.findListTypeByTypeName(typeName);
        request.setAttribute("typeList",list);
        request.getRequestDispatcher("jsp/addArea.jsp").forward(request,response);
//        ObjectMapper objectMapper=new ObjectMapper();
//        String typeListStr=objectMapper.writeValueAsString(list);
//        PrintWriter pw=response.getWriter();
//        pw.write(typeListStr);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
