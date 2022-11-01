package com.example.ruangong.pojo;

import lombok.Data;

@Data
public class User {
    private Long id;
    //用户名
    private String username;
    //昵称
    private String nickName;
    //密码
    private String password;
    //邮箱
    private String email;
    //权限标识
    private int type;

    private Integer deleted;
}
