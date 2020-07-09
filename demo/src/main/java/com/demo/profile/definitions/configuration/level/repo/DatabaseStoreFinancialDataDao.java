package com.demo.profile.definitions.configuration.level.repo;

//import com.demo.profile.definitions.configuration.level.beans.FinancialMonthSummary;
//import com.demo.profile.definitions.configuration.level.beans.FinancialQuarterSummary;
//import com.demo.profile.definitions.configuration.level.beans.FinancialYearSummary;

import com.demo.profile.definitions.configuration.level.beans.FinancialMonthSummary;
import com.demo.profile.definitions.configuration.level.beans.FinancialQuarterSummary;
import com.demo.profile.definitions.configuration.level.beans.FinancialYearSummary;

public class DatabaseStoreFinancialDataDao implements FinancialDataDao {
    @Override
    public FinancialYearSummary findFinancialYearSummary(int year) {
        System.out.println("Database Dao => findFinancialYearSummary");
        return new FinancialYearSummary();
    }

    @Override
    public FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter) {
        System.out.println("Database Dao => findFinancialQuarterSummary");
        return new FinancialQuarterSummary();
    }

    @Override
    public FinancialMonthSummary findFinancialMonthSummary(int year, int month) {
        System.out.println("Database Dao => findFinancialMonthSummary");
        return new FinancialMonthSummary();
    }
}
