package com.javaex.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
        .addResourceLocations("file:///C:/javaStudy/upload/");
        // 윈도우 경로	-> file:///C:/javaStudy/upload/
        // 맥 경로	-> /Users/kangsubin/Desktop/javaStudy/upload/
    }
}