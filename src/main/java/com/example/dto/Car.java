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

    static Integer carFlag = 1;

    private String make;
    private String numberOfSeats;
    private ChannelPaymentEnum type;
    private Integer num;

    public void setCarFlag() {
        carFlag = 2;
    }

    public Integer getCarFlag() {
        return carFlag;
    }

    //constructor, getters, setters etc.
}
