package com.zhou.forestProject.service.impl;

import com.zhou.forestProject.bean.SysEvent;
import com.zhou.forestProject.dao.IEventDao;
import com.zhou.forestProject.db.GetSession;
import com.zhou.forestProject.dto.EventDto;
import com.zhou.forestProject.service.IEventService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class EventServiceImpl implements IEventService {
    @Override
    public boolean addEvent(SysEvent sysEvent) {
        SqlSession session= GetSession.createSession();
        int n=session.getMapper(IEventDao.class).addEvent(sysEvent);
        session.commit();
        session.close();
        if(n>0){
            return true;
        }
        return false;
    }

    @Override
    public List<EventDto> findEventBySome(Map map) {
        SqlSession session= GetSession.createSession();
        List<EventDto> list=session.getMapper(IEventDao.class).findEventBySome(map);
        session.close();
        if(null==list){
            return null;
        }else {
            return list;
        }

    }

    @Override
    public int countRow(Map map) {
        SqlSession session= GetSession.createSession();
        int n=session.getMapper(IEventDao.class).countRow(map);
        session.close();
        return n;
    }

    @Override
    public EventDto findById(int eventId) {
        SqlSession session= GetSession.createSession();
        EventDto eventDto=session.getMapper(IEventDao.class).findById(eventId);
        session.close();
        if(null==eventDto) {
            return null;
        }else {
            return  eventDto;
        }
    }

    @Override
    public boolean updateEvent(long eventStage, String eventMethod, long eventId) {
        SqlSession session= GetSession.createSession();
        int n=session.getMapper(IEventDao.class).updateEvent(eventStage,eventMethod,eventId);
        session.commit();
        session.close();
        if(n>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public long findEventStageByEventId(long eventId) {
        SqlSession session= GetSession.createSession();
        long n=session.getMapper(IEventDao.class).findEventStageByEventId(eventId);
        session.close();
        return n;
    }
}
