package com.demo.profile.definitions.configuration.level.writer;

import com.demo.profile.definitions.configuration.level.beans.FinancialMonthSummary;
import com.demo.profile.definitions.configuration.level.beans.FinancialQuarterSummary;
import com.demo.profile.definitions.configuration.level.beans.FinancialYearSummary;

public interface FinancialReportWriter {
    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearSummary financialYearSummary);

    void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary);

    void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary);
}
