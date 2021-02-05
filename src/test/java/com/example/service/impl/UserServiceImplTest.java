package com.example.service.impl;

import cn.hutool.core.lang.Console;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

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
        userLambdaQueryWrapper.ge(User::getId, "1")
        ;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        Page<User> page = new Page<>(1, 3);
        IPage<User> page1 = userService.page(page, userLambdaQueryWrapper);
        Console.log("list=>" + page1.getRecords());
    }

}
