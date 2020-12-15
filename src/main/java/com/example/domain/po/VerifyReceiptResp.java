package com.example.domain.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

/**
 * 苹果沙盒环境返回的验证收据响应对象
 * {
 * "receipt": {
 * "receipt_type": "ProductionSandbox",
 * "adam_id": 0,
 * "app_item_id": 0,
 * "bundle_id": "com.Yo***ights",
 * "application_version": "1",
 * "download_id": 0,
 * "version_external_identifier": 0,
 * "receipt_creation_date": "2020-06-01 09:37:57 Etc/GMT",
 * "receipt_creation_date_ms": "1591004277000",
 * "receipt_creation_date_pst": "2020-06-01 02:37:57 America/Los_Angeles",
 * "request_date": "2020-06-01 09:38:55 Etc/GMT",
 * "request_date_ms": "1591004335844",
 * "request_date_pst": "2020-06-01 02:38:55 America/Los_Angeles",
 * "original_purchase_date": "2013-08-01 07:00:00 Etc/GMT",
 * "original_purchase_date_ms": "1375340400000",
 * "original_purchase_date_pst": "2013-08-01 00:00:00 America/Los_Angeles",
 * "original_application_version": "1.0",
 * "in_app": [
 * {
 * "quantity": "1",
 * "product_id": "com.yo***thlycard",
 * "transaction_id": "10***4780",
 * "original_transaction_id": "10***4780",
 * "purchase_date": "2020-06-01 09:36:56 Etc/GMT",
 * "purchase_date_ms": "1591004216000",
 * "purchase_date_pst": "2020-06-01 02:36:56 America/Los_Angeles",
 * "original_purchase_date": "2020-06-01 09:36:56 Etc/GMT",
 * "original_purchase_date_ms": "1591004216000",
 * "original_purchase_date_pst": "2020-06-01 02:36:56 America/Los_Angeles",
 * "is_trial_period": "false"
 * },
 * {
 * "quantity": "1",
 * "product_id": "com.yo***iteprime1",
 * "transaction_id": "10***3950",
 * "original_transaction_id": "10***3950",
 * "purchase_date": "2020-06-01 09:35:30 Etc/GMT",
 * "purchase_date_ms": "1591004130000",
 * "purchase_date_pst": "2020-06-01 02:35:30 America/Los_Angeles",
 * "original_purchase_date": "2020-06-01 09:35:30 Etc/GMT",
 * "original_purchase_date_ms": "1591004130000",
 * "original_purchase_date_pst": "2020-06-01 02:35:30 America/Los_Angeles",
 * "is_trial_period": "false"
 * }
 * ]
 * },
 * "status": 0,
 * "environment": "Sandbox"
 * }
 *
 * @author t00458
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@SuppressWarnings("unused")
public class VerifyReceiptResp {
    public static final String STATUS_OK = "0";

    private String environment;
    private Receipt receipt;
    private Integer status;


    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Builder
    @SuppressWarnings("unused")
    public static class Receipt {

        @JsonProperty("adam_id")
        private Long adamId;
        @JsonProperty("app_item_id")
        private Long appItemId;
        @JsonProperty("application_version")
        private String applicationVersion;
        @JsonProperty("bundle_id")
        private String bundleId;
        @JsonProperty("download_id")
        private Long downloadId;
        @JsonProperty("in_app")
        private List<InApp> inApp;
        @JsonProperty("original_application_version")
        private String originalApplicationVersion;
        @JsonProperty("original_purchase_date")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss[ VV]")
        private ZonedDateTime originalPurchaseDate;
        @JsonProperty("original_purchase_date_ms")
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        private Date originalPurchaseDateMs;
        @JsonProperty("original_purchase_date_pst")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss[ VV]")
        private ZonedDateTime originalPurchaseDatePst;
        @JsonProperty("receipt_creation_date")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss[ VV]")
        private ZonedDateTime receiptCreationDate;
        @JsonProperty("receipt_creation_date_ms")
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        private Date receiptCreationDateMs;
        @JsonProperty("receipt_creation_date_pst")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss[ VV]")
        private ZonedDateTime receiptCreationDatePst;
        @JsonProperty("receipt_type")
        private String receiptType;
        @JsonProperty("request_date")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss[ VV]")
        private ZonedDateTime requestDate;
        @JsonProperty("request_date_ms")
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        private Date requestDateMs;
        @JsonProperty("request_date_pst")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss[ VV]")
        private ZonedDateTime requestDatePst;
        @JsonProperty("version_external_identifier")
        private Long versionExternalIdentifier;

        @NoArgsConstructor
        @AllArgsConstructor
        @Data
        @Builder
        @SuppressWarnings("unused")
        public static class InApp {

            @JsonProperty("is_trial_period")
            private String isTrialPeriod;
            @JsonProperty("original_purchase_date")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss[ VV]")
            private ZonedDateTime originalPurchaseDate;
            @JsonProperty("original_purchase_date_ms")
            @JsonFormat(shape = JsonFormat.Shape.NUMBER)
            private Date originalPurchaseDateMs;
            @JsonProperty("original_purchase_date_pst")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss[ VV]")
            private ZonedDateTime originalPurchaseDatePst;
            @JsonProperty("original_transaction_id")
            private String originalTransactionId;
            @JsonProperty("product_id")
            private String productId;
            @JsonProperty("purchase_date")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss[ VV]")
            private ZonedDateTime purchaseDate;
            @JsonProperty("purchase_date_ms")
//            @JsonFormat(shape = JsonFormat.Shape.NUMBER)
            private String purchaseDateMs;
            @JsonProperty("purchase_date_pst")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss[ VV]")
            private ZonedDateTime purchaseDatePst;
            private Integer quantity;
            @JsonProperty("transaction_id")
            private String transactionId;

        }
    }
}

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
