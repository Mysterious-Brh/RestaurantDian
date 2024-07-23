package com.wzlt.restaurantdian.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wzlt.restaurantdian.common.Result;
import com.wzlt.restaurantdian.entity.User;
import com.wzlt.restaurantdian.exception.CustomException;
import com.wzlt.restaurantdian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/")
public class UserController {

    @Autowired
    private UserService userService;

    /*
     * 登录接口
     * */
    @PostMapping("doLogin")
    public Result<String> doLogin(String username, String password) {
        try {
            // 获取用户信息，判断用户是否存在
            User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
            if (user == null) {
                throw new CustomException("用户不存在");
            }
            if (user.getPassword().equals(password)) {
                return Result.success("登录成功", user.getUserId());
            } else {
                throw new CustomException("密码错误，请重新输入密码！");
            }
        } catch (CustomException ex) {
            return Result.error(400, ex.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException("登录过程中发生错误: " + ex.getMessage());
        }
    }


}
