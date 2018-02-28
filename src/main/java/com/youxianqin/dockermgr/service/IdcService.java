package com.youxianqin.dockermgr.service;


import com.youxianqin.dockermgr.dao.IdcMapper;
import com.youxianqin.dockermgr.models.Idc;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class IdcService {

    @Inject
    private IdcMapper idcMapper;

    public Idc createPermission(Idc idc) {
        idcMapper.addEntity(idc);
        return idc;
    }

    public List<Idc> getIdcList()  {
        return idcMapper.getEntity();
    }

    public void deleteEntity(int idcId) {
        idcMapper.deleteEntity(idcId);
    }

    public Idc updatePermission(Idc idc){
        idcMapper.updateEntity(idc);
        return idc;
    }
}