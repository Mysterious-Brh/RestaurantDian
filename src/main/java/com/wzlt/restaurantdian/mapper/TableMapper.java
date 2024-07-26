package com.wzlt.restaurantdian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzlt.restaurantdian.entity.Table;
import org.apache.ibatis.annotations.Select;

public interface TableMapper extends BaseMapper<Table> {
    /*
    * 获取restaurantId对应的所有桌号
    * */
    @Select("select table_name from t_table where restaurant_id = #{restaurantId}")
    String[] getAllTableNameByRestaurantId(Integer restaurantId);
}
