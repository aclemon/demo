package com.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: w00990
 * @Date: 2021/4/20
 */
@MapperScan("com.example.dao")
@Configuration
public class MybatiPlusConfig {
}
