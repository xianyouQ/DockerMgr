package com.youxianqin.dockermgr.service;


import com.youxianqin.dockermgr.dao.RoleUserMapper;
import com.youxianqin.dockermgr.models.BaseRole;
import com.youxianqin.dockermgr.models.RoleUser;
import com.youxianqin.dockermgr.models.Service;
import com.youxianqin.dockermgr.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class RoleUserServiceImpl implements RoleUserService{

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    public List<RoleUser> getRolesByUser(int userId) {
        return roleUserMapper.getEntityByUser(userId);
    }
    public List<RoleUser> getRolesByService(int serviceId) {
        return roleUserMapper.getEntityByService(serviceId);
    }
    @Transactional
    @Override
    public int createRoleUsers(BaseRole baseRole, List<User> users, Service service) {
        return roleUserMapper.addEntitys(users, baseRole, service);

    }
    @Transactional
    @Override
    public int deleteRoleUser(BaseRole baseRole , User user,Service service) {
        return roleUserMapper.deleteEntity(user,baseRole,service);
    }
}
