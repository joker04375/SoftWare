package com.example.ruangong.service;

import com.example.ruangong.pojo.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;


public interface UserService {
    //  登录
    User login(String username, String password);

    //根据id查询用户
    List<User> selectById(Long id);

    //登出
    void logout(String token);

    //插入用户
    int insertUser(User user);

    int register(String username, String password,String name,String email);

    //删除用户
    int deleteUser(Long id);

    //更新用户
    int updateUser(User user);

    //更新用户权限
    int updateUserAuthorization(Long id,int type);

    //更改商品是否展示
    int checkUserAndGoods(Long userId,Long goodsId);

    //查询用户权限
    Collection<? extends GrantedAuthority> getAuthorities(Long userId);
}
