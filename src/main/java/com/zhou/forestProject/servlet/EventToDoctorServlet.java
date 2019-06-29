package com.zhou.forestProject.servlet;

import com.zhou.forestProject.service.IDoctorEventService;
import com.zhou.forestProject.service.IEventService;
import com.zhou.forestProject.service.impl.DoctorEventServiceImpl;
import com.zhou.forestProject.service.impl.EventServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 申请专家会审
 */
public class EventToDoctorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDoctorEventService service=new DoctorEventServiceImpl();
        IEventService eventService=new EventServiceImpl();
        String eventId=request.getParameter("eventId");
        //验证事件状态是否已经是专家会商，是就直接返回，不做添加
        long eventStageId=eventService.findEventStageByEventId(Long.parseLong(eventId));
        if(eventStageId==7){
            response.sendRedirect("showEvent.lovo");
            return;
        }
        //添加专家事件表中数据
       boolean bl= service.addDoctorEvent(Long.parseLong(eventId));
      if(bl){
          //为真，转发到首页
          response.sendRedirect("showEvent.lovo");
          return;
      }
        response.sendRedirect("showEvent.lovo");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
