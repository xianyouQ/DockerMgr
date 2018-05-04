package com.youxianqin.dockermgr.config;

import com.youxianqin.dockermgr.mybatis.plugin.BaseOperationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.ibatis.plugin.Interceptor;



@Configuration
public class MybatisConfig {


    @Bean
    public Interceptor baseOperationFilter( ) {
        BaseOperationFilter baseOperationFilter = new BaseOperationFilter();
        return baseOperationFilter;
    }
}