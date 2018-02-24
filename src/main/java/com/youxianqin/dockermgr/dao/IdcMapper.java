package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.Idc;

public interface IdcMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Idc record);

    int insertSelective(Idc record);

    Idc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Idc record);

    int updateByPrimaryKey(Idc record);
}