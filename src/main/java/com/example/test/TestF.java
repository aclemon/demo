package com.example.test;

import cn.hutool.core.lang.Console;
import com.example.dto.Car;
import com.example.enums.ChannelPaymentEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author: w00990
 * @Date: 2020/12/9
 */
public class TestF {
    public static void main(String[] args) {
        Console.log("王麻子=>");
        Console.log("王麻子=>");
        List<ChannelPaymentEnum> channelPaymentEnums = ChannelPaymentEnum.parseOf(7);
        Console.log("channelPaymentEnums=>" + channelPaymentEnums);
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < channelPaymentEnums.size(); i++) {
            integers.add(channelPaymentEnums.get(i).bit);
        }
        List<Integer> collect = integers.stream().collect(Collectors.toList());
        int[] a = {1, 2, 3};
//        Arrays.stream(a).map(record -> record * 5).collect(Collectors.toMap(a, a));
        Car build = Car.builder()
                .make("长沙长")
                .numberOfSeats("1")
                .build();
        Optional<Car> car1 = Optional.of(build);
        Console.log("car=>" + car1.get().getMake());
        Optional<String> username = Optional
                .of(build)
                .map(Car::getMake)
                .map(String::toLowerCase);
        Console.log("username=>" + username);


    }
}
