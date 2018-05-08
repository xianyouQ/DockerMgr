package com.youxianqin.dockermgr.service;


import com.youxianqin.dockermgr.dao.BaseRoleMapper;
import com.youxianqin.dockermgr.dao.BaseRolePermissionMapper;
import com.youxianqin.dockermgr.dao.ServiceMapper;
import com.youxianqin.dockermgr.models.BaseRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@org.springframework.stereotype.Service
public class BaseRoleService {
    @Autowired
    private BaseRoleMapper baseRoleMapper;

    @Autowired
    private ServiceMapper serviceMapper;
    @Autowired
    BaseRolePermissionMapper baseRolePermissionMapper;
    @CacheEvict(cacheNames = "baseRoleCache")
    @Transactional
    public BaseRole createBaseRole(BaseRole baseRole) {
        baseRoleMapper.addEntity(baseRole);
        return baseRole;
    }

    @Cacheable(cacheNames = "baseRoleCache")
    public List<BaseRole> getBaseRoleList()  {
        List<BaseRole> baseRoles =  baseRoleMapper.getEntityWithPermission();
        return baseRoles;
    }

    @CacheEvict(cacheNames = "baseRoleCache")
    @Transactional
    public void deleteBaseRole(int baseRoleId) {
        baseRoleMapper.deleteEntity(baseRoleId);
        baseRolePermissionMapper.deleteEntityByBaseRole(baseRoleId);
    }
    @CacheEvict(cacheNames = "baseRoleCache")
    @Transactional
    public BaseRole updateBaseRole(BaseRole baseRole){
        baseRoleMapper.updateEntity(baseRole);
        return baseRole;
    }
}
