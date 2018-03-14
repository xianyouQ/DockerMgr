package com.youxianqin.dockermgr.dao;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.youxianqin.dockermgr.models.BaseRole;
import com.youxianqin.dockermgr.models.BaseRolePermission;
import com.youxianqin.dockermgr.models.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BaseRolePermissionMapper  {
    List<BaseRolePermission> getEntity();
    int addEntitys(@Param("baseRole") BaseRole baseRole, @Param("permissionList") List<Permission> permissionList);
    int deleteEntitys(@Param("baseRole") BaseRole baseRole,  @Param("permissionList")List<Permission> permissionList);
    int deleteEntityByBaseRole(int baseRoleId);
    int deleteEntityByPermission(int permissionId);
}