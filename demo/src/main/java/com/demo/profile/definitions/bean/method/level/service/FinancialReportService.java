package com.demo.profile.definitions.bean.method.level.service;

//import com.demo.profile.definitions.bean.method.level.repo.FinancialDataDao;
//import com.demo.profile.definitions.bean.method.level.beans.FinancialMonthSummary;
//import com.demo.profile.definitions.bean.method.level.beans.FinancialQuarterSummary;
//import com.demo.profile.definitions.bean.method.level.beans.FinancialYearSummary;
//import com.demo.profile.definitions.bean.method.level.writer.FinancialReportWriter;
import com.demo.profile.definitions.bean.method.level.beans.FinancialMonthSummary;
import com.demo.profile.definitions.bean.method.level.beans.FinancialQuarterSummary;
import com.demo.profile.definitions.bean.method.level.beans.FinancialYearSummary;
import com.demo.profile.definitions.bean.method.level.repo.FinancialDataDao;
import com.demo.profile.definitions.bean.method.level.writer.FinancialReportWriter;
import org.springframework.stereotype.Component;

@Component
public class FinancialReportService {

    private final FinancialDataDao financialDataDao;
    private final FinancialReportWriter financialReportWriter;

    public FinancialReportService(FinancialDataDao financialDataDao, FinancialReportWriter financialReportWriter) {
        this.financialDataDao = financialDataDao;
        this.financialReportWriter = financialReportWriter;
    }

    public void generateReport() {
        FinancialYearSummary financialYearSummary = financialDataDao.findFinancialYearSummary(2019);
        FinancialQuarterSummary financialQuarterSummary = financialDataDao.findFinancialQuarterSummary(2019, 1);
        FinancialMonthSummary financialMonthSummary = financialDataDao.findFinancialMonthSummary(2019, 4);

        financialReportWriter.appendFreeText("Year / Quarter / Month Financial Report");
        financialReportWriter.appendFinancialYearSummary(financialYearSummary);
        financialReportWriter.appendFinancialQuarterSummary(financialQuarterSummary);
        financialReportWriter.appendFinancialMonthSummary(financialMonthSummary);
    }
}
