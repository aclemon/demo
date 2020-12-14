package com.example.domain.dto;

import com.example.domain.po.Customer;
import com.example.mapper.CustomerListMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: w00990
 * @Date: 2020/12/14
 */
@SpringBootTest
class CustomerDtoTest {
    @Resource
    CustomerListMapper customerListMapper;

    @Test
    public void customersToCustomerDtosTest() {
        Customer customer1 = new Customer(1L, "herion1", true, null, new Date());
        Customer customer2 = new Customer(2L, "herion2", true, null, new Date());
        Customer customer3 = new Customer(3L, "herion3", true, null, new Date());
        List<Customer> list = new ArrayList<>();
        list.add(customer1);
        list.add(customer2);
        list.add(customer3);
        List<CustomerDto> customerDtos = customerListMapper.customersToCustomerDtos(list);
        customerDtos.forEach(customer -> {
            System.out.println(customer.toString());
        });
    }


}
