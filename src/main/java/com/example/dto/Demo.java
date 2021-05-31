package com.example.dto;

import com.example.annotation.NotNull;
import lombok.Data;

/**
 * @Author: w00990
 * @Date: 2021/5/10
 */
@Data
public class Demo {
    @NotNull("名字不能为空!")
    private String name;
    private String sex;
    private Integer age;
}
