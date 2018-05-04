package com.youxianqin.dockermgr.shiro;

import java.util.List;



import com.youxianqin.dockermgr.dao.PermissionMapper;
import com.youxianqin.dockermgr.dao.ServiceMapper;
import com.youxianqin.dockermgr.models.Permission;
import com.youxianqin.dockermgr.models.Service;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 产生责任链，确定每个url的访问权限
 *
 */
public class ChainDefinitionSectionMetaSource {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private ServiceMapper serviceMapper;

    // 静态资源访问权限
    private String filterChainDefinitions = null;

    public Ini.Section getObject() throws Exception {
        Ini ini = new Ini();
        // 加载默认的url
        ini.load(filterChainDefinitions);
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        // 循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,
        // 里面的键就是链接URL,值就是存在什么条件才能访问该链接
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
                        keySb.append("perms[" ).append(service.getCode()).append("-").append(permission.getName()).append("]");
                        originalUrl.replace("%{serviceId}", service.getId() + "");
                        section.put(originalUrl, keySb.toString());
                    }
                } else {
                    StringBuilder keySb = new StringBuilder();
                    keySb.append("perms[").append(permission.getName()).append("]");
                    // 不对角色进行权限验证
                    // 如需要则 permission = "roles[" + resources.getResKey() + "]";
                    System.out.println(keySb.toString());
                    System.out.println(permission.getUrl());
                    System.out.println(section.toString());
                    section.put(permission.getUrl() + "", keySb.toString());
                }
            }

        }
        return section;
    }

    /**
     * 通过filterChainDefinitions对默认的url过滤定义
     *
     * @param filterChainDefinitions
     *            默认的url过滤定义
     */
    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    public Class<?> getObjectType() {
        return this.getClass();
    }

    public boolean isSingleton() {
        return false;
    }
}

