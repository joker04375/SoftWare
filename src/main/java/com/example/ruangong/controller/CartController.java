package com.example.ruangong.controller;

import com.example.ruangong.pojo.Cart;
import com.example.ruangong.pojo.Goods;
import com.example.ruangong.pojo.Result;
import com.example.ruangong.service.CartService;
import com.example.ruangong.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//购物车、订单
@RestController
public class CartController {
    @Resource
    private CartService cartService;

    @Resource
    private UserService userService;

    @GetMapping("/showCart")
    public Result showCart() {
        List<Cart> carts = cartService.selectCart(null);
        return Result.ok(carts);
    }

    @GetMapping("/showCart/{id}")
    public Result showCart(@PathVariable("id") Long id) {
        List<Cart> carts = cartService.selectCart(id);
        return Result.ok(carts);
    }

    @GetMapping("/delCart/{id}")
    public Result delCart(@PathVariable("id") List<Long> ids) {
        int i = cartService.deleteCarts(ids);
        return Result.ok(i);
    }

    @PostMapping("/buy/{id}")
    public Result buyCart(@PathVariable("id") Long id) {
        int i = cartService.buyCart(id);
        return Result.ok(id);
    }
}
