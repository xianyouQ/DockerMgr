package com.youxianqin.dockermgr.controller;

import com.youxianqin.dockermgr.models.Permission;
import com.youxianqin.dockermgr.service.PermissionService;
import com.youxianqin.dockermgr.util.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/api/permission")
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
