package com.calabar.portal.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.calabar.portal.interceptor.ManagerHandlerInterceptor;

import javax.annotation.Resource;

/**
 * 拦截器注册
 */
@Configuration
public class ManagerWebConfigurerAdapter implements WebMvcConfigurer {
    @Resource
    private ManagerHandlerInterceptor managerHandlerInterceptor;
    /**添加无业务逻辑的页面跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //toregister等效于@grequestMapping("/toregister")，register跳转的页面名
        registry.addViewController("/toregister").setViewName("/register");
    }

    /**添加后台管理权限拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    //拦截所有方法
        registry.addInterceptor(managerHandlerInterceptor).addPathPatterns("/managerhtml/**");
    }
}
