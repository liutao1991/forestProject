package com.zhou.forestProject.servlet;

import com.zhou.forestProject.bean.SysArea;
import com.zhou.forestProject.bean.SysEvent;
import com.zhou.forestProject.bean.SysType;
import com.zhou.forestProject.service.IEventService;
import com.zhou.forestProject.service.impl.EventServiceImpl;
import com.zhou.forestProject.util.StringInfo;
import com.zhou.forestProject.util.UploadUtil;
import com.zhou.forestProject.util.Verify;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class AddEventAfterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IEventService eventService = new EventServiceImpl();
        //获得页面文件和文本
        UploadUtil uploadUtil = new UploadUtil();
        boolean bl = false;
        //事件对象
        SysEvent sysEvent = new SysEvent();
        try {
            Map<String, List<FileItem>> map = uploadUtil.getFileItem(request);
            //获得表单集合
            List<FileItem> listForm = map.get("listForm");
            //获得文件集合
            List<FileItem> listFile = map.get("listFile");
            //获得文件
            for (FileItem file : listFile) {
                String fileName = file.getName();//上传文件的名字
                bl = Verify.verifyFile(fileName, new String[]{"jpg", "doc"});//文件验证
                if (!bl) {
                    break;
                }
                //验证成功，产生新的文件名
                fileName = StringInfo.getNewFileName(fileName);
                //把文件名放入事件对象
                sysEvent.setEventImgPath(fileName);
                //写入文件
                InputStream in = file.getInputStream();
                OutputStream out = new FileOutputStream("D:/upload/" + fileName);
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = in.read(bytes)) > 0) {
                    out.write(bytes, 0, len);
                }
                out.close();
                in.close();
            }

            if (bl) {
                //获得表单数据
                for (FileItem f : listForm) {
                    String fileName = f.getFieldName();
                    String val = f.getString("UTF-8");
                    if (fileName.equals("eventName")) {
                        sysEvent.setEventName(val);
                    } else if (fileName.equals("eventDate")) {
                        sysEvent.setEventDate(val);
                    } else if (fileName.equals("eventType")) {
                        sysEvent.setEventType(Long.parseLong(val));
                    } else if (fileName.equals("enevtStage")) {
                        sysEvent.setEventStage(Long.parseLong(val));

                    } else if (fileName.equals("eventInfo")) {
                        sysEvent.setEventInfo(val);
                    } else if (fileName.equals("eventFindWay")) {
                        sysEvent.setEventFindWay(Long.parseLong(val));
                    } else if (fileName.equals("areaId")) {
                        SysArea sysArea = new SysArea();
                        val = val.substring(0, val.indexOf(","));
                        sysEvent.setAreaId(Long.parseLong(val));
                    } else if (fileName.equals("eventLoss")) {
                        sysEvent.setEventLoss(val);
                    } else if (fileName.equals("eventArea")) {
                        sysEvent.setEventArea(val);
                    } else if (fileName.equals("eventMethod")) {
                        sysEvent.setEventMethod(val);
                    }
                }
                if (bl) {
                    eventService.addEvent(sysEvent);
                    response.sendRedirect("showEvent.lovo");
                } else {
                    response.sendRedirect("addEventBefore.lovo");
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doPost(request, response);
    }
}
