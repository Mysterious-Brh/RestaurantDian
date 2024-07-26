package com.wzlt.restaurantdian.controller;

import com.wzlt.restaurantdian.common.Result;
import com.wzlt.restaurantdian.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TableController {
    @Autowired
    private TableService tableService;

    // 获取所有桌号
    @GetMapping("getAllTableName")
    public ResponseEntity<Result<String[]>> getAllTableName() {
        Integer restaurantId = 1;
        try {
            return ResponseEntity.ok(Result.success(tableService.getAllTableNameByRestaurantId(restaurantId)));
        } catch (Exception e) {
            return ResponseEntity.ok(Result.error(e.getMessage()));
        }

    }
}
