package com.zhou.forestProject.service.impl;

import com.zhou.forestProject.bean.SysClass;
import com.zhou.forestProject.dao.IClassDao;
import com.zhou.forestProject.db.GetSession;
import com.zhou.forestProject.dto.ClassDto;
import com.zhou.forestProject.service.IClassService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class ClassServiceImpl implements IClassService {
    @Override
    public boolean addClass(SysClass sysClass) {
        SqlSession session= GetSession.createSession();
        int n=session.getMapper(IClassDao.class).addClass(sysClass);
        session.commit();
        session.close();
        if(n>0){
            return true;
        }
        return false;
    }

    @Override
    public List<ClassDto> findClassBySome(Map map) {
        SqlSession session= GetSession.createSession();
        List<ClassDto> list=session.getMapper(IClassDao.class).findClassBySome(map);
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
        int n=session.getMapper(IClassDao.class).countRow(map);
        session.close();
        return n;
    }

    @Override
    public ClassDto findClassById(int classId) {
        SqlSession session= GetSession.createSession();
        ClassDto classDto=session.getMapper(IClassDao.class).findClassById(classId);
        session.close();
        if(null==classDto) {
            return null;
        }else {
            return classDto;
        }
    }

    @Override
    public boolean updateClass(String classLeader, String classLeaderTel, int classId) {
        SqlSession session= GetSession.createSession();
        int n=session.getMapper(IClassDao.class).updateClass(classLeader,classLeaderTel,classId);
        session.commit();
        session.close();
        if(n>0) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public SysClass findClassByAreaId(int areaId) {
        SqlSession session= GetSession.createSession();
        SysClass sysClass=session.getMapper(IClassDao.class).findClassByAreaId(areaId);
        session.close();
        if(null==sysClass) {
            return null;
        }else {
            return sysClass;
        }

    }
}
