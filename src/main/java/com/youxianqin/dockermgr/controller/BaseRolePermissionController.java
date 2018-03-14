package com.youxianqin.dockermgr.controller;


import com.youxianqin.dockermgr.models.BaseRole;
import com.youxianqin.dockermgr.models.Permission;
import com.youxianqin.dockermgr.service.BaseRolePermissionService;
import com.youxianqin.dockermgr.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/baserolepermission")
public class BaseRolePermissionController {

    @Autowired
    private BaseRolePermissionService baseRolePermissionService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseData updateBaseRolePermission(@RequestBody BaseRole baseRole) {
        List<Permission> disChosenList = new ArrayList<Permission>();
        List<Permission> chosenList = new ArrayList<Permission>();
        ResponseData response = new ResponseData();
        for(Permission permission:baseRole.getPermissionList()) {
            if(permission.getCrossService() != baseRole.getCrossService()) {
                response.setInfo("权限属性跟Role属性不一致");
                response.setStatus(false);
                return response;
            }
            if(permission.getChosen()) {
                chosenList.add(permission);
            } else {
                disChosenList.add(permission);
            }
        }
        baseRolePermissionService.updateEntitys(baseRole,chosenList,disChosenList);
        return response;
    }
}
