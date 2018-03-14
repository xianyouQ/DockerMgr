package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteEntity(int id);

    int addEntity(User record);


    User getEntityByName(String name);

    List<User> getEntity();

    int updateEntity(User record);

}