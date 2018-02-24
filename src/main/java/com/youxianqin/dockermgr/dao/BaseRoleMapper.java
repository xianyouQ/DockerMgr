package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.BaseRole;

public interface BaseRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseRole record);

    int insertSelective(BaseRole record);

    BaseRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseRole record);

    int updateByPrimaryKey(BaseRole record);
}