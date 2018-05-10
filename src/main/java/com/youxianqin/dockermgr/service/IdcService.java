package com.youxianqin.dockermgr.service;


import com.youxianqin.dockermgr.dao.IdcMapper;
import com.youxianqin.dockermgr.models.Idc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


public interface IdcService {


    public Idc createIdc(Idc idc) ;

    public List<Idc> getIdcList();
    public void deleteEntity(int idcId);
;
    public Idc updateIdc(Idc idc);


}
