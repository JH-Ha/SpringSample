package com.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan
public class BoardConfiguration implements WebMvcConfigurer {
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/");
//		resolver.setSuffix(".jsp");
//		resolver.setViewClass(JstlView.class);
//		registry.viewResolver(resolver);
//	}
}