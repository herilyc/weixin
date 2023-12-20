package com.cms.educationresources;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cms.educationresources.mapper")
public class EducationResourcesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationResourcesApplication.class, args);
    }

}
