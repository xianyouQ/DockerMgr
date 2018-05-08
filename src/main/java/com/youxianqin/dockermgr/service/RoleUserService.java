package com.youxianqin.dockermgr.service;


import com.youxianqin.dockermgr.dao.*;

import com.youxianqin.dockermgr.models.*;
import com.youxianqin.dockermgr.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@org.springframework.stereotype.Service
public class RoleUserService {

    @Autowired
    private RoleUserMapper roleUserMapper;


    public List<RoleUser> getRolesByUser(int userId) {
        return roleUserMapper.getEntityByUser(userId);
    }
    public List<RoleUser> getRolesByService(int serviceId) {
        return roleUserMapper.getEntityByService(serviceId);
    }
    @Transactional
    public int createRoleUsers(BaseRole baseRole, List<User> users, Service service) {
        return roleUserMapper.addEntitys(users, baseRole, service);

    }
    @Transactional
    public int deleteRoleUser(BaseRole baseRole , User user,Service service) {
        return roleUserMapper.deleteEntity(user,baseRole,service);
    }
}
