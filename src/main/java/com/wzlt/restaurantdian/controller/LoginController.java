package com.wzlt.restaurantdian.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wzlt.restaurantdian.common.Result;
import com.wzlt.restaurantdian.entity.User;
import com.wzlt.restaurantdian.exception.CustomException;
import com.wzlt.restaurantdian.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    private UserService userService;

    /*
     * 登录接口
     */
    @PostMapping("/doLogin")
    public ResponseEntity<Result<String>> doLogin(@RequestParam String username,
                                                  @RequestParam String password,
                                                  HttpSession session) {
        try {
            // 获取用户信息，判断用户是否存在
            User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
            if (user == null) {
                throw new CustomException("用户不存在");
            }
            if (user.getPassword().equals(password)) {
                session.setAttribute("user", user);
                return ResponseEntity.ok(Result.success("登录成功", user.getUsername()));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Result.error(400, "用户名/密码错误，请重新输入！"));
            }
        }
         catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.error(500, "登录过程中发生错误: " + ex.getMessage()));
        }
    }

}
