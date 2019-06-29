package com.zhou.forestProject.servlet;

import com.zhou.forestProject.bean.SysClass;
import com.zhou.forestProject.bean.SysEvent;
import com.zhou.forestProject.bean.SysType;
import com.zhou.forestProject.dto.EventDto;
import com.zhou.forestProject.service.IEventService;
import com.zhou.forestProject.service.ITypeService;
import com.zhou.forestProject.service.impl.EventServiceImpl;
import com.zhou.forestProject.service.impl.TypeServiceImpl;
import com.zhou.forestProject.util.PageUtil;
import com.zhou.forestProject.util.Verify;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowEventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //前端传参 查找的参数 当前页数
        String eventName=request.getParameter("eventName");   //事件名称
        String enevtStage=request.getParameter("enevtStage");   //灾情状态id
        String areaName=request.getParameter("areaName");   //发生位置
        String startDate=request.getParameter("startDate");   //起始日期
        String endDate=request.getParameter("endDate");   //结束日期
        String currentPage=request.getParameter("currentPage");   //当前页

        int currentPageNum=1;
        if(Verify.verifyString(currentPage)){
            //当前页不为空
            currentPageNum=Integer.parseInt(currentPage);
        }
        //计算起始行数
        PageUtil pageUtil=new PageUtil();
        int start=pageUtil.setStart(currentPageNum);
        //把参数放入集合
        Map<String,Object> map=new HashMap<>();
        if(Verify.verifyString(areaName)){
            map.put("areaName",areaName);
            request.setAttribute("areaName",areaName);//把参数传回页面
        }
        if(Verify.verifyString(eventName)){
            map.put("eventName",eventName);
            request.setAttribute("eventName",eventName);//把参数传回页面
        }
        if(Verify.verifyString(enevtStage)){
            map.put("enevtStage",enevtStage);
            request.setAttribute("enevtStage",enevtStage);//把参数传回页面
        }
        if(Verify.verifyString(startDate)){
            map.put("startDate",startDate);
            request.setAttribute("startDate",startDate);//把参数传回页面
        }
        if(Verify.verifyString(endDate)){
            map.put("endDate",endDate);
            request.setAttribute("endDate",endDate);//把参数传回页面
        }
        //得到下拉框数据
        ITypeService service=new TypeServiceImpl();
        List<SysType> list=service.findListTypeByTypeName("ZQJD");
        request.setAttribute("eventStatusList",list);
        //得到总行数
        IEventService eventService=new EventServiceImpl();
        int allCount=eventService.countRow(map);
        //添加查询行数
        map.put("startCount",start);
        map.put("pageCount",pageUtil.getCountPage());

        List<EventDto> eventList=eventService.findEventBySome(map);
        ITypeService typeService=new TypeServiceImpl();
        for (EventDto e:eventList) {
           e.setEnevtStage( typeService.findValById(e.getEnevtStageId()));
        }
       //查询数据库，将事件集合添加到request
        request.setAttribute("eventList",eventList);
        request.setAttribute("allCount",allCount);
        request.setAttribute("showPage",pageUtil.getCountPage());
        request.setAttribute("currentPage",currentPageNum);
       //转发到事件展示页面
        request.getRequestDispatcher("jsp/event.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
