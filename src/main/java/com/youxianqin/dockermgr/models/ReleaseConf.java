package com.youxianqin.dockermgr.models;

public class ReleaseConf {
    private Integer id;

    private Integer serviceId;

    private Integer faultTolerant;

    private Integer idcParalle;

    private Integer idcInnerParalle;

    private Integer timeOut;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getFaultTolerant() {
        return faultTolerant;
    }

    public void setFaultTolerant(Integer faultTolerant) {
        this.faultTolerant = faultTolerant;
    }

    public Integer getIdcParalle() {
        return idcParalle;
    }

    public void setIdcParalle(Integer idcParalle) {
        this.idcParalle = idcParalle;
    }

    public Integer getIdcInnerParalle() {
        return idcInnerParalle;
    }

    public void setIdcInnerParalle(Integer idcInnerParalle) {
        this.idcInnerParalle = idcInnerParalle;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }
}