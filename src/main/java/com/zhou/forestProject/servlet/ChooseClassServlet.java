package com.zhou.forestProject.servlet;

import com.zhou.forestProject.bean.SysClass;
import com.zhou.forestProject.dto.ClassDto;
import com.zhou.forestProject.service.IClassService;
import com.zhou.forestProject.service.impl.ClassServiceImpl;
import com.zhou.forestProject.util.Verify;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChooseClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String classId = request.getParameter("classId");
        String tag = request.getParameter("tag");
        //验证
        if (Verify.verifyString(classId)) {
            //不为空，根据id查找班级信息
            IClassService service = new ClassServiceImpl();
            ClassDto classDto = service.findClassById(Integer.parseInt(classId));
            request.setAttribute("currentClass", classDto);

            //重定向到查看小班信息页面
            if ("1".equals(tag)) {
                request.getRequestDispatcher("jsp/showClass.jsp").forward(request, response);
                return;
            } else if ("2".equals(tag)) {
                request.getRequestDispatcher("jsp/updateClass.jsp").forward(request, response);
                return;
            }else {
                response.sendRedirect("showClass.lovo");
                return;
            }

        } else {
            response.sendRedirect("showClass.lovo");
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
