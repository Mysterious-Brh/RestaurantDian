package com.wzlt.restaurantdian.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("t_food")
public class Food {
    /*
    * 食物ID
    * */
    @TableId
    private Integer foodId;
    /*
    * 食物名称
    * */
    private String foodName;
    /*
    * 餐馆ID
    * */
    private Integer restaurantId;
    /*
    * 食物类型ID
    * */
    private Integer foodTypeId;
    /*
    * 食物口味
    * */
    private char foodTaste;
    /*
    * 食物描述
    * */
    private String description;
    /*
    * 食物价格
    * */
    private Double price;
    /*
    * 食物缩略图1
    * */
    private String foodImageNail1;
    /*
    * 食物缩略图2
    * */
    private String foodImageNail2;
    /*
    * 食物缩略图3
    * */
    private String foodImageNail3;
    /*
    * 食物缩略图4
    * */
    private String foodImageNail4;
    /*
    * 食物图片1
    * */
    private String foodImage1;
    /*
    * 食物图片2
    * */
    private String foodImage2;
    /*
    * 食物图片3
    * */
    private String foodImage3;
    /*
    * 食物图片4
    * */
    private String foodImage4;
    /*
    * 创建时间
    * */
    private LocalDateTime createTime;
    /*
    * 更新时间
    * */
    private LocalDateTime updateTime;
    /*
    * 创建人
    * */
    private String createPerson;
    /*
    * 更新人
    * */
    private String updatePerson;
}
