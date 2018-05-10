package com.youxianqin.dockermgr.service;

import com.youxianqin.dockermgr.dao.UserMapper;
import com.youxianqin.dockermgr.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserSerivceImpl implements UserSerivce {

    @Autowired
    private UserMapper userMapper;

    @CacheEvict(cacheNames = "userCache")
    @Transactional
    @Override
    public User createUser(User user) {
        userMapper.addEntity(user);
        return user;
    }
    @Cacheable(cacheNames = "userCache")
    @Override
    public List<User> getUserList()  {
        return userMapper.getEntity();
    }

    @CacheEvict(cacheNames = "userCache")
    @Transactional
    @Override
    public void deleteUser(int userId) {
        userMapper.deleteEntity(userId);
    }

    @CacheEvict(cacheNames = "userCache")
    @Transactional
    @Override
    public User updateUser(User user){
        userMapper.updateEntity(user);
        return user;
    }

}
