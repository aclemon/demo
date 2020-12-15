package com.example.dto;

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
public class CarDto {

    private String make;
    private double seatCount;
    private String type;

}
