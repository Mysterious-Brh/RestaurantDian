package com.wzlt.restaurantdian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wzlt.restaurantdian.mapper")
public class RestaurantDianApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantDianApplication.class, args);
    }

}
