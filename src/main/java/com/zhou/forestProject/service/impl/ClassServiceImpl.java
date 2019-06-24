package com.zhou.forestProject.service.impl;

import com.zhou.forestProject.bean.SysClass;
import com.zhou.forestProject.dao.IClassDao;
import com.zhou.forestProject.db.GetSession;
import com.zhou.forestProject.service.IClassService;
import org.apache.ibatis.session.SqlSession;

public class ClassServiceImpl implements IClassService {
    @Override
    public boolean addClass(SysClass sysClass) {
        SqlSession session= GetSession.createSession();
        int n=session.getMapper(IClassDao.class).addClass(sysClass);
        session.commit();
        if(n>0){
            return true;
        }
        return false;
    }
}
