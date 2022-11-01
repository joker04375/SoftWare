package com.example.ruangong.service.impl;

import com.example.ruangong.dao.GoodsDao;
import com.example.ruangong.pojo.Goods;
import com.example.ruangong.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    @Override
    public List<Goods> selectGoods(Long id) {
        return null;
    }

    @Override
    public int deleteGoods(Long id) {
        return 0;
    }

    @Override
    public int addGoods(Goods goods) {
        return 0;
    }

    @Override
    public int updateOnSale(Integer status) {
        return 0;
    }

    public void addGoods(File file){

    }
}
