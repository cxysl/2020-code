package com.teastore.po;

import java.io.Serializable;

public class Goods implements Serializable {
    private Integer id;

    private String goodscode;

    private String goodsname;

    private String goodstype;

    private String goodspecs;

    private String goodsbrand;

    private String goodspicture;

    private Double saleprice;

    private Integer count;

    private String isonsale;

    private String goodsdescribe;


    public Goods() {
    }

    public Goods(Integer id, String goodscode, String goodsname, String goodstype, String goodspecs, String goodsbrand, String goodspicture, Double saleprice, Integer count, String isonsale, String goodsdescribe) {
        this.id = id;
        this.goodscode = goodscode;
        this.goodsname = goodsname;
        this.goodstype = goodstype;
        this.goodspecs = goodspecs;
        this.goodsbrand = goodsbrand;
        this.goodspicture = goodspicture;
        this.saleprice = saleprice;
        this.count = count;
        this.isonsale = isonsale;
        this.goodsdescribe = goodsdescribe;
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
        this.goodsname = goodsname;
    }

    public String getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(String goodstype) {
        this.goodstype = goodstype;
    }

    public String getGoodspecs() {
        return goodspecs;
    }

    public void setGoodspecs(String goodspecs) {
        this.goodspecs = goodspecs;
    }

    public String getGoodsbrand() {
        return goodsbrand;
    }

    public void setGoodsbrand(String goodsbrand) {
        this.goodsbrand = goodsbrand;
    }

    public String getGoodspicture() {
        return goodspicture;
    }

    public void setGoodspicture(String goodspicture) {
        this.goodspicture = goodspicture;
    }

    public Double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Double saleprice) {
        this.saleprice = saleprice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getIsonsale() {
        return isonsale;
    }

    public void setIsonsale(String isonsale) {
        this.isonsale = isonsale;
    }

    public String getGoodsdescribe() {
        return goodsdescribe;
    }

    public void setGoodsdescribe(String goodsdescribe) {
        this.goodsdescribe = goodsdescribe;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodscode='" + goodscode + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", goodstype='" + goodstype + '\'' +
                ", goodspecs='" + goodspecs + '\'' +
                ", goodsbrand='" + goodsbrand + '\'' +
                ", goodspicture='" + goodspicture + '\'' +
                ", saleprice=" + saleprice +
                ", count=" + count +
                ", isonsale='" + isonsale + '\'' +
                ", goodsdescribe='" + goodsdescribe + '\'' +
                '}';
    }
}