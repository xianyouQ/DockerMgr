package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.BaseRole;
import com.youxianqin.dockermgr.models.Service;

import java.util.List;

public interface RoleMapper {
    int addEntitysByBaseRole(BaseRole record,List<Service> serivce);
    int addEntitysByService(List<BaseRole> record,Service serivce);
    int addEntity(BaseRole record);
    int deleteEntityByBaseRole(BaseRole record);
    int deleteEntityByService(Service serivce);
    int deleteEntity(BaseRole record,Service serivce);
}