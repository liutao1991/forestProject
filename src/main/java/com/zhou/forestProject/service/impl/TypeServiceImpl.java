package com.zhou.forestProject.service.impl;

import com.zhou.forestProject.bean.SysType;
import com.zhou.forestProject.dao.ITypeDao;
import com.zhou.forestProject.db.GetSession;
import com.zhou.forestProject.service.ITypeService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TypeServiceImpl implements ITypeService {
    @Override
    public List<SysType> findListTypeByTypeName(String typeName) {
        SqlSession session= GetSession.createSession();
        List<SysType> list=session.getMapper(ITypeDao.class).findListTypeByTypeName(typeName);
        session.close();
        if(null==list){
            return null;
        }
        return list;
    }

    @Override
    public long findIdByVal(String typeVal) {
        SqlSession session= GetSession.createSession();
        long typeId=session.getMapper(ITypeDao.class).findIdByVal(typeVal);
        session.close();
        if(0==typeId){
            typeId=0;
        }
        return typeId;
    }
}
