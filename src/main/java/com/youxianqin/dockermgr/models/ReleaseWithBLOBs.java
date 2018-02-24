package com.youxianqin.dockermgr.models;

public class ReleaseWithBLOBs extends Release {
    private String releaseDetail;

    private String releaseResult;

    private String releaseMsg;

    public String getReleaseDetail() {
        return releaseDetail;
    }

    public void setReleaseDetail(String releaseDetail) {
        this.releaseDetail = releaseDetail == null ? null : releaseDetail.trim();
    }

    public String getReleaseResult() {
        return releaseResult;
    }

    public void setReleaseResult(String releaseResult) {
        this.releaseResult = releaseResult == null ? null : releaseResult.trim();
    }

    public String getReleaseMsg() {
        return releaseMsg;
    }

    public void setReleaseMsg(String releaseMsg) {
        this.releaseMsg = releaseMsg == null ? null : releaseMsg.trim();
    }
}