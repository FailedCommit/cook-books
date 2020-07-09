package com.demo.profile.activation.spring.boot.properties.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("database")
public class DatabaseStoreFinancialDataDao implements FinancialDataDao {
}
