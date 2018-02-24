package com.youxianqin.dockermgr.controller;

import com.youxianqin.dockermgr.models.Service;
import com.youxianqin.dockermgr.service.ServiceService;
import com.youxianqin.dockermgr.util.ResponseData;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/api/service")
public class ServiceController {

    @Inject
    ServiceService serviceService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseData createService(@RequestBody Service service) {
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
}
