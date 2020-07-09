package com.demo.profile.definitions.custom.annotation.writer;

import com.demo.profile.definitions.custom.annotation.annotations.DatabaseProfile;
import com.demo.profile.definitions.custom.annotation.beans.FinancialMonthSummary;
import com.demo.profile.definitions.custom.annotation.beans.FinancialQuarterSummary;
import com.demo.profile.definitions.custom.annotation.beans.FinancialYearSummary;
import org.springframework.stereotype.Component;

@Component
@DatabaseProfile
class DatabaseStoreFinancialReportWriter implements FinancialReportWriter {
    @Override
    public void appendFreeText(String title) {
        System.out.println("Database Writer => appendFreeText");
    }

    @Override
    public void appendFinancialYearSummary(FinancialYearSummary financialYearSummary) {
        System.out.println("Database Writer => appendFinancialYearSummary");
    }

    @Override
    public void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary) {
        System.out.println("Database Writer => appendFinancialQuarterSummary");
    }

    @Override
    public void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary) {
        System.out.println("Database Writer => appendFinancialMonthSummary");
    }
}
