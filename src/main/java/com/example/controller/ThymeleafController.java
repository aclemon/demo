package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: w00990
 * @Date: 2021/4/12
 */
@RequestMapping("thymeleaf")
@Controller
public class ThymeleafController {
    @GetMapping("helloWorld")
    public String helloWorld() {
        return "Hello";
    }
}
