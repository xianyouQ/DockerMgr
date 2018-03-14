package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    int deleteEntity(int id);

    int addEntity(Permission record);


    List<Permission> getEntity();


    int updateEntity(Permission record);
}