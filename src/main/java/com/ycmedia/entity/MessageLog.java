package com.ycmedia.entity;

import java.util.Date;

/**
 * @author zhanglei
 * @description  信息表
 * @CreateTime  2016年8月29日13:58:04
 *
 */
public class MessageLog {

    /**
     * id
     */
    private int id;

    /**
     * 信息
     */
    private String message;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 返回状态码
     */
    private String code;

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

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

    public String getMobile() {return mobile;}

    public void setMobile(String mobile) {this.mobile = mobile;}

    public String getCode() {return code;}

    public void setCode(String code) {this.code = code;}

    public Date getCreateTime() {return createTime;}

    public void setCreateTime(Date createTime) {this.createTime = createTime;}

    public Date getUpdateTime() {return updateTime;}

    public void setUpdateTime(Date updateTime) {this.updateTime = updateTime;}
}
