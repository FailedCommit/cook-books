package com.demo.lifecycle;

import com.demo.lifecycle.beans.SpringBean1;
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

  @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
  public SpringBean1 springBean1() {
    return new SpringBean1();
  }
}
