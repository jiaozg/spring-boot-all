package com.example.demo.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jiao
 */
@Configuration
public class ShiroConfiguration {  
  
    @Bean
    public ShiroFilterFactoryBean shiroFilter(WebSecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shiroFilter()");  
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();  
  
        // 必须设置SecuritManager  
        shiroFilterFactoryBean.setSecurityManager(securityManager);  
  
        // 拦截器  
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
  
        // 配置退出过滤器,其中的具体代码Shiro已经替我们实现了  
        filterChainDefinitionMap.put("/logout", "logout");  
  
        // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;  
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->  
  
        filterChainDefinitionMap.put("/**", "authc");  
  
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面  
        shiroFilterFactoryBean.setLoginUrl("/login");  
        // 登录成功后要跳转的链接  
        shiroFilterFactoryBean.setSuccessUrl("/index");  
        // 未授权界面;  
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");  
  
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);  
        return shiroFilterFactoryBean;  
  
    }  
  
    @Bean  
    public WebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
          
        return securityManager;  
    }  
  
      
  
}  
