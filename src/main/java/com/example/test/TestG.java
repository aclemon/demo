package com.example.test;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Console;
import com.example.dto.Car;
import com.example.enums.ChannelPaymentEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: w00990
 * @Date: 2020/12/17
 */
@Slf4j
public class TestG {


    public static void main(String[] args) {
//        LinkedList<Customer> customers = new LinkedList<>();
//        Console.log("aaa=>" + customers.get(0).getBirthday());
//        Console.log("Coll=>" + CollUtil.isEmpty(customers));
//        customers.forEach(record -> {
//            Console.log("record=>" + record.getEmail());
//        });

        Console.log("asdf=>");
        Integer a = new Integer(300);
        Integer b = new Integer(300);
        Console.log(a.equals(b));
        List<String> s = new LinkedList<>();
        Collections.addAll(s, "1", "2", "3");
        log.warn("list:{}", s);
        Car stu1 = new Car("长沙", "4", ChannelPaymentEnum.ALI_PAY_H5, 4);
        Car stu2 = new Car("长沙", "4", ChannelPaymentEnum.ALI_PAY_H5, 5);
        Car stu3 = new Car("长沙", "4", ChannelPaymentEnum.ALI_PAY_H5, 6);
        List<Car> list = new ArrayList<>();
        list.add(null);
//        list.add(stu2);
//        list.add(stu3);
        //判断学生年龄是否都大于18
        Boolean flag = CollUtil.isNotEmpty(list) && list.stream().allMatch(stu -> stu.getNum() > 6);
        System.out.println(flag);
    }
}
