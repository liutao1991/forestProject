package com.zhou.forestProject.service.impl;

import com.zhou.forestProject.dao.IEventDao;
import com.zhou.forestProject.dao.IInfoDoctorDao;
import com.zhou.forestProject.db.GetSession;
import com.zhou.forestProject.dto.InfoDoctorDto;
import com.zhou.forestProject.service.IInfoDoctorService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class InfoDoctorServiceImpl implements IInfoDoctorService {
    @Override
    public List<InfoDoctorDto> findByResultId(long resultId) {
        SqlSession session= GetSession.createSession();
        List<InfoDoctorDto> list=session.getMapper(IInfoDoctorDao.class).findByResultId(resultId);
        session.close();
       if(null==list){
           return null;
       }else {
           return list;
       }

    }
}
