package com.youxianqin.dockermgr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.youxian.dockermgr.dao")
@EntityScan("com.youxian.dockermgr.models")
@EnableCaching
public class DockerMgrApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerMgrApplication.class, args);
    }
}
