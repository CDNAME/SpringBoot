package com.cd.springboot.config;

import com.cd.springboot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //需要拦截的路径
        String[] addPathPatterns = {"/boot/**"};

        //不拦截的路径
        String[] excludePathPatterns = {
                "/boot/hello", "/boot/index"
        };

        //注册登陆拦截器
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);

        //注册权限拦截器
        //registry.addInterceptor(new AuthInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
