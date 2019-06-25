package com.zhou.forestProject.service;

import com.zhou.forestProject.bean.SysArea;
import com.zhou.forestProject.bean.SysType;
import com.zhou.forestProject.dto.AreaDto;
import com.zhou.forestProject.service.impl.AreaServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AreaServiceTeat {
    @Test
    public void addArea(){
        IAreaService service=new AreaServiceImpl();
        SysArea sysArea=new SysArea();
        sysArea.setAreaName("雅林一号地区");
        sysArea.setAreaTreeType("柏杨林");
        sysArea.setAreaGoodTree("柏林");
        SysType sysType=new SysType();
        sysType.setTypeId(1);
        sysArea.setSysType(sysType);
        boolean b=service.addArea(sysArea);
        System.out.println(b);
    }
    @Test
    public void find(){
        IAreaService service=new AreaServiceImpl();
        Map<String,Object> map=new HashMap<>();
      List<AreaDto> list= service.findAreaBySome(map);
        System.out.println(list.size());
    }
}
