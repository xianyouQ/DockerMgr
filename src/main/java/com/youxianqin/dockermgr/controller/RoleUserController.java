package com.youxianqin.dockermgr.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.youxianqin.dockermgr.dao.RoleUserMapper;
import com.youxianqin.dockermgr.models.*;
import com.youxianqin.dockermgr.service.BaseRoleService;
import com.youxianqin.dockermgr.service.RoleUserService;
import com.youxianqin.dockermgr.util.ResponseData;

import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/roleuser")
public class RoleUserController {
    @Inject
    private RoleUserService roleUserService;
    @Inject
    private  BaseRoleService baseRoleService;
    /*
    @RequestMapping(value = "/${userId}")
    public ResponseData getRolesByUser(@PathVariable int userId) {
        List<RoleUser> roleUserList = roleUserService.getRolesByUser(userId);
        ResponseData<List<RoleUser>> response = new ResponseData<List<RoleUser>>();
        response.setData(roleUserList);
        return response;
    }
    */


    @RequestMapping(value = "/{serviceId}",method = RequestMethod.GET)
    public ResponseData getUserRolesByService(@PathVariable int serviceId) {
        List<RoleUser> roleUserList = roleUserService.getRolesByService(serviceId);
        ResponseData<List<RoleUser>> response = new ResponseData<List<RoleUser>>();
        response.setData(roleUserList);
        return response;
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseData addRoleUsers(@RequestBody RoleUserParam roleUserParam) {
        ResponseData response = new ResponseData();
        List<BaseRole> baseRoles = baseRoleService.getBaseRoleList();
        for (BaseRole baseRole:baseRoles) {
            if (baseRole.getId() == roleUserParam.getBaseRole().getId() && !baseRole.getCrossService()){
                response.setStatus(false);
                response.setInfo("no crossService Role found");
                return response;
            }
        }
        roleUserService.createRoleUsers(roleUserParam.getBaseRole(),roleUserParam.getUsers(),roleUserParam.getService());
        return response;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseData deleteRoleUser(@RequestBody RoleUserParam roleUserParam) {
        ResponseData response = new ResponseData();
        roleUserService.deleteRoleUser(roleUserParam.getBaseRole(),roleUserParam.getUsers().get(0),roleUserParam.getService());
        return response;
    }



}
