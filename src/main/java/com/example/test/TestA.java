package com.example.test;

import cn.hutool.core.lang.Console;
import com.alibaba.fastjson.JSON;
import com.example.dto.DtoResp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class TestA {
    public static final String TEST_A = "TEST_A";
    public static final String TEST_AB = "TEST_AB";
    public static final String TEST_MAIN = "TEST_MAIN";

    public static void main(String[] args) throws JsonProcessingException {
        String jsonObj2 = "{\n" +
                "            \"cancellation_date\":\"2020-06-29 14:53:14 Etc/GMT+4\"\n" +
                "            \n" +
                "        }";
//        DtoResp newPerson = JSON.parseObject(jsonObj2, DtoResp.class);
//        Console.log("fastjson 块iii=>"+newPerson.getCancellationDate().getZone());;

        ObjectMapper mapper = new ObjectMapper();
        JavaTimeModule timeModule = new JavaTimeModule();
//        timeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        timeModule.addSerializer(ZonedDateTime.class, new ZonedDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss VV")));
        mapper.registerModule(timeModule);
        DtoResp dtoResp = mapper.readValue(jsonObj2, DtoResp.class);
        Console.log("jackson=>"+dtoResp.getCancellationDate());
    }








}
