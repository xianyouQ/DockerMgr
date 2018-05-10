package com.youxianqin.dockermgr;

import org.apache.shiro.spring.config.web.autoconfigure.ShiroWebFilterConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {
        ShiroWebFilterConfiguration.class
})
@EnableCaching
@EnableTransactionManagement
public class DockerMgrApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerMgrApplication.class, args);
    }
}
