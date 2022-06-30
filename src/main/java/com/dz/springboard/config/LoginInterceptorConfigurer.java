package com.dz.springboard.config;

import com.dz.springboard.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

//@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor loginInterceptor = new LoginInterceptor();
        List<String> excludePath = new ArrayList<>();
        excludePath.add("/bootstrap/**");
        excludePath.add("/css/**");
        excludePath.add("/js/**");
        excludePath.add("/images/**");
        excludePath.add("/web/login.html");
        excludePath.add("/web/register.html");
        excludePath.add("/web/index.html");
        excludePath.add("/web/product.html");
        excludePath.add("/users/reg");
        excludePath.add("/users/login");
        excludePath.add("/districts/*");
        excludePath.add("/products/**");

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath);
    }
}
