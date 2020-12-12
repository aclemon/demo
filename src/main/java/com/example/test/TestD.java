package com.example.test;

import cn.hutool.core.lang.Console;

import javax.xml.crypto.Data;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestD {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime =ZonedDateTime.parse("2020-06-29 14:53:14 Etc/GMT+7", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss VV"));


        ZoneId beiJingZoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime zonedDateTime1 = zonedDateTime.withZoneSameInstant(beiJingZoneId);
        Console.log("zz=>"+zonedDateTime);
        Console.log("zz1=>"+zonedDateTime1);
        Date date = Date.from(zonedDateTime.toInstant());
        Date date1 = Date.from(zonedDateTime1.toInstant());
        Console.log("date=>"+date);
        Console.log("date1=>"+date1);
    }
}
