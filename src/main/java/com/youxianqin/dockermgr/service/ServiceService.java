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



public interface ServiceService {




    public Service addService(Service service);
    public List<Service> getServices();


    public void deleteService(int serviceId);

    public Service updateService(Service service);
}
