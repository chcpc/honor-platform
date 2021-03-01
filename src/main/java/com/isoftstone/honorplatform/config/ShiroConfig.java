package com.isoftstone.honorplatform.config;

import com.isoftstone.honorplatform.shiro.filter.CustomFilter;
import com.isoftstone.honorplatform.shiro.realm.CustomerRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    // 1.创建ShiroFilter
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 给shirofilter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        shiroFilterFactoryBean.setLoginUrl("/");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/");
        // 配置自定义过滤器
        Map<String, Filter> filters = new HashMap<>();
        filters.put("authc", new CustomFilter());
        shiroFilterFactoryBean.setFilters(filters);
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        // 配置系统公共资源
        map.put("/login", "anon");
        // 配置系统受限资源
        map.put("/**", "authc");
        // 默认认证界面路径 /login.jsp
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }
    // 2.创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        // 给安全管理器设置Realm
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }
    // 3.创建自定有Realm
    @Bean
    public Realm getRealm() {
        return new CustomerRealm();
    }

    // 4.开启对shiro的注解支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
