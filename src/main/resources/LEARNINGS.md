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


#### Spring `container` & `bean` life-cycle:
1. Spring internals - initialization
2. Application Runs
3. Spring internals - destruction

<pre>
1a. Application is Starting
1b. Spring container is created
1c. Container reads configuration
1d. Beans get created
        -- Bean definitions are created from configuration
        -- BeanFactoryPostProcessors process bean definitions
        -- Instances of spring beans are created
        -- Spring beans are configured and assembeled
                - resolve property values
                - inject dependencies
        -- BeanPostProcessors :: postProcessorBeforeInitialization gets called
        -- @PostConstruct method gets called
        -- InitializingBean :: afterPropertiesSet method gets called
        -- @Bean(initMethod) method gets called
        -- BeanPostProcessor :: postProcessAfterInitialization gets called
        
2. Application Runs - Bean is ready to use

3a. Application getting shutdown
3b. Spring context gets Closed
3c. Destruction callbacks are invoked.``
        -- Bean is destroyed:
                -- @PreDestroy method gets called
                -- DisposableBean :: destroy method gets called
                -- @Bean(destroyMethod) gets called
</pre>

NOTE: For a list of all bean lifecycle methods, see the BeanFactory.java javadocs.

#### Moving ApplicationConfiguration to config folder

Error: `Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException:
No qualifying bean of type 'com.demo.lifecycle.beans.SpringBean2' available:
expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}`

Reason: Moving ApplicationConfiguration to config folder messed up the component scan.
Since, ApplicationConfiguration class was annotated with `@ComponentScan`, by default it scanned only the containing
package and its sub-packages. Hence, completely ignoring SpringBean2 and SpringBean3.

Since, the application crashed while trying to resolve SpringBean2 hence in error SpringBean3 is not there.
If we comment out SpringBean2, the code will indeed complain for missing SpringBean3.

Fix: Annotate ApplicationConfiguration with `@ComponentScan(basePackages = "com.demo.lifecycle.beans")`
An explicit path needs to be specified where spring should look. Now, Spring will look at specifid path and all its sub-packages.

NOTE: We never got `org.springframework.beans.factory.NoSuchBeanDefinitionException:
No qualifying bean of type 'com.demo.lifecycle.beans.SpringBean1'`

because to illustrate _not-so-common_ user specified initMethod and destroyMethods,
we had explicitely created SpringBean1 in the ApplicationConfiguration class. 

##Annotations and their processors



`@Autowired`                              - processed by AutowiredAnnotationBeanPostProcessor

`@Value  `                                - processed by
 
`@ComponentScan`

`@Component`

`@Configuration`



#08 July 2020


#### Proxies

Spring framework supports two kinds of proxies:
1. JDK Dynamic Proxy - used by default if target object implements interface
2. CGLIB Proxy - used when target does not implement any interface.

Limitations of JDK Dynamic Proxy:

1. Requires proxy object to implement the interface
2. Only interface method will be proxied
3. No support for self-invocation - 

        Example: A class invoking its own method. Imagine a class with two methods 
            1. save()
            2. find()
        if find() calls save(), then it is called self-invocation. 

Limitations of CGLIB Proxy:

1. Does not work for final classes
2. Does not work for final methods
3. No support for self-invocation

Advantages of Proxies:

1. Ability to change behavior of existing beans without changing original code
2. Separation of concerns (logging, transactions, security...)

Disadvantages of Proxies:

1. Code becomes hard to debug. coz on the surface it looks like you are invoking the real object but in reality the proxy get invoked
2. Needs to use unchecked exception for exceptions not declared in original method
3. May cause performance issues if before/after section in proxy code is using IO (N/W or Disk)
4. May cause unexpected equals (==) results as Proxy object and proxied object are two different objects.


#### Profiles

Spring Profiles provide a way to segregate parts of your application configuration and make it only available in certain environments.

Spring Profiles are configured by:

1. Specifying which beans are part of which profiles
2. Specifying which profiles are active

##### You can specify beans being part of profile in following ways:

1. Use `@Profile` annotation at `@Component` class level
        - bean will be part of profile(s) specified in the annotation
2. Use `@Profile` annotation at `@Configuration` class level
        - all beans from this configuration will be part of prfile(s) specified in the annotation
3. Use `@Profile` annotation at `@Bean` method of `@Configuration` class
        - instance of bean returned by this method will be part of profile(s) specified in the annotation
