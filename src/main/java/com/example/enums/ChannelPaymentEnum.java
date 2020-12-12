package com.example.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author w00990
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ChannelPaymentEnum {
    /**
     * + 银行卡支付
     * + 微信公众号支付
     * + 微信APP支付
     * + 支付宝APP支付
     * + 支付宝H5支付
     * + Apple IAP支付
     */

    BANK_CARD_PAY("bankCardPay",1,"银行卡支付"),
    WE_CHAT_PUBLIC("weChatPublic",2,"微信公众号支付"),
    WE_CHAT_APP("weChatApp",4,"微信APP支付"),
    ALI_PAY_APP("aliPayApp",8,"支付宝APP支付"),
    ALI_PAY_H5("aliPayH5",16,"支付宝H5"),
    APPLE_IAP("AppleIap",32,"Apple IAP支付"),;

    public String name;
    public int    bit;
    public String desc;

    /**
     * Get channel product by bit channel product.
     *
     * @param bit the bit
     * @return the channel product
     */
    public static ChannelPaymentEnum valueOf(int bit){
        for (ChannelPaymentEnum channelPaymentEnum : ChannelPaymentEnum.values()) {
            if (channelPaymentEnum.getBit() == bit){
                return channelPaymentEnum;
            }
        }
        return null;

    }
}
