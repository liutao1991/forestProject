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

public class AddAreaAfterServlet extends HttpServlet {
    ITypeService typeService=new TypeServiceImpl();
    IAreaService areaService=new AreaServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到添加的数据
         String areaName=  request.getParameter("areaName");
         String areaTreeType=  request.getParameter("areaTreeType");
         String areaGoodTree=  request.getParameter("areaGoodTree");
         String typeId=  request.getParameter("typeVal");
         //创建区域对象
        SysArea sysArea=new SysArea();
       //添加对象数据
        sysArea.setAreaAdressId(Long.parseLong(typeId));
        sysArea.setAreaGoodTree(areaGoodTree);
        sysArea.setAreaTreeType(areaTreeType);
        sysArea.setAreaName(areaName);
        boolean bl=areaService.addArea(sysArea);
        if(bl){
            //重定向到展示页面
            response.sendRedirect("showArea.lovo");
            return;
        }else {
            //重定向到当前页面
            response.sendRedirect("addAreaBefore.lovo");
            return;
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
