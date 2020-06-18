package com.teastore.dao;

import com.teastore.po.Orders;

import java.util.List;

public interface OrdersDAO {

    public List<Orders> queryAll();        //查所有

    public List<Orders> queryOneUserAll(Integer id);        //查所有

    public Orders queryOne(Integer id);        //查单个

    public int insert(Orders orders);       //增

    public int update(Orders orders);       //改

    public int delete(Integer id);      //删
}
