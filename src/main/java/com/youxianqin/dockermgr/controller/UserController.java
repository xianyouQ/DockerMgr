package com.youxianqin.dockermgr.controller;


import com.youxianqin.dockermgr.models.User;
import com.youxianqin.dockermgr.service.UserSerivce;
import com.youxianqin.dockermgr.util.PasswordHelper;
import com.youxianqin.dockermgr.util.ResponseData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserSerivce userSerivce;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseData createUser(@RequestBody User user) {
        ResponseData<User> response = new ResponseData<User>();
        user.setCreateTime(new Date());
        user.setPassword("123456");
        PasswordHelper.encryptPassword(user);
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
    @RequestMapping(value = "/{userId}/reset",method = RequestMethod.GET)
    public ResponseData passwordReset(@PathVariable int userId) {
        User updateUser = new User();
        updateUser.setId(userId);
        updateUser.setPassword("123456");
        PasswordHelper.encryptPassword(updateUser);
        userSerivce.updateUser(updateUser);
        ResponseData response = new ResponseData();
        return response;
    }
    @RequestMapping(value = "/passwdchange",method = RequestMethod.PUT)
    public ResponseData passwordReset(@RequestBody User  user) {
        Subject sub = SecurityUtils.getSubject();
        User user1 = (User)sub.getSession().getAttribute("userSession");
        String newPassword = user.getPassword();
        user.setPassword(user.getOldPassword());
        PasswordHelper.encryptPassword(user);
        ResponseData response = new ResponseData();
        if (!user1.getPassword().equals(user.getPassword())){
            response.setInfo("密码错误");
            response.setStatus(false);
            return response;
        }
        User updateUser = new User();
        updateUser.setPassword(newPassword);
        updateUser.setId(user1.getId());
        PasswordHelper.encryptPassword(updateUser);
        userSerivce.updateUser(updateUser);
        return response;
    }
}
