package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.RoleUser;

public interface RoleUserMapper {


    int addEntity(RoleUser record);

    int insertSelective(RoleUser record);

    RoleUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleUser record);

    int updateByPrimaryKey(RoleUser record);
}