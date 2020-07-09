package com.demo.profile.definitions.custom.annotation.writer;

import com.demo.profile.definitions.custom.annotation.beans.FinancialMonthSummary;
import com.demo.profile.definitions.custom.annotation.beans.FinancialQuarterSummary;
import com.demo.profile.definitions.custom.annotation.beans.FinancialYearSummary;

public interface FinancialReportWriter {
    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearSummary financialYearSummary);

    void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary);

    void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary);
}
