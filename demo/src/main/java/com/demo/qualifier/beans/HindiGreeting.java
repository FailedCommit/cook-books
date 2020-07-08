package com.demo.qualifier.beans;

import com.demo.qualifier.GreetingType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
//@Qualifier("hindiGreeting")
@GreetingType(GreetingType.GreetingMode.HINDI)
public class HindiGreeting implements Greeting {
    @Override
    public void greet() {
        System.out.println("Namaste");
    }
}
