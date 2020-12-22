package com.example.domain.dto;

import lombok.*;

/**
 * @Author: w00990
 * @Date: 2020/12/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String customerName;
    private String customize;
    private String codeTest;
}
