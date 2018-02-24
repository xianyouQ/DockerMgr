package com.youxianqin.dockermgr.models;

public class Service {
    private Integer id;

    private String name;

    private String code;

    private Integer releaseVerId;

    private String marathonConf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getReleaseVerId() {
        return releaseVerId;
    }

    public void setReleaseVerId(Integer releaseVerId) {
        this.releaseVerId = releaseVerId;
    }

    public String getMarathonConf() {
        return marathonConf;
    }

    public void setMarathonConf(String marathonConf) {
        this.marathonConf = marathonConf == null ? null : marathonConf.trim();
    }
}