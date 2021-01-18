package com.example.domain.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @Author: w00990
 * @Date: 2020/12/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@SuperBuilder
public class CustomerDto extends AbstractCustomerDto {
    private Long id;
    private String customerName;
}
