package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;


@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test01() {
        System.out.println("UUID0=>" + UUID.randomUUID().toString().replaceAll("\\-", ""));
        System.out.println("UUID1=>" + UUID.randomUUID().toString().replaceAll("\\-", ""));
        System.out.println("UUID2=>" + UUID.randomUUID().toString().replaceAll("\\-", ""));
        System.out.println("UUID3=>" + UUID.randomUUID().toString().replaceAll("\\-", ""));
        int a = 2;
        System.out.println("UUID4=>" + UUID.randomUUID().toString().replaceAll("\\-", ""));
        System.out.println("123123");
    }


}

