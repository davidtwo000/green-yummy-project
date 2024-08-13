package com.example.demo.util;

import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${media.filepath}")
    private String uploadDir;
    
    @Value("${app.basepath}")
    private String basePath;

    private String getUploadDir() {
        String projectRoot = System.getProperty("user.dir");
        return Paths.get(projectRoot, basePath, "/images").toString();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	String uploadDir1 = getUploadDir();
    	
        registry.addResourceHandler("/upload/**","/images/**")
                .addResourceLocations("file:" + uploadDir + "/","file:" + uploadDir1 + "/");
    }
}