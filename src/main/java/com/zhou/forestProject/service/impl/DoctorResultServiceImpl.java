package com.zhou.forestProject.service.impl;

import com.zhou.forestProject.dao.IDcotorResultDao;
import com.zhou.forestProject.db.GetSession;
import com.zhou.forestProject.dto.DoctorResultDto;
import com.zhou.forestProject.service.IDoctorResultService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DoctorResultServiceImpl implements IDoctorResultService {
    @Override
    public DoctorResultDto findByResultId(long resultId) {
        SqlSession session=GetSession.createSession();
        DoctorResultDto doctorResultDto=session.getMapper(IDcotorResultDao.class).findByResultId(resultId);
        session.close();
       if(null==doctorResultDto) {
           return null;
       }else {
           return  doctorResultDto;
       }
    }

    @Override
    public List<DoctorResultDto> findByEventId(long eventId) {
        SqlSession session=GetSession.createSession();
        List<DoctorResultDto> doctorResultDtoList=session.getMapper(IDcotorResultDao.class).findByEventId(eventId);
        session.close();
        if(null==doctorResultDtoList) {
            return null;
        }else {
            return  doctorResultDtoList;
        }
    }
}
