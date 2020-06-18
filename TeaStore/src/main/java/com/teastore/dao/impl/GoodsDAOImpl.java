package com.teastore.dao.impl;

import com.teastore.common.BaseDAO;
import com.teastore.dao.GoodsDAO;
import com.teastore.po.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAOImpl extends BaseDAO<Goods> implements GoodsDAO {

    @Override
    protected List<Goods> resultToList(ResultSet rs) throws SQLException {
        List<Goods> list = new ArrayList<>();
        while(rs.next())
        {
            Goods goods = new Goods();
            goods.setId(rs.getInt("id"));
            goods.setGoodscode(rs.getString("goodscode"));
            goods.setGoodsname(rs.getString("goodsname"));
            goods.setGoodstype(rs.getString("goodstype"));
            goods.setGoodspecs(rs.getString("goodspecs"));
            goods.setGoodsbrand(rs.getString("goodsbrand"));
            goods.setGoodspicture(rs.getString("goodspicture"));
            goods.setSaleprice(rs.getDouble("saleprice"));
            goods.setCount(rs.getInt("count"));
            goods.setIsonsale(rs.getString("isonsale"));
            goods.setGoodsdescribe(rs.getString("goodsdescribe"));
            list.add(goods);
        }
        return list;

    }

    @Override
    public List<Goods> queryAll() {
        String sql = "select * from goods";
        return this.exec_Query(sql,null,"查询茶叶信息表!!!!");
    }

    @Override
    public Goods queryOne(Integer id) {
        String sql = "select * from goods where id =?";
        Object[] objects = {id};
        List<Goods> list = exec_Query(sql,objects,"查单条数据");
        if(list.size()>0)
        {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Goods queryOneByGoodscode(String goodscode) {
        String sql = "select * from goods where goodscode =?";
        Object[] objects = {goodscode};
        List<Goods> list = exec_Query(sql,objects,"查单条数据");
        if(list.size()>0)
        {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int insert(Goods goods) {
        String sql = "insert into goods values(?,?,?,?,?,?,?,?,?,?,?)";
        Object[] objects = {
                goods.getId()
                ,goods.getGoodscode()
                ,goods.getGoodsname()
                ,goods.getGoodsbrand()
                ,goods.getGoodspicture()
                ,goods.getGoodspecs()
                ,goods.getGoodstype()
                ,goods.getSaleprice()
                ,goods.getCount()
                ,goods.getIsonsale()
                ,goods.getGoodsdescribe()
        };
        return this.exec_Update(sql,objects,"添加一条数据");
    }

    @Override
    public int update(Goods goods) {
        String sql = "update goods set goodscode=?,goodsname=?,goodstype=?,goodspecs=?,goodsbrand=?," +
                "goodspicture=?,saleprice=?,count=?,isonsale=?,goodsdescribe=? where id=?";
        Object[] objects = {
                goods.getGoodscode()
                ,goods.getGoodsname()
                ,goods.getGoodstype()
                ,goods.getGoodspecs()
                ,goods.getGoodsbrand()
                ,goods.getGoodspicture()
                ,goods.getSaleprice()
                ,goods.getCount()
                ,goods.getIsonsale()
                ,goods.getGoodsdescribe()
                ,goods.getId()
        };
        return this.exec_Update(sql,objects,"修改一条数据信息");
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from goods where id=?";
        return this.exec_Update(sql,new Object[]{id},"删除一条id是"+id+"的数据信息!!!!");
    }

}
