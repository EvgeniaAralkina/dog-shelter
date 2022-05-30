package com.example.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/help").setViewName("help_shelter");
        registry.addViewController("/advice").setViewName("advice");
        registry.addViewController("/allDogs").setViewName("allDogs");
        registry.addViewController("/ok").setViewName("ok");
    }

}
