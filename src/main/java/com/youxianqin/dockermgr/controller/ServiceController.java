package com.youxianqin.dockermgr.controller;

import com.youxianqin.dockermgr.models.Service;
import com.youxianqin.dockermgr.service.ServiceService;
import com.youxianqin.dockermgr.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    private final int SERVICE_COUNT = 2;
    private final String SERVICE_SPLIT = "-";

    @RequestMapping(method = RequestMethod.POST)
    public ResponseData createService(@RequestBody Service service) {
        if (service.getCode().split(SERVICE_SPLIT).length != 2) {
            ResponseData response = new ResponseData();
            response.setStatus(false);
            response.setInfo("不合法的service名称");
            return response;
        }
        serviceService.addService(service);
        ResponseData response  = new ResponseData<Service>();
        response.setData(service);
        return response;
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseData getServices() {
        List<Service> services  = serviceService.getServices();
        ResponseData response  = new ResponseData<List<Service>>();
        response.setData(services);
        return response;
    }

    @RequestMapping(value = "/{serviceId}",method = RequestMethod.GET)
    public ResponseData deleteService(@PathVariable int serviceId) {
        serviceService.deleteService(serviceId);
        return new ResponseData();
    }
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseData updateService(@RequestBody Service serivce) {
        serviceService.updateService(serivce);
        ResponseData response  = new ResponseData<Service>();
        response.setData(serivce);
        return response;
    }

    @RequestMapping(value="/count",method=RequestMethod.GET)
    public ResponseData getServiceCount() {
        ResponseData response  = new ResponseData<Integer>();
        response.setData(SERVICE_COUNT);
        return response;
    }
}
