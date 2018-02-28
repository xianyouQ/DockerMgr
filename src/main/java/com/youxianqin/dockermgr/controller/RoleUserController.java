package com.youxianqin.dockermgr.controller;


import com.youxianqin.dockermgr.dao.RoleMapper;
import com.youxianqin.dockermgr.models.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/roleuser")
public class RoleUserController {
    @Inject
    private RoleMapper roleMapper;

    /*
    @RequestMapping(value = "/${userId}")
    public List<Role> getRolesByUser(@PathVariable int userId) {

    }
    */
}
