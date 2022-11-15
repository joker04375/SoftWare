package com.example.ruangong;

import com.example.ruangong.dao.UserDao;
import com.example.ruangong.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

public class userTest {
    @Resource
    private UserDao userDao;

    @Test
    private void selectUser(){
        List<User> userList = userDao.selectById(2L);
        System.out.println(1);
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
