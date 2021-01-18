package com.example.domain.dto;

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
public class AbstractCustomerDto {
    public String handPhone;
}
