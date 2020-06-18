package com.teastore.dao;

import com.teastore.po.Goods;

import java.util.List;

public interface GoodsDAO {
    public List<Goods> queryAll();        //查所有

    public Goods queryOne(Integer id);        //查单个

    public Goods queryOneByGoodscode(String goodscode);        //查单个

    public int insert(Goods goods);       //增

    public int update(Goods goods);       //改

    public int delete(Integer id);      //删
}
