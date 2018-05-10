package com.youxianqin.dockermgr.service;


import com.youxianqin.dockermgr.dao.*;

import com.youxianqin.dockermgr.models.*;
import com.youxianqin.dockermgr.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

public interface RoleUserService {

    public List<RoleUser> getRolesByUser(int userId);
    public List<RoleUser> getRolesByService(int serviceId);
    public int createRoleUsers(BaseRole baseRole, List<User> users, Service service) ;
    public int deleteRoleUser(BaseRole baseRole , User user,Service service);
}
