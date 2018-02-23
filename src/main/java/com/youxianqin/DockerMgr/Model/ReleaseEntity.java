package com.youxianqin.DockerMgr.Model;


public class ReleaseEntity {
    private Long id;
    private Long releaseConfId;
    private Time releaseTime;
    private Time operationTime;
    private Long serviceId;
    private String version;
    private Long releaseUserId;
    private Long operationUserId;
    private Long reviewUserId;
    private Time reviewTime;
    private int taskStatus;
    private Long cancelUserId;
    private String releaseDetail;
    private String releaseResult;
    private String releaseMsg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReleaseConfId() {
        return releaseConfId;
    }

    public void setReleaseConfId(Long releaseConfId) {
        this.releaseConfId = releaseConfId;
    }

    public Time getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Time releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Time getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Time operationTime) {
        this.operationTime = operationTime;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getReleaseUserId() {
        return releaseUserId;
    }

    public void setReleaseUserId(Long releaseUserId) {
        this.releaseUserId = releaseUserId;
    }

    public Long getOperationUserId() {
        return operationUserId;
    }

    public void setOperationUserId(Long operationUserId) {
        this.operationUserId = operationUserId;
    }

    public Long getReviewUserId() {
        return reviewUserId;
    }

    public void setReviewUserId(Long reviewUserId) {
        this.reviewUserId = reviewUserId;
    }

    public Time getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Time reviewTime) {
        this.reviewTime = reviewTime;
    }

    public int getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(int taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Long getCancelUserId() {
        return cancelUserId;
    }

    public void setCancelUserId(Long cancelUserId) {
        this.cancelUserId = cancelUserId;
    }

    public String getReleaseDetail() {
        return releaseDetail;
    }

    public void setReleaseDetail(String releaseDetail) {
        this.releaseDetail = releaseDetail;
    }

    public String getReleaseResult() {
        return releaseResult;
    }

    public void setReleaseResult(String releaseResult) {
        this.releaseResult = releaseResult;
    }

    public String getReleaseMsg() {
        return releaseMsg;
    }

    public void setReleaseMsg(String releaseMsg) {
        this.releaseMsg = releaseMsg;
    }
}
