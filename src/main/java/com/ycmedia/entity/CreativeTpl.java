package com.ycmedia.entity;


public class CreativeTpl {

    /**
     * ID 
     */
    private int id;

    /**
     * 模板类型说明
     */
    private String info;

    /**
     * 模板图片URL
     */
    private String url;

    /**
     * 预留:广告（项目）类型
     */
    private int adType;

    /**
     * 排序
     */
    private int ord;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAdType() {
        return adType;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public int getOrd() {
        return ord;
    }

    public void setOrd(int ord) {
        this.ord = ord;
    }
}
