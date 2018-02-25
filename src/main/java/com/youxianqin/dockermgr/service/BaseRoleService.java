package com.youxianqin.dockermgr.service;

import com.youxianqin.dockermgr.dao.BaseRoleMapper;
import com.youxianqin.dockermgr.models.BaseRole;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class BaseRoleService {
    @Inject
    private BaseRoleMapper baseRoleMapper;

    public BaseRole createBaseRole(BaseRole baseRole) {
        baseRoleMapper.addEntity(baseRole);
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
