package com.example.ruangong.service.impl;

import com.example.ruangong.dao.CartDao;
import com.example.ruangong.pojo.Cart;
import com.example.ruangong.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Override
    public int addCart(Cart cart) {
        return cartDao.addCart(cart);
    }

    @Override
    public int deleteCarts(List<Long> ids) {
        return cartDao.deleteCarts(ids);
    }

    @Override
    public List<Cart> selectCart(Long id) {
        return cartDao.selectCart(id);
    }

    @Override
    public int buyCart(Long id) {
        return cartDao.buyCart(id);
    }
}
