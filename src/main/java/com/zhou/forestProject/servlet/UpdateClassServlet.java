package com.zhou.forestProject.servlet;

import com.zhou.forestProject.service.IClassService;
import com.zhou.forestProject.service.impl.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到页面的数据
        String classId=request.getParameter("classId");//班级id
        String classLeader=request.getParameter("classLeader");//负责人
        String classLeaderTel=request.getParameter("classLeaderTel");//负责人电话

        IClassService service=new ClassServiceImpl();
        boolean bl=service.updateClass(classLeader,classLeaderTel,Integer.parseInt(classId));

       if(bl) {
           //添加成功，转发到展示小班页面
           response.sendRedirect("showClass.lovo");
           return;
       }else{
           //添加不成功，重定向到添加页面
           request.getRequestDispatcher("jsp/updateClass.jsp").forward(request,response);
       }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
