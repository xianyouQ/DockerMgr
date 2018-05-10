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


public interface PermissionService {

    public Permission createPermission(Permission permission) ;
    public List<Permission> getPermissionList();

    public void deleteEntity(int permissionId) ;


    public Permission updatePermission(Permission permission);
}
