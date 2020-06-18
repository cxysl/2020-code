package com.teastore.dao.impl;

import com.teastore.common.BaseDAO;
import com.teastore.dao.OrdersDAO;
import com.teastore.po.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl extends BaseDAO<Orders> implements OrdersDAO {

    @Override
    protected List<Orders> resultToList(ResultSet rs) throws SQLException {
        List<Orders> list = new ArrayList<>();
        while(rs.next())
        {
            Orders orders = new Orders();
            orders.setId(rs.getInt("id"));
            orders.setOrderid(rs.getString("orderid"));
            orders.setUserid(rs.getString("userid"));
            orders.setUsername(rs.getString("username"));
            orders.setOrderprice(rs.getDouble("orderprice"));
            orders.setOrderdate(rs.getString("orderdate"));
            orders.setOrderstate(rs.getInt("orderstate"));
            list.add(orders);
        }
        return list;
    }

    @Override
    public List<Orders> queryAll() {
        String sql = "select * from orders";
        return this.exec_Query(sql,null,"查询所有");
    }

    @Override
    public List<Orders> queryOneUserAll(Integer id) {
        String sql = "select * from orders where userId =?";
        Object[] objects = {id};
        return this.exec_Query(sql,objects,"查询某用户所有");
    }

    @Override
    public Orders queryOne(Integer id) {
        String sql = "select * from orders where orderId =?";
        Object[] objects = {id};
        List<Orders> list = exec_Query(sql,objects,"查单条数据");
        if(list.size()>0)
        {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int insert(Orders orders) {
        String sql = "insert into orders values(?,?,?,?,?,?,?)";
        Object[] objects = {
                orders.getId()
                ,orders.getOrderid()
                , orders.getUserid()
                ,orders.getUsername()
                ,orders.getOrderprice()
                ,orders.getOrderdate()
                ,orders.getOrderstate()
        };
        return this.exec_Update(sql,objects,"添加一条数据");
    }

    @Override
    public int update(Orders orders) {
        String sql = "update orders set orderid=?,userid=?,username=?,orderprice=?,orderdate=?," +
                "orderstate=? where id=?";
        Object[] objects = {
                orders.getOrderid()
                , orders.getUserid()
                ,orders.getUsername()
                ,orders.getOrderprice()
                ,orders.getOrderdate()
                ,orders.getOrderstate()
                ,orders.getId()
        };
        return this.exec_Update(sql,objects,"修改一条数据信息");
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from orders where id=?";
        return this.exec_Update(sql,new Object[]{id},"删除一条id是"+id+"的数据信息!!!!");
    }
}
