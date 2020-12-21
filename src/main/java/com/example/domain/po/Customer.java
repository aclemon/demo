package com.example.domain.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: w00990
 * @Date: 2020/12/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private Long id;
    private String name;
    private Boolean isDisable;
    private String email;
    private Date birthday;
    private Integer code;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDisable() {
        return isDisable;
    }

    public void setDisable(Boolean disable) {
        isDisable = disable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
