package com.example.mq.consumer;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author icier
 * @Date 2021/5/9 19:55
 **/
@Component
@RocketMQMessageListener(consumerGroup = "spring-boot-group", topic = "TestTopic", consumeMode = ConsumeMode.CONCURRENTLY)
public class SimpleConsumer implements RocketMQListener<String> {
    /**
     * ConsumeMode 指定消费模式
     */


        @Override
        public void onMessage(String message) {
            System.out.println("Received message : " + message);
        }

}
