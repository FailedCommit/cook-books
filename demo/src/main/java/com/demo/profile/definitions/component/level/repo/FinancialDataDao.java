package com.demo.profile.definitions.component.level.repo;

import com.demo.profile.definitions.component.level.beans.FinancialMonthSummary;
import com.demo.profile.definitions.component.level.beans.FinancialQuarterSummary;
import com.demo.profile.definitions.component.level.beans.FinancialYearSummary;

public interface FinancialDataDao {
    FinancialYearSummary findFinancialYearSummary(int year);

    FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter);

    FinancialMonthSummary findFinancialMonthSummary(int year, int month);
}
