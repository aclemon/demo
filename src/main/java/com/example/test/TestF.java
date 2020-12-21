package com.example.test;

import cn.hutool.core.lang.Console;
import com.example.enums.ChannelPaymentEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: w00990
 * @Date: 2020/12/9
 */
public class TestF {
    public static void main(String[] args) {
        List<ChannelPaymentEnum> channelPaymentEnums = ChannelPaymentEnum.parseOf(7);
        Console.log("channelPaymentEnums=>" + channelPaymentEnums);
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < channelPaymentEnums.size(); i++) {
            integers.add(channelPaymentEnums.get(i).bit);
        }
        List<Integer> collect = integers.stream().collect(Collectors.toList());
        int[] a = {1, 2, 3};
//        Arrays.stream(a).map(record -> record * 5).collect(Collectors.toMap(a, a));
    }
}
