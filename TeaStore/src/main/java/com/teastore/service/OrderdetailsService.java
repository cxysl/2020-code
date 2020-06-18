package com.teastore.service;

import com.teastore.dao.OrderdetailsDAO;
import com.teastore.dao.impl.OrderdetailsDAOImpl;
import com.teastore.po.Orderdetails;

import java.util.List;

public class OrderdetailsService {
    private OrderdetailsDAO dao = new OrderdetailsDAOImpl();

    public List<Orderdetails> queryAll(){  //查
        return dao.queryAll();
    }   //查

    public List<Orderdetails> queryAllOneOrders(String orderid){  //查一个订单所有商品明细
        return dao.queryAllOneOrders(orderid);
    }

    public Orderdetails queryOne(Integer id){return dao.queryOne(id);}        //查单个

    public int addOD(Orderdetails od){  //增
        return dao.insert(od);
    }   //增

    public int delOD(Integer id){   //删
        return dao.delete(id);
    }   //删

    public int updateOD(Orderdetails od){  //改
        return dao.update(od);
    }   //改
}
