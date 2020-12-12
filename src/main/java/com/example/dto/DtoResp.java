package com.example.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZonedDateTime;


/**
 * @author w00990
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DtoResp implements Serializable {

    private static final long serialVersionUID = -6830740454090395290L;
    @JsonProperty("cancellation_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss VV", timezone = "GMT+8")
    @JSONField(name = "cancellation_date",format = "yyyy-MM-dd HH:mm:ss VV")
    private ZonedDateTime cancellationDate;
}
