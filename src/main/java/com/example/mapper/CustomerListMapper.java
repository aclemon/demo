package com.example.mapper;

import com.example.domain.dto.CustomerDto;
import com.example.domain.po.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @Author: w00990
 * @Date: 2020/12/14
 */
@Mapper(componentModel = "spring")
public interface CustomerListMapper {

    @Mappings({
            @Mapping(source = "name", target = "customerName"),
    })
    CustomerDto customersToCustomer(Customer customer);


    /**
     * @param customers
     * @return
     */
    List<CustomerDto> customersToCustomerDtos(List<Customer> customers);

}

