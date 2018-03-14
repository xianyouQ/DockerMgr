package com.youxianqin.dockermgr.config;


import com.youxianqin.dockermgr.shiro.spring.SpringCacheManagerWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public SpringCacheManagerWrapper cacheManager() {
        SpringCacheManagerWrapper cacheManager = new com.youxianqin.dockermgr.shiro.spring.SpringCacheManagerWrapper();
        cacheManager.setCacheManager();
    }
}
