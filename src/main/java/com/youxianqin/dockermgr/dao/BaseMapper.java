package com.youxianqin.dockermgr.dao;

import java.util.List;

public interface BaseMapper<T> {
    int deleteEntity(Integer id);

    int addEntity(T record);

    List<T> getEntity();

    int updateEntity(T record);
}
