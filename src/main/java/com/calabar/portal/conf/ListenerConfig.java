package com.calabar.portal.conf;

import com.cdcalabar.cas.client.CASSingSignOutHttpSessionListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class ListenerConfig {
    @Bean
    @Order(0)
    public ServletListenerRegistrationBean<CASSingSignOutHttpSessionListener> serssionListenerBean(){
        ServletListenerRegistrationBean<CASSingSignOutHttpSessionListener>
                cASSingSignOutHttpSessionListener = new ServletListenerRegistrationBean<CASSingSignOutHttpSessionListener>(new CASSingSignOutHttpSessionListener());
        return cASSingSignOutHttpSessionListener;
    }
}