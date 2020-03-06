package com.shengfa.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>Title:MybatisUtils</p>
 * <p>Description:TODO</p>
 *
 * @author 郭亮
 * @date 2020/2/21 12:56
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static{
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream ( "sqlMapConfig.xml" );
        } catch (IOException e) {
            e.printStackTrace ();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder ().build ( resourceAsStream );
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

}
