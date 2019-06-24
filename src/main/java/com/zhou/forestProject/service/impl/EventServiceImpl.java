package com.zhou.forestProject.service.impl;

import com.zhou.forestProject.bean.SysEvent;
import com.zhou.forestProject.dao.IEventDao;
import com.zhou.forestProject.db.GetSession;
import com.zhou.forestProject.service.IEventService;
import org.apache.ibatis.session.SqlSession;

public class EventServiceImpl implements IEventService {
    @Override
    public boolean addEvent(SysEvent sysEvent) {
        SqlSession session= GetSession.createSession();
        int n=session.getMapper(IEventDao.class).addEvent(sysEvent);
        session.commit();
        if(n>0){
            return true;
        }
        return false;
    }
}
