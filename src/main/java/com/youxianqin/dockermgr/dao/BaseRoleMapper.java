package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.BaseRole;

import java.util.List;

public interface BaseRoleMapper {
    int deleteEntity(Integer id);

    int addEntity(BaseRole record);

    List<BaseRole> getEntity();

    int updateEntity(BaseRole record);

}