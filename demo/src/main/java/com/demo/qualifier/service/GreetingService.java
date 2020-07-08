package com.demo.qualifier.service;

import com.demo.qualifier.GreetingType;
import com.demo.qualifier.beans.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Autowired
//    @Qualifier("hindiGreeting")
    @GreetingType(GreetingType.GreetingMode.HINDI)
    private Greeting greeting;

    public void sayGreeting() {
        greeting.greet();
    }
}
