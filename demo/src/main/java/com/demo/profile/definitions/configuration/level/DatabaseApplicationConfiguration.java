package com.demo.profile.definitions.configuration.level;

import com.demo.profile.definitions.configuration.level.repo.DatabaseStoreFinancialDataDao;
import com.demo.profile.definitions.configuration.level.repo.FinancialDataDao;
import com.demo.profile.definitions.configuration.level.writer.DatabaseStoreFinancialReportWriter;
import com.demo.profile.definitions.configuration.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("database")
public class DatabaseApplicationConfiguration {
    @Bean
    public FinancialDataDao databaseStoreFinancialDataDao() {
        return new DatabaseStoreFinancialDataDao();
    }

    @Bean
    public FinancialReportWriter databaseStoreFinancialReportWriter() {
        return new DatabaseStoreFinancialReportWriter();
    }
}
