package com.example.ruangong.dao;

import com.example.ruangong.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {
    List<Goods> selectGoods(@Param("id") Long id);

    int deleteGoods(@Param("id") Long id);

    int addGoods(Goods goods);

    int updateOnSale(Integer status);
}
