package com.youxianqin.dockermgr.controller;

import com.youxianqin.dockermgr.models.User;
import com.youxianqin.dockermgr.util.ResponseData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginOutController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseData Login(@RequestBody User user) {
        Subject sub = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        sub.login(token);
        ResponseData<User> response  = new ResponseData<User>();
        user.setPassword("");
        response.setData(user);
        return response;
    }
    @RequestMapping("/logout")
    public ResponseData LogOut() {
        Subject sub = SecurityUtils.getSubject();
        sub.logout();
        return new ResponseData();
    }
}
