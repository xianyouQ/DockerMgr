package com.youxianqin.dockermgr.dao;

import com.youxianqin.dockermgr.models.BaseRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;

@Mapper
public interface BaseRoleMapper  extends BaseMapper<BaseRole>{
    @Cacheable(cacheNames = "baseRoleCache")
    List<BaseRole> getEntityWithPermission();

}