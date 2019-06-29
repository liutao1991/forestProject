package com.zhou.forestProject.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhou.forestProject.bean.SysClass;
import com.zhou.forestProject.service.IClassService;
import com.zhou.forestProject.service.impl.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddEventFindClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String areaId= request.getParameter("areaId");
        IClassService service=new ClassServiceImpl();
        SysClass sysClass=service.findClassByAreaId(Integer.parseInt(areaId));
        ObjectMapper objectMapper=new ObjectMapper();
       String sysClassStr= objectMapper.writeValueAsString(sysClass);
        PrintWriter pw=response.getWriter();
        pw.write(sysClassStr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
