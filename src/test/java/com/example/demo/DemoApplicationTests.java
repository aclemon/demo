package com.example.demo;

import cn.hutool.core.lang.Console;
import com.example.dto.Car;
import com.example.dto.CarDto;
import com.example.enums.ChannelPaymentEnum;
import com.example.mapper.CarMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.text.ParseException;
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

    @Test
    public void shouldMapCarToDto() throws ParseException {
        //given
        Car car = new Car("Morris", "00.5464", ChannelPaymentEnum.ALI_PAY_APP);

        Number parse = new DecimalFormat("#.00").parse(car.getNumberOfSeats()).doubleValue();

        Console.log("DecimalFormat=>" + parse);

        //when
        CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);

        Console.log("carDto=>" + carDto);

    }

}

