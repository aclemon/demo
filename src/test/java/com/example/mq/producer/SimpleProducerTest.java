package com.example.mq.producer;

import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author icier
 * @Date 2021/5/9 20:27
 **/
@SpringBootTest
class SimpleProducerTest {
    private final String topic = "TestTopic";

    @Resource
    private SimpleProducer producer;

    @Test
    public  void testSend(){
        String message = "asd爱的世界拉开圣诞节";
        producer.sendMessage(topic + ":testTag", message);
        Console.log("asef=>");
    }

}
