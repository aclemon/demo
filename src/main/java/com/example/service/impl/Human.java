package com.example.service.impl;

import cn.hutool.core.lang.Console;
import com.example.service.Mammals;

/**
 * @Author: w00990
 * @Date: 2020/12/22
 */
public class Human implements Mammals {
    /**
     * useTool
     */
    @Override
    public void useTool() {
        Console.log("useTool=>");
    }

    /**
     * 测试
     */
    @Override
    public void speak() {
        Console.log("speak=>");

    }
}
