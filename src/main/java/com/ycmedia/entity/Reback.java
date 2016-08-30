package com.ycmedia.entity;

import java.util.Date;

/**
 * @author zhanglei
 * @description  意见反馈实体
 * @CreateTime  2016年8月29日14:50:19
 *
 */
public class Reback {

    /**
     * id
     */
    private int id;

    /**
     * 客户id
     */
    private String uid;

    /**
     * 返回信息
     */
    private String reback;

    /**
     * 手机号
     */
    private String mobile;

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

    public String getReback() {return reback;}

    public void setReback(String reback) {this.reback = reback;}

    public String getMobile() {return mobile;}

    public void setMobile(String mobile) {this.mobile = mobile;}

    public Date getCreateTime() {return createTime;}

    public void setCreateTime(Date createTime) {this.createTime = createTime;}

    public Date getUpdateTime() {return updateTime;}

    public void setUpdateTime(Date updateTime) {this.updateTime = updateTime;}
}
