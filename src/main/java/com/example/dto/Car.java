package com.example.dto;

import com.example.enums.ChannelPaymentEnum;
import lombok.*;

/**
 * @Author: w00990
 * @Date: 2020/12/14
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Car {

    private String make;
    private int numberOfSeats;
    private ChannelPaymentEnum type;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public ChannelPaymentEnum getType() {
        return type;
    }

    public void setType(ChannelPaymentEnum type) {
        this.type = type;
    }
    //constructor, getters, setters etc.
}
