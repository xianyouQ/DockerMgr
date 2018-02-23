package com.youxianqin.DockerMgr.Model;

public class IpEntity {
    private  Long id;
    private String ip;
    private String mac;
    private Boolean allocated;
    private Long cidrId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Boolean getAllocated() {
        return allocated;
    }

    public void setAllocated(Boolean allocated) {
        this.allocated = allocated;
    }

    public Long getCidrId() {
        return cidrId;
    }

    public void setCidrId(Long cidrId) {
        this.cidrId = cidrId;
    }
}
