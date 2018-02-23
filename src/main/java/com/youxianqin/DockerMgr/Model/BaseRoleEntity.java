package com.youxianqin.DockerMgr.Model;

public class BaseRoleEntity {
    private Long id;
    private String name;
    private Boolean available;
    private Boolean crossService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getCrossService() {
        return crossService;
    }

    public void setCrossService(Boolean crossService) {
        this.crossService = crossService;
    }

}
