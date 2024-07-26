package com.wzlt.restaurantdian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzlt.restaurantdian.entity.Table;
import com.wzlt.restaurantdian.mapper.TableMapper;
import com.wzlt.restaurantdian.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl extends ServiceImpl<TableMapper, Table> implements TableService {
    @Autowired
    private TableMapper tableMapper;

    @Override
    public String[] getAllTableNameByRestaurantId(Integer restaurantId) {
        return tableMapper.getAllTableNameByRestaurantId(restaurantId);
    }
}
