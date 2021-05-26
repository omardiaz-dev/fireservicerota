package com.conem.layouts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.conem.layouts.Application;

@Configuration
@PropertySource("classpath:persistence.properties")
@PropertySource("classpath:application.properties")
@ComponentScan(basePackageClasses = Application.class)
class ApplicationConfig {
	
	public static String ACTION_SAVE = "SAVE";

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}