package com.teastore.po;

import java.io.Serializable;

public class Shoppingcar  implements Serializable {
    private Integer id;

    private String goodscode;

    private String goodsname;

    private String goodspicture;

    private Double goodsprice;

    private Integer buycount;

    private String goodsdescribe;

    private Integer userid;

    public Shoppingcar() {
    }

    public Shoppingcar(Integer id, String goodscode, String goodsname, String goodspicture, Double goodsprice, Integer buycount, String goodsdescribe, Integer userid) {
        this.id = id;
        this.goodscode = goodscode;
        this.goodsname = goodsname;
        this.goodspicture = goodspicture;
        this.goodsprice = goodsprice;
        this.buycount = buycount;
        this.goodsdescribe = goodsdescribe;
        this.userid = userid;
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
        this.goodscode = goodscode;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getGoodspicture() {
        return goodspicture;
    }

    public void setGoodspicture(String goodspicture) {
        this.goodspicture = goodspicture == null ? null : goodspicture.trim();
    }

    public Double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public Integer getBuycount() {
        return buycount;
    }

    public void setBuycount(Integer buycount) {
        this.buycount = buycount;
    }

    public String getGoodsdescribe() {
        return goodsdescribe;
    }

    public void setGoodsdescribe(String goodsdescribe) {
        this.goodsdescribe = goodsdescribe == null ? null : goodsdescribe.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Shoppingcar{" +
                "id=" + id +
                ", goodscode=" + goodscode +
                ", goodsname='" + goodsname + '\'' +
                ", goodspicture='" + goodspicture + '\'' +
                ", goodsprice=" + goodsprice +
                ", buycount=" + buycount +
                ", goodsdescribe='" + goodsdescribe + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }
}