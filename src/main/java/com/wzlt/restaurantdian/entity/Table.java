package com.wzlt.restaurantdian.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_table")
public class Table {
    /*
    * 桌子ID
    * */
    private Integer tableId;
    /*
    * 桌子名称
    * */
    private String tableName;
    /*
    * 餐馆ID
    * */
    private Integer restaurantId;
}
