package com.zhou.forestProject.service;

import com.zhou.forestProject.bean.SysType;
import com.zhou.forestProject.service.impl.TypeServiceImpl;
import org.junit.Test;

import java.util.List;

public class TypeServiceTest {
    @Test
    public void findTypeList(){
      ITypeService service=new TypeServiceImpl();
     List<SysType> list= service.findListTypeByTypeName("DL");
        System.out.println(list.size());
    }
    @Test
    public void findIdByName(){
        ITypeService service=new TypeServiceImpl();
        long typeId=service.findIdByVal("虫害");
        System.out.println(typeId);
    }
}
