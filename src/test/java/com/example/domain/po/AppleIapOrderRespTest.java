package com.example.domain.po;

import com.example.mapper.AppleIapMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


/**
 * 苹果沙盒对象
 * {
 * "receipt": {
 * "receipt_type": "ProductionSandbox",
 * "adam_id": 0,
 * "app_item_id": 0,
 * "bundle_id": "com.samoyed.creditkuai",
 * "application_version": "1",
 * "download_id": 0,
 * "version_external_identifier": 0,
 * "receipt_creation_date": "2020-12-08 11:31:58 Etc/GMT",
 * "receipt_creation_date_ms": "1607427118000",
 * "receipt_creation_date_pst": "2020-12-08 03:31:58 America/Los_Angeles",
 * "request_date": "2020-12-08 12:58:26 Etc/GMT",
 * "request_date_ms": "1607432306013",
 * "request_date_pst": "2020-12-08 04:58:26 America/Los_Angeles",
 * "original_purchase_date": "2013-08-01 07:00:00 Etc/GMT",
 * "original_purchase_date_ms": "1375340400000",
 * "original_purchase_date_pst": "2013-08-01 00:00:00 America/Los_Angeles",
 * "original_application_version": "1.0",
 * "in_app": [
 * {
 * "quantity": "1",
 * "product_id": "SY06",
 * "transaction_id": "1000000751573313",
 * "original_transaction_id": "1000000751573313",
 * <p>
 * App Store向用户的帐户收取购买或恢复的产品的费用的时间，或者App过期后向用户的帐户收取订阅的购买或续费的时间
 * "purchase_date": "2020-12-08 09:30:36 Etc/GMT",
 * "purchase_date_ms": "1607419836000",
 * "purchase_date_pst": "2020-12-08 01:30:36 America/Los_Angeles",
 * <p>
 * 原始应用内购买的时间
 * "original_purchase_date": "2020-12-08 09:30:36 Etc/GMT",
 * "original_purchase_date_ms": "1607419836000",
 * "original_purchase_date_pst": "2020-12-08 01:30:36 America/Los_Angeles",
 * 指示订阅是否处于免费试用期内。
 * "is_trial_period": "false"
 * },
 * {
 * "quantity": "1",
 * "product_id": "SY06",
 * "transaction_id": "1000000751577374",
 * "original_transaction_id": "1000000751577374",
 * "purchase_date": "2020-12-08 09:35:50 Etc/GMT",
 * "purchase_date_ms": "1607420150000",
 * "purchase_date_pst": "2020-12-08 01:35:50 America/Los_Angeles",
 * "original_purchase_date": "2020-12-08 09:35:50 Etc/GMT",
 * "original_purchase_date_ms": "1607420150000",
 * "original_purchase_date_pst": "2020-12-08 01:35:50 America/Los_Angeles",
 * "is_trial_period": "false"
 * },
 * {
 * "quantity": "1",
 * "product_id": "SY06",
 * "transaction_id": "1000000751648397",
 * "original_transaction_id": "1000000751648397",
 * "purchase_date": "2020-12-08 11:31:58 Etc/GMT",
 * "purchase_date_ms": "1607427118000",
 * "purchase_date_pst": "2020-12-08 03:31:58 America/Los_Angeles",
 * "original_purchase_date": "2020-12-08 11:31:58 Etc/GMT",
 * "original_purchase_date_ms": "1607427118000",
 * "original_purchase_date_pst": "2020-12-08 03:31:58 America/Los_Angeles",
 * "is_trial_period": "false"
 * }
 * ]
 * },
 * "environment": "Sandbox",
 * "status": 0
 * }
 */

/**
 * @Author: w00990
 * @Date: 2020/12/14
 */
@SpringBootTest
@Slf4j
class AppleIapOrderRespTest {
    @Resource
    private AppleIapMapper appleIapMapper;

