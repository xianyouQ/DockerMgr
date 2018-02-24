package com.youxianqin.dockermgr.controller;


import com.youxianqin.dockermgr.models.User;
import com.youxianqin.dockermgr.service.UserSerivce;
import com.youxianqin.dockermgr.util.ResponseData;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Inject
    private UserSerivce userSerivce;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseData createUser(@RequestBody User user) {
        ResponseData<User> response = new ResponseData<User>();
        response.setData(userSerivce.createUser(user));
        return response;
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseData getUsers() {
        ResponseData<List<User>> response = new ResponseData<List<User>>();
        response.setData(userSerivce.getUserList());
        return response;
    }
    @RequestMapping(value = "/{userId}",method = RequestMethod.DELETE)
    public ResponseData deleteUser(@PathVariable int userId) {
        ResponseData response = new ResponseData();
        userSerivce.deleteUser(userId);
        return response;
    }
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseData updateUser(@RequestBody User user) {
        ResponseData<User> response = new ResponseData<User>();
        userSerivce.updateUser(user);
        response.setData(user);
        return response;
    }
}
