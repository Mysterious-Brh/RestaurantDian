package com.wzlt.restaurantdian.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("restaurant")
/*
* 餐厅实体类
* */
public class Restaurant {
    /*
    * 餐馆id
    * */
    @TableId
    private Integer restaurantId;
    /*
    * 餐馆名称
    * */
    private String restaurantName;
    /*
    * 餐馆地址
    * */
    private String address;
    /*
    * 餐馆简介
    * */
    private String description;
    /*
    * 餐馆等级
    * */
    private char level;
    /*
    * 餐馆区域
    * */
    private char area;
    /*
    * 餐馆停车位
    * */
    private Integer parkingCount;
    /*
    * 餐馆地图
    * */
    private String restaurantMap;
    /*
    * 创建时间
    * */
    private LocalDateTime createTime;
    /*
    * 创建人
    * */
    private String createPerson;
    /*
    * 更新时间
    * */
    private LocalDateTime updateTime;
    /*
    * 更新人
    * */
    private String updatePerson;
}

