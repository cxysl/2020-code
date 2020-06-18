package com.teastore.po;

import java.io.Serializable;

public class Userinfo implements Serializable {
    private Integer id;

    private String userid;

    private String accountnumber;

    private String pwd;

    private Integer isadmin;

    private String username;

    private String address;

    private String phone;

    public Userinfo() {
    }

    public Userinfo(Integer id, String userid, String accountnumber, String pwd, Integer isadmin, String username, String address, String phone) {
        this.id = id;
        this.userid = userid;
        this.accountnumber = accountnumber;
        this.pwd = pwd;
        this.isadmin = isadmin;
        this.username = username;
        this.address = address;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber == null ? null : accountnumber.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Integer getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Integer isadmin) {
        this.isadmin = isadmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", accountnumber='" + accountnumber + '\'' +
                ", pwd='" + pwd + '\'' +
                ", isadmin=" + isadmin +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}