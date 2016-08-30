package com.ycmedia.entity;

import java.util.Date;

/**
 * @author zhanglei
 * @description  订单表实体
 * @CreateTime  2016年8月29日13:58:04
 *
 */
public class Order {

    /**
     * id
     */
    private int id;

    /**
     * 用户id
     */
    private String uid;

    /**
     * 商户网站（自己系统）唯一订单号
     */
    private String outTradeNo;

    /**
     * 支付宝/微信交易号
     */
    private String tradeNo;

    /**
     * 订单金额  单位分
     */
    private int money;
    private String m;  //用列表显示

    /**
     * 订单标题
     */
    private String subject;

    /**
     * 广告详情
     */
    private String body;

    /**
     * 订单状态   0:未支付   1:支付成功  2：支付失败
     */
    private int state;

    /**
     * 支付方式  1:支付宝支付  2:微信支付
     */
    private int payType;

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

    public String getOutTradeNo() {return outTradeNo;}

    public void setOutTradeNo(String outTradeNo) {this.outTradeNo = outTradeNo;}

    public String getTradeNo() {return tradeNo;}

    public void setTradeNo(String tradeNo) {this.tradeNo = tradeNo;}

    public int getMoney() {return money;}

    public void setMoney(int money) {this.money = money;}

    public String getM() {return m;}

    public void setM(String m) {this.m = m;}

    public String getSubject() {return subject;}

    public void setSubject(String subject) {this.subject = subject;}

    public String getBody() {return body;}

    public void setBody(String body) {this.body = body;}

    public int getState() {return state;}

    public void setState(int state) {this.state = state;}

    public int getPayType() {return payType;}

    public void setPayType(int payType) {this.payType = payType;}

    public Date getCreateTime() {return createTime;}

    public void setCreateTime(Date createTime) {this.createTime = createTime;}

    public Date getUpdateTime() {return updateTime;}

    public void setUpdateTime(Date updateTime) {this.updateTime = updateTime;}
}
