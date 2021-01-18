package com.example.domain.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author: w00990
 * @Date: 2021/1/17
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AbstractCustomer {
    public String phone;
}
