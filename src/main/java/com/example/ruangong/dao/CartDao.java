package com.example.ruangong.dao;

import com.example.ruangong.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface CartDao {
    int addCart(Cart cart);

    int deleteCarts(List<Long> ids);

    Cart selectCart(Long id);

    int buyCart(Long id);
}
