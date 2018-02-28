package com.youxianqin.dockermgr.controller;

import com.youxianqin.dockermgr.models.Permission;
import com.youxianqin.dockermgr.service.PermissionService;
import com.youxianqin.dockermgr.util.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Inject
    private PermissionService permissionService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseData createPermission(@RequestBody Permission permission) {
        ResponseData<Permission> response = new ResponseData<Permission>();
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
