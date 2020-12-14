package com.example.demo;

import cn.hutool.core.lang.Console;
import com.example.dto.Car;
import com.example.dto.CarDto;
import com.example.enums.ChannelPaymentEnum;
import com.example.mapper.CarMapper;
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
        if (a == 2) {
            System.out.println("UUID4=>" + UUID.randomUUID().toString().replaceAll("\\-", ""));
            System.out.println("123123");
        }
    }

    @Test
    public void shouldMapCarToDto() {
        //given
        Car car = new Car("Morris", 5, ChannelPaymentEnum.ALI_PAY_APP);

        //when
        CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);

        Console.log("carDto=>" + carDto);

        //then
//        assertThat(carDto).isNotNull();
//        assertThat(carDto.getMake()).isEqualTo("Morris");
//        assertThat(carDto.getSeatCount()).isEqualTo(5);
//        assertThat(carDto.getType()).isEqualTo("SEDAN");
    }

}

