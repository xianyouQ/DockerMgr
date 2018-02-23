package com.youxianqin.DockerMgr.Model;

public class CidrEntity {

    private Long id;
    private String net;
    private String startIp;
    private String endIp;
    private Long idcId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getStartIp() {
        return startIp;
    }

    public void setStartIp(String startIp) {
        this.startIp = startIp;
    }

    public String getEndIp() {
        return endIp;
    }

    public void setEndIp(String endIp) {
        this.endIp = endIp;
    }

    public Long getIdcId() {
        return idcId;
    }

    public void setIdcId(Long idcId) {
        this.idcId = idcId;
    }
}
