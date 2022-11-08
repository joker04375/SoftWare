package com.example.ruangong.dao;

import com.example.ruangong.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    List<User> selectById(Long id);

    User login(@Param("username") String username,@Param("password") String password);

    int register(@Param("username") String username, @Param("password") String password,@Param("nickname")String name,@Param("email")String email);

    int insertUser(User user);

    int deleteUser(Long id);

    int updateUser(User user);

    int updateUserAuthorization(@Param("id") Long id,@Param("type") int type);

    int checkUserAndGoods(Long userId,Long goodsId);
}
