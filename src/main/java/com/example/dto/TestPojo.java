package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: w00990
 * @Date: 2021/1/21
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestPojo {
    public String name;
    public int height;
}
