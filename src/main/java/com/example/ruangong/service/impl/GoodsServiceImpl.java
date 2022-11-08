package com.example.ruangong.service.impl;

import com.example.ruangong.dao.GoodsDao;
import com.example.ruangong.pojo.Goods;
import com.example.ruangong.service.GoodsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> selectGoods(Long id) {
        return goodsDao.selectGoods(id);
    }

    @Override
    public int deleteGoods(Long id) {
        return goodsDao.deleteGoods(id);
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsDao.addGoods(goods);
    }

    @Override
    public int updateOnSale(Long id,Integer status) {
        return goodsDao.updateOnSale(id,status);
    }

    public void addGoods(File file){

    }
}
