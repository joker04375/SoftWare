package com.example.ruangong.controller;

import com.example.ruangong.pojo.Result;
import com.example.ruangong.service.CartService;
import com.example.ruangong.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
//购物车、订单
@RestController
public class CartController {
    @Resource
    private CartService cartService;

    @Resource
    private UserService userService;

    @GetMapping("/showCart")
    public Result showCart(){
        return Result.ok();
    }

    @GetMapping("/showCart/{id}")
    public Result showCart(@PathVariable("id")Long id){
        return Result.ok();
    }

    @GetMapping("/delCart/{id}")
    public Result delCart(@PathVariable("id")Long id){
        return Result.ok();
    }

    @PostMapping("/buy/{id}")
    public Result buyCart(@PathVariable("id")Long id){
        return Result.ok();
    }
}
