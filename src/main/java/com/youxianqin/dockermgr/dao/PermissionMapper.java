package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.Permission;

import java.util.List;

public interface PermissionMapper {
    int deleteEntity(int id);

    int addEntity(Permission record);


    List<Permission> getEntity();


    int updateEntity(Permission record);
}