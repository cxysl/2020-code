package com.teastore.dao;

import com.teastore.po.Shoppingcar;

import java.util.List;

public interface ShoppingcarDAO {
    public List<Shoppingcar> queryAll();        //查所有

    public List<Shoppingcar> queryOneUserinfoAll(Integer userid);        //查指定顾客购物车所有

    public Shoppingcar queryOne(Integer id);        //查单个

    public int insert(Shoppingcar shoppingcar);       //增

    public int update(Shoppingcar shoppingcar);       //改

    public int delete(Integer id);      //删
}
