package com.youxianqin.dockermgr.service;

import java.util.*;

import com.youxianqin.dockermgr.dao.BaseRoleMapper;
import com.youxianqin.dockermgr.dao.ServiceMapper;
import com.youxianqin.dockermgr.models.BaseRole;
import com.youxianqin.dockermgr.models.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;


@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceMapper serviceMapper;



    @Autowired
    private BaseRoleMapper baseRoleMapper;

    @CacheEvict(cacheNames = "serviceCache")
    @Transactional
    public Service addService(Service service) {
        serviceMapper.addEntity(service);
        return service;
    }
    @Cacheable (cacheNames = "serviceCache")
    public List<Service> getServices()  {
        return serviceMapper.getEntity();
    }

    @CacheEvict(cacheNames = "serviceCache")
    @Transactional
    public void deleteService(int serviceId) {
        serviceMapper.deleteEntity(serviceId);
    }

    @CacheEvict(cacheNames = "serviceCache")
    @Transactional
    public Service updateService(Service service){
        serviceMapper.updateEntity(service);
        return service;
    }
}
