package com.example.ruangong;

import com.example.ruangong.dao.GoodsDao;
import com.example.ruangong.pojo.Goods;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

public class GoodsTest {
    @Resource
    private GoodsDao goodsDao;

    @Test
    void insertGoods() {
        Goods goods = new Goods();
        goods.setName("qq糖");
        goods.setNum(10);
        goods.setOnSale(0);
        goods.setPrice(1.0);
        goods.setOwnSpec("好吃有好玩");
        int i = goodsDao.addGoods(goods);
        if(i==0){
            System.out.println("插入失败");
        }
        System.out.println("插入成功");
    }


    @Test
    void selectGoods() {
        List<Goods> goods = goodsDao.selectGoods(null);
        System.out.println(goods);
    }

}
