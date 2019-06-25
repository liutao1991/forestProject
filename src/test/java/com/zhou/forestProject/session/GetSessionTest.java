package com.zhou.forestProject.session;

import com.zhou.forestProject.bean.SysArea;
import com.zhou.forestProject.bean.SysClass;
import com.zhou.forestProject.db.GetSession;
//import com.zhou.forestProject.service.IClassService;
//import com.zhou.forestProject.service.impl.ClassServiceImpl;
import com.zhou.forestProject.service.IClassService;
import com.zhou.forestProject.service.impl.ClassServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Test;

public class GetSessionTest {
    @After
    public void  a(){

    }
    @Test
    public void getSession(){
        SqlSession session=GetSession.createSession();
        System.out.println(session);
    }
    @Test
    public void addClass(){
        IClassService service=new ClassServiceImpl();

        SysClass c=new SysClass();
        SysArea a=new SysArea();
        a.setAreaName("雅安一号地区");
        c.setArea(a);
        c.setClassLeader("河元庆");
        c.setClassName("雅林一班");
        c.setClassLeaderTel("13533568863");
        c.setClassNum(3);
        boolean bl=   service.addClass(c);
        System.out.println(bl);
    }
}
