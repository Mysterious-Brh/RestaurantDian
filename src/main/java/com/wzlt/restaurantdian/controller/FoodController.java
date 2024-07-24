package com.wzlt.restaurantdian.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wzlt.restaurantdian.common.Result;
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

@RestController
@RequestMapping("/foods/")
public class FoodController {
    @Autowired
    private FoodService foodService;
    /*
     * 获取所有食品
     */
    @GetMapping("/getFoods")
    public ResponseEntity<Result<List<Food>>> getAllFoods(@RequestParam Integer restaurantId) {
        try {
            List<Food> foods = foodService.list(new QueryWrapper<Food>().eq("restaurant_id", restaurantId));
            return ResponseEntity.ok(Result.success("获取食品列表成功", foods));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.error(500, "获取食品列表过程中发生错误: " + ex.getMessage()));
        }
    }

}
