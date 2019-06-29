package com.zhou.forestProject.servlet;

import com.zhou.forestProject.bean.SysArea;
import com.zhou.forestProject.bean.SysType;
import com.zhou.forestProject.dto.AreaDto;
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

public class AddEventBeforeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //查找下拉框信息
        ITypeService service=new TypeServiceImpl();
        List<SysType> enevtStagelist=service.findListTypeByTypeName("ZQJD");//事件阶段
        List<SysType> eventTypeList=service.findListTypeByTypeName("ZHLX");//事件类型
        List<SysType> eventFindWayList=service.findListTypeByTypeName("FXTJ");//发现途径
        request.setAttribute("enevtStagelist",enevtStagelist);
        request.setAttribute("eventTypeList",eventTypeList);
        request.setAttribute("eventFindWayList",eventFindWayList);

        //查找所有区域
        IAreaService areaService=new AreaServiceImpl();
        List<AreaDto> areaList=areaService.findAreaBySome(null);
        request.setAttribute("areaList",areaList);

        request.getRequestDispatcher("jsp/addEvent.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
