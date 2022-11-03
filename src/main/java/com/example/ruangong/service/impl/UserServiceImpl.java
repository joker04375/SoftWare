package com.example.ruangong.service.impl;

import com.example.ruangong.dao.UserDao;
import com.example.ruangong.pojo.User;
import com.example.ruangong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        User user = userDao.login(username, password);
        return user;
    }

    @Override
    public User selectById(Long id) {
        return null;
    }

    @Override
    public void logout(String token) {

    }

    @Override
    public int insertUser(User user) {
        int i = userDao.insertUser(user);
        return i;
    }

    @Override
    public int register(String username, String password, String name, String email) {
        int user = userDao.register(username, password ,name, email);
        return user;
    }

    @Override
    public int deleteUser(Long id) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int updateUserAuthorization(Long id, int status) {
        return 0;
    }

    @Override
    public int checkUserAndGoods(Long userId, Long goodsId) {
        return 0;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(Long userId) {
        User user = this.selectById(userId);

        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                switch (user.getType()) {
                    case 1:
                        return "author";
                    case 2:
                        return "super";
                    default:
                        return "normal";
                }
            }
        });
        return list;
    }
}
