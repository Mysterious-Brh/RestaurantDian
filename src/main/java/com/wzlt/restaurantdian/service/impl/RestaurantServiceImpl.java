package com.wzlt.restaurantdian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzlt.restaurantdian.entity.Restaurant;
import com.wzlt.restaurantdian.mapper.RestaurantMapper;
import com.wzlt.restaurantdian.service.RestaurantService;
import org.springframework.stereotype.Service;


@Service
public class RestaurantServiceImpl extends ServiceImpl<RestaurantMapper, Restaurant> implements RestaurantService {

}

