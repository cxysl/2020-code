package com.teastore.service;



import com.teastore.dao.UserinfoDAO;
import com.teastore.dao.impl.UserinfoDAOlmpl;
import com.teastore.po.Userinfo;

import java.util.List;

public class UserinfoService {

    private UserinfoDAO dao = new UserinfoDAOlmpl();

    public Userinfo doLogin(String uname, String pwd){
        return dao.loginByUser(uname,pwd);
    }       //验证用户名和密码

    public List<Userinfo> queryAll(){  //查
        return dao.queryAll();
    }   //查

    public Userinfo queryOne(Integer id){return dao.queryOne(id);}       //查单个

    public Userinfo queryOneByOrders(String userid){return dao.queryOneByOrders(userid);}

    public int addUser(Userinfo user){  //增
        return dao.insert_UserInfo(user);
    }   //增

    public int delUser(Integer id){   //删
        return dao.delete_UserInfo(id);
    }   //删

    public int updateUser(Userinfo user){  //改
        return dao.update_UserInfo(user);
    }   //改
}
