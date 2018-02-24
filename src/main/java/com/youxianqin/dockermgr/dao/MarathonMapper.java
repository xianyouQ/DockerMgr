package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.Marathon;

public interface MarathonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Marathon record);

    int insertSelective(Marathon record);

    Marathon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Marathon record);

    int updateByPrimaryKey(Marathon record);
}