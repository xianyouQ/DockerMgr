package com.youxianqin.dockermgr.service;

import com.youxianqin.dockermgr.dao.BaseRolePermissionMapper;
import com.youxianqin.dockermgr.dao.PermissionMapper;

import com.youxianqin.dockermgr.models.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
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
