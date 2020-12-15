package com.example.mapper;

import com.example.domain.po.AppleIapOrderResp;
import com.example.domain.po.VerifyReceiptResp;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

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
            @Mapping(source = "isTrialPeriod", target = "isTrialPeriod")
    })
    AppleIapOrderResp.InApp inAppTransForm(VerifyReceiptResp.Receipt.InApp inApp);

    @IterableMapping(dateFormat = "$#.00")
    List<String> prices(List<Integer> prices);

    @Mappings({
            @Mapping(source = "receiptResp.receipt.receiptType", target = "receiptType"),
            @Mapping(source = "receiptResp.receipt.inApp", target = "inAppList"),

    })
    AppleIapOrderResp receiptToOrder(VerifyReceiptResp receiptResp);
}
