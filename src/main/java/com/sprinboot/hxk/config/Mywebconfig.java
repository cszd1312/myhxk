package com.sprinboot.hxk.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sprinboot.hxk.handler.AdminInterceptor;
@Configuration
public class Mywebconfig implements WebMvcConfigurer{
	
	//添加拦截器到IOC容器中
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> addpath=new ArrayList<String>();
		addpath.add("/demo");
		addpath.add("/console");
		addpath.add("/console");
		addpath.add("/query/admin");
		addpath.add("/blog_insertUI");
		addpath.add("/console2");
		addpath.add("/type_list");
		addpath.add("/note_insert");
		addpath.add("/note_query");
		registry.addInterceptor(new AdminInterceptor()).addPathPatterns(addpath).excludePathPatterns("");
		
	}
	
}
