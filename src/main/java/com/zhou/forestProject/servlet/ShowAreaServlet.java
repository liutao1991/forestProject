package com.zhou.forestProject.servlet;


import com.zhou.forestProject.bean.SysArea;
import com.zhou.forestProject.dto.AreaDto;
import com.zhou.forestProject.service.IAreaService;
import com.zhou.forestProject.service.impl.AreaServiceImpl;
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

public class ShowAreaServlet extends HttpServlet {
    IAreaService service=new AreaServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //前端传参 查找的参数 当前页数
        String areaName=request.getParameter("areaName");   //区域名称
        String areaTreeType=request.getParameter("areaTreeType");   //林种
        String className=request.getParameter("className");   //负责小班
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
        if(Verify.verifyString(areaTreeType)){
            map.put("areaTreeType",areaTreeType);
            request.setAttribute("areaTreeType",areaTreeType);
        }
        if(Verify.verifyString(className)){
            map.put("className",className);
            request.setAttribute("className",className);
        }

        //统计行数
        int allCount= service.countRow(map);

        //添加查询行数
         map.put("startCount",start);
         map.put("pageCount",pageUtil.getCountPage());

         List<AreaDto> list=service.findAreaBySome(map);

        request.setAttribute("allCount",allCount);//总行数
        request.setAttribute("showPage",pageUtil.getCountPage());//展示的行数
        request.setAttribute("areaList",list);//查询的集合
        request.setAttribute("currentPage",currentPageNum);//把当前页放回页面
        request.getRequestDispatcher("jsp/area.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
