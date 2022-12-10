package com.example.ruangong.service;

        import com.example.ruangong.pojo.Cart;

        import java.util.List;

public interface CartService {
    //添加商品到购物车
    int addCart(Long goodId,Long userId,Integer num);

    //删除商品
    int deleteCarts(List<Long> ids);

    //查询订单
    List<Cart> selectCart(Long userId);

    //购买
    int buyCart(Long id);
}
