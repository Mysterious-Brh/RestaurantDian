package com.wzlt.restaurantdian.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wzlt.restaurantdian.common.Result;
import com.wzlt.restaurantdian.dto.FoodDto;
import com.wzlt.restaurantdian.entity.Food;
import com.wzlt.restaurantdian.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class FoodController {
    @Autowired
    private FoodService foodService;

    // 前端数据封装
    private ResponseEntity<Result<List<FoodDto>>> getResultFoodDto(List<Food> foods) {
        List<FoodDto> foodDtos = foods.stream().map(food -> {
            FoodDto dto = new FoodDto();
            dto.setFoodName(food.getFoodName());
            dto.setFoodImageNail1(food.getFoodImageNail1());
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(Result.success("获取食品列表成功", foodDtos));
    }

    @GetMapping("/getFoods")
    public ResponseEntity<Result<List<FoodDto>>> getAllFoods() {
        Integer restaurantId = 1;
        try {
            List<Food> foods = foodService.list(new QueryWrapper<Food>().eq("restaurant_id", restaurantId));
            return getResultFoodDto(foods);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.error(500, "获取食品列表过程中发生错误: " + ex.getMessage()));
        }
    }

    /*
     * 根据食品类型获取食品
     */
    @GetMapping("/getFoodsByTypeId")
    public ResponseEntity<Result<List<FoodDto>>> getFoodsByType(@RequestParam Integer foodTypeId) {
        try {
            List<Food> foods = foodService.list(new QueryWrapper<Food>().eq("food_type_id", foodTypeId));
            return getResultFoodDto(foods);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.error(500, "获取食品列表过程中发生错误: " + ex.getMessage()));
        }
    }

    /*
    * 根据味道获取食品
    * */
    @GetMapping("/getRecommendFoods")
    public ResponseEntity<Result<List<FoodDto>>> getFoodsByTaste() {
        char foodTaste = 'A';
        try {
            List<Food> foods = foodService.list(new QueryWrapper<Food>().eq("food_taste", foodTaste));
            return getResultFoodDto(foods);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.error(500, "获取食品列表过程中发生错误: " + ex.getMessage()));
        }
    }

}
