package com.example.service.impl;

import cn.hutool.core.lang.Console;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.entity.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: w00990
 * @Date: 2021/1/28
 */
@SpringBootTest
class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void testWrapper() {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getId, 1);
        userLambdaQueryWrapper.eq(User::getUsername, null);
        List<User> list = userService.list(userLambdaQueryWrapper);
        Console.log("list=>" + list);
    }

}
