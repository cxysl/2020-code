package com.teastore.dao.impl;

import com.teastore.common.BaseDAO;
import com.teastore.dao.UserinfoDAO;
import com.teastore.po.Userinfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserinfoDAOlmpl extends BaseDAO<Userinfo> implements UserinfoDAO {

    /**
     * 查所有
     */
    public List<Userinfo> queryAll() {
        String sql = "select * from userinfo";
        return this.exec_Query(sql,null,"查询顾客表信息!!!!");
    }


    /**
     * 查单个
     */
    @Override
    public Userinfo queryOne(Integer id) {
        String sql = "select * from userinfo where id =?";
        Object[] objects = {id};
        List<Userinfo> list = exec_Query(sql,objects,"查单个顾客");
        if(list.size()>0)
        {
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据订单中的userid查下单的顾客
     */
    @Override
    public Userinfo queryOneByOrders(String userid) {
        String sql = "select * from userinfo where userId =?";
        Object[] objects = {userid};
        List<Userinfo> list = exec_Query(sql,objects,"查单个顾客");
        if(list.size()>0)
        {
            return list.get(0);
        }
        return null;
    }

    /**
     * 增
     */
    public int insert_UserInfo(Userinfo user) {
        String sql = "insert into userinfo values(?,?,?,?,?,?,?,?)";
        Object[] objects = {
                user.getId()
                ,user.getUserid()
                ,user.getAccountnumber()
                ,user.getPwd()
                ,user.getIsadmin()
                ,user.getUsername()
                ,user.getAddress()
                ,user.getPhone()
        };
        return this.exec_Update(sql,objects,"添加顾客表信息!!!!");
    }

    /**
     *改
     */
    public int update_UserInfo(Userinfo user) {
        String sql = "update userinfo set userid=?,accountnumber=?,pwd=?,isadmin=?,username=?,address=?,phone=? where id=?";
        Object[] objects = {
                user.getUserid()
                ,user.getAccountnumber()
                ,user.getPwd()
                ,user.getIsadmin()
                ,user.getUsername()
                ,user.getAddress()
                ,user.getPhone()
                ,user.getId()
        };
        return this.exec_Update(sql,objects,"修改顾客信息!!!!");
    }

    /**
     * 删
     */
    public int delete_UserInfo(Integer id) {
        String sql = "delete from userinfo where id=?";
        return this.exec_Update(sql,new Object[]{id},"删除用户id是"+id+"的用户信息!!!!");
    }

    /**
     * 验证账户和密码（查部分）
     */
    public Userinfo loginByUser(String accountnumber, String pwd) {
        String sql = "select * from userinfo where accountnumber=? and pwd=?";
        Object[] objects = {accountnumber, pwd};
        List<Userinfo> list = exec_Query(sql,objects,"用户登录!!!");

        if(list.size()>0)
        {
            return list.get(0);
        }
        return null;
    }



    protected List<Userinfo> resultToList(ResultSet rs) throws SQLException {
        List<Userinfo> list = new ArrayList<>();
        while(rs.next())
        {
            Userinfo user = new Userinfo();
            user.setId(rs.getInt("id"));
            user.setUserid(rs.getString("userid"));
            user.setAccountnumber(rs.getString("accountnumber"));
            user.setPwd(rs.getString("pwd"));
            user.setIsadmin(rs.getInt("isadmin"));
            user.setUsername(rs.getString("username"));
            user.setAddress(rs.getString("address"));
            user.setPhone(rs.getString("phone"));
            list.add(user);
        }
        return list;
    }
}