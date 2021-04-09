package com.example.service.impl;

import cn.hutool.core.lang.Console;
import com.example.entity.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: w00990
 * @Date: 2021/3/23
 */
@SpringBootTest
public class MM {

    @Resource
    private UserService userService;

    @Test
    public void testRR() {
        List<User> userListBigData = userService.getUserListBigData("id,username", Arrays.asList(123L));
        Console.log(userListBigData);

    }
}
