package com.demo.profile.definitions.configuration.level.writer;

//import com.demo.profile.definitions.configuration.level.beans.FinancialMonthSummary;
//import com.demo.profile.definitions.configuration.level.beans.FinancialQuarterSummary;
//import com.demo.profile.definitions.configuration.level.beans.FinancialYearSummary;

import com.demo.profile.definitions.configuration.level.beans.FinancialMonthSummary;
import com.demo.profile.definitions.configuration.level.beans.FinancialQuarterSummary;
import com.demo.profile.definitions.configuration.level.beans.FinancialYearSummary;

public class FileStoreFinancialReportWriter implements FinancialReportWriter {
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
