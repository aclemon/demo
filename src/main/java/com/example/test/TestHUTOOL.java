package com.example.test;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.domain.dto.CarDto;
import com.example.domain.dto.ScheduleSilentSignModel;
import com.example.dto.Car;
import com.example.dto.Person;
import com.example.dto.TestPojo;
import com.example.enums.ChannelPaymentEnum;
import com.example.util.PaymentJsonUtil;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.*;
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

    private static final String NO_CONTRACT = "38602";
    public static final String AA = "asd";


    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("testSS");
        testSS(strings);


//        testStr2();
//        testSub();
//        testInt();
//        testStrUtil();
//        testFileUtil();
//        testLog();
//        testExceptionUtil();
//        testStrUtil();
//        testRunTime();
//        testHour();
//        testAwaitTermination();
//        testThread();
//        testStr();
//        testDateTime();
//        testInt();
//        testCompare();
//        testReflect();
//        testPaymentUtil();
//        testStatic();
//        testBaseType();
//        timeTrans();
//        dateTimeTrans();
//        testSub();
//        testSlfj();
//        testThread();
    }

    private static void testSS(ArrayList test) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("ssss");
        test = strings;
        Console.log("test=>" + test);
        List<String> list = new ArrayList<String>();
        list.add("保护环境");  //向列表中添加数据
        list.add("爱护地球");  //向列表中添加数据
        list.add("从我做起");  //向列表中添加数据
        List<String> list1 = new ArrayList<String>();
        list1.add("保护环境");  //向列表中添加数据
        list1.add("爱护地球");  //向列表中添加数据
        boolean ret = list.removeAll(list1);  //从list中移除与list1相同的元素
        Iterator<String> it = list.iterator();  //创建迭代器
        while (it.hasNext()) {  //循环遍历迭代器
            System.out.println(it.next());  //输出集合中元素
        }
    }

    private static void testStr2() {
        boolean flag = false;
        Console.log("=>" + flag);
        String aa = "123456";
        String s = StrUtil.replace(aa, 1, 2, 's');
        Console.log("s=>" + s);

        String substring = aa.substring(5);
        Console.log("substring=>" + substring);
        flag = aa.indexOf('#') == -1;
        Console.log("=>" + flag);

        int bb = 989;
        Console.log("=>" + bb % 16);
        int i = bb & 15;
        Console.log("=>" + i);
    }

    private static void testFileUtil() {

        Car car = new Car();
        System.out.println(car);
//        List<String> strings = FileUtil.readUtf8Lines("test_mu.lua");
//        String a = "a.txt";
//        String fileRoute = "/data/";
//        String fullPath = fileRoute + a;
//
//        File touch = FileUtil.touch(fullPath);
//
//        List<String> strings = Arrays.asList("aaa", "qwer");
//
//        FileUtil.appendUtf8Lines(strings, touch);

    }

    private static void testLog() {
        log.info("chajasldjf");
    }

    private static void testExceptionUtil() {


        try {

            for (int i = 0; i < 10; i++) {
                throw new ValidateException("验证异常asdasd");
            }
        } catch (ValidateException e) {
            e.printStackTrace();
            String message = ExceptionUtil.getMessage(e);
            log.info(message);
            log.error("异常信息:", e);

        }
    }

    private static void testStrUtil() {


        String a = "王惠东|6212260509003753183||13934037682|201811271816291836408934347";
        System.out.print(a);
        System.out.print('\n');
        System.out.print(a);

//        String[] split = StrUtil.split(a, "|");
//        for (int i = 0; i < split.length; i++) {
//            String s = split[i];
//            log.info(s);
//        }

    }

    private static void testRunTime() {
        int i = Runtime.getRuntime().availableProcessors();
        log.info("sdf:{}", i);
    }

    private static void testHour() {
        int currentHour = new DateTime().toCalendar().get(Calendar.HOUR_OF_DAY);
        Console.log("=>" + currentHour);
    }

    private static void testStr() {
        String[] strings = {"ORDERNOTEXIST"};
        String SEPARATOR = "-";
        Console.log("aaa=>" + ArrayUtil.join(strings, SEPARATOR));
        String a = "";
        String b = "38602";
        String c = "38603";

        boolean a1 = StrUtil.isNotBlank(a) && !NO_CONTRACT.equals(a);
        boolean b1 = StrUtil.isNotBlank(b) && !NO_CONTRACT.equals(b);
        boolean c1 = StrUtil.isNotBlank(c) && !NO_CONTRACT.equals(c);
        Console.log("=>" + a1);
        Console.log("=>" + b1);
        Console.log("=>" + c1);
    }

    private static void testDateTime() {
        String chaxun = "2017-05-01 22:33:23";
        Date date1 = DateUtil.parse(chaxun);
        LocalDateTime localDateTime = DateUtil.toLocalDateTime(date1);

        String dateStr2 = "2017-04-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr2);
        LocalDateTime localDateTime1 = DateUtil.toLocalDateTime(date2);
        Console.log("=>" + localDateTime.isAfter(localDateTime1));

//相差一个月，31天
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
    }

    private static void testInt() {

        int a = 129;
        Integer b = 129;
        boolean te = a == b;
        Console.log("ab=>" + te);

        int i = 1;
//        string strValue = i.ToString("0000000#");

//        String format = StrUtil.format("{0:00000000}", i);

        String last = StrUtil.subSufByLength("0000" + (i + 1), 4);
        log.info(last);
    }


    private static void testCompare() {
        Car car1 = new Car("make", "numberOfSeats", ChannelPaymentEnum.ALI_PAY_H5, 9);
        Car car2 = new Car("make", "numberOfSeats", ChannelPaymentEnum.ALI_PAY_H5, 10);
        LinkedList<Car> cars = new LinkedList<>();
        cars.add(car1);
        cars.add(car2);
        int i = 1;
        try {
            i++;
        } catch (Exception e) {
            log.error("异常信息", e);
        } finally {
            i = 5;
        }
        log.info("整数I:{}", i);
        for (Car car : cars) {
            Console.log("=>" + car);
        }

//        Console.log("list=>" + cars);
//        cars.sort(Comparator.comparing(Car::getNum));
//        Console.log("sort=>" + cars);

        Console.log("list=>" + cars);
        // 比较器
        Comparator<Car> comparator = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getNum().compareTo(o1.getNum());
            }
        };


