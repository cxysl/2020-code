package com.teastore.po;

import java.io.Serializable;

public class Orderdetails implements Serializable {
    private Integer id;

    private String goodscode;

    private String goodsname;

    private Integer buycount;

    private Double goodsprice;

    private String orderid;

    public Orderdetails() {
    }

    public Orderdetails(Integer id, String goodscode, String goodsname, Integer buycount, Double goodsprice, String orderid) {
        this.id = id;
        this.goodscode = goodscode;
        this.goodsname = goodsname;
        this.buycount = buycount;
        this.goodsprice = goodsprice;
        this.orderid = orderid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodscode() {
        return goodscode;
    }

    public void setGoodscode(String goodscode) {
        this.goodscode = goodscode == null ? null : goodscode.trim();
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public Integer getBuycount() {
        return buycount;
    }

    public void setBuycount(Integer buycount) {
        this.buycount = buycount;
    }

    public Double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    @Override
    public String toString() {
        return "Orderdetails{" +
                "id=" + id +
                ", goodscode='" + goodscode + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", buycount=" + buycount +
                ", goodsprice=" + goodsprice +
                ", orderid='" + orderid + '\'' +
                '}';
    }
}