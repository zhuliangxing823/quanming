package com.ycmedia.entity;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author zhuliangxing
 * 创意
 *
 */
public class Creative {
	

    /**
     * 广告ID
     */
    private int adId;

    /**
     * 用户ID
     */
    private String uid;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 图片地址
     */
    private String loadingPage;

    //审核理由
    private String auditReason;
    //审核修改
    private String additShow;

    /**
     * 更新时间
     */
    private Date updateTime;
    
    private Date publishTime;
    /**
     * 投放状态
     */
    private String status ;
    
    
    /**
     * 审核状态
     */
    private String auditStatus;
    

    /**
     * 发布状态 0  未发布， 1 发布， 3 删除
     */
    private String publishStatus;
    
    
    private String address;
    
    private String lonLa;
    

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLoadingPage() {
		return loadingPage;
	}

	public void setLoadingPage(String loadingPage) {
		this.loadingPage = loadingPage;
	}

	public String getAuditReason() {
		return auditReason;
	}

	public void setAuditReason(String auditReason) {
		this.auditReason = auditReason;
	}

	public String getAdditShow() {
		return additShow;
	}

	public void setAdditShow(String additShow) {
		this.additShow = additShow;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPublishStatus() {
		if(this.publishStatus.equals("0")){
			return "未发布";
		}else if(this.publishStatus.equals("1")){
			return "已发布";
		}else{
			return "删除";
		}
	}

	public void setPublishStatus(String publishStatus) {
		this.publishStatus = publishStatus;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getStatus() {
		if(status.equals("0")){
			return "待投放";
		}else if(status.equals("1")){
			return "投放中";
		} else if(status.equals("2")){
			return "暂停";
		}else{
		  return "投放结束";
		}
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAuditStatus() {
		if(auditStatus.equals("0")){
			return "未审核";
		}else if(auditStatus.equals("1")){
			return "审核通过";
		}else{
			return "审核失败";
		}
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLonLa() {
		return lonLa;
	}

	public void setLonLa(String lonLa) {
		this.lonLa = lonLa;
	}


    
    


}