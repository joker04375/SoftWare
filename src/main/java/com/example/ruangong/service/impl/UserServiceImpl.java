package com.example.ruangong.service.impl;

import com.example.ruangong.dao.UserDao;
import com.example.ruangong.pojo.User;
import com.example.ruangong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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
    public List<User> selectById(Long id) {
        return userDao.selectById(id);
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
    public int register(String username, String password, String nickname, String email) {
        int user = userDao.register(username, password ,nickname, email);
        return user;
    }

    @Override
    public int deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int updateUserAuthorization(Long id, int status) {
        int i = userDao.updateUserAuthorization(id, status);
        return i;
    }

    @Override
    public int checkUserAndGoods(Long userId, Long goodsId) {
        return 0;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(Long userId) {
        List<User> userList = this.selectById(userId);
        User user = userList.get(0);
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
