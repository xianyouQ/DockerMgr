package com.youxianqin.dockermgr.service;


import com.youxianqin.dockermgr.dao.IdcMapper;
import com.youxianqin.dockermgr.models.Idc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class IdcService {

    @Autowired
    private IdcMapper idcMapper;
    @Transactional
    public Idc createIdc(Idc idc) {
        idcMapper.addEntity(idc);
        return idc;
    }

    public List<Idc> getIdcList()  {
        return idcMapper.getEntity();
    }
    @Transactional
    public void deleteEntity(int idcId) {
        idcMapper.deleteEntity(idcId);
    }
    @Transactional
    public Idc updateIdc(Idc idc){
        idcMapper.updateEntity(idc);
        return idc;
    }


}
