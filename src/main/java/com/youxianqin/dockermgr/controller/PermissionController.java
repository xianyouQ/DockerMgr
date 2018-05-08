package com.youxianqin.dockermgr.controller;

import com.youxianqin.dockermgr.models.Permission;
import com.youxianqin.dockermgr.service.PermissionService;
import com.youxianqin.dockermgr.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseData createPermission(@RequestBody Permission permission) {
        ResponseData<Permission> response = new ResponseData<Permission>();
        if(permission.getCrossService() && permission.getUrl().indexOf("%{serviceId}") < 0) {
            response.setInfo("url不包含%{serviceId}");
            response.setStatus(false);
            return  response;
        }
        response.setData(permissionService.createPermission(permission));
        return response;
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseData getPermissionList() {
        ResponseData<List<Permission>> response = new ResponseData<List<Permission>>();
        response.setData(permissionService.getPermissionList());
        return response;
    }
    @RequestMapping(value = "/{baseRoleId}",method = RequestMethod.DELETE)
    public ResponseData deletePermission(@PathVariable int permissionId) {
        ResponseData response = new ResponseData();
        permissionService.deleteEntity(permissionId);
        return response;
    }
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseData updatePermission(@RequestBody Permission permission) {
        ResponseData<Permission> response = new ResponseData<Permission>();
        permissionService.updatePermission(permission);
        response.setData(permission);
        return response;
    }
}
