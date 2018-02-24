package com.youxianqin.dockermgr.models;

public class Idc {
    private Integer id;

    private String name;

    private String code;

    private Boolean available;

    private Integer marathonId;

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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getMarathonId() {
        return marathonId;
    }

    public void setMarathonId(Integer marathonId) {
        this.marathonId = marathonId;
    }
}