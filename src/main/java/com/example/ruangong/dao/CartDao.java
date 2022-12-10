package com.example.ruangong.dao;

import com.example.ruangong.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartDao {

    int deleteCarts(@Param("idlist")List<Long> ids);

    List<Cart> selectCart(@Param("userId") Long userId);

    int buyCart(@Param("id") Long id);

    int addCart(@Param("goodId") Long goodId,@Param("userId") Long userId,@Param("num") Integer num);

    List<Cart> selectCartByOrderId(@Param("orderId") Long orderId);
}
