package com.wzlt.restaurantdian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzlt.restaurantdian.entity.Food;
import com.wzlt.restaurantdian.mapper.FoodMapper;
import com.wzlt.restaurantdian.service.FoodService;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {

}
