package com.youxianqin.dockermgr.controller;

import com.youxianqin.dockermgr.models.Idc;
import com.youxianqin.dockermgr.service.IdcService;
import com.youxianqin.dockermgr.util.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/idc")
public class IdcController {

    @Inject
    private IdcService idcService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseData getIdcs() {
        List<Idc> idcs  = idcService.getIdcList();
        ResponseData response  = new ResponseData<List<Idc>>();
        response.setData(idcs);
        return response;
    }
}
