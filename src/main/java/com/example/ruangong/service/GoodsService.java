package com.example.ruangong.service;

import com.example.ruangong.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {
    //查询商品
    List<Goods> selectGoods(@Param("id") Long id);

    //删除商品
    int deleteGoods(@Param("id") Long id);

    //添加商品
    int addGoods(Goods goods);

    //更新是否展示
    int updateOnSale(Integer status);
}
