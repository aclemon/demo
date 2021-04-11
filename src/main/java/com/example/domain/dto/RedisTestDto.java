package com.example.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: w00990
 * @Date: 2021/2/26
 */
@Data
public class RedisTestDto implements Serializable {
    private String permit;
    @JsonProperty("cert_id")
    private String certId;
}
