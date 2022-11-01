package com.example.ruangong.dao;

import com.example.ruangong.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface CartDao {
    int addCart(Cart cart);

    int deleteCarts(List<Long> ids);

    Cart selectCart(Long id);

    int buyCart(Long id);
}
