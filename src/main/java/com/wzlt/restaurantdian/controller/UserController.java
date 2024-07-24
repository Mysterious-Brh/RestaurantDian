package com.wzlt.restaurantdian.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wzlt.restaurantdian.common.Result;
import com.wzlt.restaurantdian.entity.User;
import com.wzlt.restaurantdian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserById")
    public ResponseEntity<Result<User>> getUserById(@RequestParam String userId) {
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", userId);
            User user = userService.getOne(queryWrapper);
            if (user != null) {
                return ResponseEntity.ok(Result.success("获取用户成功", user));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Result.error(404, "用户不存在"));
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.error(500, "获取用户过程中发生错误: " + ex.getMessage()));
        }
    }




}
