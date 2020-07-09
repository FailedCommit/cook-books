package com.demo.profile.definitions.bean.method.level.repo;

//import com.demo.profile.definitions.bean.method.level.beans.FinancialMonthSummary;
//import com.demo.profile.definitions.bean.method.level.beans.FinancialQuarterSummary;
//import com.demo.profile.definitions.bean.method.level.beans.FinancialYearSummary;

import com.demo.profile.definitions.bean.method.level.beans.FinancialMonthSummary;
import com.demo.profile.definitions.bean.method.level.beans.FinancialQuarterSummary;
import com.demo.profile.definitions.bean.method.level.beans.FinancialYearSummary;

public interface FinancialDataDao {
    FinancialYearSummary findFinancialYearSummary(int year);

    FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter);

    FinancialMonthSummary findFinancialMonthSummary(int year, int month);
}
