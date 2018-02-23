package com.youxianqin.DockerMgr.Model;

public class BaseRolePermissEntity {
    private Long id;
    private Long baseRoleId;
    private Long permissionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBaseRoleId() {
        return baseRoleId;
    }

    public void setBaseRoleId(Long baseRoleId) {
        this.baseRoleId = baseRoleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
