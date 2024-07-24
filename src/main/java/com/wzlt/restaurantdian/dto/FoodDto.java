package com.wzlt.restaurantdian.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
    /*
    * 食物缩略图1
    * */
    private String foodImageNail1;
    /*
    * 食物名称
    * */
    private String foodName;
}
