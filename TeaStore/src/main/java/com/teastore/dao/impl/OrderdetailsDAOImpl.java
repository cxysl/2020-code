package com.teastore.dao.impl;

import com.teastore.common.BaseDAO;
import com.teastore.dao.OrderdetailsDAO;
import com.teastore.po.Orderdetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderdetailsDAOImpl extends BaseDAO<Orderdetails> implements OrderdetailsDAO {
    @Override
    protected List<Orderdetails> resultToList(ResultSet rs) throws SQLException {
        List<Orderdetails> list = new ArrayList<>();
        while(rs.next())
        {
            Orderdetails od = new Orderdetails();
            od.setId(rs.getInt("id"));
            od.setGoodscode(rs.getString("goodscode"));
            od.setGoodsname(rs.getString("goodsname"));
            od.setBuycount(rs.getInt("buycount"));
            od.setGoodsprice(rs.getDouble("goodsprice"));
            od.setOrderid(rs.getString("orderid"));
            list.add(od);
        }
        return list;
    }

    @Override
    public List<Orderdetails> queryAll() {
        String sql = "select * from orderDetails";
        return this.exec_Query(sql,null,"查询所有");
    }

    @Override
    public List<Orderdetails> queryAllOneOrders(String orderid) {
        String sql = "select * from orderDetails where orderId =?";
        Object[] objects = {orderid};
        return this.exec_Query(sql,objects,"查询同一个订单的所有明细");
    }

    @Override
    public Orderdetails queryOne(Integer id) {
        String sql = "select * from orderDetails where id =?";
        Object[] objects = {id};
        List<Orderdetails> list = exec_Query(sql,objects,"查单条数据");
        if(list.size()>0)
        {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int insert(Orderdetails od) {
        String sql = "insert into orderDetails values(?,?,?,?,?,?)";
        Object[] objects = {
                od.getId()
                ,od.getGoodscode()
                ,od.getGoodsname()
                ,od.getBuycount()
                ,od.getGoodsprice()
                ,od.getOrderid()
        };
        return this.exec_Update(sql,objects,"添加一条数据");
    }

    @Override
    public int update(Orderdetails od) {
        String sql = "update orderDetails set goodscode=?,goodsname=?,buycount=?,goodsprice=?,orderid=? where id=?";
        Object[] objects = {
                od.getGoodscode()
                ,od.getGoodsname()
                ,od.getBuycount()
                ,od.getGoodsprice()
                ,od.getOrderid()
                ,od.getId()
        };
        return this.exec_Update(sql,objects,"修改一条数据信息");
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from orderDetails where id=?";
        return this.exec_Update(sql,new Object[]{id},"删除一条id是"+id+"的数据信息!!!!");
    }
}
