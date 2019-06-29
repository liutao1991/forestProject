package com.zhou.forestProject.servlet;

import com.zhou.forestProject.bean.SysType;
import com.zhou.forestProject.dto.DoctorResultDto;
import com.zhou.forestProject.dto.EventDto;
import com.zhou.forestProject.dto.InfoDoctorDto;
import com.zhou.forestProject.service.IDoctorResultService;
import com.zhou.forestProject.service.IEventService;
import com.zhou.forestProject.service.IInfoDoctorService;
import com.zhou.forestProject.service.ITypeService;
import com.zhou.forestProject.service.impl.DoctorResultServiceImpl;
import com.zhou.forestProject.service.impl.EventServiceImpl;
import com.zhou.forestProject.service.impl.InfoDoctorServiceImpl;
import com.zhou.forestProject.service.impl.TypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ChooseEventServlet extends HttpServlet {
    IEventService eventService=new EventServiceImpl();//事件
    ITypeService typeService=new TypeServiceImpl();//类型
    IInfoDoctorService infoDoctorService=new InfoDoctorServiceImpl();//会商专家
    IDoctorResultService doctorResultService=new DoctorResultServiceImpl();//会商结果
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventId = request.getParameter("eventId");
        String tag = request.getParameter("tag");

        //创建一个事件dto 查找基本数据
        EventDto eventDto=eventService.findById(Integer.parseInt(eventId));
        //添加typeval
        eventDto.setEnevtStage(typeService.findValById(eventDto.getEnevtStageId()));
        eventDto.setEventFindWay(typeService.findValById(eventDto.getEventFindWayId()));
        eventDto.setEventType(typeService.findValById(eventDto.getEventTypeId()));
        //放入doctorResultlist
        List<DoctorResultDto> doctorResultDtoList=doctorResultService.findByEventId(Integer.parseInt(eventId));
        for (DoctorResultDto d:doctorResultDtoList) {
           List<InfoDoctorDto> infoDoctorDtoList= infoDoctorService.findByResultId( d.getResultId());
           d.setInfoDoctorDtoList(infoDoctorDtoList);
        }

        eventDto.setDoctorResultDtoList(doctorResultDtoList);
        request.setAttribute("eventDto",eventDto);
        if("1".equals(tag)){
        request.getRequestDispatcher("jsp/showEvent.jsp").forward(request,response);}
        else if("2".equals(tag)){
          List<SysType> typeList=typeService.findListTypeByTypeName("ZQJD");
          request.setAttribute("typeList",typeList);
            request.getRequestDispatcher("jsp/updateEvent.jsp").forward(request,response);}

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
