package com.calabar.portal.conf;

import com.cdcalabar.cas.client.CASAuthenticationExecuteFilter;
import com.cdcalabar.cas.client.CASReceivingTicketValidationFilter;
import com.cdcalabar.cas.client.util.CASAssertionThreadLocalFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import  com.cdcalabar.cas.client.CASSingleSignOutExcuteFilter;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FilterConfig {
    @Value("${portal.CASurl}")
    private String CASurl;
    @Value("${portal.localIp}")
    private String localIp;
    @Value("${server.port}")
    private String serverPort;
    @Bean
    @Order(1)
    public FilterRegistrationBean signOutFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CASSingleSignOutExcuteFilter());
        registration.addUrlPatterns("/*");
        registration.setName("signOutFilter");
        registration.setOrder(1);
        return registration;
    }
    @Bean
    @Order(2)
    public FilterRegistrationBean signOnFilter () {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CASAuthenticationExecuteFilter());
        List<String> urls=new ArrayList<String>();
        urls.add("/cas/singleLogin/*");
        urls.add("/*/islogin/*");
        urls.add("/managerhtml/*");
        registration.setUrlPatterns(urls);
        registration.addInitParameter("casServerLoginUrl",CASurl);
       //这里换成自己的ip和端口
        registration.addInitParameter("serverName",localIp+":"+serverPort+"/");
        registration.setName("signOnFilter");
        registration.setOrder(2);
        return registration;
    }
    @Bean
    @Order(3)
    public FilterRegistrationBean validationFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CASReceivingTicketValidationFilter());
        registration.addInitParameter("casServerUrlPrefix",CASurl );
        //这里换成自己的ip和端口
        registration.addInitParameter("serverName",localIp+":"+serverPort+"/" );
        registration.addUrlPatterns("/*");
        registration.setName("validationFilter");
        registration.setOrder(3);
        return registration;
    }
    @Bean
    @Order(4)
    public FilterRegistrationBean assertionThreadLocalFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CASAssertionThreadLocalFilter());
        registration.addUrlPatterns("/*");
        registration.setName("assertionThreadLocalFilter");
        registration.setOrder(4);
        return registration;
    }
}
