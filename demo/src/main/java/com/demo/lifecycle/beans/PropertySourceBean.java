package com.demo.lifecycle.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * A bean to illustrate the concept of property sources.
 */
@Component
public class PropertySourceBean {
    @Value("${app.name}")
    private String appName;
    @Value("${author}")
    private String author;
    @Value("${aource.folder.name}")
    private String sourceFolderName;
    @Value("${app.env}")
    private String appEnv;
    // Set vm.option as a property in VM options, to see this in action
    @Value("${vm.option}")
    private String vmOption;
    // System properties are readily available
    @Value("${JAVA_HOME}")
    private String javaHome;

    public void printProperties() {
        System.out.println("app.name = " + appName);
        System.out.println("author = " + author);
        System.out.println("source.folder.name = " + sourceFolderName);
        System.out.println("app.env = " + appEnv);
        System.out.println("vm.option = " + vmOption);
        System.out.println("JAVA_HOME = " + javaHome);
        System.out.println("\n");
    }
}
