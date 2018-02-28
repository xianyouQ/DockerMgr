package com.youxianqin.dockermgr.service;

import com.youxianqin.dockermgr.dao.UserMapper;
import com.youxianqin.dockermgr.models.User;
import com.youxianqin.dockermgr.util.PasswordHelper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Service
public class UserSerivce {

    @Inject
    private UserMapper userMapper;

    public User createUser(User user) {
        userMapper.addEntity(user);
        return user;
    }
    public List<User> getUserList()  {
        return userMapper.getEntity();
    }

    public void deleteUser(int userId) {
        userMapper.deleteEntity(userId);
    }

    public User updateUser(User user){
        userMapper.updateEntity(user);
        return user;
    }

}
