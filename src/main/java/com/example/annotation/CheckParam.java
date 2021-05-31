package com.example.annotation;

import java.lang.annotation.*;

/**
 * @Author: w00990
 * @Date: 2021/5/10
 */
@Target({ElementType.TYPE, ElementType.METHOD})  //作用的位置
@Retention(RetentionPolicy.RUNTIME) //作用域
@Documented
public @interface CheckParam {
}
