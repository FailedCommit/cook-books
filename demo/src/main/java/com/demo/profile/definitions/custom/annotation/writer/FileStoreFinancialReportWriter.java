package com.demo.profile.definitions.custom.annotation.writer;

import com.demo.profile.definitions.custom.annotation.annotations.FileProfile;
import com.demo.profile.definitions.custom.annotation.beans.FinancialMonthSummary;
import com.demo.profile.definitions.custom.annotation.beans.FinancialQuarterSummary;
import com.demo.profile.definitions.custom.annotation.beans.FinancialYearSummary;
import org.springframework.stereotype.Component;

@Component
@FileProfile
class FileStoreFinancialReportWriter implements FinancialReportWriter {
    @Override
    public void appendFreeText(String title) {
        System.out.println("File Writer => appendFreeText");
    }

    @Override
    public void appendFinancialYearSummary(FinancialYearSummary financialYearSummary) {
        System.out.println("File Writer => appendFinancialYearSummary");
    }

    @Override
    public void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary) {
        System.out.println("File Writer => appendFinancialQuarterSummary");
    }

    @Override
    public void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary) {
        System.out.println("File Writer => appendFinancialMonthSummary");
    }
}
