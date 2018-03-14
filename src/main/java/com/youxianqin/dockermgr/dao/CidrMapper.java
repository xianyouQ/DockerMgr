package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.Cidr;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CidrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cidr record);

    int insertSelective(Cidr record);

    Cidr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cidr record);

    int updateByPrimaryKey(Cidr record);
}