package com.example.test;

import com.example.entity.User;
import com.example.service.impl.UserResultHandler;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

public class TestB {
    public static final String test = "TEST_B";
    public static final String TEST_AB = "TEST_AB";
    public static final String TEST_MAIN = "TEST_MAIN";

    public static void main(String[] args) throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        System.out.println("sqlSessionFactory:" + sqlSessionFactory);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 正常查询
        List<User> userList5 = sqlSession.selectList("selectUser");
        // 流式查询
        UserResultHandler userResultHandler = new UserResultHandler(100);
        sqlSession.select("selectUser", userResultHandler);
        userResultHandler.end();
        sqlSession.close();


    }
}
