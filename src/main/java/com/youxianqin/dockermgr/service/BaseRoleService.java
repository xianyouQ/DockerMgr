package com.youxianqin.dockermgr.service;

import com.youxianqin.dockermgr.dao.BaseRoleMapper;
import com.youxianqin.dockermgr.dao.BaseRolePermissionMapper;
import com.youxianqin.dockermgr.dao.ServiceMapper;
import com.youxianqin.dockermgr.models.BaseRole;
import com.youxianqin.dockermgr.models.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@org.springframework.stereotype.Service
public class BaseRoleService {
    @Autowired
    private BaseRoleMapper baseRoleMapper;

    @Autowired
    private ServiceMapper serviceMapper;
    @Autowired
    BaseRolePermissionMapper baseRolePermissionMapper;
    public BaseRole createBaseRole(BaseRole baseRole) {
        baseRoleMapper.addEntity(baseRole);
        List<Service> services = serviceMapper.getEntity();
        return baseRole;
    }

    public List<BaseRole> getBaseRoleList()  {
        return baseRoleMapper.getEntity();
    }

    public void deleteBaseRole(int baseRoleId) {
        baseRoleMapper.deleteEntity(baseRoleId);
        baseRolePermissionMapper.deleteEntityByBaseRole(baseRoleId);
    }

    public BaseRole updateBaseRole(BaseRole baseRole){
        baseRoleMapper.updateEntity(baseRole);
        return baseRole;
    }
}
