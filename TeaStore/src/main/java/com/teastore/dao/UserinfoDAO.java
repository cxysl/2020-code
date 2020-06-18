package com.teastore.dao;


import com.teastore.po.Userinfo;

import java.util.List;

public interface UserinfoDAO {
    public List<Userinfo> queryAll();        //查所有

    public Userinfo queryOne(Integer id);        //查单个

    public Userinfo queryOneByOrders(String userid);        //查单个

    public int insert_UserInfo(Userinfo user);       //增

    public int update_UserInfo(Userinfo user);       //改

    public int delete_UserInfo(Integer id);      //删

    public Userinfo loginByUser(String accountnumber, String pwd);     //验证账户密码
}
