package com.youxianqin.dockermgr.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BaseMapper<T> {
    int deleteEntity(Integer id);

    List<T> getEntity();

    int addEntity(T record);

    int updateEntity(T record);
}
