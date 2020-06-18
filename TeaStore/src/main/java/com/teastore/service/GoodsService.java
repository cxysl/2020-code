package com.teastore.service;

import com.teastore.dao.GoodsDAO;
import com.teastore.dao.impl.GoodsDAOImpl;
import com.teastore.po.Goods;

import java.util.List;

public class GoodsService {

    private GoodsDAO dao = new GoodsDAOImpl();

    public List<Goods> queryAll(){  //查
        return dao.queryAll();
    }   //查

    public Goods queryOne(Integer id){return dao.queryOne(id);};        //查单个

    public Goods queryOneByGoodscode(String goodscode){return dao.queryOneByGoodscode(goodscode);};        //查单个

    public int addGoods(Goods user){  //增
        return dao.insert(user);
    }   //增

    public int delGoods(Integer id){   //删
        return dao.delete(id);
    }   //删

    public int updateGoods(Goods user){  //改
        return dao.update(user);
    }   //改

}
