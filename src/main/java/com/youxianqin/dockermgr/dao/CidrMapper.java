package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.Cidr;

public interface CidrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cidr record);

    int insertSelective(Cidr record);

    Cidr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cidr record);

    int updateByPrimaryKey(Cidr record);
}