package com.cms.educationresources.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/swiper/**").addResourceLocations("file:D:/Graduation Project/images/swiperImages/");
        registry.addResourceHandler("/image/subjects/**").addResourceLocations("file:D:/Graduation Project/images/subjectImages/");
        registry.addResourceHandler("/image/bookCover/**").addResourceLocations("file:D:/Graduation Project/images/bookImages/");
    }
}
