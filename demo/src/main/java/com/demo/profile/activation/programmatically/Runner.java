package com.demo.profile.activation.programmatically;


import com.demo.profile.activation.programmatically.beans.FinancialDataDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        // Activate profile
        context.getEnvironment().setActiveProfiles("file");
        context.register(ApplicationConfig.class);
        context.refresh();

        FinancialDataDao financialDataDao = context.getBean(FinancialDataDao.class);

        System.out.println(financialDataDao.getClass().getSimpleName());
    }
}
