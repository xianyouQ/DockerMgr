package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.Release;
import com.youxianqin.dockermgr.models.ReleaseWithBLOBs;

public interface ReleaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReleaseWithBLOBs record);

    int insertSelective(ReleaseWithBLOBs record);

    ReleaseWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReleaseWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ReleaseWithBLOBs record);

    int updateByPrimaryKey(Release record);
}