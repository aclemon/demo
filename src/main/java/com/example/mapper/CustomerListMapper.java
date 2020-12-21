package com.example.mapper;

import com.example.domain.dto.CustomerDto;
import com.example.domain.po.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

/**
 * @Author: w00990
 * @Date: 2020/12/14
 */
@Mapper(componentModel = "spring")
public interface CustomerListMapper {

    @Mappings({
            @Mapping(source = "name", target = "customerName", qualifiedByName = "addStrMapping"),
    })
    CustomerDto customersToCustomer(Customer customer);


    @Named("addStrMapping")
    default String addStr(String name) {
        return name + "123";
    }

    /**
     * @param customers
     * @return
     */
    Set<CustomerDto> customersToCustomerDtos(List<Customer> customers);

}

