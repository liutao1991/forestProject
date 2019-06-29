package com.zhou.forestProject.servlet;

import com.zhou.forestProject.bean.SysArea;
import com.zhou.forestProject.bean.SysClass;
import com.zhou.forestProject.service.IClassService;
import com.zhou.forestProject.service.impl.ClassServiceImpl;
import com.zhou.forestProject.util.DateUtils;
import com.zhou.forestProject.util.Verify;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddClassAfterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //得到添加页面的数据
        String className=request.getParameter("className"); //小班名称
        String classLeader=request.getParameter("classLeader");//负责人
        String classLeaderTel=request.getParameter("classLeaderTel");//负责人电话
        String classNum=request.getParameter("classNum");//人员数量
        String areaId=request.getParameter("areaId");//负责区域id
       //数据验证
        boolean bl=Verify.verifyString(classLeader,className,classLeaderTel,classNum,areaId);
        if(bl) {
            //添加到班级对象
            SysClass c = new SysClass();
            c.setClassName(className);
            c.setClassLeader(classLeader);
            c.setClassLeaderTel(classLeaderTel);
            c.setClassNum(Integer.parseInt(classNum));
            c.setAreaId(Long.parseLong(areaId));

            // 添加日期
            c.setClassStartDate(DateUtils.getDateString("yyyy-MM-dd"));
            //添加到数据库
            IClassService service=new ClassServiceImpl();
            boolean l=service.addClass(c);

            if(l){
                //添加成功，重定向到展示页面
                response.sendRedirect("showClass.lovo");
                 return;
            }else{
                // 添加不成功，重定向到添加页面
                response.sendRedirect("addClassBefore.lovo");
                return;
            }

        }

        // 添加不成功，重定向到添加页面
        response.sendRedirect("addClassBefore.lovo");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
