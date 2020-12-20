package com.example.dto;

import com.example.enums.ChannelPaymentEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: w00990
 * @Date: 2020/12/14
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    private String make;
    private String numberOfSeats;
    private ChannelPaymentEnum type;


    //constructor, getters, setters etc.
}
