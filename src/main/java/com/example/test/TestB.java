package com.example.test;

import cn.hutool.core.lang.Console;
import com.example.enums.ChannelPaymentEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class TestB {
    public static final String TEST_B = "TEST_B";
    public static final String TEST_AB = "TEST_AB";
    public static final String TEST_MAIN = "TEST_MAIN";

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("aaa1");
        list.add("bbb1");
        list.add("ccc1");
        list.add("aaa2");
        String message = list.stream()
                .filter(record -> record.startsWith("aaa"))
                .map(record ->{
                    return "<"+record+">";
                })
                .collect(Collectors.joining(","));//返回一个String以,分隔
        //.collect(Collectors.toList());//返回一个List<String>
        System.out.println(message);

        Console.log("Cc=>"+ ChannelPaymentEnum.ALI_PAY_APP.name);
        Console.log("Cc=>"+ChannelPaymentEnum.ALI_PAY_APP.bit);
        Console.log("Cc=>"+ChannelPaymentEnum.ALI_PAY_APP.desc);


        Console.log("Cc=>"+ Objects.requireNonNull(ChannelPaymentEnum.valueOf(3)).getName());

    }
}
