package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.example.annotation.Condition;
import lombok.*;

import java.util.Date;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2021-01-28 14:28:19
 */

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = false)
@TableName("system_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends Model<User> {
    private String id;

    @Condition
    private String username;
    @Condition
    private String password;

    private String role;
    @Condition
    @TableField(value = "testTime")
    private Date testTime;


}
