package com.youxianqin.dockermgr.models;

public class BaseRolePermission {
    private Integer id;

    private Integer baseRoleId;

    private Integer permissionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBaseRoleId() {
        return baseRoleId;
    }

    public void setBaseRoleId(Integer baseRoleId) {
        this.baseRoleId = baseRoleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}