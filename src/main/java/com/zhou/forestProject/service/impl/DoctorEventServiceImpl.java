package com.zhou.forestProject.service.impl;

import com.zhou.forestProject.dao.IDoctorEventDao;
import com.zhou.forestProject.dao.IEventDao;
import com.zhou.forestProject.db.GetSession;
import com.zhou.forestProject.service.IDoctorEventService;
import org.apache.ibatis.session.SqlSession;

public class DoctorEventServiceImpl implements IDoctorEventService {
    @Override
    public boolean addDoctorEvent(long eventId) {
        SqlSession session=GetSession.createSession();
        //添加专家事件表中数据
        int n=session.getMapper(IDoctorEventDao.class).addDoctorEvent(eventId);
        //修改事件灾情阶段
        int m=session.getMapper(IEventDao.class).updateEventStage(7,eventId);
        if(n>0&&m>0){
            session.commit();
            session.close();
            return true;
        }else {
            session.close();
            return false;
        }


    }
}
