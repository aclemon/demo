package com.example.test;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ReflectUtil;
import com.example.domain.dto.CarDto;
import com.example.domain.dto.ScheduleSilentSignModel;
import com.example.dto.Car;
import com.example.dto.TestPojo;
import com.example.enums.ChannelPaymentEnum;
import com.example.util.PaymentJsonUtil;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.*;

/**
 * @Author: w00990
 * @Date: 2021/1/17
 */

@Slf4j
public class TestHUTOOL {

    /**
     * 没有交给spring管理的类无法通过@Resource 注入
     *
     * @Resource 位于javax 下
     */
    @Resource
    private static TestA testA;

    public static void main(String[] args) {
        Console.log("testA =>" + testA);

//        testInt();
//        testCompare();
//        testReflect();
        testPaymentUtil();
//        testStatic();
//        testBaseType();
//        timeTrans();
//        dateTimeTrans();
//        testSub();
//        testSlfj();
//        testThread();
    }

    private static void testInt() {

        int a = 129;
        Integer b = 129;
        boolean te = a == b;
        Console.log("ab=>" + te);
    }


    private static void testCompare() {
        Car car1 = new Car("make", "numberOfSeats", ChannelPaymentEnum.ALI_PAY_H5, 9);
        Car car2 = new Car("make", "numberOfSeats", ChannelPaymentEnum.ALI_PAY_H5, 10);
        LinkedList<Car> cars = new LinkedList<>();
        cars.add(car1);
        cars.add(car2);
        Console.log("list=>" + cars);
        cars.sort(Comparator.comparing(Car::getNum));
        Console.log("sort=>" + cars);


//        // 比较器
//        Comparator<Car> comparator = new Comparator<Car>() {
//            @Override
//            public int compare(Car o1, Car o2) {
//                return o2.getNum().compareTo(o1.getNum());
//            }
//        };
//
//        LinkedList<Car> cars1 = new LinkedList<>();
//        Console.log("ccc=>" + CollUtil.isNotEmpty(cars1));
//        Console.log("ccc=>" + cars1);
//
//        List<Car> sort = CollUtil.sort(cars, comparator);
//        Console.log("list=>" + cars);
//        Console.log("sort=>" + sort);

    }

    private static void testReflect() {
        CarDto carDto = new CarDto();
        carDto.setCode(123);
        try {
            Object[] fieldsValue = ReflectUtil.getFieldsValue(carDto);
            Field code = ReflectUtil.getField(CarDto.class, "code");
            Object fieldValue = ReflectUtil.getFieldValue(carDto, code);
            log.info("filedValue:{}", fieldValue);
            for (int i = 0; i < fieldsValue.length; i++) {
                Console.log("obj=>" + fieldsValue[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void testPaymentUtil() {
        String param = "{\n" +
                "\"channel_id\":\"BFBQUICK\",\n" +
                "\"merchant_id\":\"axqy\",\n" +
                "\"channel_merchant_id\":\"1000132454\",\n" +
                "\"end_date\":\"2021-01-25 06:00:00\"\n" +
//                "\"time\":\"2021-01-25 06:00:00\",\n" +
//                "\"exe_size\":\"3\"\n" +
                "}";
        ScheduleSilentSignModel scheduleSilentSignModel = PaymentJsonUtil.str2Obj(param, ScheduleSilentSignModel.class);
        boolean aa = null != scheduleSilentSignModel.getExeSize() && scheduleSilentSignModel.getExeSize() > 0;
        Console.log("scheduleSilentSignModel=>" + scheduleSilentSignModel);
        Console.log("scheduleSilentSignModel=>" + aa);

    }

    private static void testStatic() {
        Car car1 = new Car();
        Car car2 = new Car();
        car1.setCarFlag();
        Console.log("car2=>" + car2.getCarFlag());
        Console.log("car1=>" + car1.getCarFlag());
    }

    private static void timeTrans() {
        String dateStr = "06:03:01";
        Date date = DateUtil.parse(dateStr, "HH:mm:ss");
        Console.log("date=>" + date);
    }

    /**
     * 包装类型为null
     * 基本类型
     * int 为0
     * boolean 为false
     */
    private static void testBaseType() {
        TestPojo testPojo = new TestPojo();
        Car car = new Car();
        Console.log("car=>" + car);
        Console.log("testPojo=>" + testPojo);
    }

    private static void dateTimeTrans() {
        String tt = "210117";
        StringBuilder sb = new StringBuilder("20");
        sb.append(tt);
        Console.log("sb=>" + sb);
        DateTime yyyyMMdd = DateUtil.parse(sb, "yyyyMMdd");
        Console.log("yyyyMMdd=>" + yyyyMMdd);

    }

    private static void testThread() {
        ExecutorService threadPool = new ThreadPoolExecutor(2, 3,
                1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.format("假如%d", 5);
            }
        });

        threadPool.shutdown();

    }

    private static void testSlfj() {
        try {
            int a = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("catch:{}", "asd", e);
        }
        log.info("asdf:{}", "dfs");
    }


    private static void testSub() {
        String a = "01";
        String b = "1";
        String date = "C632101170005670001";
        Console.log("date.substring(3,9);=>" + date.substring(3, 9));


        Console.log("=>" + a.substring(a.length() - 1));
        Console.log("=>" + b.substring(b.length() - 1));
    }


}