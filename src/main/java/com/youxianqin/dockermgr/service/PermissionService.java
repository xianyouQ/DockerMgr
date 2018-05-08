package com.youxianqin.dockermgr.service;

import com.youxianqin.dockermgr.dao.BaseRolePermissionMapper;
import com.youxianqin.dockermgr.dao.PermissionMapper;

import com.youxianqin.dockermgr.models.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    BaseRolePermissionMapper baseRolePermissionMapper;
    @CacheEvict(cacheNames = "permissionCache")
    @Transactional
    public Permission createPermission(Permission permission) {
        permissionMapper.addEntity(permission);
        return permission;
    }
    @Cacheable(cacheNames = "permissionCache")
    public List<Permission> getPermissionList()  {
        return permissionMapper.getEntity();
    }

    @CacheEvict(cacheNames = "permissionCache")
    @Transactional
    public void deleteEntity(int permissionId) {
        permissionMapper.deleteEntity(permissionId);
        baseRolePermissionMapper.deleteEntityByPermission(permissionId);
    }

    @CacheEvict(cacheNames = "permissionCache")
    @Transactional
    public Permission updatePermission(Permission permission){
        permissionMapper.updateEntity(permission);
        return permission;
    }
}
