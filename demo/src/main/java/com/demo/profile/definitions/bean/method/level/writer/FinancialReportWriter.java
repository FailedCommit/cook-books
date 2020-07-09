package com.demo.profile.definitions.bean.method.level.writer;

//import com.demo.profile.definitions.bean.method.level.beans.FinancialMonthSummary;
//import com.demo.profile.definitions.bean.method.level.beans.FinancialQuarterSummary;
//import com.demo.profile.definitions.bean.method.level.beans.FinancialYearSummary;

import com.demo.profile.definitions.bean.method.level.beans.FinancialMonthSummary;
import com.demo.profile.definitions.bean.method.level.beans.FinancialQuarterSummary;
import com.demo.profile.definitions.bean.method.level.beans.FinancialYearSummary;

public interface FinancialReportWriter {
    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearSummary financialYearSummary);

    void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary);

    void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary);
}