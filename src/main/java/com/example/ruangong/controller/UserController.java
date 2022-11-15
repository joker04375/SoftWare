package com.example.ruangong.controller;

import com.example.ruangong.pojo.Goods;
import com.example.ruangong.pojo.Result;
import com.example.ruangong.pojo.User;
import com.example.ruangong.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private GoodsService goodsService;

    //用户注册
    @PostMapping("register")
    public Result register(String username, String password,String name,String email) {
        int i = userService.register(username, password,name,email);
        if (i==0){
            return Result.error(0,"更新失败");
        }
        return Result.ok();
    }

    //用户登录
    @GetMapping("login")
    public Result login(String username, String password, HttpSession session) {
        User user = userService.login(username, password);
        if(user==null){
            return Result.error(100,"登录失败");
        }
        return Result.ok("登陆成功");
    }

    //用户登出
    @GetMapping("logout")
    public Result logout(String token) {
        return Result.ok();
    }


    //添加用户
    @PostMapping("/inserUser")
    public Result insertUser(User user){
        int i = userService.insertUser(user);
        if (i==0){

        }
        return Result.ok();
    }

    //修改用户信息
    @PostMapping("/updateUser")
    public Result updateUser(User user){
        int i = userService.updateUser(user);
        return Result.ok();
    }

    //删除用户
    @GetMapping("/delUser/{id}")
    public Result insertUser(@PathVariable("id")Long userId){
        return Result.ok();
    }

    //商品添加
    @PostMapping("/addGoods")
    public Result addGoods(@RequestBody Goods goods){
        int i = goodsService.addGoods(goods);
        if(i==0){
            return Result.error("添加失败");
        }
        return Result.ok("添加成功");
    }

//    //商品批量添加
//    @PostMapping("/addGoods")
//    public Result addGoods(MultipartFile multipartFile){
//        return Result.ok();
//    }

    //商品删除
    @PostMapping("/delGoods")
    public Result delGoods(Long goodsId){
        int i = goodsService.deleteGoods(goodsId);
        if(i==0){
            return Result.error("删除失败");
        }
        return Result.ok("删除成功");
    }

   /* //管理商品
    @PostMapping("/updateUserAndGoods/{goodsId}")
    public Result updateUserAndGoods(@PathVariable("id")Long goodsId){
        return Result.ok();
    }

    //修改用户权限
    @PostMapping("/updateAuthor/{id}")
    public Result updateUserAuthor(@PathVariable("id")Long userId){
        return Result.ok();
    }*/
}
