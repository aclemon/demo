package com.example.test;

import java.util.Random;

/**
 * @Author: w00990
 * @Date: 2020/12/21
 */
public class TestH {
    public static void main(String[] args) {
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
        
    }
}
