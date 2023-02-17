package com.example.practice.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
/**
 * @author Anh Dung
 *
 */
@Configuration
public class AppServiceInterceptorAppConfig extends WebMvcConfigurationSupport {
    @Autowired
    AppServiceInterceptor appServiceInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(appServiceInterceptor);
    }
}
