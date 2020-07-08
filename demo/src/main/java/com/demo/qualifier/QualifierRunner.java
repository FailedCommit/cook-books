package com.demo.qualifier;

import com.demo.qualifier.config.ApplicationConfiguration;
import com.demo.qualifier.service.GreetingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QualifierRunner {
    public static void main(String[] args){
      try(AnnotationConfigApplicationContext context =
                  new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
          final GreetingService greetingService = context.getBean(GreetingService.class);
          greetingService.sayGreeting();
      }
    }
}
