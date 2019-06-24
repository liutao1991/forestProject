package com.zhou.forestProject.service.impl;

import com.zhou.forestProject.bean.SysArea;
import com.zhou.forestProject.dao.IAreaDao;
import com.zhou.forestProject.db.GetSession;
import com.zhou.forestProject.service.IAreaService;
import org.apache.ibatis.session.SqlSession;

public class AreaServiceImpl implements IAreaService
{
    @Override
    public boolean addArea(SysArea sysArea) {
        SqlSession session=GetSession.createSession();
        int n=session.getMapper(IAreaDao.class).addArea(sysArea);
        session.commit();
        if(n>0){
            return true;
        }
        return false;
    }
}
