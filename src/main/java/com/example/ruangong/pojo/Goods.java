package com.example.ruangong.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Goods {
    private Long id;

    private String name;

    private Double price;
    // 库存
    private Integer num;
    // 是否展示商品
    private Integer onSale;
    //详情
    private String ownSpec;
    //图片
    private String img;
    private Integer deleted;
}