    @Test
    public void appleTest() throws JsonProcessingException {
        String appleJson = "{\n" +
                "      \"receipt\": {\n" +
                "          \"receipt_type\": \"ProductionSandbox\",\n" +
                "          \"adam_id\": 0,\n" +
                "          \"app_item_id\": 0,\n" +
                "          \"bundle_id\": \"com.samoyed.creditkuai\",\n" +
                "          \"application_version\": \"1\",\n" +
                "          \"download_id\": 0,\n" +
                "          \"version_external_identifier\": 0,\n" +
                "          \"receipt_creation_date\": \"2020-12-08 11:31:58 Etc/GMT\",\n" +
                "          \"receipt_creation_date_ms\": \"1607427118000\",\n" +
                "          \"receipt_creation_date_pst\": \"2020-12-08 03:31:58 America/Los_Angeles\",\n" +
                "          \"request_date\": \"2020-12-08 12:58:26 Etc/GMT\",\n" +
                "          \"request_date_ms\": \"1607432306013\",\n" +
                "          \"request_date_pst\": \"2020-12-08 04:58:26 America/Los_Angeles\",\n" +
                "          \"original_purchase_date\": \"2013-08-01 07:00:00 Etc/GMT\",\n" +
                "          \"original_purchase_date_ms\": \"1375340400000\",\n" +
                "          \"original_purchase_date_pst\": \"2013-08-01 00:00:00 America/Los_Angeles\",\n" +
                "          \"original_application_version\": \"1.0\",\n" +
                "          \"in_app\": [\n" +
                "              {\n" +
                "                  \"quantity\": \"1\",\n" +
                "                  \"product_id\": \"SY06\",\n" +
                "                  \"transaction_id\": \"1000000751573313\",\n" +
                "                  \"original_transaction_id\": \"1000000751573313\",\n" +
                " \n" +
                "                                             \"purchase_date\": \"2020-12-08 09:30:36 Etc/GMT\",\n" +
                "                  \"purchase_date_ms\": \"1607419836000\",\n" +
                "                  \"purchase_date_pst\": \"2020-12-08 01:30:36 America/Los_Angeles\",\n" +
                " \n" +
                "                                             \"original_purchase_date\": \"2020-12-08 09:30:36 Etc/GMT\",\n" +
                "                  \"original_purchase_date_ms\": \"1607419836000\",\n" +
                "                  \"original_purchase_date_pst\": \"2020-12-08 01:30:36 America/Los_Angeles\",\n" +
                "                  \"is_trial_period\": \"false\"\n" +
                "                                         },\n" +
                "              {\n" +
                "                  \"quantity\": \"1\",\n" +
                "                  \"product_id\": \"SY06\",\n" +
                "                  \"transaction_id\": \"1000000751577374\",\n" +
                "                  \"original_transaction_id\": \"1000000751577374\",\n" +
                "                  \"purchase_date\": \"2020-12-08 09:35:50 Etc/GMT\",\n" +
                "                  \"purchase_date_ms\": \"1607420150000\",\n" +
                "                  \"purchase_date_pst\": \"2020-12-08 01:35:50 America/Los_Angeles\",\n" +
                "                  \"original_purchase_date\": \"2020-12-08 09:35:50 Etc/GMT\",\n" +
                "                  \"original_purchase_date_ms\": \"1607420150000\",\n" +
                "                  \"original_purchase_date_pst\": \"2020-12-08 01:35:50 America/Los_Angeles\",\n" +
                "                  \"is_trial_period\": \"false\"\n" +
                "                                         },\n" +
                "              {\n" +
                "                  \"quantity\": \"1\",\n" +
                "                  \"product_id\": \"SY06\",\n" +
                "                  \"transaction_id\": \"1000000751648397\",\n" +
                "                  \"original_transaction_id\": \"1000000751648397\",\n" +
                "                  \"purchase_date\": \"2020-12-08 11:31:58 Etc/GMT\",\n" +
                "                  \"purchase_date_ms\": \"1607427118000\",\n" +
                "                  \"purchase_date_pst\": \"2020-12-08 03:31:58 America/Los_Angeles\",\n" +
                "                  \"original_purchase_date\": \"2020-12-08 11:31:58 Etc/GMT\",\n" +
                "                  \"original_purchase_date_ms\": \"1607427118000\",\n" +
                "                  \"original_purchase_date_pst\": \"2020-12-08 03:31:58 America/Los_Angeles\",\n" +
                "                  \"is_trial_period\": \"false\"\n" +
                "                                         }\n" +
                "          ]\n" +
                "      },\n" +
                "      \"environment\": \"Sandbox\",\n" +
                "      \"status\": 0\n" +
                "                     }";
//        VerifyReceiptResp verifyReceiptResp = JSON.parseObject(appleJson, VerifyReceiptResp.class);
//        Console.log("verifyReceiptResp=>" + verifyReceiptResp);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, true);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JavaTimeModule timeModule = new JavaTimeModule();
        timeModule.addSerializer(ZonedDateTime.class, new ZonedDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss VV")));
        mapper.registerModule(timeModule);
        VerifyReceiptResp serverNotifyRefundResp1 = mapper.readValue(appleJson, VerifyReceiptResp.class);
//        Console.log("VerifyReceiptResp=>" + serverNotifyRefundResp1);
        log.info("VerifyReceiptResp=>{}", serverNotifyRefundResp1);

//        AppleIapOrderResp appleIapOrderResp = appleIapMapper.receiptToOrder(serverNotifyRefundResp1);
//        Console.log("appleIapOrderResp=>" + appleIapOrderResp);
    }

}