//        LinkedList<Car> cars1 = new LinkedList<>();
//        Console.log("ccc=>" + CollUtil.isNotEmpty(cars1));
//        Console.log("ccc=>" + cars1);

        List<Car> sort = CollUtil.sort(cars, comparator);

        Console.log("sort=>" + sort);

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

        String param2 = "{\n" +
                "\"merchant_id\":\"SMYS\",\n" +
                "\"channel_id\":\"BFBQUICK\",\n" +
                "\"channel_merchant_id\":\"1002933811\",\n" +
                "\"start_date\":\"2021-01-26 22:00:00\",\n" +
                "\"end_date\":\"2021-01-26 22:00:00\",\n" +
                "\"exe_size\":10,\n" +
                "\"exe_page\":3\n" +
                "}";
        ScheduleSilentSignModel scheduleSilentSignModel = PaymentJsonUtil.str2Obj(param2, ScheduleSilentSignModel.class);
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

    public static void testAwaitTermination() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            String str = i + "";
            service.execute(() -> {
                System.out.println(str);
            });
        }
        // shutdown() 和 awaitTermination() 组合使用
        service.shutdown();
//        service.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("线程池已关闭");
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
//        String a = "01";
//        String b = "1";
//        String date = "C632101170005670001";
//        Console.log("date.substring(3,9);=>" + date.substring(3, 9));
//
//
//        Console.log("=>" + a.substring(a.length() - 1));
//        Console.log("=>" + b.substring(b.length() - 1));

//        String cc = "000010_20180606_0001.txt";
//        String sub = StrUtil.sub(cc, 7, 20).replace("_", "");
//        long l = Long.parseLong(sub);
//        log.info(sub);
//        System.out.println(l);

//        String t1 = "001773_20211206";
//        String t2 = "001773_20201206";
//        int result = t1.compareTo(t2);
//
//        String[] aa = "aaa|bbb|ccc".split("\\|");
//
//
//        System.out.println(result);
//        Console.log(aa);
//        Assert.assertEquals(1, result);

//        2147483648
        try {
            DateTime yyyyMMddHHmmss = DateUtil.parse("20210413060000", "yyyyMMddHHmmss");
            Person person = new Person();
//            person.setBirthday(yyyyMMddHHmmss);
            person.setBirthday(null);
            Console.log("Person:{}", person);
            String resp = "C20210308172948X82100040619";
            log.info("ahs:{}", resp.hashCode());
            HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
            String oldCertId = StrUtil.sub(resp, 17, 27);
            int i = Integer.parseInt(oldCertId);
            log.info(oldCertId);
            Console.log(i);
        } finally {
            log.info("热部署");
        }


    }
}
