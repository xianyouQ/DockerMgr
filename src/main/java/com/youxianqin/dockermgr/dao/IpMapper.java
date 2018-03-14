package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.Ip;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ip record);

    int insertSelective(Ip record);

    Ip selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ip record);

    int updateByPrimaryKey(Ip record);
}