package com.demo.profile.definitions.configuration.level;

import com.demo.profile.definitions.configuration.level.repo.FinancialDataDao;
import com.demo.profile.definitions.configuration.level.service.FinancialReportService;
import com.demo.profile.definitions.configuration.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DatabaseApplicationConfiguration.class, FileApplicationConfiguration.class})
public class ApplicationConfiguration {

    @Bean
    public FinancialReportService financialReportService(FinancialDataDao financialDataDao, FinancialReportWriter financialReportWriter) {
        return new FinancialReportService(financialDataDao, financialReportWriter);
    }
}
