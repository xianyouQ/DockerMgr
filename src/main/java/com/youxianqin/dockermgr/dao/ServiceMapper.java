package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.Service;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServiceMapper {
    int deleteEntity(int id);

    int addEntity(Service record);


    List<Service> getEntity();


    int updateEntity(Service record);

}