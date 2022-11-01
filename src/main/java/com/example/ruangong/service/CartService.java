package com.example.ruangong.service;

        import com.example.ruangong.pojo.Cart;

        import java.util.List;

public interface CartService {
    //添加订单
    int addCart(Cart cart);

    //删除订单
    int deleteCarts(List<Long> ids);

    //查询订单
    Cart selectCart(Long id);

    //购买
    int buyCart(Long id);
}
