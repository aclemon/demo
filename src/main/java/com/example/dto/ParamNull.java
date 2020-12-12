package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author w00990
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ParamNull {
    @NotNull
    private String id;
    @NotBlank
   
    private String code;
    @NotEmpty
    private String desc;
}
