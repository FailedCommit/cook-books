package com.demo.lifecycle;

import com.demo.lifecycle.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
  public static void main(String[] args) {
    try (AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
      System.out.println("Getting SpringBean1 from the context");
      SpringBean1 springBean1 = context.getBean(SpringBean1.class);
      System.out.println("Got SpringBean1 from the context");
    }
  }
}
