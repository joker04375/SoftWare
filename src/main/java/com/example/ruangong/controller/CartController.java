package com.example.ruangong.controller;

import com.example.ruangong.Utils.UserHolder;
import com.example.ruangong.pojo.Cart;
import com.example.ruangong.pojo.Result;
import com.example.ruangong.pojo.User;
import com.example.ruangong.service.CartService;
import com.example.ruangong.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//购物车、订单
@RestController
public class CartController {
    @Resource
    private CartService cartService;

    @Resource
    private UserService userService;

    //添加到购物车
    @PostMapping("/addToCart")
    public Result addCart(@RequestParam Long goodId,@RequestParam Integer num){
        //获取当前用户
        User user = UserHolder.getUser();
        int i = cartService.addCart(goodId,user.getId(),num);
        if(i==0){
            return Result.error("添加失败");
        }
        return Result.ok("添加成功");
    }

    //展示订单
    @GetMapping("/showCart")
    public Result showCart(){
        //获取当前用户
        User user = UserHolder.getUser();
        List<Cart> carts = cartService.selectCart(user.getId());
        if(carts==null){
            return Result.error("订单为空");
        }
        return Result.ok(carts);
    }

    @PostMapping("/delCart")
    public Result delCart(@RequestBody List<Long> ids){
        int i = cartService.deleteCarts(ids);
        if(i==0){
            return Result.error("删除失败");
        }
        return Result.ok("删除成功");
    }

    @PostMapping("/buy/{id}")
    public Result buyCart(@PathVariable("id")Long id){
        int i = cartService.buyCart(id);
        if(i==0){
            return Result.error("购买失败");
        }
        return Result.ok("支付成功");
    }
}
