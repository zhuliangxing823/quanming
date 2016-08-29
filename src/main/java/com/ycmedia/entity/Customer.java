package com.ycmedia.entity;

import java.util.Date;

/**
 * @author zhagnlei
 * @description  客户实体类
 * @CreateTime  2016年8月25日10:42:51
 *
 */
public class Customer {

    /**
     * id
     */
    private int id;

    /**
     * 客户id
     */
    private String uid;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 密钥
     */
    private String token;

    /**
     * 总充值金额  单位是分
     */
    private double doubleSumMoney;

    /**
     * 总充值金额  单位是分
     */
    private long sumMoney;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getUid() {return uid;}

    public void setUid(String uid) {this.uid = uid;}

    public String getMobile() {return mobile;}

    public void setMobile(String mobile) {this.mobile = mobile;}

    public String getToken() {return token;}

    public void setToken(String token) {this.token = token;}

    public double getDoubleSumMoney() {return doubleSumMoney;}

    public void setDoubleSumMoney(double doubleSumMoney) {this.doubleSumMoney = doubleSumMoney;}

    public long getSumMoney() {return sumMoney;}

    public void setSumMoney(long sumMoney) {this.sumMoney = sumMoney;}

    public Date getCreateTime() {return createTime;}

    public void setCreateTime(Date createTime) {this.createTime = createTime;}

    public Date getUpdateTime() {return updateTime;}

    public void setUpdateTime(Date updateTime) {this.updateTime = updateTime;}

}
