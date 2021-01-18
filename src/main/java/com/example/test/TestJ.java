package com.example.test;

import cn.hutool.core.lang.Console;
import com.example.domain.po.Customer;
import com.example.domain.po.CustomerWithMoney;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: w00990
 * @Date: 2020/12/22
 */
@Slf4j
public class TestJ {
    public static void main(String[] args) {


        log.info("asdf");

//        String string = FileUtil.readUtf8String("/data/app/smy-pcs/jetty/profile/alipayH5/dfkChannelmerchant/dfk_privateKey.txt");
//        Console.log("string=>" + string);
        Customer customer = new Customer();
        Customer customer1 = new Customer();
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(customer.getId());
        customer1.setId(customer.getId());
        Console.log("=>" + customer1);
//        Customer show = show();
//        Console.log("show=>" + show);
//
//        Human human = new Human();
//        human.useTool();
    }

    private static Customer show() {
        CustomerWithMoney customerWithMoney = new CustomerWithMoney(1L, "张三", 300);
        Console.log("customer=>" + customerWithMoney);
        CustomerWithMoney customerWithMoney1 = new CustomerWithMoney();
        customerWithMoney1.setName("张大帅");
        Console.log("张三=>" + customerWithMoney1.getName());

        return customerWithMoney;
    }
}
