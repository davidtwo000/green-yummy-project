package com.example.demo.util;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

public interface WebMVCConfigurer {

	void addResourceHandlers(ResourceHandlerRegistry registry);

}
