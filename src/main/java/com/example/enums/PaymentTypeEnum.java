package com.example.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: w00990
 * @Date: 2021/1/30
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PaymentTypeEnum {
    /**
     * 支付方式
     */
    WE_CHAT_PAY("WE_CHAT_PAY", "微信支付", Arrays.asList(ChannelPaymentEnum.WE_CHAT_APP, ChannelPaymentEnum.WE_CHAT_JS)),
    ALI_PAY("ALI_PAY", "阿里支付", Arrays.asList(ChannelPaymentEnum.ALI_PAY_APP, ChannelPaymentEnum.ALI_PAY_H5)),
    BANK_PAY("BANK_PAY", "银行卡支付", Collections.singletonList(ChannelPaymentEnum.BANK_CARD_PAY)),
    APPLE_PAY("APPLE_PAY", "苹果支付", Collections.singletonList(ChannelPaymentEnum.APPLE_IAP));

    public String code;
    public String desc;
    public List<ChannelPaymentEnum> channelPaymentEnum;


}
