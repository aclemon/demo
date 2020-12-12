package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @Author: w00990
 * @Date: 2020/12/11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @NotBlank(message = "usernames")
    private String username;
    @NotBlank(message = "password")
    private String password;
}
