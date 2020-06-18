package com.teastore.service;

import com.teastore.dao.OrdersDAO;
import com.teastore.dao.impl.OrderDAOImpl;
import com.teastore.po.Orders;

import java.util.List;

public class OrdersService {
    private OrdersDAO dao = new OrderDAOImpl();

    public List<Orders> queryAll(){  //查
        return dao.queryAll();
    }
    public List<Orders> queryOneUserAll(Integer id){  //查某个用户的全部订单
        return dao.queryOneUserAll(id);
    }

    public Orders queryOne(Integer id){return dao.queryOne(id);}        //查单个

    public int addOrders(Orders orders){  //增
        return dao.insert(orders);
    }   //增

    public int delOrders(Integer id){   //删
        return dao.delete(id);
    }   //删

    public int updateOrders(Orders orders){  //改
        return dao.update(orders);
    }   //改
}










