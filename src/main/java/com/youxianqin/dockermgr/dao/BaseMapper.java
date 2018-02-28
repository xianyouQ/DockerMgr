package com.youxianqin.dockermgr.dao;

import java.util.List;


public interface BaseMapper<T> {
    int deleteEntity(Integer id);

    List<T> getEntity();

    int addEntity(T record);

    int updateEntity(T record);
}
