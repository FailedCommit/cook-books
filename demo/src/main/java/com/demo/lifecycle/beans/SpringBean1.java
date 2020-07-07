package com.demo.lifecycle.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringBean1 implements InitializingBean, DisposableBean {
    private SpringBean2 springBean2;
    private SpringBean3 springBean3;

    public SpringBean1() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }

    public void sayHello() {
        System.out.println("\nHello :: SpringBean1\n");
        springBean2.sayHello();
        springBean3.sayHello();
    }

    @Autowired
    public void setSpringBean2(SpringBean2 springBean2) {
        System.out.println(getClass().getSimpleName() + "::setSpringBean2");
        this.springBean2 = springBean2;
    }

    @Autowired
    public void setSpringBean3(SpringBean3 springBean3) {
        System.out.println(getClass().getSimpleName() + "::setSpringBean3");
        this.springBean3 = springBean3;
    }

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct " + getClass().getSimpleName() + " :: init");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy " + getClass().getSimpleName());
        System.out.println("Do you want to do any cleanup before spring destrys this bean?? now is the time...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean::afterPropertiesSet " + getClass().getSimpleName());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean::destroy -> " + getClass().getSimpleName() + " has now been destroyed");
    }

    private void initMethod() {
        System.out.println("@Bean(initMethod) " + getClass().getSimpleName());
    }

    private void destroyMethod() {
        System.out.println("@Bean(destroyMethod) " + getClass().getSimpleName());
    }
}
