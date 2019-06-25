package com.zhou.forestProject.service.impl;

import com.zhou.forestProject.bean.SysArea;
import com.zhou.forestProject.dao.IAreaDao;
import com.zhou.forestProject.db.GetSession;
import com.zhou.forestProject.dto.AreaDto;
import com.zhou.forestProject.service.IAreaService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class AreaServiceImpl implements IAreaService
{
    @Override
    public boolean addArea(SysArea sysArea) {
        SqlSession session=GetSession.createSession();
        int n=session.getMapper(IAreaDao.class).addArea(sysArea);
        session.commit();
        session.close();
        if(n>0){
            return true;
        }
        return false;
    }

    @Override
    public List<AreaDto> findAreaBySome(Map<String, Object> map) {
        SqlSession session=GetSession.createSession();
        List<AreaDto> list=session.getMapper(IAreaDao.class).findAreaBySome(map);
        session.close();
        if(null==list){
            return null;
        }
       return list;
    }
}
