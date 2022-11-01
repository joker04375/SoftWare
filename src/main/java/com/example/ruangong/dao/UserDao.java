package com.example.ruangong.dao;

import com.example.ruangong.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    User selectById(Long id);

    User login(@Param("username") String username,@Param("password") String password);

    int insertUser(String username, String password);

    int deleteUser(Long id);

    int updateUser(User user);

    int updateUserAuthorization(Long id,int type);

    int checkUserAndGoods(Long userId,Long goodsId);
}
