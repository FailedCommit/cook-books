package com.demo.profile.definitions.bean.method.level;

import com.demo.profile.definitions.configuration.level.repo.DatabaseStoreFinancialDataDao;
import com.demo.profile.definitions.configuration.level.repo.FileStoreFinancialDataDao;
import com.demo.profile.definitions.configuration.level.repo.FinancialDataDao;
import com.demo.profile.definitions.configuration.level.service.FinancialReportService;
import com.demo.profile.definitions.configuration.level.writer.DatabaseStoreFinancialReportWriter;
import com.demo.profile.definitions.configuration.level.writer.FileStoreFinancialReportWriter;
import com.demo.profile.definitions.configuration.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public FinancialReportService financialReportService(FinancialDataDao financialDataDao, FinancialReportWriter financialReportWriter) {
        return new FinancialReportService(financialDataDao, financialReportWriter);
    }

    @Bean
    @Profile("database")
    public FinancialDataDao databaseStoreFinancialDataDao() {
        return new DatabaseStoreFinancialDataDao();
    }

    @Bean
    @Profile("database")
    public FinancialReportWriter databaseStoreFinancialReportWriter() {
        return new DatabaseStoreFinancialReportWriter();
    }

    @Bean
    @Profile("file")
    public FinancialDataDao fileStoreFinancialDataDao() {
        return new FileStoreFinancialDataDao();
    }

    @Bean
    @Profile("file")
    public FinancialReportWriter fileStoreFinancialReportWriter() {
        return new FileStoreFinancialReportWriter();
    }
}
