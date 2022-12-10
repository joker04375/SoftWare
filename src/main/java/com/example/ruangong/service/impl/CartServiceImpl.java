package com.example.ruangong.service.impl;

import com.example.ruangong.Utils.UserHolder;
import com.example.ruangong.dao.CartDao;
import com.example.ruangong.dao.GoodsDao;
import com.example.ruangong.pojo.Cart;
import com.example.ruangong.pojo.Goods;
import com.example.ruangong.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Autowired
    private GoodsDao goodsDao;


    @Override
    public int addCart(Long goodId,Long userId,Integer num) {
        return cartDao.addCart(goodId,userId,num);
    }

    @Override
    public int deleteCarts(List<Long> ids) {
        for (Long id : ids) {
            System.out.println(id);
        }
        return cartDao.deleteCarts(ids);
    }

    @Override
    public List<Cart> selectCart(Long id) {
        List<Cart> carts = cartDao.selectCart(id);
        for (Cart cart : carts) {
            List<Goods> goods = goodsDao.selectGoods(cart.getGoodsId());
            cart.setGoods(goods.get(0));
        }
        return carts;
    }

    @Override
    public int buyCart(Long id) {
        List<Cart> carts = cartDao.selectCartByOrderId(id);
        for (Cart cart : carts) {
            Long goodsId = cart.getGoodsId();
            Integer num = cart.getNum();
            goodsDao.updateGoodsNum(goodsId,num);
        }
        return cartDao.buyCart(id);
    }
}
