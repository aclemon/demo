package com.example.domain.po;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @Author: w00990
 * @Date: 2020/12/22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CustomerWithMoney extends Customer {
    private Integer money;

    public CustomerWithMoney(Long id, String name, Integer money) {
        super(id, name);
        this.money = money;
    }

}
