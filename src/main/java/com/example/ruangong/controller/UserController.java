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
import java.util.List;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    //用户注册 1
    @PostMapping("register")
    public Result register(@RequestParam String username, @RequestParam String password,@RequestParam  String name,@RequestParam String email) {
        int i = userService.register(username, password,name,email);
        if (i==0){
            return Result.error(0,"更新失败");
        }
        return Result.ok();
    }

    //用户登录 2
    @GetMapping("login")
    public Result login(String username, String password,HttpSession session) {
        User user = userService.login(username, password);
        if(user==null){
            return Result.error(100,"登录失败");
        }
        return Result.ok("登陆成功");
    }

    //用户登出 3
    @GetMapping("logout")
    public Result logout(String token) {
        return Result.ok();
    }

    //查询所有用户
    @GetMapping("/selectUser")
    public Result selectAllUser(){
        List<User> user = userService.selectById(null);
        return Result.ok(user);
    }

    //查询单个用户
    @GetMapping("/selectUser/id")
    public Result selectOneUser(@PathVariable("id") Long id){
        List<User> user = userService.selectById(id);
        return Result.ok(user);
    }

    //添加用户 4
    @PostMapping("/insertUser")
    public Result insertUser(@RequestBody User user){
        int i = userService.insertUser(user);
        if (i==0){
            return Result.error(0,"插入失败");
        }
        return Result.ok();
    }

    //修改用户信息
    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody User user){
        int i = userService.updateUser(user);
        if (i==0){
            return Result.error(0,"更新失败");
        }
        return Result.ok();
    }

    //删除用户
    @GetMapping("/delUser/{id}")
    public Result insertUser(@PathVariable("id")Long id){
        int i = userService.deleteUser(id);
        if (i==0){
            return Result.error(0,"删除失败");
        }
        return Result.ok();
    }
    //修改用户权限
    @PostMapping("/updateAuthor/{id}")
    public Result updateUserAuthor(@PathVariable("id")Long userId,int type){
        int i = userService.updateUserAuthorization(userId, type);
        if (i==0){
            return Result.error(0,"修改失败");
        }
        return Result.ok();
    }
//    //管理商品
//    @PostMapping("/updateUserAndGoods/{goodsId}")
//    public Result updateUserAndGoods(@PathVariable("id")Long goodsId){
//        return Result.ok();
//    }
//
//    //商品添加
//    @PostMapping("/addGoods")
//    public Result addGoods(Goods goods){
//        return Result.ok();
//    }
//
//    //商品批量添加
//    @PostMapping("/addGoods")
//    public Result addGoods(MultipartFile multipartFile){
//        return Result.ok();
//    }
//
//    //商品删除
//    @GetMapping("/delGoods/{id}")
//    public Result delGoods(@PathVariable("id") Long goodsId){
//        return Result.ok();
//    }
//
//    //修改用户权限
//    @PostMapping("/updateAuthor/{id}")
//    public Result updateUserAuthor(@PathVariable("id")Long userId){
//        return Result.ok();
//    }
//
//    //添加用户
//    @PostMapping("/inserUser")
//    public Result insertUser(User user){
//        return Result.ok();
//    }
//
//    //修改用户信息
//    @PostMapping("/updateUser")
//    public Result updateUser(User user){
//        return Result.ok();
//    }
//
//    //删除用户
//    @GetMapping("/delUser/{id}")
//    public Result insertUser(@PathVariable("id")Long userId){
//        return Result.ok();
//    }
}
