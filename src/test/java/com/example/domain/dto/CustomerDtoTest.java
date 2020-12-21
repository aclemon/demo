package com.example.domain.dto;

import cn.hutool.core.lang.Console;
import com.example.domain.po.Customer;
import com.example.mapper.CustomerListMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

/**
 * @Author: w00990
 * @Date: 2020/12/14
 */
@SpringBootTest
class CustomerDtoTest {
    @Resource
    CustomerListMapper customerListMapper;

    /**
     * 验卡mock测试
     */
    @Value("${AppleIap.mock.flag:true}")
    private boolean mock;

    @Test
    public void customersToCustomerDtosTest() {
        Customer customer1 = new Customer(1L, "herion1", true, null, new Date(), 1);
        Customer customer2 = new Customer(2L, "herion2", true, null, new Date(), 2);
        Customer customer3 = new Customer(3L, "herion3", true, null, new Date(), 3);
        Customer customer4 = new Customer(3L, "herion3", true, null, new Date(), 4);
        customer1.toString();
        List<Customer> list = new ArrayList<>();
        list.add(customer1);
        list.add(customer1);
        list.add(customer2);
        list.add(customer3);
        list.add(customer4);
        Set<CustomerDto> customerDtos = customerListMapper.customersToCustomerDtos(list);
        customerDtos.forEach(customer -> {
            System.out.println(customer.toString());
        });
    }

    @Test
    public void testFormat() throws ParseException {
        String numberCE = "1,234567"; // 1.234567
        String formatUK = "###,##0.000";

        // do the format
        DecimalFormat formatterUK = new DecimalFormat(formatUK);
        Double valCEWithUKFormat = formatterUK.parse(numberCE).doubleValue();

        String output = formatterUK.format(valCEWithUKFormat.doubleValue());
        // I want the number to DPs in the format string!!!
        System.out.println("CE Value     " + numberCE + " in UK format (" + formatUK + ") is "
                + valCEWithUKFormat);
        Console.log("output=>" + output);
    }

    @Test
    public void test3() throws ParseException {
        String text = "1,234567";
        NumberFormat nf_in = NumberFormat.getNumberInstance(Locale.GERMANY);
        double val = nf_in.parse(text).doubleValue();

        NumberFormat nf_out = NumberFormat.getNumberInstance(Locale.UK);
        nf_out.setMaximumFractionDigits(3);


        Console.log("double=>" + val);
        Console.log("nf_out=>" + nf_out);
    }

    @Test
    public void test4() {
        Console.log("mock=>" + mock);
        if (mock) {
            Console.log("1232=>" + 13);
        }
    }


}
