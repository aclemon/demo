package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.entity.User;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Author icier
 * @Date 2021/3/22 20:36
 **/
@Slf4j
@SpringBootTest
public class MybatisTest {

    @Resource
    UserService userService;

    @Test
    public void testOne() {
        List<User> userListBigData = userService.getUserListBigData("id,username", Collections.singletonList(123L));
        log.info("查找的数据:{}", userListBigData);
    }

    @Test
    public void testSaveOrUpdateByCondition() throws InstantiationException, IllegalAccessException {

        User asdf = User.builder()
                .id("1")
                .username("asdfF")
                .password("asdasdasd")
                .testTime(new Date())
                .build();
        LambdaQueryWrapper<User> userQueryWrapper = new LambdaQueryWrapper<>();
        userQueryWrapper.eq(User::getUsername, "ssss");
        userQueryWrapper.eq(User::getRole, "kkk");

//        userService.saveOrUpdateByCondition(asdf, userQueryWrapper);
        userService.saveOrUpdateByAnnotation(asdf);
    }
}
