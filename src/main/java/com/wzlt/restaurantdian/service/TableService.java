package com.wzlt.restaurantdian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzlt.restaurantdian.entity.Table;

public interface TableService extends IService<Table> {
    /*
    * 根据餐馆ID获取所有桌子名称
    * */
    String[] getAllTableNameByRestaurantId(Integer restaurantId);
}
