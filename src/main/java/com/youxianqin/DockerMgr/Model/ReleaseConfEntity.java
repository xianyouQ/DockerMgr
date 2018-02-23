package com.youxianqin.DockerMgr.Model;

public class ReleaseConfEntity {
    private Long id;
    private Long serviceId;
    private int faultTolerant;
    private int idcParalle;
    private int idcInnerParalle;
    private int timeOut;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public int getFaultTolerant() {
        return faultTolerant;
    }

    public void setFaultTolerant(int faultTolerant) {
        this.faultTolerant = faultTolerant;
    }

    public int getIdcParalle() {
        return idcParalle;
    }

    public void setIdcParalle(int idcParalle) {
        this.idcParalle = idcParalle;
    }

    public int getIdcInnerParalle() {
        return idcInnerParalle;
    }

    public void setIdcInnerParalle(int idcInnerParalle) {
        this.idcInnerParalle = idcInnerParalle;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }
}
