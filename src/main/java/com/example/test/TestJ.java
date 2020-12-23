package com.example.test;

import cn.hutool.core.lang.Console;
import com.example.domain.po.Customer;
import com.example.domain.po.CustomerWithMoney;
import com.example.service.impl.Human;

/**
 * @Author: w00990
 * @Date: 2020/12/22
 */
public class TestJ {
    public static void main(String[] args) {
        Customer show = show();
        Console.log("show=>" + show);

        Human human = new Human();
        human.useTool();
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
