package com.demo.profile.definitions.configuration.level;

//import com.demo.profile.definitions.configuration.level.repo.FileStoreFinancialDataDao;
//import com.demo.profile.definitions.configuration.level.repo.FinancialDataDao;
//import com.demo.profile.definitions.configuration.level.writer.FileStoreFinancialReportWriter;
//import com.demo.profile.definitions.configuration.level.writer.FinancialReportWriter;
import com.demo.profile.definitions.configuration.level.repo.FileStoreFinancialDataDao;
import com.demo.profile.definitions.configuration.level.repo.FinancialDataDao;
import com.demo.profile.definitions.configuration.level.writer.FileStoreFinancialReportWriter;
import com.demo.profile.definitions.configuration.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("file")
public class FileApplicationConfiguration {
    @Bean
    public FinancialDataDao fileStoreFinancialDataDao() {
        return new FileStoreFinancialDataDao();
    }

    @Bean
    public FinancialReportWriter fileStoreFinancialReportWriter() {
        return new FileStoreFinancialReportWriter();
    }
}
