package com.demo.proxy.proxy.spring;

import com.demo.proxy.beans.SpringBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class ApplicationConfig {
    @Bean
    SpringBean springBean() {
        System.out.println("Creating SpringBean in " + getClass().getSimpleName());

        return new SpringBean();
    }
}
