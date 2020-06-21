#21 June 2020


When Spring encounters a class with the `@Configuration` annotation, it looks for bean instance definitions in the class,
which are Java methods decorated with the `@Bean` annotation.

The Java methods create and return a bean instance.

Any method definitions decorated with the `@Bean` annotation generates a bean name based on the method name.

Alternatively, you can explicitly specify the bean name in the `@Bean` annotation with the name attribute. For example,
 `@Bean(name="myBean")` makes the bean available as **myBean**.