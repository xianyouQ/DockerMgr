package com.youxianqin.dockermgr.service;


import com.youxianqin.dockermgr.dao.BaseRolePermissionMapper;
import com.youxianqin.dockermgr.models.BaseRole;
import com.youxianqin.dockermgr.models.BaseRolePermission;
import com.youxianqin.dockermgr.models.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
public class BaseRolePermissionService {

    @Autowired
    private BaseRolePermissionMapper baseRolePermissionMapper;

    @CacheEvict(cacheNames = "baseRoleCache")
    @Transactional
    public void updateEntitys(BaseRole baseRole,List<Permission> chosenList,List<Permission> disChosenList) {

        if (disChosenList.size() > 0) {
            baseRolePermissionMapper.deleteEntitys(baseRole,disChosenList);
        }
        if (chosenList.size() > 0 ) {
            baseRolePermissionMapper.addEntitys(baseRole, chosenList);
        }
    }
}
