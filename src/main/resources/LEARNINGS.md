#21 June 2020


When Spring encounters a class with the `@Configuration` annotation, it looks for bean instance definitions in the class,
which are Java methods decorated with the `@Bean` annotation.

The Java methods create and return a bean instance.

Any method definitions decorated with the `@Bean` annotation generates a bean name based on the method name.

Alternatively, you can explicitly specify the bean name in the `@Bean` annotation with the name attribute. For example,
 `@Bean(name="myBean")` makes the bean available as **myBean**.
 
 
POJOs are classified in application layers. In Spring there are three layers: persistence, service, and presentation. 
@Component is a general-purpose annotation to decorate POJOs for Spring detection, whereas @Repository, @Service, and 
@Controller are specializations of @Component for more specific cases of POJOs associated with the persistence,
service, and presentation layers.

If you’re unsure about a POJO’s purpose, you can decorate it with the @Component annotation. 
However, it’s better to use the specialization annotations where possible because these provide extra facilities based 
on a POJO’s purpose (e.g., @Repository causes exceptions to be wrapped up as DataAccessExceptions, which makes debugging easier).

#07 July 2020


#### Spring container life-cycle:
1. Spring internals - initialization
2. Application Runs
3. Spring internals - destruction


1a. Application is Started
1b. Spring container is created
1c. Container reads configuration
1d. Beans get created
        -- Bean definitions are created from configuration
        -- BeanFactoryPostProcessors process bean definitions
        -- Instances of spring beans are created
        -- Spring beans are configured and assembeled
                - resolve property values
                - inject dependencies
        -- BeanPostProcessors get called
        
2.

3a. Application gets shutdown
3b. Spring context gets Closed
3c. Destruction callbacks are invoked.``


#### Questions 
1. What is the usage of @ComponenScan and @Confguration? Can they be used as replacements of each other?






























