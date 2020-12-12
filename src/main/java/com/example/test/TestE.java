package com.example.test;

import java.math.BigDecimal;

public class TestE {
    public static void main(String[] args) {
        BigDecimal newZero = new BigDecimal(0.0);
        System.out.println(BigDecimal.ZERO.compareTo(newZero));

        BigDecimal stringNewZero = new BigDecimal("0.0");
        System.out.println(BigDecimal.ZERO.compareTo(stringNewZero));

        BigDecimal noScaleZero = BigDecimal.valueOf(0.0);
        System.out.println(BigDecimal.ZERO.compareTo(noScaleZero));

        BigDecimal scaleZero = BigDecimal.valueOf(0.0).setScale(1);
        System.out.println(BigDecimal.ZERO.compareTo(scaleZero));
    }
}
