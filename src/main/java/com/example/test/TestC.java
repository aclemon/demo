package com.example.test;

import cn.hutool.core.lang.Console;
import com.example.dto.ParamNull;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotEmpty;

/**
 * @author w00990
 */
@Slf4j
public class TestC {
    public static void main(String[] args) {

//        TestC testC = new TestC();
//        testC.paramTest(null, 7);
//        testC.paramTest("", 0);
        ParamNull build = ParamNull.builder()
                .id("id")
                .code("")
                .build();
//        testC.paramTest1(build);
        log.info("buid=>{}=={}", build.toString());

    }


    private String paramTest(@NotEmpty String str, Integer code) {
        Console.log("param=>" + str);
        Console.log("param=>" + code);
        return str;
    }

    private String paramTest1(ParamNull p) {
        Console.log("param=>" + p);
        return p.getId();
    }
}