4. Use `@Profile` annotation to define custom annotation
        - `@Component` or `@Configuration` or `@Bean` method annotated with this custom anotation will be part of
           profile(s) in the annotation
           
           
`If bean does not have profile specified in any way, it will be created in every profile.
 You can use `!` to specify in which profile bean should not be created.`
 
#####  You can activate profiles in following ways:
 
1. Programmatically with usage of `ConfigurableEnvironment`
2. By using `spring.profiles.active` property
3. On JUnit Test level by using `@ActiveProfiles` annotation
4. In Spring Boot, programmatically by usage of `SpringApplicationBuilder`
5. In Spring Boot by `application.properties` or `application.yml` file














#### Questions 
1. What is the usage of @ComponentScan and @Confguration? Can they be used as replacements of each other?

    `@Configuration` indicates that the annotated class contains all the configuration ofr creating beans,
     implementing security and key information to conect to the data-base.
    `@ComponentScan` tells Spring where to look for beans. 
    
    These two annotations are used together but if all your bean definitions are already in your configuration file itself
    then you can live with omitting @componentScan annotation.
    
    To further underline the above explaination, 
    In spring boot we use @SpringBootApplication annotation which is ultimately the combiation of 3 annotations:
    `@Configuration`
    `@ComponentScan`
    `@EnableAutoConfiguration`
    
2. What are the key steps to be able to write test cases in Spring?

    1. Add spring-test dependency - `implementation 'org.springframework:spring-test:5.0.4.RELEASE'`
    2. Annotate your test case with:
        1. @RunWith(SpringRunner.class)
        2. ContextConfiguration(classes = ApplicationConfigration.class) - _ApplicationConfigration.java is where my configs reside_
   
3. What are stereotypes in Spring? Can't I just annotate everything with `@Component` and keep life simple?

    `Stereotypes` - are annotations applied to classes to describe the role that will be performed by this class. 
    Spring discovered clases annotated by stereotypes and creates bean definitions based on those types.
    
    Types of Stereotypes:
    
    1. `Component` - for generic components in the system, root stereotype, candidate for auto-scanning.
    2. `Service` - for classes that contain business logic.
    3. `Repository` - for classes that are data repositories (used for DAO, persistence)
    4. `Controller` - for classes that are controllers, usually a web controller (used with `@RequestMapping`)
    
    ---- pending answer ------


4. What are various bean scopes? 

    1. `Singleton` - default. 
    2. `Prototype` -
    3. `Request` -
    4. `Session` -
    5. `Application` -
    6. `Websocket` -
    
    usage - 
    `@scope("prototype")`, `@RequestScope`, `@SessionScope`, `@ApplicationScope`.
    For singleton you can use `@scope("singleton")` if you want to make it explicit or no annotation means singleton as it is the default scope.
    
    Official reference on BenaScopes: https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-factory-scopes

    NOTE: 
    The `request`, `session`, `application`, and `websocket` scopes are available only if you use a web-aware Spring ApplicationContext implementation (such as XmlWebApplicationContext). If you use these scopes with regular Spring IoC containers, such as the ClassPathXmlApplicationContext, an IllegalStateException that complains about an unknown bean scope is thrown.

5. Are beans instantiated Lazily or Eagerly? How can we control this behavior?

    Singleton beans are instantiated eagerly.
    Prototype beans are instantiated lazily.
    
    Altering Behavior:
    
    1. For all beans in the application - `@ComponentScan(lazyInit = true)`, default value of lazyInit is false.
    2. For individual beans - Annotate specific bean with `@Lazy`. Default value is true, to force eager instantiation use `@Lazy(false)`
    3. Annotate a configuration class (annotated with @Configuration) with @Lazy to have global effect.
     
6. How `@Autowire` resolves dependencies?

    1. Match exactly by type, if only one found, finish.
    2. If multiple beans of same type are found, check if anyone contains `@Primary` annotation, if yes,
        inject primary bean and finish.
    3. If no exact match exists, check if `@Qualifier` exists for field and use that to resolve.
    4. If still no exact match found, narrow the search by using bean name.
    5. If still no exact match found, throw exception:
            `NoSuchBeanDefntionException` - if no bean found.
            `NoUniqueBeanDefinitionException` - if more than one bean found.
    
    If there is only one constructor, then in case of constructor injection you don't need to annotate the constructor 
    with @Autowired, but in case of multiple constructors you must annotate at least one constructor else Spring will
    throw `NoSuchMethodException`.


7. 



















