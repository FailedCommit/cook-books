package com.demo.profile.definitions.component.level.writer;

import com.demo.profile.definitions.component.level.beans.FinancialMonthSummary;
import com.demo.profile.definitions.component.level.beans.FinancialQuarterSummary;
import com.demo.profile.definitions.component.level.beans.FinancialYearSummary;

public interface FinancialReportWriter {
    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearSummary financialYearSummary);

    void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary);

    void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary);
}
