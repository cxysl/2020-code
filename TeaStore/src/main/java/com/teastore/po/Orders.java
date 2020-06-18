package com.teastore.po;

import java.io.Serializable;

public class Orders implements Serializable {
    private Integer id;

    private String orderid;

    private String userid;

    private String username;

    private Double orderprice;

    private String orderdate;

    private Integer orderstate;

    public Orders() {
    }

    public Orders(Integer id, String orderid, String userid, String username, Double orderprice, String orderdate, Integer orderstate) {
        this.id = id;
        this.orderid = orderid;
        this.userid = userid;
        this.username = username;
        this.orderprice = orderprice;
        this.orderdate = orderdate;
        this.orderstate = orderstate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(Double orderprice) {
        this.orderprice = orderprice;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate == null ? null : orderdate.trim();
    }

    public Integer getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderid='" + orderid + '\'' +
                ", userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", orderprice=" + orderprice +
                ", orderdate='" + orderdate + '\'' +
                ", orderstate=" + orderstate +
                '}';
    }
}