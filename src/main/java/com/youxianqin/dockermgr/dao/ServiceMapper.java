package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.Service;

import java.util.List;

public interface ServiceMapper {
    int deleteEntity(int id);

    int addEntity(Service record);


    List<Service> getEntity();


    int updateEntity(Service record);

}