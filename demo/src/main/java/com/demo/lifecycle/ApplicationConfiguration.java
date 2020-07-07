package com.demo.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
public class ApplicationConfiguration {
  @Bean
  public static CustomBeanFactoryPostProcessor getCustomBeanFactoryPostProcessor() {
    return new CustomBeanFactoryPostProcessor();
  }

  @Bean
  public static CustomBeanPostProcessor getCustomerBeanPostProcessor() {
    return new CustomBeanPostProcessor();
  }
}
