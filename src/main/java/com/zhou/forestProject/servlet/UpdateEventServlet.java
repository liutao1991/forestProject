package com.zhou.forestProject.servlet;

import com.zhou.forestProject.service.IEventService;
import com.zhou.forestProject.service.impl.EventServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateEventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IEventService service=new EventServiceImpl();

        String eventId= request.getParameter("eventId");
        String eventStatus= request.getParameter("eventStatus");//灾情阶段
        String eventMethod= request.getParameter("eventMethod");//防治方案
        boolean bl=service.updateEvent(Long.parseLong(eventStatus),eventMethod,Long.parseLong(eventId));
        if(bl){
            response.sendRedirect("showEvent.lovo");
        }else{
            request.getRequestDispatcher("jsp/updateEvent.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
