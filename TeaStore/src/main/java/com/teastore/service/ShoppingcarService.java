package com.teastore.service;

import com.teastore.dao.ShoppingcarDAO;
import com.teastore.dao.impl.ShoppingcarDAOImpl;
import com.teastore.po.Shoppingcar;

import java.util.List;

public class ShoppingcarService {
    private ShoppingcarDAO dao = new ShoppingcarDAOImpl();

    public List<Shoppingcar> queryAll(){  //查
        return dao.queryAll();
    }   //查

    public List<Shoppingcar> queryOneUserinfoAll(Integer id){  //查一个订单所有商品明细
        return dao.queryOneUserinfoAll(id);
    }

    public Shoppingcar queryOne(Integer id){return dao.queryOne(id);}        //查单个

    public int addOD(Shoppingcar shoppingcar){  //增
        return dao.insert(shoppingcar);
    }   //增

    public int delOD(Integer id){   //删
        return dao.delete(id);
    }   //删

    public int updateOD(Shoppingcar shoppingcar){  //改
        return dao.update(shoppingcar);
    }   //改
}
