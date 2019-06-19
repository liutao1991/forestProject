package com.zhou.forestProject.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetSession {
    private static SqlSessionFactory sqlSessionFactory ;
    private static InputStream in;
    static {
        try {
            in = Resources.getResourceAsStream("mybaitsConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static SqlSession createSession(){
        return sqlSessionFactory.openSession();
    }

}
