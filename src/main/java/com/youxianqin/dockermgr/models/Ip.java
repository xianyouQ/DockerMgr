package com.youxianqin.dockermgr.models;

public class Ip {
    private Integer id;

    private Integer cidrId;

    private String ip;

    private String mac;

    private Boolean allocated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCidrId() {
        return cidrId;
    }

    public void setCidrId(Integer cidrId) {
        this.cidrId = cidrId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public Boolean getAllocated() {
        return allocated;
    }

    public void setAllocated(Boolean allocated) {
        this.allocated = allocated;
    }
}