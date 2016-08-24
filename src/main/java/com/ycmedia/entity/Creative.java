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
     * 发布状态 0  未发布， 1 发布， 3 删除
     */
    private String publishStatus;

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


    
    


}