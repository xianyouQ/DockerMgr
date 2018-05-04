package com.youxianqin.dockermgr.config;

import com.youxianqin.dockermgr.dao.PermissionMapper;
import com.youxianqin.dockermgr.dao.ServiceMapper;
import com.youxianqin.dockermgr.models.Permission;
import com.youxianqin.dockermgr.models.Service;
import com.youxianqin.dockermgr.shiro.MyRealm;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;


import org.springframework.cache.CacheManager;

import org.apache.shiro.realm.Realm;

import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.List;


@Configuration
public class ShiroConfig {
    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private ServiceMapper serviceMapper;

    @Bean
    public Realm realm() {
        MyRealm realm = new MyRealm();
        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        realm.setCachingEnabled(false);
        return realm;
    }


    @Bean
    HashedCredentialsMatcher hashedCredentialsMatcher () {
        HashedCredentialsMatcher mHashedCredentialsMatcher = new HashedCredentialsMatcher();
        mHashedCredentialsMatcher.setHashAlgorithmName("md5");
        mHashedCredentialsMatcher.setHashIterations(3);
        mHashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return mHashedCredentialsMatcher;
    }



    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

        // logged in users with the 'admin' role
        chainDefinition.addPathDefinition("/api/service/count", "anon");

        // logged in users with the 'document:read' permission
        chainDefinition.addPathDefinition("/api/login", "anon");

        // all other paths require a logged in user
        chainDefinition.addPathDefinition("/api/logout", "anon");
        chainDefinition.addPathDefinition("/api/user", "anon");
        chainDefinition.addPathDefinitions(serviceFilterChainDefinition());
        return chainDefinition;
    }

    @Bean
    @Scope("prototype")
    public HashMap<String,String> serviceFilterChainDefinition() {
            HashMap<String,String> serivceFilterChainDefinition = new HashMap<String, String>();
            List<Permission> permissionList = permissionMapper.getEntity();
            List<Service> serviceList = serviceMapper.getEntity();
            for (Permission permission : permissionList) {
                // 构成permission字符串
                if (StringUtils.isNotEmpty(permission.getUrl() + "") && StringUtils.isNotEmpty(permission.getName()+ "")) {
                    if(permission.getCrossService()) {
                        String originalUrl = permission.getUrl();
                        if ( !originalUrl.contains("%{serviceId}")) {
                            continue;
                        }
                        for (Service service:serviceList) {
                            StringBuilder keySb = new StringBuilder();
                            keySb.append("perms[" ).append(service.getCode()).append("-").append(permission.getName()).append(":").append(permission.getMethod()).append("]");
                            originalUrl.replace("%{serviceId}", service.getId() + "");
                            serivceFilterChainDefinition.put(originalUrl, keySb.toString());
                        }
                    } else {
                        StringBuilder keySb = new StringBuilder();
                        keySb.append("perms[").append(permission.getName()).append("]");
                        // 不对角色进行权限验证
                        // 如需要则 permission = "roles[" + resources.getResKey() + "]";
                    }
                }

            }
            return serivceFilterChainDefinition;
        }



}
