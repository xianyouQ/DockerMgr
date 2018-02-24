package com.youxianqin.dockermgr.models;

import java.util.List;

public class BaseRole {
    private Integer id;

    private String name;

    private Boolean available;

    private Boolean crossService;

    private List<Permission> permissionList;

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

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}