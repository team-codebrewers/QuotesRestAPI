package com.example.quotesrestapi.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Component
public class AuthServiceConfig extends WebMvcConfigurerAdapter{
    @Autowired
    AuthServiceHandler authServiceHandler;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authServiceHandler);
    }
}
