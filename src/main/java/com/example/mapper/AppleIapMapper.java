package com.example.mapper;

import com.example.domain.po.AppleIapOrderResp;
import com.example.domain.po.VerifyReceiptResp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;

/**
 * @Author: w00990
 * @Date: 2020/12/14
 */
@Mapper(componentModel = "spring")
public interface AppleIapMapper {
    AppleIapMapper INSTANCE = Mappers.getMapper(AppleIapMapper.class);

    @Mappings({
            @Mapping(source = "purchaseDate", target = "purchaseDate"),
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "transactionId", target = "transactionId"),
            @Mapping(source = "isTrialPeriod", target = "isTrialPeriod"),
            @Mapping(source = "purchaseDateMs", target = "transDate", qualifiedByName = "str2Date"),
    })
    AppleIapOrderResp.InApp inAppTransForm(VerifyReceiptResp.Receipt.InApp inApp);

    @Named("str2Date")
    default Date str2Date(String str) {
        long longTimeStamp = Long.parseLong(str);
        Date date = new Date(longTimeStamp);
        return date;
    }

    @Mappings({
            @Mapping(source = "receiptResp.receipt.receiptType", target = "receiptType"),
            @Mapping(source = "receiptResp.receipt.inApp", target = "inAppList"),

    })
    AppleIapOrderResp receiptToOrder(VerifyReceiptResp receiptResp);
}
