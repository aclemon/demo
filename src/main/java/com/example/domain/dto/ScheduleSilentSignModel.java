package com.example.domain.dto;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * @Author: w00990
 * @Date: 2021/1/25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleSilentSignModel {
    /**
     * 开始时间
     *
     * @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss[ VV]")
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Etc/GMT")
    @JsonProperty("start_date")
    private ZonedDateTime startDate;
    /**
     * 结束时间
     */

//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty(value = "end_date")
    private LocalDateTime endDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private DateTime time;
    /**
     * 查询次数
     */
    @JsonProperty("exe_size")
    private Integer exeSize;

    @JsonProperty("exe_page")
    private Integer exePage;
    @JsonProperty("merchant_id")
    public String merchantId;
    @JsonProperty("channel_id")
    public String channelId;
    @JsonProperty("channel_merchant_id")
    public String channelMerchantId;
}
