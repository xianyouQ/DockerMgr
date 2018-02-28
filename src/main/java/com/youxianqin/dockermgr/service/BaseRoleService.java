package com.youxianqin.dockermgr.service;

import com.youxianqin.dockermgr.dao.BaseRoleMapper;
import com.youxianqin.dockermgr.dao.RoleMapper;
import com.youxianqin.dockermgr.dao.ServiceMapper;
import com.youxianqin.dockermgr.models.BaseRole;
import com.youxianqin.dockermgr.models.Service;

import javax.inject.Inject;
import java.util.List;

@org.springframework.stereotype.Service
public class BaseRoleService {
    @Inject
    private BaseRoleMapper baseRoleMapper;

    @Inject
    private ServiceMapper serviceMapper;
    @Inject
    private RoleMapper roleMapper;
    public BaseRole createBaseRole(BaseRole baseRole) {
        baseRoleMapper.addEntity(baseRole);
        if (baseRole.getCrossService()) {
            List<Service> services = serviceMapper.getEntity();
            roleMapper.addEntitysByBaseRole(baseRole,services);
        } else {
            roleMapper.addEntity(baseRole);
        }
        return baseRole;
    }

    public List<BaseRole> getBaseRoleList()  {
        return baseRoleMapper.getEntity();
    }

    public void deleteBaseRole(int baseRoleId) {
        baseRoleMapper.deleteEntity(baseRoleId);
    }

    public BaseRole updateBaseRole(BaseRole baseRole){
        baseRoleMapper.updateEntity(baseRole);
        return baseRole;
    }
}
