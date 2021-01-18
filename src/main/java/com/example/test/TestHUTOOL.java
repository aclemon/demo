package com.example.test;

import cn.hutool.core.lang.Console;

/**
 * @Author: w00990
 * @Date: 2021/1/17
 */

public class TestHUTOOL {

    public static void main(String[] args) {
//        testSub();
    }


    private static void testSub() {
        String a = "01";
        String b = "1";

        Console.log("=>" + a.substring(a.length() - 1));
        Console.log("=>" + b.substring(b.length() - 1));
    }


}
