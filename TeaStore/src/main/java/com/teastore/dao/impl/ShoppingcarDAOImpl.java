package com.teastore.dao.impl;

import com.teastore.common.BaseDAO;
import com.teastore.dao.ShoppingcarDAO;
import com.teastore.po.Shoppingcar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingcarDAOImpl extends BaseDAO<Shoppingcar> implements ShoppingcarDAO {
    @Override
    protected List<Shoppingcar> resultToList(ResultSet rs) throws SQLException {
        List<Shoppingcar> list = new ArrayList<>();
        while(rs.next())
        {
            Shoppingcar car = new Shoppingcar();
            car.setId(rs.getInt("id"));
            car.setGoodscode(rs.getString("goodscode"));
            car.setGoodsname(rs.getString("goodsname"));
            car.setGoodspicture(rs.getString("goodspicture"));
            car.setGoodsprice(rs.getDouble("goodsprice"));
            car.setBuycount(rs.getInt("buycount"));
            car.setGoodsdescribe(rs.getString("goodsdescribe"));
            car.setUserid(rs.getInt("userid"));
            list.add(car);
        }
        return list;
    }

    @Override
    public List<Shoppingcar> queryAll() {
        String sql = "select * from shoppingcar";
        return this.exec_Query(sql,null,"查询所有");
    }

    @Override
    public List<Shoppingcar> queryOneUserinfoAll(Integer id) {
        String sql = "select * from shoppingcar where userId =?";
        Object[] objects = {id};
        return this.exec_Query(sql,objects,"查询指定顾客的所有购物车记录");
    }

    @Override
    public Shoppingcar queryOne(Integer id) {
        String sql = "select * from shoppingcar where id =?";
        Object[] objects = {id};
        List<Shoppingcar> list = exec_Query(sql,objects,"查单条数据");
        if(list.size()>0)
        {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int insert(Shoppingcar shoppingcar) {
        String sql = "insert into shoppingcar values(?,?,?,?,?,?,?,?)";
        Object[] objects = {
                shoppingcar.getId()
                ,shoppingcar.getGoodscode()
                ,shoppingcar.getGoodsname()
                ,shoppingcar.getGoodspicture()
                ,shoppingcar.getGoodsprice()
                ,shoppingcar.getBuycount()
                ,shoppingcar.getGoodsdescribe()
                ,shoppingcar.getUserid()
        };
        return this.exec_Update(sql,objects,"添加一条数据");
    }

    @Override
    public int update(Shoppingcar shoppingcar) {
        String sql = "update shoppingcar set goodscode=?,goodsname=?,goodspicture=?,goodsprice=?,buycount=?,goodsdescribe=?,userid=? where id=?";
        Object[] objects = {
                shoppingcar.getGoodscode()
                ,shoppingcar.getGoodsname()
                ,shoppingcar.getGoodspicture()
                ,shoppingcar.getGoodsprice()
                ,shoppingcar.getBuycount()
                ,shoppingcar.getGoodsdescribe()
                ,shoppingcar.getUserid()
                ,shoppingcar.getId()
        };
        return this.exec_Update(sql,objects,"修改一条数据信息");
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from shoppingcar where id=?";
        return this.exec_Update(sql,new Object[]{id},"删除一条id是"+id+"的数据信息!!!!");
    }
}
