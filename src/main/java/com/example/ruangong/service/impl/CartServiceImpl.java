package com.example.ruangong.service.impl;

import com.example.ruangong.dao.CartDao;
import com.example.ruangong.pojo.Cart;
import com.example.ruangong.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private CartDao cartDao;

    @Override
    public int addCart(Cart cart) {
        return 0;
    }

    @Override
    public int deleteCarts(List<Long> ids) {
        return 0;
    }

    @Override
    public Cart selectCart(Long id) {
        return null;
    }

    @Override
    public int buyCart(Long id) {
        return 0;
    }
}
