package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.BaseRolePermission;

public interface BaseRolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseRolePermission record);

    int insertSelective(BaseRolePermission record);

    BaseRolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseRolePermission record);

    int updateByPrimaryKey(BaseRolePermission record);
}