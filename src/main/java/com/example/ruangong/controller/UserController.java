package com.example.ruangong.controller;

import com.example.ruangong.Utils.UserHolder;
import com.example.ruangong.pojo.Goods;
import com.example.ruangong.pojo.Result;
import com.example.ruangong.pojo.User;
import com.example.ruangong.service.GoodsService;
import com.example.ruangong.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private GoodsService goodsService;

    //用户注册
    @PostMapping("register")
    public Result register(@RequestParam String username, @RequestParam String password,String name,String email) {
        int i = userService.register(username, password,name,email);
        if (i==0){
            return Result.error("更新失败");
        }
        return Result.ok("更新成功");
    }

    //用户登录
    @PostMapping("login")
    public Result login(@RequestParam String username,@RequestParam String password, HttpSession session) {
        User user = userService.login(username, password);
        if(user==null){
            return Result.error(100,"登录失败");
        }
        session.setAttribute("user",user);
        return Result.ok(user);
    }

//    //用户登录
//    @PostMapping("login")
//    public User login(@RequestParam String username,@RequestParam String password, HttpSession session) {
//        User user = userService.login(username, password);
//        if(user==null){
////            return Result.error(100,"登录失败");
//        }
//        session.setAttribute("user",user);
////        return Result.ok(user);
//        return user;
//    }

    //用户登出
    @GetMapping("logout")
    public Result logout(String token,HttpSession session) {
        session.removeAttribute("user");
        return Result.ok("登出成功");
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
            return Result.error("插入失败");
        }
        return Result.ok("插入成功");
    }

    //修改用户信息
    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody User user){
        int i = userService.updateUser(user);
        if (i==0){
            return Result.error("更新失败");
        }
        return Result.ok("更新成功");
    }

    //删除用户
    @GetMapping("/delUser/{id}")
    public Result insertUser(@PathVariable("id")Long id){
        int i = userService.deleteUser(id);
        if (i==0){
            return Result.error("删除失败");
        }
        return Result.ok();
    }
    //修改用户权限
    @PostMapping("/updateAuthor/{id}")
    public Result updateUserAuthor(@PathVariable("id")Long userId,int type){
        int i = userService.updateUserAuthorization(userId, type);
        if (i==0){
            return Result.error("修改失败");
        }
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
