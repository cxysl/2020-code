package com.teastore.dao;

import com.teastore.po.Orderdetails;

import java.util.List;

public interface OrderdetailsDAO {
    public List<Orderdetails> queryAll();        //查所有

    public List<Orderdetails> queryAllOneOrders(String orderid);        //查一个订单所有商品明细

    public Orderdetails queryOne(Integer id);        //查单个

    public int insert(Orderdetails od);       //增

    public int update(Orderdetails od);       //改

    public int delete(Integer id);      //删
}
