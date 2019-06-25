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

public class AddAreaServlet extends HttpServlet {
    ITypeService typeService=new TypeServiceImpl();
    IAreaService areaService=new AreaServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String areaName=  request.getParameter("areaName");
         String areaTreeType=  request.getParameter("areaTreeType");
         String areaGoodTree=  request.getParameter("areaGoodTree");
         String typeName=  request.getParameter("typeVal");
         long typeId=typeService.findIdByVal(typeName);
        SysArea sysArea=new SysArea();
        SysType sysType=new SysType();
        sysType.setTypeId(typeId);
        sysArea.setSysType(sysType);
        sysArea.setAreaGoodTree(areaGoodTree);
        sysArea.setAreaTreeType(areaTreeType);
        sysArea.setAreaName(areaName);
        boolean bl=areaService.addArea(sysArea);
        if(bl){
            request.getRequestDispatcher("jsp/area.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("jsp/addArea.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
