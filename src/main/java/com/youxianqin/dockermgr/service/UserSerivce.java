package com.youxianqin.dockermgr.service;

import com.youxianqin.dockermgr.dao.UserMapper;
import com.youxianqin.dockermgr.models.User;
import com.youxianqin.dockermgr.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;


public interface UserSerivce {


    public User createUser(User user) ;
    public List<User> getUserList();


    public void deleteUser(int userId);

    public User updateUser(User user);

}
