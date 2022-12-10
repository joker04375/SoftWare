package com.example.ruangong.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Cart {
    private Long id;

    private Long userId;

    private Long goodsId;

    private Double price;
    //数目
    private Integer num;
    //详情
    private String ownSpec;
    //标题
    private String title;
    //图片
    private String image;
    //是否支付
    private Integer isPayment;

    private Integer deleted;

    private Goods goods;
}
