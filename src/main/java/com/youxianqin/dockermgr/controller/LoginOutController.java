package com.youxianqin.dockermgr.controller;

import com.youxianqin.dockermgr.models.User;
import com.youxianqin.dockermgr.service.UserSerivce;
import com.youxianqin.dockermgr.util.ResponseData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;

@RestController
public class LoginOutController {

    @Autowired
    UserSerivce userSerivce;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseData Login(@RequestBody User user) {
        Subject sub = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            sub.login(token);
        }catch (ExcessiveAttemptsException e) {
            ResponseData response = new ResponseData();
            response.setStatus(false);
            response.setInfo("账号重试过多");
            return response;
        }catch (AuthenticationException e) {
            ResponseData response = new ResponseData();
            response.setStatus(false);
            response.setInfo("账号或密码错误");
            return response;
        }
        Session session = sub.getSession();
        Integer userId = (Integer) session.getAttribute("userSessionId");
        User user1  = (User) session.getAttribute("userSession");
        ResponseData<User> response  = new ResponseData<User>();
        User updateUser = new User();
        updateUser.setId(userId);
        updateUser.setLastLoginTime(new Date());
        userSerivce.updateUser(updateUser);
        updateUser.setCreateTime(user1.getCreateTime());
        updateUser.setUsername(user1.getUsername());
        updateUser.setEmail(user1.getEmail());
        response.setData(updateUser);
        return response;
    }
    @RequestMapping("/logout")
    public ResponseData LogOut() {
        Subject sub = SecurityUtils.getSubject();
        sub.logout();
        return new ResponseData();
    }
}
