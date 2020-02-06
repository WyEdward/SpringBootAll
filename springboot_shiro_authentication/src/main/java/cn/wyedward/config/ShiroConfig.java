package cn.wyedward.config;

import cn.wyedward.shiro.ShiroRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * shiro的配置类
 */
@Configuration
public class ShiroConfig {
    /**
     * shiro过滤器工程类 用来判断  验证登录的方式 登录之后的跳转 对资源的拦截
     * @param securityManager 依赖于安全管理类
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置securityManage
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置登录的url
        shiroFilterFactoryBean.setLoginUrl("/login");
        //登录成功后跳转的url
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权url
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //定义filterChain,静态资源不拦截
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/fonts/**","anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        //druid数据源监控页面不拦截
        filterChainDefinitionMap.put("/druid/**","anon");
        //配置退出过滤器，其中具体的退出代码Shiro已经替我们实现
        filterChainDefinitionMap.put("/logout","logout");
        filterChainDefinitionMap.put("/","anon");
        //除上以外所有url都必须认证通过才可以访问，未通过认证自动访问LoginUrl
        filterChainDefinitionMap.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * shiro的安全管理类
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        //配置SecurityManage 并注入shiroRealm
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    /**
     * 自定义验证方式
     * @return
     */
    @Bean
    public ShiroRealm shiroRealm(){
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }

}
