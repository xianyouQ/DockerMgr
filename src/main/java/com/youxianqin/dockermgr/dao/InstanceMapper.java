package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.Instance;

public interface InstanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Instance record);

    int insertSelective(Instance record);

    Instance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Instance record);

    int updateByPrimaryKey(Instance record);
}