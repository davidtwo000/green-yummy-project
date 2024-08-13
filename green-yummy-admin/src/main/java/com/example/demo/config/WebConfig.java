package com.example.demo.config;

import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${app.basepath}")
    private String basePath;

    private String getUploadDir() {
        String projectRoot = System.getProperty("user.dir");
        return Paths.get(projectRoot, basePath, "admin/images").toString();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String uploadDir = getUploadDir();
        registry.addResourceHandler("/admin/images/**")
                .addResourceLocations("file:" + uploadDir + "/");
    }
}