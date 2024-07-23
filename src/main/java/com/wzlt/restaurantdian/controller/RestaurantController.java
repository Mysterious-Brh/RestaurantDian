package com.wzlt.restaurantdian.controller;

import com.wzlt.restaurantdian.entity.Restaurant;
import com.wzlt.restaurantdian.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants/")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("getAllRestaurants")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.list();
    }

    @PostMapping
    public boolean addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.save(restaurant);
    }
}

