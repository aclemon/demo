package com.example.annotation;

import java.lang.annotation.*;

/**
 * @Author: w00990
 * @Date: 2021/5/10
 */
@Target({ElementType.FIELD})  //作用的位置
@Retention(RetentionPolicy.RUNTIME) //作用域
@Documented
public @interface NotNull {
    String value() default "{报错信息}";
}
