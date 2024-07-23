package com.wzlt.restaurantdian.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户实体类
 */
@Data
@TableName("t_user")
public class User {
    /**
     * 员工ID
     */
    @TableId
    private String userId;
    /**
     * 员工姓名
     */
    private String username;
    /**
     * 餐馆ID
     */
    private Integer restaurantId;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private char sex;
    /**
     * 办公电话
     */
    private String officePhone;
    /**
     * 手机号码
     */
    private String mobilePhone;
    /**
     * 是否管理员
     */
    private boolean isAdmin;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 创建人
     */
    private String createPerson;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 更新人
     */
    private String updatePerson;
}
