package com.wzlt.restaurantdian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzlt.restaurantdian.entity.User;
import com.wzlt.restaurantdian.mapper.UserMapper;
import com.wzlt.restaurantdian.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
