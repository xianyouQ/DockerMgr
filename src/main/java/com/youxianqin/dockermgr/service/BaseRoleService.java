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

public interface BaseRoleService {

    public BaseRole createBaseRole(BaseRole baseRole) ;

    public List<BaseRole> getBaseRoleList() ;

    public void deleteBaseRole(int baseRoleId);
    public BaseRole updateBaseRole(BaseRole baseRole);
}
