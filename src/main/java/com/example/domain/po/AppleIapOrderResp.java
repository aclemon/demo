package com.example.domain.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * @Author: w00990
 * @Date: 2020/12/14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppleIapOrderResp {


    /**
     * 收据类型
     */
    private String receiptType;


    private List<InApp> inAppList;


    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Builder
    @SuppressWarnings("unused")
    public static class InApp {

        private String isTrialPeriod;
        private String productId;
        private ZonedDateTime purchaseDate;
        private Integer quantity;
        private String transactionId;

    }
}
