package com.example.ruangong.dao;

import com.example.ruangong.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface GoodsDao {
    List<Goods> selectGoods(@Param("id") Long id);

    int deleteGoods(@Param("id") Long id);

    int addGoods(Goods goods);

    int updateOnSale(@Param("id")Long id,@Param("status")Integer status);

    int updateImage(@Param("id") Long id, @Param("image") String image);
}
