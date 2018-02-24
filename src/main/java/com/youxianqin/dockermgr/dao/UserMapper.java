package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.User;

import java.util.List;

public interface UserMapper {
    int deleteEntity(int id);

    int addEntity(User record);


    User getEntityByName(String name);

    List<User> getEntity();

    int updateEntity(User record);

}