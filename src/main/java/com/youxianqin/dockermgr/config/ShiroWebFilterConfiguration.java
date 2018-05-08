

package com.youxianqin.dockermgr.config;
import com.youxianqin.dockermgr.shiro.filter.MyPermissionsAuthorizationFilter;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.AbstractShiroWebFilterConfiguration;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ConditionalOnProperty(
        name = {"shiro.web.enabled"},
        matchIfMissing = true
)
public class ShiroWebFilterConfiguration extends AbstractShiroWebFilterConfiguration {
    public ShiroWebFilterConfiguration() {
    }

    @Bean
    @ConditionalOnMissingBean
    protected ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean bean =  super.shiroFilterFactoryBean();
        Map<String, Filter> filters = new HashMap<String,Filter>();
        filters.put("perms",myPermissionsAuthorizationFilter());
        filters.put("anon",new AnonymousFilter());
        bean.setFilters(filters);
        return bean;
    }


    @Bean

    public MyPermissionsAuthorizationFilter myPermissionsAuthorizationFilter() {
        return new MyPermissionsAuthorizationFilter();
    }
    @Bean(
            name = {"filterShiroFilterRegistrationBean"}
    )
    @ConditionalOnMissingBean
    protected FilterRegistrationBean filterShiroFilterRegistrationBean() throws Exception {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter((AbstractShiroFilter)this.shiroFilterFactoryBean().getObject());
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
