package com.wzlt.restaurantdian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    /*
     * 登录转发
     * */
    @RequestMapping("/")
    public String login() {
        return "forward:login.html";
    }

}
