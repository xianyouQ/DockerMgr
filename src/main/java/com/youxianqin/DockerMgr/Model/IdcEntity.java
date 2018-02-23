package com.youxianqin.DockerMgr.Model;

public class IdcEntity {
    private Long id;
    private Boolean available;
    private String name;
    private String code;
    private Long marathonId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getMarathonId() {
        return marathonId;
    }

    public void setMarathonId(Long marathonId) {
        this.marathonId = marathonId;
    }
}
