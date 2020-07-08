package com.demo.qualifier.beans;

import com.demo.qualifier.GreetingType;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@GreetingType(GreetingType.GreetingMode.ENGLISH)
public class EnglishGreeting implements Greeting {
    @Override
    public void greet() {
        System.out.println("Hello");
    }
}
