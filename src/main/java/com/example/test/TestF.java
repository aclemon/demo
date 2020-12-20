package com.example.test;

import cn.hutool.core.lang.Console;
import com.example.dto.Car;

import java.util.Optional;

/**
 * @Author: w00990
 * @Date: 2020/12/9
 */
public class TestF {
    public static void main(String[] args) {
        Car build = Car.builder()
                .make("长沙长")
                .numberOfSeats("1")
                .build();
        Optional<Car> car1 = Optional.of(build);
        Console.log("car=>"+car1.get().getMake());

        Optional<String> username = Optional
                .ofNullable(build)
                .map(user -> user.getMake())
                .map(make -> make.toLowerCase());

        Optional<String> username1 = Optional
                .ofNullable(build)
                .flatMap(car -> Optional.of(car.getMake()))
                .flatMap(name -> Optional.of(name.toLowerCase()));

        Console.log("username=>"+username);
        Console.log("username1=>"+username1);


    }
}
