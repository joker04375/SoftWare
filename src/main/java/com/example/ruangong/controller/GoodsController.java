package com.example.ruangong.controller;

import com.example.ruangong.dao.GoodsDao;
import com.example.ruangong.pojo.Goods;
import com.example.ruangong.pojo.Result;
import com.example.ruangong.service.CartService;
import com.example.ruangong.service.GoodsService;
import com.example.ruangong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @Resource
    private UserService userService;

    //展示商品
    @GetMapping("/showGoods")
    public Result showGoods(){
        List<Goods> goods = goodsService.selectGoods(null);
        return Result.ok(goods);
    }

    //展示某个商品
    @GetMapping("/showGoods/{id}")
    public Result GoodsInfo(@PathVariable("id") Long id){
        List<Goods> goods = goodsService.selectGoods(id);
        return Result.ok(goods);
    }

}
