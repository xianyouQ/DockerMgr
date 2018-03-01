package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.BaseRole;
import com.youxianqin.dockermgr.models.RoleUser;
import com.youxianqin.dockermgr.models.Service;
import com.youxianqin.dockermgr.models.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleUserMapper {


    int addEntitys(@Param("users") List<User> users,  @Param("baseRole") BaseRole baseRole, @Param("service")Service service);

    int deleteEntity(@Param("user") User user, @Param("baseRole") BaseRole baseRole, @Param("service")Service service);

    List<RoleUser> getEntityByUser(int userId);
    List<RoleUser> getEntityByService(int userId);

    int deleteEntityByUser(int userId);

    int deleteEntityByService(int  serviceId);

    int deleteEntityByBaseRole(int  baseRoleId);
}