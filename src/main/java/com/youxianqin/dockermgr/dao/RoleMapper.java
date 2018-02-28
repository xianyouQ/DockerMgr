package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.BaseRole;
import com.youxianqin.dockermgr.models.Role;
import com.youxianqin.dockermgr.models.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int addEntitysByBaseRole(@Param("baseRole")BaseRole record,@Param("serviceList")List<Service> serivces);
    int addEntitysByService(@Param("baseRoleList")List<BaseRole> record,@Param("service")Service serivce);
    int addEntity(BaseRole record);
    List<Role> getEntity();
    int deleteEntityByBaseRole(BaseRole record);
    int deleteEntityByService(Service serivce);
}