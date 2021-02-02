package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.ToString;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2021-01-28 14:28:19
 */
@SuppressWarnings("serial")
@TableName("system_user")
@ToString
public class User extends Model<User> {

    private String id;

    private String username;

    private String password;

    private String role;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
