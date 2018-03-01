package com.youxianqin.dockermgr.service;

import com.youxianqin.dockermgr.dao.BaseRolePermissionMapper;
import com.youxianqin.dockermgr.dao.PermissionMapper;

import com.youxianqin.dockermgr.models.Permission;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PermissionService {
    @Inject
    private PermissionMapper permissionMapper;

    @Inject
    BaseRolePermissionMapper baseRolePermissionMapper;
    public Permission createPermission(Permission permission) {
        permissionMapper.addEntity(permission);
        return permission;
    }

    public List<Permission> getPermissionList()  {
        return permissionMapper.getEntity();
    }

    public void deleteEntity(int permissionId) {
        permissionMapper.deleteEntity(permissionId);
        baseRolePermissionMapper.deleteEntityByPermission(permissionId);
    }

    public Permission updatePermission(Permission permission){
        permissionMapper.updateEntity(permission);
        return permission;
    }
}
