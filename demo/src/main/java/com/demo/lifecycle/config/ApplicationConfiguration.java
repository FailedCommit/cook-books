package com.demo.lifecycle.config;

import com.demo.lifecycle.processors.CustomBeanFactoryPostProcessor;
import com.demo.lifecycle.processors.CustomBeanPostProcessor;
import com.demo.lifecycle.beans.SpringBean1;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.*;

/**
 * For a list of all bean lifecycle methods, see the
 * {@link BeanFactory BeanFactory javadocs}.
 */
// Moving ApplicationConfiguration to config folder messed up the component scan. See readme for more details.
@ComponentScan(basePackages = "com.demo.lifecycle.beans")
@Configuration
@PropertySources({
        @PropertySource("file:${app-home}/app-home.properties"), // for this to work add VM option as -Dapp-home=app-home
        @PropertySource("classpath:/app-defaults.properties")
})
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
