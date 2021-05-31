package com.example.test;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.Console;
import com.example.annotation.CheckParam;
import com.example.dto.Demo;

/**
 * @Author: w00990
 * @Date: 2021/5/10
 */
public class TestHUTOOLA {
    public static void main(String[] args) {
//        Demo demo = new Demo();
//        demo.setAge(1);
//        demo.setName("sdf");
//        demo.setSex("xy");
//        testNoNullCheck1(demo);
        testDateTime();
    }

    private static void testDateTime() {
        DateTime dateTime = new DateTime("2017-01-05 12:34:23", DatePattern.NORM_DATETIME_FORMAT);

//默认情况下DateTime为可变对象，此时offset == dateTime
//        DateTime offset = dateTime.offset(DateField.YEAR, 0);
//        DateTime offset1 = dateTime.offset(DateField.YEAR, -1);
        Console.log(dateTime.offset(DateField.YEAR, 0), dateTime.offset(DateField.YEAR, -1));


    }


    @CheckParam
    public static void testNoNullCheck1(Demo demo) {
        Console.log("demo=>" + demo);
    }
}
