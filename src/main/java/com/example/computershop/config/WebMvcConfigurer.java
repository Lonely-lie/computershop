package com.example.computershop.config;

import com.example.computershop.interceptor.LoginInterceptor;
import com.example.computershop.interceptor.OtherInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Bean
    public OtherInterceptor getOtherIntercepter() {
        return new OtherInterceptor();
    }
    @Bean
    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getOtherIntercepter())
                .addPathPatterns("/**");
        registry.addInterceptor(getLoginInterceptor())
                .addPathPatterns("/**");
    }
}
